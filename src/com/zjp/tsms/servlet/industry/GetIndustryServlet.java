package com.zjp.tsms.servlet.industry;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.IndustryDao;
import com.zjp.tsms.entity.Industry;
import com.zjp.tsms.servlet.BaseServlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月7日 下午12:03:20
 */
@WebServlet("/manage/getIndustry.json")
public class GetIndustryServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		List<Industry> listIndust = IndustryDao.getInstance().getIndustry();
		JSONArray jsonArray = new JSONArray();
		for (Industry industry : listIndust) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", industry.getId());
			jsonObject.put("text", industry.getIndustryName());
			jsonArray.add(jsonObject);
		}
		
		response.getWriter().println(jsonArray.toString());
		
	}

}

