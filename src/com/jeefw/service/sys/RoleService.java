package com.jeefw.service.sys;

import com.jeefw.model.sys.Role;

import core.service.Service;

/**
 * 角色的业务逻辑层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface RoleService extends Service<Role> {

	// 删除角色
	void deleteSysUserAndRoleByRoleId(Long roleId);

}
