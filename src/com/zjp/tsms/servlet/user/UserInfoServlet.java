package com.zjp.tsms.servlet.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.UserDao;
import com.zjp.tsms.servlet.BaseServlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/manage/getUserInfo.json")
public class UserInfoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taxerId =  request.getSession().getAttribute("taxerId").toString();
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject json = new JSONObject();
		List<Map<String, String>> list = UserDao.getInstance().getUserInfoByTaxerId(Integer.parseInt(taxerId));
		if (list!=null) {
			json.put("rows", JSONArray.fromObject(list));
			json.put("success", true);
		} else {
			json.put("success", false);
		}
		write(response, json);
	
		
	}


}
