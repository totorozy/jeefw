package com.jeefw.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jeefw.dao.sys.AttachmentDao;
import com.jeefw.model.sys.Attachment;
import com.jeefw.service.sys.AttachmentService;

import core.service.BaseService;

/**
 * 附件的业务逻辑层的实现
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Service
public class AttachmentServiceImpl extends BaseService<Attachment> implements AttachmentService {

	private AttachmentDao attachmentDao;

	@Resource
	public void setAttachmentDao(AttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
		this.dao = attachmentDao;
	}

	// 此方法仅作代码写法演示，与功能模块无关

	public List<Object[]> queryFlowerList(String epcId) {
		return attachmentDao.queryFlowerList(epcId);
	}

	// 此方法仅作代码写法演示，与功能模块无关

	public void deleteAttachmentByForestryTypeId(Long umTypeId) {
		attachmentDao.deleteAttachmentByForestryTypeId(umTypeId);
	}

	// 此方法仅作代码写法演示，与功能模块无关

	public List<Object[]> querySensorList() {
		return attachmentDao.querySensorList();
	}

}
