package com.orientation.service;

import java.util.List;

import com.orientation.model.WheatProduction;

import core.service.Service;

/**
 * 附件的业务逻辑层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface WheatProductionService extends Service<WheatProduction> {

	List<Object[]> queryFlowerList(String epcId);

	void deleteAttachmentByForestryTypeId(Long umTypeId);

	List<Object[]> querySensorList();

}
