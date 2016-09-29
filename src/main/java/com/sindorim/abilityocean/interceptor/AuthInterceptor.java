package com.sindorim.abilityocean.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sindorim.abilityocean.domain.User;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.debug("prehandler");
		System.out.println("prehandler");
		if(this.isMain(request)) return true;
		
		if(this.isUriToExclude(request)) return true; 
		
		if(this.isMember(request).equals("ADMIN")){
			response.sendRedirect(request.getContextPath() + "/admin");
		}else if(this.isMember(request).equals("USER")){
			response.sendRedirect(request.getContextPath() + "/basic");
		}else{
			response.sendRedirect(request.getContextPath() + "/");
		};
		
		
		return false;
	}

	/*@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("postHandler");
		super.postHandle(request, response, handler, modelAndView);
	}*/
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	private String isMember(HttpServletRequest request){
		
		//boolean isMember = false;
		System.out.println("here?");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_INFO");
		
		//isMember = (user == null || "".equals(user.getTwUserId())) ? false : true;
		
		if(user == null || "".equals(user.getTwUserId())){
			
		}
		else{
			for(String adminId : ADMIN_ID){
				if(user.getTwUserId().indexOf(adminId) > -1){
					return "ADMIN";
				}
				else{
					return "USER";
				}
			}
		}
		
		
		return "NOT";
	}
	
	private boolean isMain(HttpServletRequest request){
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if(requestUri.equals(contextPath + "/")){
			return true;
		}		
		return false;
	}
	
	private boolean isUriToExclude(HttpServletRequest request){
		String requestUri = request.getRequestURI();
		System.out.println(requestUri);
		logger.debug("isUriToExclude 메소드");
		System.out.println("isUri");
		for(String uriToExclude : URI_TO_EXCLUDE){
			if(requestUri.indexOf(uriToExclude) > -1) return true;
		}
		
		return false;
	}
	
	
	static final String[] ADMIN_ID = {
		"adminuser"
	};

	static final String[] URI_TO_EXCLUDE = {
		"/user/"
		, "/basic"
		, "/admin"
	};
}
