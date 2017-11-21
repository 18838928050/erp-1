package com.ahpu.erp.auth.emp.service.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.emp.model.EmpQueryModel;

@Transactional
public interface EmpService {

	/**
	 * 
	 * @param userName
	 * @param pwd
	 * @param loginIp 
	 * @return ��¼�û���Ϣ���������null,��ʾ��¼ʧ��
	 */
	public EmpModel login(String userName, String pwd, String loginIp);

	public void save(EmpModel em, Long[] roleUuids);

	public List<EmpModel> getAll(EmpQueryModel eqm, Integer pageNum,
			Integer pageCount);

	public Integer getCount(EmpQueryModel eqm);

	public void update(EmpModel em, Long[] roleUuids);

	public void delete(EmpModel em);

	public EmpModel get(Long uuid);

	public boolean changePwd(String userName, String pwd, String newPwd);


}
