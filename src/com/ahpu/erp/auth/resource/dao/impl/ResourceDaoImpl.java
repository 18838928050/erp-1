package com.ahpu.erp.auth.resource.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.dao.dao.ResourceDao;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.model.ResourceQueryModel;
import com.ahpu.erp.auth.role.model.RoleModel;

public class ResourceDaoImpl extends HibernateDaoSupport implements ResourceDao{

	public Integer getCount(ResourceQueryModel rsqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(ResourceModel.class);
		dc.setProjection(Projections.rowCount());
		if(rsqm.getName()!=null&&rsqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+rsqm.getName().trim()+"%"));
		}
		if(rsqm.getUrl()!=null&&rsqm.getUrl().trim().length()>0){
			dc.add(Restrictions.like("url", "%"+rsqm.getUrl().trim()+"%"));
		}
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	public List<ResourceModel> getAll(ResourceQueryModel rsqm, Integer pageNum,
			Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(ResourceModel.class);
		if(rsqm.getName()!=null&&rsqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+rsqm.getName().trim()+"%"));
		}
		if(rsqm.getUrl()!=null&&rsqm.getUrl().trim().length()>0){
			dc.add(Restrictions.like("url", "%"+rsqm.getUrl().trim()+"%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public void save(ResourceModel rsm) {
		this.getHibernateTemplate().save(rsm);
	}

	public void update(ResourceModel rsm) {
		this.getHibernateTemplate().update(rsm);
	}

	public ResourceModel get(Long uuid) {
		return this.getHibernateTemplate().get(ResourceModel.class, uuid);
	}

	public void delete(ResourceModel rsm) {
		this.getHibernateTemplate().delete(rsm);
	}

	public List<ResourceModel> getAll() {
		String hql = "from ResourceModel";
		return this.getHibernateTemplate().find(hql);
	}

	public List<ResourceModel> getAllById(Long uuid) {
		
		String hql = "select res from EmpModel em join em.roles rm join rm.reses res where em.uuid =?";
		
		return this.getHibernateTemplate().find(hql,uuid);
	}

}
