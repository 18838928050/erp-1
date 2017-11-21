package com.ahpu.erp.auth.emp.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ahpu.erp.auth.emp.dao.dao.EmpDao;
import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.emp.model.EmpQueryModel;
import com.ahpu.erp.auth.emp.service.service.EmpService;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.util.format.MD5Utils;

public class EmpServiceImpl implements EmpService {
	private EmpDao empDao;

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public EmpModel login(String userName, String pwd, String lastLoginIp) {
		// MD5����
		// pwd = MD5Utils.md5(pwd);
		// �������ݲ�
		EmpModel loginEm = empDao.getByUserNameAndPwd(userName, pwd);
		if (loginEm != null) {
			// ��½�ɹ�
			// ��¼����+1
			loginEm.setLoginTimes(loginEm.getLoginTimes() + 1);
			// ����¼ʱ��
			loginEm.setLastLoginTime(System.currentTimeMillis());
			// ����¼Ip
			loginEm.setLastLoginIp(lastLoginIp);
		}
		return loginEm;
	}

	public List<EmpModel> getAll(EmpQueryModel eqm, Integer pageNum,
			Integer pageCount) {
		return empDao.getAll(eqm, pageNum, pageCount);
	}

	public Integer getCount(EmpQueryModel eqm) {
		// TODO Auto-generated method stub
		return empDao.getCount(eqm);
	}

	/*
	 * public void update(EmpModel em) { //���������
	 * //em.setPwd(MD5Utils.md5(em.getPwd())); EmpModel temp =
	 * empDao.get(em.getUuid()); temp.setName(em.getName());
	 * temp.setEmail(em.getEmail()); temp.setTele(em.getTele());
	 * temp.setGender(em.getGender()); temp.setAddress(em.getAddress());
	 * temp.setDm(em.getDm()); }
	 */
	public void delete(EmpModel em) {
		empDao.delete(em);

	}

	public EmpModel get(Long uuid) {
		return empDao.get(uuid);
	}

	public boolean changePwd(String userName, String pwd, String newPwd) {

		return empDao.updatePwdByUserNameAndPwd(userName, pwd, newPwd);
	}

	public void save(EmpModel em, Long[] roleUuids) {
		empDao.save(em, roleUuids);
	}
	//���ո�������
	public void update(EmpModel em, Long[] roleUuids) {
		// ���������
		// em.setPwd(MD5Utils.md5(em.getPwd()));
		EmpModel temp = empDao.get(em.getUuid());
		
		temp.setName(em.getName());
		temp.setEmail(em.getEmail());
		temp.setTele(em.getTele());
		temp.setGender(em.getGender());
		temp.setAddress(em.getAddress());
		temp.setDm(em.getDm());
		
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long uuid : roleUuids){
			RoleModel retemp = new RoleModel();
			retemp.setUuid(uuid);
			roles.add(retemp);
		}
		temp.setRoles(roles);
	}
}
