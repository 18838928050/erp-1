package com.ahpu.erp.auth.goodstype.service.impl;

import java.util.List;

import com.ahpu.erp.auth.goodstype.dao.dao.GoodstypeDao;
import com.ahpu.erp.auth.goodstype.model.GoodstypeModel;
import com.ahpu.erp.auth.goodstype.model.GoodstypeQueryModel;
import com.ahpu.erp.auth.goodstype.service.service.GoodstypeService;

public class GoodstypeServiceImpl implements GoodstypeService {
	private GoodstypeDao goodstypeDao;

	public GoodstypeDao getGoodstypeDao() {
		return goodstypeDao;
	}

	public void setGoodstypeDao(GoodstypeDao goodstypeDao) {
		this.goodstypeDao = goodstypeDao;
	}

	public Integer getCount(GoodstypeQueryModel gtqm) {
		return goodstypeDao.getCount(gtqm);
	}

	public List<GoodstypeModel> getAll(GoodstypeQueryModel gtqm,
			Integer pageNum, Integer pageCount) {
		return goodstypeDao.getAll(gtqm,pageNum,pageCount);
	}

	public void save(GoodstypeModel gtm) {
		goodstypeDao.save(gtm);
	}

	public void update(GoodstypeModel gtm) {
		goodstypeDao.update(gtm);
	}

	public void delete(GoodstypeModel gtm) {
		goodstypeDao.delete(gtm);
	}

	public List<GoodstypeModel> getAll() {
		return goodstypeDao.getAll();
	}

	public GoodstypeModel get(Long uuid) {
		return goodstypeDao.get(uuid);
	}
}
