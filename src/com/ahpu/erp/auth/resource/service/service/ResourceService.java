package com.ahpu.erp.auth.resource.service.service;

import java.util.List;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.model.ResourceQueryModel;

public interface ResourceService {

	public Integer getCount(ResourceQueryModel rsqm);

	public List<ResourceModel> getAll(ResourceQueryModel rsqm, Integer pageNum,
			Integer pageCount);

	public void save(ResourceModel rsm);

	public void update(ResourceModel rsm);

	public ResourceModel get(Long uuid);

	public void delete(ResourceModel rsm);

	public List<ResourceModel> getAll();

	/**
	 * 获取指定用户所有指定可操作资源
	 * @param uuid
	 * @return
	 */
	public List<ResourceModel> getAllById(Long uuid);

}
