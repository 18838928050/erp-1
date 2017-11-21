package com.ahpu.erp.auth.role.action;

import java.util.List;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.service.service.ResourceService;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.role.model.RoleQueryModel;
import com.ahpu.erp.auth.role.service.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport  {
	private RoleService roleService;
	private ResourceService resourceService;
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public RoleModel rm = new RoleModel();
	public RoleQueryModel rqm = new RoleQueryModel();
	
	public Integer pageNum=1;//��ǰҳ��
	public Integer pageCount=6;//ÿҳ��ʾ��������
	public Integer maxPageNum;//���ҳ����
	public Integer dataTotal;//��������
	public Long[] resourceUuids;
	
	public String list(){
		// ��ѯ��������
		dataTotal = roleService.getCount(rqm);
		// ���ҳ��ֵ
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		List<RoleModel> roleList = roleService.getAll(rqm, pageNum, pageCount);
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	
	public String input(){
		//������Դ��Ϣ
		List<ResourceModel> resourceList = resourceService.getAll();
		ActionContext.getContext().put("resourceList", resourceList);
		if(rm.getUuid()!=null){
			rm = roleService.get(rm.getUuid());
			
			resourceUuids = new Long[rm.getReses().size()];
			int i = 0;
			for(ResourceModel temp : rm.getReses()){
				resourceUuids[i++] = temp.getUuid();
			}
		}
		return "input";
	}
	
	public String save(){
		if(rm.getUuid()==null){
			roleService.save(rm,resourceUuids);
		}else{
			roleService.update(rm,resourceUuids);
		}
		return "toList";
	}
	
	public String delete(){
		roleService.delete(rm);
		return "toList";
	}
	
}
