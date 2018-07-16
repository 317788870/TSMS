package com.zjp.tsms.servlet.taxsource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxSourceDao;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SearchTaskSetvlet
 */
@WebServlet("/manage/getAllSearchTaskSetvlet.json")
public class SearchTaskSetvlet extends BaseServlet {

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pageNo = request.getParameter("page");//第几页 pageNo
		String pageSize = request.getParameter("rows");//每页的条数 pageSize
		
		String payerCode = request.getParameter("payerCode");//纳税人识别号
		String payerName = request.getParameter("payerName");//纳税人名称
		String taxOrganId = request.getParameter("taxOrganId");//税务机关
		String industryId = request.getParameter("industryId");//行业
		String executeTime = request.getParameter("executeTime");//任务开始执行时间
		String recordTaskDate = request.getParameter("recordTaskDate");//任务结束执行时间
		
		
		
		JSONObject json = new JSONObject();
		TaxSourceDao dao = TaxSourceDao.getInstance();
		int totalCount = dao.getAllSearchTaskCount(payerCode,payerName,taxOrganId,industryId,executeTime,recordTaskDate);
		if (pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == null) {
			pageSize = "10";
		}
		if (executeTime != null) {
			if (recordTaskDate == null) {
				json.put("msg", "任务结束时间不能为空");
			}
		}
		
		List<Map<String, String>> list = dao.getAllSearchTaskByPage(StringUtil.stringToInteger(pageNo),StringUtil.stringToInteger(pageSize),
				payerCode,payerName,taxOrganId,industryId,executeTime,recordTaskDate);
		JSONArray array = JSONArray.fromObject(list);
		if (list != null) {
			json.put("total", totalCount);
			json.put("rows", array);
		} else {
			json.put("total", totalCount);
			json.put("rows", array);
			
		}
		
		write(response, json);
	}
}
