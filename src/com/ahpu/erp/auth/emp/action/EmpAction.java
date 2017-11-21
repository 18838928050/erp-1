package com.ahpu.erp.auth.emp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.dep.model.DepQueryModel;
import com.ahpu.erp.auth.dep.service.DepService;
import com.ahpu.erp.auth.emp.dao.dao.EmpDao;
import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.emp.model.EmpQueryModel;
import com.ahpu.erp.auth.emp.service.service.EmpService;
import com.ahpu.erp.auth.menu.model.MenuModel;
import com.ahpu.erp.auth.menu.model.MenuQueryModel;
import com.ahpu.erp.auth.menu.service.service.MenuService;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.auth.role.service.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	public EmpModel em = new EmpModel();
	public EmpQueryModel eqm = new EmpQueryModel();
	//注入业务层接口
	private EmpService empService;
	private DepService depService;
	private RoleService roleService;
	

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public void setDepService(DepService depService) {
		this.depService = depService;
	}
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	public Integer pageNum=1;//当前页码
	public Integer pageCount=6;//每页显示数据总数
	public Integer maxPageNum;//最大页码量
	public Integer dataTotal;//总数据量
	public Long[] roleUuids;//接收页面传递的角色参数
	//	登录
	/*
	页面收集了用户名，密码信息
	将数据传递到业务层
	业务层转调数据层
	进行业务查询，查询结果返回*/
	public String list(){
		// 加载所有部门的信息数据
		List<DepModel> depList = depService.getAll();
		ActionContext.getContext().put("depList", depList);
		// 查询数据总数
		dataTotal = empService.getCount(eqm);
		// 最大页码值
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		List<EmpModel> empList = empService.getAll(eqm, pageNum, pageCount);
		ActionContext.getContext().put("empList", empList);
		return "list";
	}
	
	public String input(){
		List<DepModel> depList = depService.getAll();
		ActionContext.getContext().put("depList", depList);
		// 加载所有的角色信息
		List<RoleModel> roleList = roleService.getAll();
		ActionContext.getContext().put("roleList", roleList);
		if(em.getUuid()!=null){
			em = empService.get(em.getUuid());
			//加载roleUuids
			roleUuids = new Long[em.getRoles().size()];//为roleUuids分配空间
			int i=0;
			for(RoleModel temp : em.getRoles()){
				roleUuids[i++] = temp.getUuid();
			}
		}
		return "input";
	}
	
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String loginIp = request.getHeader("x-forwarded-for"); 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getRemoteAddr(); 
		}
		EmpModel loginEm = empService.login(em.getUserName(), em.getPwd(),loginIp);
		// 判断查询结果，如果查询到
		// 登录成功，否则登录失败
		if (loginEm == null) {
			// 登录失败
			// 添加登录失败的信息
			this.addActionError("对不起，用户名密码错误！");
			return "loginFail";
		} else {
			// 登录成功
			// 将登录人信息放入Session，跳转到主页
			ActionContext.getContext().getSession()
					.put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, loginEm);
			return "loginSuccess";
		}
	}
	
	public String save(){
		if(em.getUuid()==null){
			empService.save(em,roleUuids);
		}else{
			empService.update(em,roleUuids);
		}
		return "toList";
	}
	
	//delete
	public String delete(){
		
		empService.delete(em);
		return "toList";
	}
	//注销用户
	public String quit(){
		ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, null);
		return "noLogin";
	}
	//跳转到修改密码页面
	public String tochangePwd(){
		return "tochangePwd";
	}
	//获取当前用户信息
	public EmpModel getLogin(){
		return (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
	}
	//修改密码
	public String newPwd;
	public String renewPwd;
	public String changePwd(){
		boolean flag = empService.changePwd(getLogin().getUserName(),em.getPwd(),newPwd);
		if(!newPwd.equals(renewPwd)){
			addActionError("两次输入密码不一致");
			return "tochangePwd";
		}
		if(flag){
			//重新登录
			ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, null);
			return "noLogin";
		}else{
			//提示用户修改信息错误
			addActionError("原密码不正确");
			return "tochangePwd";
		}
	}
	
}
