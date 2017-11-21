package com.ahpu.erp.auth.menu.service.service;

import java.util.List;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.menu.model.MenuModel;
import com.ahpu.erp.auth.menu.model.MenuQueryModel;

public interface MenuService {

	public Integer getCount(MenuQueryModel mqm);

	public List<MenuModel> getAll();

	public List<MenuModel> getAll(MenuQueryModel mqm, Integer pageNum,
			Integer pageCount);

	/**
	 * 获取所有的一级菜单
	 * @return
	 */
	public List<MenuModel> getAllOneLevel();

	public MenuModel get(Long uuid);

	public void save(MenuModel mm, Long[] roleUuids);

	public void update(MenuModel mm, Long[] roleUuids);

	public void delete(MenuModel mm);

	public List<MenuModel> getAllOneLevelByEmp(Long uuid);

	public List<MenuModel> getByEmpAndPuuid(Long uuid, Long puuid);

}
