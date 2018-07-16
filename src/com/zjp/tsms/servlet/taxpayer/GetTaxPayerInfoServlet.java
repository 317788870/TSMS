package com.zjp.tsms.servlet.taxpayer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxPayerDao;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月7日 上午9:45:29
 */
@WebServlet("/manage/getTaxPayerInfo.json")
public class GetTaxPayerInfoServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setContentType("application/json;charset=utf-8");
		
		List<Map<String, String>> list = TaxPayerDao.getInstance().getTaxPayerById(StringUtil.stringToInteger(id));
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

