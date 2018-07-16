package com.zjp.tsms.servlet.taxer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxerDao;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet("/manage/deleteTaxerById.json")
public class DeletetaxerByIdServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		boolean flag = TaxerDao.getInstance().deleteTaxerById(StringUtil.stringToInteger(id));
		
		JSONObject json = new JSONObject();

		if (flag) {
			json.put("msg", " 删除成功");
			json.put("success", true);
		} else {
			json.put("msg", " 删除失败");
			json.put("success", false);
		}
		write(response, json);
	}

}
