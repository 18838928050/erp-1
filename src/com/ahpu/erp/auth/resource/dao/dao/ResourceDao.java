package com.ahpu.erp.auth.resource.dao.dao;

import java.util.List;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.model.ResourceQueryModel;

public interface ResourceDao {

	public Integer getCount(ResourceQueryModel rsqm);

	public List<ResourceModel> getAll(ResourceQueryModel rsqm, Integer pageNum,
			Integer pageCount);

	public void save(ResourceModel rsm);

	public void update(ResourceModel rsm);

	public ResourceModel get(Long uuid);

	public void delete(ResourceModel rsm);

	public List<ResourceModel> getAll();

	public List<ResourceModel> getAllById(Long uuid);

}
