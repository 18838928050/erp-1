package com.ahpu.erp.auth.supplier.dao.dao;

import java.util.List;

import com.ahpu.erp.auth.supplier.model.SupplierModel;
import com.ahpu.erp.auth.supplier.model.SupplierQueryModel;

public interface SupplierDao {

	public Integer getCount(SupplierQueryModel sqm);

	public List<SupplierModel> getAll(SupplierQueryModel sqm, Integer pageNum,
			Integer pageCount);

	public void delete(SupplierModel sm);

	public void save(SupplierModel sm);

	public void update(SupplierModel sm);

	public List<SupplierModel> getAll();

	public SupplierModel get(Long uuid);

}
