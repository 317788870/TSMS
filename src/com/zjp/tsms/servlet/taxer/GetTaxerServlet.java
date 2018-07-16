package com.zjp.tsms.servlet.taxer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxerDao;
import com.zjp.tsms.entity.Taxer;
import com.zjp.tsms.servlet.BaseServlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月8日 上午11:13:50
 */
@WebServlet("/manage/getTaxer.json")
public class GetTaxerServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		List<Taxer> listTaxers = TaxerDao.getInstance().getTaxer();
		JSONArray jsonArray = new JSONArray();
		for (Taxer taxer : listTaxers) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", taxer.getId());
			jsonObject.put("text", taxer.getTaxerName());
			jsonArray.add(jsonObject);
		}
		response.getWriter().println(jsonArray.toString());
		
		

	}

}

