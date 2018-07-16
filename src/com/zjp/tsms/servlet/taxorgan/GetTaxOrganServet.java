package com.zjp.tsms.servlet.taxorgan;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.TaxOrganDao;
import com.zjp.tsms.entity.TaxOrgan;
import com.zjp.tsms.servlet.BaseServlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月7日 下午2:46:51
 */
@WebServlet("/manage/getTaxOrgan.json")
public class GetTaxOrganServet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		List<TaxOrgan> listIndust = TaxOrganDao.getInstance().getTaxOrgan();
		JSONArray jsonArray = new JSONArray();
		for (TaxOrgan taxOrgan : listIndust) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", taxOrgan.getId());
			jsonObject.put("text", taxOrgan.getOrganName());
			jsonArray.add(jsonObject);
		}
		response.getWriter().println(jsonArray.toString());
		
	}

}

