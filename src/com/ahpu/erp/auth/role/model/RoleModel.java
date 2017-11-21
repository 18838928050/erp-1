package com.ahpu.erp.auth.role.model;

import java.util.Set;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;

public class RoleModel {
	private Long uuid;
	private String name;
	private String code;
	
	//对资源多对多
	private Set<ResourceModel> reses;
	private Set<EmpModel> emps;
	public void setEmps(Set<EmpModel> emps) {
		this.emps = emps;
	}
	public Set<ResourceModel> getReses() {
		return reses;
	}
	public void setReses(Set<ResourceModel> reses) {
		this.reses = reses;
	}
	public Set<EmpModel> getEmps() {
		return emps;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
