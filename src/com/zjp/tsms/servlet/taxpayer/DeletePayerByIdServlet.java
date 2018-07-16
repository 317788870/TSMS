package com.zjp.tsms.servlet.taxpayer;

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

/**
 * @author zjp
 * @date 2017年11月6日 下午4:16:10
 */
@WebServlet("/manage/deletePayerById.json")
public class DeletePayerByIdServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		int id = StringUtil.stringToInteger(request.getParameter("id"));
		
		
		JSONObject json = new JSONObject();
		boolean flag = TaxSourceDao.getInstance().getTaxSourceByPayerId(id);
		
		if (flag) {
			json.put("msg", "还有调查任务还未处理...");
			json.put("success", false);
			
		} else {
			boolean b = TaxPayerDao.getInstance().deletePayerById(id);
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

