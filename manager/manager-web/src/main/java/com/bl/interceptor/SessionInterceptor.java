package com.bl.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.pojo.LoginBean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 这个类用来检查每个请求耗费的时间
 * @author hanst
 *
 */
public class SessionInterceptor implements HandlerInterceptor{
		public static Logger log = LogManager.getLogger(SessionInterceptor.class);
		
		@Override  
		public boolean preHandle(HttpServletRequest request,   
		        HttpServletResponse response, Object handler) throws Exception {
			long startTime = System.currentTimeMillis();
	        request.setAttribute("request_per_handleTime",startTime);	        	        
			return true;   
		}   
		  
		@Override  
		public void postHandle(HttpServletRequest request,   
		        HttpServletResponse response, Object handler,   
		        ModelAndView modelAndView) throws Exception {   
			  
		}   
		 
		  
		@Override  
		public void afterCompletion(HttpServletRequest request,   
		        HttpServletResponse response, Object handler, Exception ex)   
		        throws Exception {
            LoginBean loginBean = null;

			try {
				if(request.getSession(false)!=null){
					loginBean = (LoginBean) request.getSession().getAttribute(LoginBean.UserLoginKey);
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}

			long startTime = (Long)request.getAttribute("request_per_handleTime");  
	        request.removeAttribute("request_per_handleTime");  
	        long endTime = System.currentTimeMillis();
	        if(loginBean!=null){
                log.info(loginBean.getUserName()+"请求:" + request.getServletPath() + "共耗时:" + ((endTime - startTime)/1000.0 + "秒"));
            }else{
                log.info("请求:" + request.getServletPath() + "共耗时:" + ((endTime - startTime)/1000.0 + "秒"));
            }

		}
		
}
