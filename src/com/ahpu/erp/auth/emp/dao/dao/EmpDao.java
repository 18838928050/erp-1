package com.ahpu.erp.auth.emp.dao.dao;

import java.util.List;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.emp.model.EmpQueryModel;

public interface EmpDao {

	public EmpModel getByUserNameAndPwd(String userName, String pwd);

	public void save(EmpModel em, Long[] roleUuids);

	public List<EmpModel> getAll(EmpQueryModel eqm, Integer pageNum,
			Integer pageCount);

	public Integer getCount(EmpQueryModel eqm);

	public void delete(EmpModel em);

	public void update(EmpModel em);

	public EmpModel get(Long uuid);

	public boolean updatePwdByUserNameAndPwd(String userName, String pwd,
			String newPwd);

}
