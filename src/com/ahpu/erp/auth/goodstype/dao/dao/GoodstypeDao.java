package com.ahpu.erp.auth.goodstype.dao.dao;

import java.util.List;

import com.ahpu.erp.auth.goodstype.model.GoodstypeModel;
import com.ahpu.erp.auth.goodstype.model.GoodstypeQueryModel;

public interface GoodstypeDao {

	public Integer getCount(GoodstypeQueryModel gtqm);

	
	public List<GoodstypeModel> getAll(GoodstypeQueryModel gtqm,
			Integer pageNum, Integer pageCount);

	public void save(GoodstypeModel gtm);


	public void update(GoodstypeModel gtm);


	public void delete(GoodstypeModel gtm);


	public List<GoodstypeModel> getAll();


	public GoodstypeModel get(Long uuid);

}
