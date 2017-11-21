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
	
	public Integer pageNum=1;//当前页码
	public Integer pageCount=6;//每页显示数据总数
	public Integer maxPageNum;//最大页码量
	public Integer dataTotal;//总数据量
	
	public String list(){
		// 查询数据总数
		dataTotal = supplierService.getCount(sqm);
		// 最大页码值
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
