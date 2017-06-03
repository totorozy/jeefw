package com.jeefw.service.sys;

import java.util.List;

import com.jeefw.model.sys.Information;

import core.service.Service;

/**
 * 信息发布的业务逻辑层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface InformationService extends Service<Information> {

	// 获取信息，包括内容的HTML和过滤HTML两部分
	List<Information> queryInformationHTMLList(List<Information> resultList);

	// 生成信息的索引
	void indexingInformation();

	// 全文检索信息
	List<Information> queryByInformationName(String name);

}
