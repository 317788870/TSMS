package com.zjp.tsms.servlet.taxer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxerDao;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/manage/getAllListTaxer.json")
public class GetAllListTaxerServlet extends BaseServlet{


	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		String taxerName = request.getParameter("taxerName");
		
		if (pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == null) {
			pageSize = "10";
		}
		
		TaxerDao dao = TaxerDao.getInstance();
		
		JSONObject json = new JSONObject();
		
		List<Map<String, String>> list = dao.getTaxerByPage(StringUtil.stringToInteger(pageNo), StringUtil.stringToInteger(pageSize), taxerName);
		if (list != null) {
			JSONArray array = JSONArray.fromObject(list);
			json.put("total", dao.getTaxerCount(taxerName));
			json.put("rows", array);
		}
		write(response, json);
		
		
	}

}
