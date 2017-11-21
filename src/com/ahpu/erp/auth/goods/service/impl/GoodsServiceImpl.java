package com.ahpu.erp.auth.goods.service.impl;

import com.ahpu.erp.auth.goods.dao.dao.GoodsDao;
import com.ahpu.erp.auth.goods.service.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDao goodsDao;

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
}
