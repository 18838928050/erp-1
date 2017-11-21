package com.ahpu.erp.auth.supplier.service.impl;

import java.util.List;

import com.ahpu.erp.auth.supplier.dao.dao.SupplierDao;
import com.ahpu.erp.auth.supplier.model.SupplierModel;
import com.ahpu.erp.auth.supplier.model.SupplierQueryModel;
import com.ahpu.erp.auth.supplier.service.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {
	private SupplierDao supplierDao;

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public Integer getCount(SupplierQueryModel sqm) {
		return supplierDao.getCount(sqm);
	}

	public List<SupplierModel> getAll(SupplierQueryModel sqm, Integer pageNum,
			Integer pageCount) {
		return supplierDao.getAll(sqm,pageNum,pageCount);
	}

	public void delete(SupplierModel sm) {
		supplierDao.delete(sm);
	}

	public void save(SupplierModel sm) {
		supplierDao.save(sm);
	}

	public void update(SupplierModel sm) {
		supplierDao.update(sm);
	}

	public List<SupplierModel> getAll() {
		return supplierDao.getAll();
	}

	public SupplierModel get(Long uuid) {
		return supplierDao.get(uuid);
	}
}
