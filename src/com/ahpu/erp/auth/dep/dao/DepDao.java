package com.ahpu.erp.auth.dep.dao;

import java.util.List;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.dep.model.DepQueryModel;

public interface DepDao {

	public void save(DepModel dm);

	public List<DepModel> getAll();

	public DepModel get(Long uuid);

	public void update(DepModel dm);

	public void delele(DepModel dm);

	public List<DepModel> getAll(DepQueryModel dqm);

	public List<DepModel> getAll(DepQueryModel dqm, Integer pageNum,
			Integer pageCount);

	public Integer getCount(DepQueryModel dqm);

}
