package com.jeefw.dao.sys;

import java.util.List;

import com.jeefw.model.sys.Information;

import core.dao.Dao;

/**
 * 信息发布的数据持久层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface InformationDao extends Dao<Information> {

	// 生成信息的索引
	void indexingInformation();

	// 全文检索信息
	List<Information> queryByInformationName(String name);

}
