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
	//定义一个收集查询条件的数据对象
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
	//跳转到列表页面
	public String list(){
		//查询数据总数
		dataTotal = depService.getCount(dqm);
		//最大页码值
		maxPageNum =( dataTotal+pageCount-1)/pageCount;
		//加载所有部门信息
		List<DepModel> depList = depService.getAll(dqm,pageNum,pageCount);
		//request
		ActionContext.getContext().put("depList", depList);
		/*List<DepModel> depListAll = depService.getAll();
		ActionContext.getContext().put("depListAll", depListAll);*/
		return "list";
	}
	//查询列表
	/*public String query(){
		//根据查询条件获取数据
		List<DepModel> depList = depService.getAll(dqm);
		//放入指定
		ActionContext.getContext().put("depList", depList);
		return "list";
	}*/
	//跳转到添加页面
	public String input(){
		if(dm.getUuid()!=null){
			dm = depService.get(dm.getUuid());
		}
			return "input";
	}
	//添加功能
	public String save(){
		if(dm.getUuid()==null){
			//将收集的只传递到业务层，完成保存功能
			depService.save(dm);
		}else{
			depService.update(dm);
		}
		return "toList";
	}
	
	//删除功能
	public String delete(){
		depService.delete(dm);
		return "toList";
	}
}
