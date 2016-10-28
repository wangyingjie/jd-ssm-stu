package com.jd.ssmman.web.sso;


public class ErpUser {

	private Integer userId;//用户ID				（人事库数据）
	private String userCode;//用户ERP账号		（人事库数据）
	private String userName;//用户名称			（人事库数据）
	private Integer organizationId;//组织机构ID	（人事库数据）
	private String organizationName;//组织机构名称（人事库数据）
	private Integer deptId;//部门ID				（人事库数据）
	private String deptName;//部门名称			（人事库数据）
    private String userOrgId;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
