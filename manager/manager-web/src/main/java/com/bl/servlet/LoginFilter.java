package com.bl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.base.LoginBean;
import org.springframework.web.filter.OncePerRequestFilter;

public class LoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest arg0,
			HttpServletResponse arg1, FilterChain arg2)
			throws ServletException, IOException {
		//这里可做些日志和客户端信息统计
		LoginBean lb = (LoginBean) arg0.getSession().getAttribute(LoginBean.UserLoginKey);

		String queryString1 = arg0.getQueryString();
		if (queryString1 != null && (queryString1.contains("doLogin"))) {
			arg2.doFilter(arg0, arg1);
			return;
		}
	    String message = "会话超时或未登陆，请登录后再试";
		if (lb == null) {
			PrintWriter writer = arg1.getWriter();
			arg1.setContentType("text/html");

			writer.write("<html><head>");
			writer.write("<script type=\"text/javascript\" src=\""
					+ arg0.getContextPath() + "/js/jQuery-2.1.3.min.js\"></script>");
			String login = arg0.getContextPath() + "/index.jsp";
			writer.write("<script language=\"javascript\" type=\"text/javascript\">");

			writer.write("$(function(){");
			writer.write("alert('"+message+"');"
					+ "if (window.parent)"
					+ " window.parent.location.href='"
					+ login
					+ "'; "
					+ "else "
					+ " window.location.href='"
					+ login + "';");
			writer.write("});");
			writer.write("</script></head><body></body></html>");
			writer.flush();
			writer.close();
			return;
		} else{
			arg2.doFilter(arg0, arg1);
		}
	}
}
