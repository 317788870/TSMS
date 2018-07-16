package com.zjp.tsms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BaseServlet
 */
public abstract class BaseServlet extends HttpServlet {
	
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected static final String ROWS = "rows";
	protected static final String PAGE = "page";
	protected static final String TOTAL = "total";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			excuteRequest(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/manage/html/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * 子类必须重写的方法，用来处理请求和响应
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected abstract void excuteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	protected void write(HttpServletResponse response, JSONObject json) {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}

}
