package com.ahpu.erp.auth.resource.service.impl;

import java.util.List;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.dao.dao.ResourceDao;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.model.ResourceQueryModel;
import com.ahpu.erp.auth.resource.service.service.ResourceService;

public class ResourceServiceImpl implements ResourceService {
	private ResourceDao resourceDao;

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public Integer getCount(ResourceQueryModel rsqm) {
		return resourceDao.getCount(rsqm);
	}

	public List<ResourceModel> getAll(ResourceQueryModel rsqm, Integer pageNum,
			Integer pageCount) {
		return resourceDao.getAll(rsqm,pageNum,pageCount);
	}

	public void save(ResourceModel rsm) {
		resourceDao.save(rsm);
	}

	public void update(ResourceModel rsm) {
		resourceDao.update(rsm);
	}

	public ResourceModel get(Long uuid) {
		return resourceDao.get(uuid);
	}

	public void delete(ResourceModel rsm) {
		resourceDao.delete(rsm);
	}

	public List<ResourceModel> getAll() {
		return resourceDao.getAll();
	}

	public List<ResourceModel> getAllById(Long uuid) {
		return resourceDao.getAllById(uuid);
	}
}
