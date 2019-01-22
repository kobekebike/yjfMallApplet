package com.bl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.pojo.LoginBean;
import org.springframework.web.filter.OncePerRequestFilter;

public class LoginFilter extends OncePerRequestFilter {
	//public static Logger log = Logger.getLogger(LoginFilter.class);



	@Override
	protected void doFilterInternal(HttpServletRequest arg0,
			HttpServletResponse arg1, FilterChain arg2)
			throws ServletException, IOException {
		//这里可做些日志和客户端信息统计
		 LoginBean lb = (LoginBean) arg0.getSession().getAttribute(LoginBean.UserLoginKey);
		    boolean auth2Lower = false;
		    
		    String queryString1 = arg0.getQueryString();
		    if(queryString1!=null&&(queryString1.contains("getQccInfoCount")||queryString1.contains("gongshangheming") ||queryString1.contains("toPassWord"))){
				arg2.doFilter(arg0, arg1);
				return ;
			}
	    
	    if (lb != null)
	    {
	    	// 判断用户当前状态
			// 如果状态不等于0，则清除session，重新登陆
//			UserService userService = null;
//			ServletContext sc = arg0.getSession().getServletContext();
//			XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);
//			if(cxt != null && cxt.getBean("userService") != null && userService == null) {
//				userService = (UserService) cxt.getBean("userService");
//			}
//			User user = userService.getUserById(lb.getUserId());
//			if ( user.getStatus() != Byte.valueOf("0") ) {
//				arg0.getSession().removeAttribute(LoginBean.UserLoginKey);
//			}


	    	String service = arg0.getServletPath();
	    	String queryString = arg0.getQueryString();
	    	if (queryString == null)
	    	{
	    		queryString = "";
	    		Enumeration<String> params = arg0.getParameterNames();
	    		while (params.hasMoreElements())
	    		{
	    			String param = params.nextElement();
	    			queryString += (param + "=" + arg0.getParameter(param) + "&");
	    		}	    		
	    	}
//	    	log.info("操作用户: " + lb.getUserName() + " 账号: " + lb.getUserAccount() + " 远程位置:" +
//	    			arg0.getRemoteAddr());
//	    	log.info("请求: " + service + " 参数:" + queryString);
	    	
	    	//就算其登陆了，还要检验对应的权限	    	
	    	String method = arg0.getParameter("method");	    	
//	    	for(RoleResourceBean r: lb.getResourceList())
//	    	{
//	    		boolean cond1 = (r.getService() != null) && (service.indexOf(r.getService()) > 0);
//	    		boolean cond2 = (r.getMethod() != null) && (r.getMethod().length() > 0);
//	    		 
//	    		if ((cond1 && cond2 && (method != null) && method.equalsIgnoreCase(r.getMethod())) //配置了服务和方法
//	    		|| (cond1 && !cond2 && (method == null)))	//只有服务
//    			{		    			
//    				if (!r.getEnabled())
//	    			{
//	    				log.info("用户尝试了一个非法请求");
//	    				lb = null;
//	    				auth2Lower = true;
//	    				break;
//	    			}
//    			}
//	    	}
	    }
	    String message = auth2Lower==true?"权限不足，请使用其他身份登录再试":"会话超时或未登陆，请登录后再试";
		if (lb == null) {
			PrintWriter writer = arg1.getWriter();
			/*if (arg0.getHeader("accept").indexOf("text/json") >= 0
					|| arg0.getHeader("accept").indexOf("application/json") >= 0
					|| arg0.getHeader("accept").indexOf("text/javascript") >= 0) {
				arg1.setContentType("text/json");
				// arg1.addHeader("accept", "application/json");
				HashMap<String, String> rlt = new HashMap<>();
				rlt.put("result", "false");				 
				rlt.put("message", message);				
				writer.write(JSONObject.fromObject(rlt).toString());
				writer.flush();
				writer.close();
				return;
			} else*/
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
		} else
			arg2.doFilter(arg0, arg1);
	}

}
