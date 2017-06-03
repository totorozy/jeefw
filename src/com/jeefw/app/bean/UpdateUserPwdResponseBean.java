package com.jeefw.app.bean;

/**
 * APP接口的实体Bean的响应端（根据用户名更新密码）
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public class UpdateUserPwdResponseBean extends BaseResponseBean {

	private String result; // 返回结果

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
