package com.ahpu.erp.auth.role.dao.dao;

import java.util.List;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.role.model.RoleQueryModel;

public interface RoleDao {

	public Integer getCount(RoleQueryModel rqm);

	public List<RoleModel> getAll(RoleQueryModel rqm, Integer pageNum,
			Integer pageCount);

	public RoleModel get(Long uuid);

	//public void update(RoleModel rm, Long[] resourceUuids);

	public void delete(RoleModel rm);

	public List<RoleModel> getAll();

	//public void save(RoleModel rm, Long[] resourceUuids);

	public void save(RoleModel rm);

	public void update(RoleModel rm);

}
