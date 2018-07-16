package com.zjp.tsms.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;
import com.zjp.tsms.dao.UserDao;
import com.zjp.tsms.entity.User;
import com.zjp.tsms.servlet.BaseServlet;
import com.zjp.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLogin.do")
public class UserLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		String remeberUser = request.getParameter("remeberUser");
		response.setContentType("application/json;charset=utf-8");
		
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		
		UserDao dao = UserDao.getInstance();
		User user = dao.getUserByUserName(userName);
		
		String validateCaptcha = session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
	
		if (validateCaptcha.equalsIgnoreCase(captcha)) {
			if (user != null) {
				String pwd = EncryptUtil.encryptMD5(password + user.getSalt());
				if (pwd.equals(user.getPassword())) {
					if ("on".equals(remeberUser)) {
						Cookie cookie = new Cookie("userName", userName);
						cookie.setMaxAge(60 * 60 * 24 * 7);
						response.addCookie(cookie);
					}
					session.setAttribute("userName", userName);
					session.setAttribute("id", user.getId());
					session.setAttribute("taxerId", user.getTaxerId());
					json.put("success", true);
					json.put("msg", "登录成功");
				} else {
					json.put("success", false);
					json.put("msg", "密码有误");
				}
			} else {
				json.put("success", false);
				json.put("msg", "账号有误");
			}
		} else {
			json.put("success", false);
			json.put("msg", "验证码有误");
		}
		write(response, json);
		
	}

}
