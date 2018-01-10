package com.loski.collect.share.tender.action;

import java.util.Collections;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.loski.collect.share.common.action.StrutsAction;
import com.loski.collect.share.common.util.JsonUtil;
import com.loski.collect.share.shiro.util.ShiroUtils;
import com.loski.collect.share.tender.entity.TenderData;
import com.loski.collect.share.tender.util.AverageTender;
import com.loski.collect.share.tender.util.ComparatorTender;

import net.sf.json.JSONArray;

@Namespace("/tender")
@ParentPackage("json-default")
public class TenderAction extends StrutsAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9054044794898235700L;

	@Action(value="tender",results={@Result(name="success",type="freemarker",location="/ui/html/tender.html")})
	public String tender(){
		ShiroUtils.getSession();
		
		System.out.println("1234");
		return SUCCESS;
	}
	
	@SuppressWarnings({ "static-access", "unchecked" })
	@Action(value="tenderResult")
	public void tenderResult(){
		String jsonString = request.getParameter("jsonString");
		if(jsonString != null && !"".equals(jsonString)){
			JSONArray jsonArray = new JSONArray();
			jsonArray = jsonArray.fromObject(jsonString);
			@SuppressWarnings("rawtypes")
			List<TenderData> list = (List)JSONArray.toCollection(jsonArray, TenderData.class);
			ComparatorTender comparator=new ComparatorTender();
			Collections.sort(list, comparator);
			if( list.size() >3 && list.size() <=9){
				int i = list.size();
				list.remove(i-1);
				list.remove(0);
				JsonUtil.sendSuccessMsg(response,"计算成功",AverageTender.average(list));
			}else if(list.size() >9){
				int i = list.size();
				list.remove(i-2);
				list.remove(0);
				JsonUtil.sendSuccessMsg(response,"计算成功",AverageTender.average(list));
			}else{
				JsonUtil.sendSuccessMsg(response,"计算成功",AverageTender.average(list));
			}
		}
	}
}
