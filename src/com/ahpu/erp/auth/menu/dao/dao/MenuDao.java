package com.ahpu.erp.auth.menu.dao.dao;

import java.util.List;

import com.ahpu.erp.auth.menu.model.MenuModel;
import com.ahpu.erp.auth.menu.model.MenuQueryModel;

public interface MenuDao {

	public Integer getCount(MenuQueryModel mqm);

	public List<MenuModel> getAll();

	public List<MenuModel> getAll(MenuQueryModel mqm, Integer pageNum,
			Integer pageCount);

	public List<MenuModel> getByPuuidIsOneOrZero();

	public MenuModel get(Long uuid);

	public void save(MenuModel mm);

	public void update(MenuModel mm);

	public void delete(MenuModel mm);

	public List<MenuModel> getAllOneLevelByEmp(Long uuid);

	public List<MenuModel> getByEmpAndPuuid(Long uuid, Long puuid);

}
