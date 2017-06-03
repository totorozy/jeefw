package com.jeefw.dao.sys;

import com.jeefw.model.sys.SysUser;

import core.dao.Dao;

/**
 * 用户的数据持久层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface SysUserDao extends Dao<SysUser> {

	String getRoleValueBySysUserId(Long sysUserId);

}
