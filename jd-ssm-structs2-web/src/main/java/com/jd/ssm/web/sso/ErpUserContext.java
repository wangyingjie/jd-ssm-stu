package com.jd.ssm.web.sso;

public class ErpUserContext {

	private final static ThreadLocal<ErpUser> holder = new ThreadLocal<ErpUser>();

    public static void setErpUser(ErpUser erpUser) {
        holder.set(erpUser);
    }

    public static ErpUser getErpUser() {
        return holder.get();
    }
    
    public static void remove() {
        holder.remove();
    }
}
