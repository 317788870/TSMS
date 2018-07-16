package com.zjp.tsms.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjp.tsms.servlet.BaseServlet;

/**
 * @author zjp
 * @date 2017年11月6日 上午11:34:30
 */
@WebServlet("/manage/UserLoginOut.action")
public class UserLoginOutServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("userName");
		response.sendRedirect("login.html");
		
	}

}

