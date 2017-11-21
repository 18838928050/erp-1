package com.ahpu.erp.auth.dep.action;

import java.util.List;

import com.ahpu.erp.auth.dep.model.DepModel;
import com.ahpu.erp.auth.dep.model.DepQueryModel;
import com.ahpu.erp.auth.dep.service.DepService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DepAction extends ActionSupport {
	private DepService depService;
	
	private DepModel dm = new DepModel();
	//����һ���ռ���ѯ���������ݶ���
	public DepQueryModel dqm = new DepQueryModel();
	public DepModel getDm() {
		return dm;
	}

	public void setDm(DepModel dm) {
		this.dm = dm;
	}

	public void setDepService(DepService depService) {
		this.depService = depService;
	}
	public Integer pageNum=1;
	public Integer pageCount=6;
	public Integer maxPageNum;
	public Integer dataTotal;
	//��ת���б�ҳ��
	public String list(){
		//��ѯ��������
		dataTotal = depService.getCount(dqm);
		//���ҳ��ֵ
		maxPageNum =( dataTotal+pageCount-1)/pageCount;
		//�������в�����Ϣ
		List<DepModel> depList = depService.getAll(dqm,pageNum,pageCount);
		//request
		ActionContext.getContext().put("depList", depList);
		/*List<DepModel> depListAll = depService.getAll();
		ActionContext.getContext().put("depListAll", depListAll);*/
		return "list";
	}
	//��ѯ�б�
	/*public String query(){
		//���ݲ�ѯ������ȡ����
		List<DepModel> depList = depService.getAll(dqm);
		//����ָ��
		ActionContext.getContext().put("depList", depList);
		return "list";
	}*/
	//��ת�����ҳ��
	public String input(){
		if(dm.getUuid()!=null){
			dm = depService.get(dm.getUuid());
		}
			return "input";
	}
	//��ӹ���
	public String save(){
		if(dm.getUuid()==null){
			//���ռ���ֻ���ݵ�ҵ��㣬��ɱ��湦��
			depService.save(dm);
		}else{
			depService.update(dm);
		}
		return "toList";
	}
	
	//ɾ������
	public String delete(){
		depService.delete(dm);
		return "toList";
	}
}
