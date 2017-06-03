package com.jeefw.dao.sys;

import com.jeefw.model.sys.Role;

import core.dao.Dao;

/**
 * 角色的数据持久层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface RoleDao extends Dao<Role> {

	// 删除角色
	void deleteSysUserAndRoleByRoleId(Long roleId);

	// 根据菜单编码删除按钮权限
	void deleteRolePermissionByMenuCode(String menuCode);

	// 保存按钮权限
	void saveRolePermission(Long roleId, String permissions);

}
