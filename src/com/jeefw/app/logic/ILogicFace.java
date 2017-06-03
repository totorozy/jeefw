package com.jeefw.app.logic;

import org.springframework.web.context.WebApplicationContext;

/**
 * APP接口的业务处理逻辑封装接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface ILogicFace<BaseRequestBean, BaseResponseBean> {

	public BaseResponseBean logic(WebApplicationContext wac, BaseRequestBean brb);

}
