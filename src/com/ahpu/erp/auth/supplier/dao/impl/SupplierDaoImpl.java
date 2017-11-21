package com.ahpu.erp.auth.supplier.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.supplier.dao.dao.SupplierDao;
import com.ahpu.erp.auth.supplier.model.SupplierModel;
import com.ahpu.erp.auth.supplier.model.SupplierQueryModel;

public class SupplierDaoImpl extends HibernateDaoSupport implements SupplierDao {

	public Integer getCount(SupplierQueryModel sqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(SupplierModel.class);
		dc.setProjection(Projections.rowCount());
		if(sqm.getName()!=null&&sqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+sqm.getName().trim()+"%"));
		}
		if(sqm.getTele()!=null&&sqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+sqm.getTele().trim()+"%"));
		}
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	public List<SupplierModel> getAll(SupplierQueryModel sqm, Integer pageNum,
			Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(SupplierModel.class);
		if(sqm.getName()!=null&&sqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+sqm.getName().trim()+"%"));
		}
		if(sqm.getTele()!=null&&sqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+sqm.getTele().trim()+"%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public void delete(SupplierModel sm) {
		this.getHibernateTemplate().delete(sm);
	}

	public void save(SupplierModel sm) {
		this.getHibernateTemplate().save(sm);
	}

	public void update(SupplierModel sm) {
		this.getHibernateTemplate().delete(sm);
	}

	public List<SupplierModel> getAll() {
		String hql ="from SupplierModel";
		return this.getHibernateTemplate().find(hql);
	}

	public SupplierModel get(Long uuid) {
		return this.getHibernateTemplate().get(SupplierModel.class, uuid);
	}

}
