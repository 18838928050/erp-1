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
	//ע��ҵ���ӿ�
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
	
	public Integer pageNum=1;//��ǰҳ��
	public Integer pageCount=6;//ÿҳ��ʾ��������
	public Integer maxPageNum;//���ҳ����
	public Integer dataTotal;//��������
	public Long[] roleUuids;//����ҳ�洫�ݵĽ�ɫ����
	//	��¼
	/*
	ҳ���ռ����û�����������Ϣ
	�����ݴ��ݵ�ҵ���
	ҵ���ת�����ݲ�
	����ҵ���ѯ����ѯ�������*/
	public String list(){
		// �������в��ŵ���Ϣ����
		List<DepModel> depList = depService.getAll();
		ActionContext.getContext().put("depList", depList);
		// ��ѯ��������
		dataTotal = empService.getCount(eqm);
		// ���ҳ��ֵ
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		List<EmpModel> empList = empService.getAll(eqm, pageNum, pageCount);
		ActionContext.getContext().put("empList", empList);
		return "list";
	}
	
	public String input(){
		List<DepModel> depList = depService.getAll();
		ActionContext.getContext().put("depList", depList);
		// �������еĽ�ɫ��Ϣ
		List<RoleModel> roleList = roleService.getAll();
		ActionContext.getContext().put("roleList", roleList);
		if(em.getUuid()!=null){
			em = empService.get(em.getUuid());
			//����roleUuids
			roleUuids = new Long[em.getRoles().size()];//ΪroleUuids����ռ�
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
		// �жϲ�ѯ����������ѯ��
		// ��¼�ɹ��������¼ʧ��
		if (loginEm == null) {
			// ��¼ʧ��
			// ��ӵ�¼ʧ�ܵ���Ϣ
			this.addActionError("�Բ����û����������");
			return "loginFail";
		} else {
			// ��¼�ɹ�
			// ����¼����Ϣ����Session����ת����ҳ
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
	//ע���û�
	public String quit(){
		ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, null);
		return "noLogin";
	}
	//��ת���޸�����ҳ��
	public String tochangePwd(){
		return "tochangePwd";
	}
	//��ȡ��ǰ�û���Ϣ
	public EmpModel getLogin(){
		return (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
	}
	//�޸�����
	public String newPwd;
	public String renewPwd;
	public String changePwd(){
		boolean flag = empService.changePwd(getLogin().getUserName(),em.getPwd(),newPwd);
		if(!newPwd.equals(renewPwd)){
			addActionError("�����������벻һ��");
			return "tochangePwd";
		}
		if(flag){
			//���µ�¼
			ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, null);
			return "noLogin";
		}else{
			//��ʾ�û��޸���Ϣ����
			addActionError("ԭ���벻��ȷ");
			return "tochangePwd";
		}
	}
	
}
