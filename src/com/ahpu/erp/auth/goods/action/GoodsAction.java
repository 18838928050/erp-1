package com.ahpu.erp.auth.goods.action;

import com.ahpu.erp.auth.goods.model.GoodsModel;
import com.ahpu.erp.auth.goods.model.GoodsQueryModel;
import com.ahpu.erp.auth.goods.service.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport{
	private GoodsService goodsService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	public GoodsModel gm = new GoodsModel();
	public GoodsQueryModel gqm = new GoodsQueryModel();
	
	
}
