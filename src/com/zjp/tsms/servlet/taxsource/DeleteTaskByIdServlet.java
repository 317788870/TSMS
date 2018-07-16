package com.zjp.tsms.servlet.taxsource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxPayerDao;
import com.zjp.tsms.dao.TaxSourceDao;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet("/manage/deleteTaskById.json")
public class DeleteTaskByIdServlet extends BaseServlet {

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = StringUtil.stringToInteger(request.getParameter("id"));
		response.setContentType("application/json;charset=utf-8");
		
		JSONObject json = new JSONObject();
		
		
		boolean flag = TaxSourceDao.getInstance().getTaxSourceByPayerId(id);
	
		if (flag) {
			json.put("msg", "还有调查任务还未处理...");
			json.put("success", false);
			
		} else {
			boolean b = TaxSourceDao.getInstance().deleteTaskById(id);
			if (b) {
				json.put("msg", "删除成功");
				json.put("success", true);
			} else {
				json.put("msg", "删除失败");
				json.put("success", false);
			}
		}
		
		
		write(response, json);
		
		
		

	}

}
