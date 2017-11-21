package com.ahpu.erp.auth.dep.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.dep.model.DepQueryModel;

public class DepDaoImpl extends HibernateDaoSupport implements DepDao {

	public void save(DepModel dm) {
		this.getHibernateTemplate().save(dm);
	}

	public List<DepModel> getAll() {
		String hql="from DepModel";
		return this.getHibernateTemplate().find(hql);
	}

	public DepModel get(Long uuid) {
		return this.getHibernateTemplate().get(DepModel.class, uuid);
	}

	public void update(DepModel dm) {
		this.getHibernateTemplate().update(dm);
	}

	public void delele(DepModel dm) {
		this.getHibernateTemplate().delete(dm);
	}

	public List<DepModel> getAll(DepQueryModel dqm) {
		//执行查询，动态连接dqm
		DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
		if(dqm.getName()!=null&&dqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+dqm.getName().trim()+"%"));
		}
		if(dqm.getTele()!=null&&dqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc);
	}

	public List<DepModel> getAll(DepQueryModel dqm, Integer pageNum,Integer pageCount) {
			//执行查询，动态连接dqm
				DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
				if(dqm.getName()!=null&&dqm.getName().trim().length()>0){
					dc.add(Restrictions.like("name", "%"+dqm.getName().trim()+"%"));
				}
				if(dqm.getTele()!=null&&dqm.getTele().trim().length()>0){
					dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
				}
				return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public Integer getCount(DepQueryModel dqm) {
		//执行查询，动态连接dqm
		DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
		
		dc.setProjection(Projections.rowCount());
		if(dqm.getName()!=null&&dqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+dqm.getName().trim()+"%"));
		}
		if(dqm.getTele()!=null&&dqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

}
