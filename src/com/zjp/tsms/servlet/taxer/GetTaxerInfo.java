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

/**
 * @author zjp
 * @date 2017年11月3日 上午11:29:35
 */
@WebServlet("/manage/getTaxerInfo.json")
public class GetTaxerInfo extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		String id = request.getParameter("id");
		List<Map<String, String>> list = TaxerDao.getInstance().getTaxerById(StringUtil.stringToInteger(id));
		JSONArray jsonArray = JSONArray.fromObject(list);
		JSONObject json = new JSONObject();
		if (list != null && list.size() == 1) {
			json.put("rows", jsonArray);
			json.put("success", true);
		} else {
			json.put("msg", "没有用户");
			json.put("success", false);
		}
		write(response, json);
		
	}

}

