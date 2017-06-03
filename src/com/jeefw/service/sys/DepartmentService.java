package com.jeefw.service.sys;

import java.util.List;

import com.jeefw.model.sys.Department;

import core.service.Service;

/**
 * 部门的业务逻辑层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface DepartmentService extends Service<Department> {

	// 获取包含部门中文名称的列表
	List<Department> queryDepartmentCnList(List<Department> resultList);

}
