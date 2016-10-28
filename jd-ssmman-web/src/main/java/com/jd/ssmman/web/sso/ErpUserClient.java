package com.jd.ssmman.web.sso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 构造当前登录用户信息
 */
public class ErpUserClient {
	
	private static Logger logger = LoggerFactory.getLogger(ErpUserClient.class);

	
	/**
	 * 获取当前登录用户完整信息
	 * @return
	 */
	public ErpUser getCurrentUser() throws Exception{
		
		ErpUser erpUser = ErpUserContext.getErpUser();
		
		if(null != erpUser){
			return erpUser;	
		}
		
		erpUser = getCurrentUserFromLoginContext();

		
		ErpUserContext.setErpUser(erpUser);
		return erpUser;
	}


	/**
	 * 获取当前登录用户信息（从登陆cookie中获取）
	 * @author suihonghua
	 * @return
	 */
	public ErpUser getCurrentUserFromLoginContext(){


		ErpUser erpUser = new ErpUser();

		return erpUser;
	}
	/**
	 * 
	 * [获取当前用户信息]
	 * @return
	 * @throws Exception
	 */
	public ErpUser getAbstractUser() throws Exception{
		ErpUser erpUser = getCurrentUserFromLoginContext();

		return erpUser;
	}

}
