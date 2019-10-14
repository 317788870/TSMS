package com.zjp.tsms.servlet.captcha;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjp.tsms.servlet.BaseServlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/Captcha.jpg")
public class CaptchaServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义图形验证码的长、宽、验证码字符数、干扰元素个数
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(150, 50, 4, 20);

		HttpSession session = request.getSession();
		session.setAttribute("captcha", captcha);
		captcha.write(response.getOutputStream());
	}
}
