package com.zjp.tsms.servlet.taxsource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxSourceDao;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/manage/getTaskInfo.json")
public class GetTaskInfoServlet extends BaseServlet {

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		response.setContentType("application/json;charset=utf-8");
		
		List<Map<String, String>> list = TaxSourceDao.getInstance().getTaskInfoById(StringUtil.stringToInteger(id));
		
		
		JSONObject json = new JSONObject();
		if (list!=null) {
			json.put("rows", JSONArray.fromObject(list));
			json.put("success", true);
		} else {
			json.put("success", false);
		}
		write(response, json);
	}

}
