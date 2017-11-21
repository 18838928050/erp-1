package com.ahpu.erp.auth.menu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.menu.dao.dao.MenuDao;
import com.ahpu.erp.auth.menu.model.MenuModel;
import com.ahpu.erp.auth.menu.model.MenuQueryModel;
import com.ahpu.erp.auth.role.model.RoleModel;

public class MenuDaoImpl extends HibernateDaoSupport implements MenuDao {

	public Integer getCount(MenuQueryModel mqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(MenuModel.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.not(Restrictions.eq("uuid", MenuModel.MENU_SYSTEM_MENU_UUID)));
		if(mqm.getName()!=null&&mqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+mqm.getName().trim()+"%"));
		}
		if(mqm.getParent()!=null&&mqm.getParent().getUuid()!=null && mqm.getParent().getUuid()!=-1){
			dc.add(Restrictions.eq("parent", mqm.getParent()));
		}
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}
	
	public List<MenuModel> getAll(MenuQueryModel mqm, Integer pageNum,
			Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(MenuModel.class);
		//设置过滤掉系统菜单的条件
		//uuid不等于1
		dc.add(Restrictions.not(Restrictions.eq("uuid", MenuModel.MENU_SYSTEM_MENU_UUID)));
		if(mqm.getName()!=null&&mqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+mqm.getName().trim()+"%"));
		}
		if(mqm.getParent()!=null&&mqm.getParent().getUuid()!=null && mqm.getParent().getUuid()!=-1){
			dc.add(Restrictions.eq("parent", mqm.getParent()));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public List<MenuModel> getAll() {

		String hql = "from MenuModel";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<MenuModel> getByPuuidIsOneOrZero() {
		String hql = "from MenuModel where parent.uuid =? or uuid =?";
		return this.getHibernateTemplate().find(hql,MenuModel.MENU_SYSTEM_MENU_UUID,MenuModel.MENU_SYSTEM_MENU_UUID);
	}

	public MenuModel get(Long uuid) {
		return this.getHibernateTemplate().get(MenuModel.class, uuid);
	}

	public void save(MenuModel mm) {
		this.getHibernateTemplate().save(mm);
	}

	public void update(MenuModel mm) {
		this.getHibernateTemplate().update(mm);
	}

	public void delete(MenuModel mm) {
		this.getHibernateTemplate().delete(mm);
	}

	public List<MenuModel> getAllOneLevelByEmp(Long uuid) {
		String hql ="select distinct menu from MenuModel menu join menu.roles role join role.emps emp where emp.uuid = ? and menu.parent.uuid = ? order by menu.uuid";
		return this.getHibernateTemplate().find(hql,uuid,MenuModel.MENU_SYSTEM_MENU_UUID);
	}

	public List<MenuModel> getByEmpAndPuuid(Long uuid, Long puuid) {
		String hql ="select distinct menu from MenuModel menu join menu.roles role join role.emps emp where emp.uuid = ? and menu.parent.uuid = ? order by menu.uuid";
		return this.getHibernateTemplate().find(hql,uuid,puuid);
	}


}
