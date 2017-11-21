package com.ahpu.erp.auth.emp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.SimpleFormatter;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.role.model.RoleModel;
import com.ahpu.erp.util.format.FormatUtil;
/**
 * Ա����Ϣ
 * @author Miracle
 *
 */
public class EmpModel {
	public static final String EMP_LOGIN_USER_OBJECT_NAME = "loginEm";

	public static final Integer EMP_GENDER_OF_MAN = 1;
	public static final Integer EMP_GENDER_OF_WOMAN = 0;
	
	public static final String EMP_GENDER_OF_MAN_VIEW = "��";
	public static final String EMP_GENDER_OF_WOMAN_VIEW = "Ů";
	
	public static final Map<Integer, String> genderMap = new HashMap<Integer, String>();
	static{
		genderMap.put(EMP_GENDER_OF_MAN, EMP_GENDER_OF_MAN_VIEW);
		genderMap.put(EMP_GENDER_OF_WOMAN, EMP_GENDER_OF_WOMAN_VIEW);
	}
	// ע�Ṧ��
	private Long uuid;
	// �û���
	private String userName;
	// ����
	private String pwd;
	// ��ʵ����
	private String name;
	// ��������
	private String email;
	// ��ϵ��ʽ
	private String tele;
	// ��ַ
	private String address;
	// �Ա�
	private Integer gender;// 1-�� 0-Ů
	private Long birthday;
	// ����
	private DepModel dm;
	//��ɫ
	private Set<RoleModel> roles;
	
	public Set<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	private String birthdayView;
	private String genderView;
	private Long lastLoginTime;
	private String lastLoginIp;
	private Integer loginTimes;
	private String lastLoginTimeView;

	public String getLastLoginTimeView() {
		return lastLoginTimeView;
	}
	public Long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		this.lastLoginTimeView = FormatUtil.formatDate(lastLoginTime);
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Integer getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getGenderView() {
		return genderView;
	}
	public String getBirthdayView() {
		return birthdayView;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
		this.genderView = genderMap.get(gender);
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {

		this.birthday = birthday;
		this.birthdayView = FormatUtil.formatDate(birthday);
	}

	public DepModel getDm() {
		return dm;
	}

	public void setDm(DepModel dm) {
		this.dm = dm;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
