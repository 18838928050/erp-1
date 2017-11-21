package com.ahpu.erp.auth.emp.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.emp.dao.dao.EmpDao;
import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.emp.model.EmpQueryModel;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.util.exception.AppException;
import com.ahpu.erp.util.format.MD5Utils;

public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao {

	public EmpModel getByUserNameAndPwd(String userName, String pwd) {

		String hql = "from EmpModel where userName = ? and pwd = ?";
		List<EmpModel> temp = this.getHibernateTemplate().find(hql, userName,pwd);
		return temp.size() > 0 ? temp.get(0) : null;
	}

	/*public void save(EmpModel em) {
		//em.setPwd(MD5Utils.md5(em.getPwd()));
		if(em.getUserName()==null || em.getUserName().trim().length()==0){
			throw new AppException("INFO_EMP_USERNAME_IS_EMPTY");
		}
		em.setLastLoginTime(System.currentTimeMillis());
		em.setLastLoginIp("-");
		em.setLoginTimes(0);
		this.getHibernateTemplate().save(em);
	}*/

	public List<EmpModel> getAll(EmpQueryModel eqm, Integer pageNum,
			Integer pageCount) {
		//执行查询，动态连接dqm
		DetachedCriteria dc = DetachedCriteria.forClass(EmpModel.class);
		if(eqm.getUserName()!=null&&eqm.getUserName().trim().length()>0){
			dc.add(Restrictions.eq("userName", eqm.getUserName().trim()));
		}
		if(eqm.getName()!=null&&eqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+eqm.getName().trim()+"%"));
		}
		if(eqm.getTele()!=null&&eqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+eqm.getTele().trim()+"%"));
		}
		if(eqm.getGender()!=null&&eqm.getGender()!=-1){
			dc.add(Restrictions.eq("gender", eqm.getGender()));
		}
		if(eqm.getEmail()!=null&&eqm.getEmail().trim().length()>0){
			dc.add(Restrictions.like("email", "%"+eqm.getEmail().trim()+"%"));
		}
		if(eqm.getDm()!=null&&eqm.getDm().getUuid()!=null&&eqm.getDm().getUuid()!=-1){
			dc.add(Restrictions.eq("dm", eqm.getDm()));
		}
		if(eqm.getBirthday()!=null){
			dc.add(Restrictions.ge("birthday", eqm.getBirthday()));
		}
		if(eqm.getBirthday2()!=null){
			dc.add(Restrictions.le("birthday", eqm.getBirthday2()+86400000-1));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public Integer getCount(EmpQueryModel eqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(EmpModel.class);
		dc.setProjection(Projections.rowCount());
		if(eqm.getUserName()!=null&&eqm.getUserName().trim().length()>0){
			dc.add(Restrictions.eq("userName", eqm.getUserName().trim()));
		}
		if(eqm.getName()!=null&&eqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+eqm.getName().trim()+"%"));
		}
		if(eqm.getTele()!=null&&eqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+eqm.getTele().trim()+"%"));
		}
		if(eqm.getGender()!=null&&eqm.getGender()!=-1){
			dc.add(Restrictions.eq("gender", eqm.getGender()));
		}
		if(eqm.getEmail()!=null&&eqm.getEmail().trim().length()>0){
			dc.add(Restrictions.like("email", "%"+eqm.getEmail().trim()+"%"));
		}
		if(eqm.getDm()!=null&&eqm.getDm().getUuid()!=null&&eqm.getDm().getUuid()!=-1){
			dc.add(Restrictions.eq("dm", eqm.getDm()));
		}
		if(eqm.getBirthday()!=null){
			dc.add(Restrictions.ge("birthday", eqm.getBirthday()));
		}
		if(eqm.getBirthday2()!=null){
			dc.add(Restrictions.le("birthday", eqm.getBirthday2()+86400000-1));
		}
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	public void delete(EmpModel em) {
		this.getHibernateTemplate().delete(em);
	}

	public void update(EmpModel em) {
		this.getHibernateTemplate().update(em);
	}

	public EmpModel get(Long uuid) {
		return this.getHibernateTemplate().get(EmpModel.class, uuid);
	}

	public boolean updatePwdByUserNameAndPwd(String userName, String pwd,
			String newPwd) {
		String hql = "update EmpModel set pwd = ? where userName = ? and pwd = ?";
		int row = this.getHibernateTemplate().bulkUpdate(hql,newPwd,userName,pwd);
		return row>0;
	}

	public void save(EmpModel em, Long[] roleUuids) {
		if(em.getUserName()==null || em.getUserName().trim().length()==0){
			throw new AppException("INFO_EMP_USERNAME_IS_EMPTY");
		}
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long uuid:roleUuids){
			RoleModel temp = new RoleModel();
			temp.setUuid(uuid);
			roles.add(temp);
		}
		em.setRoles(roles);
		em.setLastLoginTime(System.currentTimeMillis());
		em.setLastLoginIp("-");
		em.setLoginTimes(0);
		this.getHibernateTemplate().save(em);
	}

}
