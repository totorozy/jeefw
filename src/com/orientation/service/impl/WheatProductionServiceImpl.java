package com.orientation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.orientation.dao.WheatProductionDao;
import com.orientation.model.WheatProduction;
import com.orientation.service.WheatProductionService;

import core.service.BaseService;

/**
 * 附件的业务逻辑层的实现
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Service
public class WheatProductionServiceImpl extends BaseService<WheatProduction> implements WheatProductionService {

	private WheatProductionDao wheatProductionDao;

	@Resource
	public void setWheatProductionDao(WheatProductionDao wheatProductionDao) {
		this.wheatProductionDao = wheatProductionDao;
		this.dao = wheatProductionDao;
	}

	// 此方法仅作代码写法演示，与功能模块无关

	public List<Object[]> queryFlowerList(String epcId) {
		return wheatProductionDao.queryFlowerList(epcId);
	}

	// 此方法仅作代码写法演示，与功能模块无关

	public void deleteAttachmentByForestryTypeId(Long umTypeId) {
		wheatProductionDao.deleteAttachmentByForestryTypeId(umTypeId);
	}

	// 此方法仅作代码写法演示，与功能模块无关

	public List<Object[]> querySensorList() {
		return wheatProductionDao.querySensorList();
	}

}
