package com.ahpu.erp.auth.menu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.menu.model.MenuModel;
import com.ahpu.erp.auth.menu.model.MenuQueryModel;
import com.ahpu.erp.auth.menu.service.service.MenuService;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.role.service.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	public MenuModel mm = new MenuModel();
	public MenuQueryModel mqm = new MenuQueryModel();

	private MenuService menuService;
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public Integer pageNum = 1;// 当前页码
	public Integer pageCount = 6;// 每页显示数据总数
	public Integer maxPageNum;// 最大页码量
	public Integer dataTotal;// 总数据量
	public Long[] roleUuids;

	public String list() {
		// 查询数据总数
		dataTotal = menuService.getCount(mqm);
		// 最大页码值
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		// 加载所有一级菜单
		List<MenuModel> parentList = menuService.getAllOneLevel();
		ActionContext.getContext().put("parentList", parentList);
		List<MenuModel> menuList = menuService.getAll(mqm, pageNum, pageCount);
		ActionContext.getContext().put("menuList", menuList);
		return "list";
	}

	public String input() {
		List<RoleModel> roleList = roleService.getAll();
		ActionContext.getContext().put("roleList", roleList);
		// 加载所有一级菜单
		List<MenuModel> menuList = menuService.getAllOneLevel();
		ActionContext.getContext().put("menuList", menuList);
		if(mm.getUuid()!=null){
			mm = menuService.get(mm.getUuid());
			roleUuids = new Long[mm.getRoles().size()];
			int i = 0;
			for(RoleModel rm : mm.getRoles()){
				roleUuids[i++] = rm.getUuid();
			}
		}
		return "input";
	}

	public String save() {

		if(mm.getUuid() == null){
			menuService.save(mm,roleUuids);
		}else{
			menuService.update(mm,roleUuids);
		}
		return "toList";
	}

	public String delete() {
		menuService.delete(mm);
		return "toList";
	}
	public EmpModel getLogin(){
		return (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
	}
	public void showMenu() throws IOException{
		//String json = "[{\"text\":\"aaaaa\"}]";
		String root = ServletActionContext.getRequest().getParameter("root");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		StringBuilder json = new StringBuilder();
		json.append("[");
		
		if("source".equals(root)){
			List<MenuModel> menuList = menuService.getAllOneLevelByEmp(getLogin().getUuid());
			for(MenuModel temp : menuList){
			//一级菜单
				json.append("{\"text\":\"");
				json.append(temp.getName());
				json.append("\",\"hasChildren\":true,\"classes\":\"folder\",\"id\":\"");
				json.append(temp.getUuid());
				json.append("\"},");
			}
		}else{
			Long puuid = new Long(root);
			List<MenuModel> menuList = menuService.getByEmpAndPuuid(getLogin().getUuid(),puuid);
			for(MenuModel temp :menuList){
				json.append("{\"text\":\"<a target='mainFrame' onFocus='this.blur()' class='hei' href='");
				json.append(temp.getUrl());
				json.append("'>");
				json.append(temp.getName());
				json.append("</a>\",\"hasChildren\":false,\"classes\":\"file\"},");
			}
		}
		json.deleteCharAt(json.length()-1);
		//二级菜单
		json.append("]");
		pw.write(json.toString());
		pw.flush();
	}
}
