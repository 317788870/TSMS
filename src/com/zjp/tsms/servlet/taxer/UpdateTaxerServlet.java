package com.zjp.tsms.servlet.taxer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxerDao;
import com.zjp.tsms.entity.Taxer;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet("/manage/updateTaxer.json")
public class UpdateTaxerServlet extends BaseServlet {

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		
		String id = request.getParameter("id");
		String taxerCode = request.getParameter("taxerCode");
		String taxerName = request.getParameter("taxerName");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String taxOrganId = request.getParameter("taxOrganId");
		
		Taxer taxer = new Taxer();
		taxer.setId(StringUtil.stringToInteger(id));
		taxer.setTaxerCode(StringUtil.isNotNullStr(taxerCode));
		taxer.setTaxerName(StringUtil.isNotNullStr(taxerName));
		taxer.setMobile(StringUtil.isNotNullStr(mobile));
		taxer.setAddress(StringUtil.isNotNullStr(address));
		taxer.setSex(sex);
		taxer.setEmail(StringUtil.isNotNullStr(email));
		if (birthday != null && !"".equals(birthday)) {
			taxer.setBirthday(birthday);
		}
		taxer.setOrganId(StringUtil.stringToInteger(taxOrganId));
		
		TaxerDao dao = TaxerDao.getInstance();
		JSONObject json = new JSONObject();
		if ("add".equals(type)) {
			boolean flag = dao.addTaxer(taxer);
			if (flag) {
				json.put("msg", " 添加成功");
				json.put("success", true);
			} else {
				json.put("msg", " 添加失败");
				json.put("success", false);
			}
		} else if("update".equals(type)) {
			boolean flag = dao.updateTaxer(taxer);
			if (flag) {
				json.put("msg", " 修改成功");
				json.put("success", true);
			} else {
				json.put("msg", " 修改失败");
				json.put("success", false);
			}
		}
		
		write(response, json);
	}

}
