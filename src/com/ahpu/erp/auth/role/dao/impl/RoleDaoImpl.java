package com.ahpu.erp.auth.role.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.role.dao.dao.RoleDao;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.role.model.RoleQueryModel;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	public Integer getCount(RoleQueryModel rqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(RoleModel.class);
		dc.setProjection(Projections.rowCount());
		if(rqm.getName()!=null&&rqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+rqm.getName().trim()+"%"));
		}
		if(rqm.getCode()!=null&&rqm.getCode().trim().length()>0){
			dc.add(Restrictions.like("code", "%"+rqm.getCode().trim()+"%"));
		}
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	public List<RoleModel> getAll(RoleQueryModel rqm, Integer pageNum,
			Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(RoleModel.class);
		if(rqm.getName()!=null&&rqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+rqm.getName().trim()+"%"));
		}
		if(rqm.getCode()!=null&&rqm.getCode().trim().length()>0){
			dc.add(Restrictions.like("code", "%"+rqm.getCode().trim()+"%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public RoleModel get(Long uuid) {
		return this.getHibernateTemplate().get(RoleModel.class, uuid);
	}

	public void save(RoleModel rm) {
		this.getHibernateTemplate().save(rm);
	}

	public void update(RoleModel rm) {
		this.getHibernateTemplate().update(rm);
	}

	public void delete(RoleModel rm) {
		this.getHibernateTemplate().delete(rm);
	}

	public List<RoleModel> getAll() {
		String hql = "from RoleModel";
		return this.getHibernateTemplate().find(hql);
	}

	/*public void update(RoleModel rm, Long[] resourceUuids) {
		// TODO Auto-generated method stub
		
	}

	public void save(RoleModel rm, Long[] resourceUuids) {
		// TODO Auto-generated method stub
		
	}*/

}
