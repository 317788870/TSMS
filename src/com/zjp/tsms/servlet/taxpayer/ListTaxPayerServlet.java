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
 * Servlet implementation class ListTaxPayerServlet
 */
@WebServlet("/manage/getlistTaxPayerServlet.json")
public class ListTaxPayerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public ListTaxPayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String type = request.getParameter("type");//第几页 pageNo
		String pageNo = request.getParameter("page");//第几页 pageNo
		String pageSize = request.getParameter("rows");//每页的条数 pageSize
		String payerCode = request.getParameter("payerCode");
		String payerName = request.getParameter("payerName");
		if (pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == null) {
			pageSize = "10";
		}
		TaxPayerDao dao = TaxPayerDao.getInstance();
		
		
		JSONObject json = new JSONObject();
		if ("list".equals(type)) {
			List<Map<String, String>>  list = dao.getAllTaxPayerByPage(StringUtil.stringToInteger(pageNo), StringUtil.stringToInteger(pageSize), payerCode, payerName);
			JSONArray jsonArray = JSONArray.fromObject(list);
			if (list != null && list.size() > 0) {
				json.put("rows", jsonArray);
				json.put("total", dao.getAllPayersTotalRows(payerCode, payerName));
			} else {
				json.put("rows", jsonArray);
				json.put("total", dao.getAllPayersTotalRows(payerCode, payerName));
			}
		} else if ("noResearch".equals(type)) {
			List<Map<String, String>>  list = dao.getNoResearchByPage(StringUtil.stringToInteger(pageNo), StringUtil.stringToInteger(pageSize), payerCode, payerName);
			JSONArray jsonArray = JSONArray.fromObject(list);
			if (list != null && list.size() > 0) {
				json.put("rows", jsonArray);
				json.put("total", dao.getNoResearchCount(payerCode, payerName));
			} else {
				json.put("rows", jsonArray);
				json.put("total", dao.getNoResearchCount(payerCode, payerName));
			}
		}
		
		write(response, json);
	}


}
