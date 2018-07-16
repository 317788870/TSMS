package com.zjp.tsms.servlet.taxsource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxSourceDao;
import com.zjp.tsms.entity.TaxSource;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONObject;


@WebServlet("/manage/updateTaskServlet.json")
public class UpdateTaskServlet extends BaseServlet {

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");//根据type值确定为修改任务和任务录入（添加）
		
		
	
		JSONObject json = new JSONObject();
		
		TaxSource source = new TaxSource();
		String id = request.getParameter("id");//税源id
		String payerId = request.getParameter("payerId");//纳税人id
		String taskName = request.getParameter("taskName");//任务名称
		String taxOrganId = request.getParameter("taxOrganId");//下达部门 id
		String approveId = request.getParameter("approveId");//批准人 id
		String executeId = request.getParameter("executeId");////执行人 id
		String executeTime = request.getParameter("executeTime");//任务开始执行时间
		String taskState = request.getParameter("taskState");//执行任务情况
		
		source.setId(StringUtil.stringToInteger(id));
		source.setPayerId(StringUtil.stringToInteger(payerId));
		source.setTaskName(StringUtil.isNotNullStr(taskName));
		source.setSubOrganId(StringUtil.stringToInteger(taxOrganId));
		source.setApproveId(StringUtil.stringToInteger(approveId));
		source.setExecuteId(StringUtil.stringToInteger(executeId));
		source.setExecuteTime(StringUtil.isNotNullStr(executeTime));
		source.setTaskState(StringUtil.isNotNullStr(taskState));
		
		TaxSourceDao dao = TaxSourceDao.getInstance();
		
		
		if ("edit".equals(type)) {
			boolean flag = dao.updateTaxSource(source);
			if (flag) {
				json.put("msg", "修改成功");
				json.put("success", flag);
			} else {
				json.put("msg", "修改失败");
				json.put("success", flag);
			}
			
		}
		if ("add".equals(type)) {
			boolean flag = TaxSourceDao.getInstance().addTaxSource(source);
			if (flag) {
				json.put("msg", "添加成功");
				json.put("success", flag);
			} else {
				json.put("msg", "添加失败");
				json.put("success", flag);
			}
		}
		
		write(response, json);
	}

}
