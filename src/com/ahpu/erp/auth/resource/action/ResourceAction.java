package com.ahpu.erp.auth.resource.action;

import java.util.List;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.model.ResourceQueryModel;
import com.ahpu.erp.auth.resource.service.service.ResourceService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResourceAction extends ActionSupport {
	private ResourceService resourceService;

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	public ResourceModel rsm = new ResourceModel();
	public  ResourceQueryModel rsqm = new ResourceQueryModel();
	
	public Integer pageNum=1;//当前页码
	public Integer pageCount=6;//每页显示数据总数
	public Integer maxPageNum;//最大页码量
	public Integer dataTotal;//总数据量
	public String list(){
		// 查询数据总数
		 dataTotal = resourceService.getCount(rsqm);
		// 最大页码值
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		List<ResourceModel> resourceList = resourceService.getAll(rsqm, pageNum, pageCount);
		ActionContext.getContext().put("resourceList", resourceList);
		return "list";
	}
	//input
	public String input(){
		if(rsm.getUuid()!=null){
			rsm = resourceService.get(rsm.getUuid());
		}
		return "input";
	}
	//save
	public String save(){
		if(rsm.getUuid()==null){
			resourceService.save(rsm);
		}else{
			resourceService.update(rsm);
		}
		return "toList";
	}
	//delete
	public String delete(){
		resourceService.delete(rsm);
		return "toList";
	}
	
}
