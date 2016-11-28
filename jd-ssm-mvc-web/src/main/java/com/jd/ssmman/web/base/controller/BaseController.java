package com.jd.ssmman.web.base.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * @author kaiming.chi
 */
public abstract class BaseController {

    //    protected Logger log = LoggerFactory.getLogger(getClass());
//	public User getLoginUser(HttpSession session) {
//		UserSession userSession = (UserSession) session.getAttribute(UserConstants.USER_SESSION_KEY);
//		if (userSession != null) {
//			return userSession.getUser();
//		} else {
//			return null;
//		}
//	}
//
//	protected String getIpAddr(HttpServletRequest request) {
//		String ip = request.getHeader("x-forwarded-for");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}
//		return ip;
//	}
}
