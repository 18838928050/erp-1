package com.ahpu.erp.auth.dep.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.dep.model.DepQueryModel;

@Transactional
public interface DepService {

	public void save(DepModel dm);

	public List<DepModel> getAll();

	public DepModel get(Long uuid);

	public void update(DepModel dm);

	public void delete(DepModel dm);

	public List<DepModel> getAll(DepQueryModel dqm);

	public List<DepModel> getAll(DepQueryModel dqm, Integer pageNum,
			Integer pageCount);

	public Integer getCount(DepQueryModel dqm);
	
}
