package com.jeefw.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.jeefw.dao.sys.RoleAuthorityDao;
import com.jeefw.model.sys.RoleAuthority;

import core.dao.BaseDao;

/**
 * 角色权限的数据持久层的实现类
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Repository
public class RoleAuthorityDaoImpl extends BaseDao<RoleAuthority> implements RoleAuthorityDao {

	public RoleAuthorityDaoImpl() {
		super(RoleAuthority.class);
	}

}
