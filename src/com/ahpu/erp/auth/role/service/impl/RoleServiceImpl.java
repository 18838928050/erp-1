package com.ahpu.erp.auth.role.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.role.dao.dao.RoleDao;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.role.model.RoleQueryModel;
import com.ahpu.erp.auth.role.service.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public Integer getCount(RoleQueryModel rqm) {
		
		return roleDao.getCount(rqm);
	}
	public List<RoleModel> getAll(RoleQueryModel rqm, Integer pageNum,
			Integer pageCount) {
		return roleDao.getAll(rqm,pageNum,pageCount);
	}

	public RoleModel get(Long uuid) {
		return roleDao.get(uuid);
	}

	/*public void save(RoleModel rm) {
		roleDao.save(rm);
	}*/

	/*public void update(RoleModel rm) {
		roleDao.update(rm);
	}*/

	public void delete(RoleModel rm) {
		roleDao.delete(rm);
	}

	public List<RoleModel> getAll() {
		return roleDao.getAll();
	}

	public void save(RoleModel rm, Long[] resourceUuids) {
		Set<ResourceModel> reses = new HashSet<ResourceModel>();
		for(Long uuid : resourceUuids){
			ResourceModel temp = new ResourceModel();
			temp.setUuid(uuid);
			reses.add(temp);
		}
		rm.setReses(reses);
		roleDao.save(rm);
	}

	public void update(RoleModel rm, Long[] resourceUuids) {
		Set<ResourceModel> reses = new HashSet<ResourceModel>();
		for(Long uuid : resourceUuids){
			ResourceModel temp = new ResourceModel();
			temp.setUuid(uuid);
			reses.add(temp);
		}
		rm.setReses(reses);
		roleDao.update(rm);
	}
}
