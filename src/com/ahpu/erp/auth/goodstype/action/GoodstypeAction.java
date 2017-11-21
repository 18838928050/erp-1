package com.ahpu.erp.auth.goodstype.action;

import java.util.List;

import com.ahpu.erp.auth.goodstype.model.GoodstypeModel;
import com.ahpu.erp.auth.goodstype.model.GoodstypeQueryModel;
import com.ahpu.erp.auth.goodstype.service.service.GoodstypeService;
import com.ahpu.erp.auth.supplier.model.SupplierModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodstypeAction extends ActionSupport {
	public GoodstypeModel gtm = new GoodstypeModel();
	public GoodstypeQueryModel gtqm = new GoodstypeQueryModel();

	private GoodstypeService goodstypeService;

	public GoodstypeService getGoodstypeService() {
		return goodstypeService;
	}

	public void setGoodstypeService(GoodstypeService goodstypeService) {
		this.goodstypeService = goodstypeService;
	}

	public Integer pageNum = 1;// ��ǰҳ��
	public Integer pageCount = 6;// ÿҳ��ʾ��������
	public Integer maxPageNum;// ���ҳ����
	public Integer dataTotal;// ��������

	public String list() {
		// ��ѯ��������
		dataTotal = goodstypeService.getCount(gtqm);
		// ���ҳ��ֵ
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		List<GoodstypeModel> goodstypeList = goodstypeService.getAll(gtqm, pageNum,pageCount);
		ActionContext.getContext().put("goodstypeList", goodstypeList);
		return "list";
	}

	public String input() {
		List<GoodstypeModel> goodstypeList = goodstypeService.getAll();
		ActionContext.getContext().put("goodstypeList", goodstypeList);
		if(gtm.getUuid()!=null){
			gtm = goodstypeService.get(gtm.getUuid());
		}
		return "input";
	}

	public String save() {
		if(gtm.getUuid()==null){
			goodstypeService.save(gtm);
		}else{
			goodstypeService.update(gtm);
		}
		return "toList";
	}

	public String delete() {
		goodstypeService.delete(gtm);
		return "toList";
	}

}
