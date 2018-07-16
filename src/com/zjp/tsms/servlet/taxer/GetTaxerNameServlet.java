package com.zjp.tsms.servlet.taxer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxPayerDao;
import com.zjp.tsms.dao.TaxerDao;
import com.zjp.tsms.servlet.BaseServlet;

import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月8日 下午3:29:13
 */
@WebServlet("/manage/getTaxerName.json")
public class GetTaxerNameServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String id = request.getSession().getAttribute("taxerId").toString();
		JSONObject json = new JSONObject();
		
		String taxerName = TaxerDao.getInstance().getTaxerName(id);
		if (taxerName != null) {
			json.put("taxerName", taxerName);
		}
		write(response, json);
	}

}

