package com.ahpu.erp.auth.menu.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ahpu.erp.auth.menu.dao.dao.MenuDao;
import com.ahpu.erp.auth.menu.model.MenuModel;
import com.ahpu.erp.auth.menu.model.MenuQueryModel;
import com.ahpu.erp.auth.menu.service.service.MenuService;
import com.ahpu.erp.auth.role.model.RoleModel;

public class MenuServiceImpl implements MenuService {
	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public Integer getCount(MenuQueryModel mqm) {
		return menuDao.getCount(mqm);
	}

	public List<MenuModel> getAll() {
		return menuDao.getAll();
	}

	public List<MenuModel> getAll(MenuQueryModel mqm, Integer pageNum,
			Integer pageCount) {
		return menuDao.getAll(mqm,pageNum,pageCount);
	}

	public List<MenuModel> getAllOneLevel() {
		return menuDao.getByPuuidIsOneOrZero();
	}

	public MenuModel get(Long uuid) {
		return menuDao.get(uuid);
	}

	public void save(MenuModel mm, Long[] roleUuids) {
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long uuid:roleUuids){
			RoleModel temp = new RoleModel();
			temp.setUuid(uuid);
			roles.add(temp);
		}
		mm.setRoles(roles);
		menuDao.save(mm);
	}

	public void update(MenuModel mm, Long[] roleUuids) {
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long uuid:roleUuids){
			RoleModel temp = new RoleModel();
			temp.setUuid(uuid);
			roles.add(temp);
		}
		mm.setRoles(roles);
		menuDao.update(mm);
	}

	public void delete(MenuModel mm) {
		//删除前加载级联关系
		MenuModel temp =menuDao.get(mm.getUuid());
		menuDao.delete(temp);
	}

	public List<MenuModel> getAllOneLevelByEmp(Long uuid) {
		return menuDao.getAllOneLevelByEmp(uuid);
	}

	public List<MenuModel> getByEmpAndPuuid(Long uuid, Long puuid) {
		return menuDao.getByEmpAndPuuid(uuid,puuid);
	}
}
