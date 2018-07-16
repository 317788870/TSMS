package com.zjp.tsms.servlet.taxpayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxPayerDao;
import com.zjp.tsms.servlet.BaseServlet;

import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月8日 下午2:26:11
 */
@WebServlet("/manage/getTaxPayerCodes.json")
public class GetTaxPayerCodesServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String payerCode = request.getParameter("payerCode");
		JSONObject json = new JSONObject();
		boolean flag = TaxPayerDao.getInstance().checkPayerCode(payerCode);
		
		if (flag) {
			json.put("msg", "可以使用");
			json.put("success", flag);
		} else {
			json.put("msg", "已存在");
			json.put("success", flag);
		}
		write(response, json);

	}

}

