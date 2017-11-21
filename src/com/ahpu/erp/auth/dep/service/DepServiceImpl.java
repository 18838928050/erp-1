package com.ahpu.erp.auth.dep.service;

import java.util.List;

import com.ahpu.erp.auth.dep.dao.DepDao;
import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.dep.model.DepQueryModel;

public class DepServiceImpl implements DepService {
	private DepDao depDao;

	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
	}

	public void save(DepModel dm) {
		depDao.save(dm);
	}

	public List<DepModel> getAll() {
		return depDao.getAll();
	}

	public DepModel get(Long uuid) {
		return  depDao.get(uuid);
	}

	public void update(DepModel dm) {
		depDao.update(dm);
	}

	public void delete(DepModel dm) {
		depDao.delele(dm);
	}

	public List<DepModel> getAll(DepQueryModel dqm) {
		return depDao.getAll(dqm);
	}

	public List<DepModel> getAll(DepQueryModel dqm, Integer pageNum,Integer pageCount) {
		return depDao.getAll(dqm,pageNum,pageCount);
	}

	public Integer getCount(DepQueryModel dqm) {
		return depDao.getCount(dqm);
	}
}
