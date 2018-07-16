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

/**
 * @author zjp
 * @date 2017年11月8日 上午11:42:25
 */
@WebServlet("/manage/addTaxSource.json")
public class AddTaxSourceServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		
		TaxSource source = new TaxSource();
		
		String taskName = request.getParameter("taskName");
		if (taskName != null) {
			source.setTaskName(taskName);
		}
		String payerId = request.getParameter("payerId");
		if (payerId != null) {
			source.setPayerId(StringUtil.stringToInteger(payerId));;
		}
		String taxOrganId = request.getParameter("taxOrganId");
		if (taxOrganId != null) {
			source.setSubOrganId(StringUtil.stringToInteger(taxOrganId));
		}
		String approveId = request.getParameter("approveId");
		if (approveId != null) {
			source.setApproveId(StringUtil.stringToInteger(approveId));
		}
		String executeId = request.getParameter("executeId");
		if (executeId != null) {
			source.setExecuteId(StringUtil.stringToInteger(executeId));
		}
		String executeTime = request.getParameter("executeTime");
		if (executeTime != null) {
			source.setExecuteTime(executeTime);
		} else {
			source.setExecuteTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		String taskState = request.getParameter("taskState");
		if (taskState != null) {
			source.setTaskState(taskState);
		}
		
		boolean flag = TaxSourceDao.getInstance().addTaxSource(source);
		if (flag) {
			json.put("msg", "添加成功");
			json.put("success", flag);
		} else {
			json.put("msg", "添加失败");
			json.put("success", flag);
		}
		write(response, json);

	}

}

