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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月8日 上午10:56:48
 */
@WebServlet("/manage/getTaxPayerByPayerCode.json")
public class GetTaxPayerByPayerCodeServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String payerCode = request.getParameter("payerCode");
		
		List<Map<String, String>> list = TaxPayerDao.getInstance().getTaxPayerByPayerCode(payerCode);
		JSONObject json = new JSONObject();
		if (list!=null) {
			json.put("rows", JSONArray.fromObject(list));
			json.put("success", true);
		} else {
			json.put("success", false);
			json.put("msg", "纳税识别号有误！");
		}
		write(response, json);

	}

}

