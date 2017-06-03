package com.jeefw.service.sys;

import java.util.List;

import com.jeefw.app.bean.UpdateUserPwdRequestBean;
import com.jeefw.model.sys.SysUser;

import core.service.Service;

/**
 * 用户的业务逻辑层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface SysUserService extends Service<SysUser> {

	// 获取用户信息（将数据库查询出来的信息再处理，增加字段的中文意思）
	List<SysUser> querySysUserCnList(List<SysUser> resultList);

	// 获取个人资料信息（将数据库查询出来的信息再处理，增加头像）
	SysUser getSysUserWithAvatar(SysUser sysuser);

	String updateSysUser(UpdateUserPwdRequestBean brb);

}
