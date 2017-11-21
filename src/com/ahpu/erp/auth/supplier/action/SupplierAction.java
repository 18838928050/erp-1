package com.ahpu.erp.auth.supplier.action;

import java.util.List;

import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.supplier.model.SupplierModel;
import com.ahpu.erp.auth.supplier.model.SupplierQueryModel;
import com.ahpu.erp.auth.supplier.service.service.SupplierService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierAction extends ActionSupport{
	public SupplierModel sm = new SupplierModel();
	public SupplierQueryModel sqm = new SupplierQueryModel();
	
	private SupplierService supplierService;

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	public Integer pageNum=1;//��ǰҳ��
	public Integer pageCount=6;//ÿҳ��ʾ��������
	public Integer maxPageNum;//���ҳ����
	public Integer dataTotal;//��������
	
	public String list(){
		// ��ѯ��������
		dataTotal = supplierService.getCount(sqm);
		// ���ҳ��ֵ
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		List<SupplierModel> supplierList = supplierService.getAll(sqm, pageNum, pageCount);
		ActionContext.getContext().put("supplierList", supplierList);
		return "list";
	}
	
	public String input(){
		List<SupplierModel> supplierList = supplierService.getAll();
		ActionContext.getContext().put("supplierList", supplierList);
		if(sm.getUuid()!=null){
			sm = supplierService.get(sm.getUuid());
		}
		return "input";
	}
	public String save(){
		if(sm.getUuid()==null){
			supplierService.save(sm);
		}else{
			supplierService.update(sm);
		}
		return "toList";
	}
	public String delete(){
		supplierService.delete(sm);
		return "toList";
	}
}
