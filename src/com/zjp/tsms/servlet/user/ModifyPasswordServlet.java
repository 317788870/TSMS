package com.zjp.tsms.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.dao.UserDao;
import com.zjp.tsms.entity.User;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * @author zjp
 * @date 2017年11月6日 上午10:31:51
 */
@WebServlet("/manage/modifypassword.json")
public class ModifyPasswordServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getSession().getAttribute("userName").toString();
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		response.setContentType("application/json;charset=utf-8");
		JSONObject json = new JSONObject();
		
		UserDao dao = UserDao.getInstance();
		User user = dao.getUserByUserName(userName);
		
		String salt = user.getSalt();
		String pwd = EncryptUtil.encryptMD5(oldPassword + salt);
		
		if (user.getPassword().equals(pwd)) {
			boolean flag = dao.modifyPasswordByUserName(userName, EncryptUtil.encryptMD5(newPassword + salt));
			if (flag) {
				json.put("msg", "修改成功");
				json.put("success", true);
			} else {
				json.put("msg", "修改失败");
				json.put("success", false);
			}
		} else {
			json.put("msg", "旧密码有误！");
			json.put("success", false);

		}
		
		write(response, json);
		
	}

}

