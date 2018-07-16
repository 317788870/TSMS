package com.zjp.tsms.servlet.taxpayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxPayerDao;
import com.zjp.tsms.entity.TaxPayer;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月7日 下午3:26:31
 */
@WebServlet("/manage/editTaxPayer.json")
public class EditTaxPayerServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		JSONObject json = new JSONObject();
		
		TaxPayer payer = new TaxPayer();
		String id = request.getParameter("id");
		payer.setId(StringUtil.stringToInteger(id));
		String payerCode = request.getParameter("payerCode");
		payer.setPayerCode(payerCode);
		String payerName = request.getParameter("payerName");
		if (payerName != null) {
			payer.setPayerName(payerName);
		}
		String bizAddress = request.getParameter("bizAddress");
		if (bizAddress != null) {
			payer.setBizAddress(bizAddress);
		}
		String bizAddressPhone = request.getParameter("bizAddressPhone");
		if (bizAddressPhone != null) {
			payer.setBizAddressPhone(bizAddressPhone);
		}
		String taxOrganId = request.getParameter("taxOrganId");
		if (taxOrganId != null) {
			payer.setTaxOrganId(StringUtil.stringToInteger(taxOrganId));
		}
		String industryId = request.getParameter("industryId");
		if (industryId != null) {
			payer.setIndustryId(StringUtil.stringToInteger(industryId));
		}
		String bizScope = request.getParameter("bizScope");
		if (bizScope != null) {
			payer.setBizScope(bizScope);
		}
		String invoiceType = request.getParameter("invoiceType");
		if (invoiceType != null) {
			payer.setInvoiceType(invoiceType);
		}
		String legalPerson = request.getParameter("legalPerson");
		if (legalPerson != null) {
			payer.setLegalPerson(legalPerson);
		}
		String legalIdCard = request.getParameter("legalIdCard");
		if (legalIdCard != null) {
			payer.setLegalIdCard(legalIdCard);
		}
		String finaceName = request.getParameter("finaceName");
		if (finaceName != null) {
			payer.setFinaceName(finaceName);
		}
		String finaceIdCard = request.getParameter("finaceIdCard");
		if (finaceIdCard != null) {
			payer.setFinaceIdCard(finaceIdCard);
		}
		String userId = request.getSession().getAttribute("id").toString();
		payer.setUserId(StringUtil.stringToInteger(userId));
		
		boolean flag = TaxPayerDao.getInstance().updatePayer(payer);
		if (flag) {
			json.put("msg", " 修改成功");
			json.put("success", true);
		} else {
			json.put("msg", " 修改失败");
			json.put("success", false);
		}
		write(response, json);
		
		
		
	}

}

