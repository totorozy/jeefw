package com.jeefw.app.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefw.app.bean.BaseResponseBean;

/**
 * APP接口的协议传输接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface ITransmission {

	public String resv(HttpServletRequest request);

	public void resp(HttpServletResponse response, BaseResponseBean brb);

}
