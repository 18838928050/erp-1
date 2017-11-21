package com.ahpu.erp.auth.goodstype.model;

import com.ahpu.erp.auth.supplier.model.SupplierModel;

public class GoodstypeModel {
	private Long uuid;
	private String name;
	private SupplierModel sm;
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
	public SupplierModel getSm() {
		return sm;
	}
	public void setSm(SupplierModel sm) {
		this.sm = sm;
	}
}
