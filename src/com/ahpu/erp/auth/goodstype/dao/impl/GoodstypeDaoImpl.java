package com.ahpu.erp.auth.goodstype.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahpu.erp.auth.goodstype.dao.dao.GoodstypeDao;
import com.ahpu.erp.auth.goodstype.model.GoodstypeModel;
import com.ahpu.erp.auth.goodstype.model.GoodstypeQueryModel;
import com.ahpu.erp.auth.supplier.model.SupplierModel;

public class GoodstypeDaoImpl extends HibernateDaoSupport implements GoodstypeDao {

	public Integer getCount(GoodstypeQueryModel gtqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(GoodstypeModel.class);
		dc.setProjection(Projections.rowCount());
		if(gtqm.getName()!=null&&gtqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+gtqm.getName().trim()+"%"));
		}
		
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	public List<GoodstypeModel> getAll(GoodstypeQueryModel gtqm,
			Integer pageNum, Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(GoodstypeModel.class);
		if(gtqm.getName()!=null&&gtqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+gtqm.getName().trim()+"%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public void save(GoodstypeModel gtm) {
		this.getHibernateTemplate().save(gtm);
	}

	public void update(GoodstypeModel gtm) {
		this.getHibernateTemplate().update(gtm);
	}

	public void delete(GoodstypeModel gtm) {
		this.getHibernateTemplate().delete(gtm);
	}

	public List<GoodstypeModel> getAll() {
		String hql ="from GoodstypeModel";
		return this.getHibernateTemplate().find(hql);
	}

	public GoodstypeModel get(Long uuid) {
		return this.getHibernateTemplate().get(GoodstypeModel.class, uuid);
	}
	
}
