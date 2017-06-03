package com.jeefw.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeefw.core.JavaEEFrameworkBaseController;
import com.jeefw.model.sys.Attachment;
import com.jeefw.service.sys.AttachmentService;

/**
 * 附件的控制层
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Controller
@RequestMapping("/sys/attachment")
public class AttachmentController extends JavaEEFrameworkBaseController<Attachment> {

	@Resource
	private AttachmentService attachmentService;

	// 获取柱状图数据，仅作前后端数据交互演示
	@RequestMapping(value = "/getMorrisBarChart", method = { RequestMethod.POST, RequestMethod.GET })
	public void getMorrisBarChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("[ {device : 'iPhone',geekbench : 136}, {device : 'iPhone 3G',geekbench : 137}, {device : 'iPhone 3GS',geekbench : 275}, {device : 'iPhone 4',geekbench : 380}, {device : 'iPhone 4S',geekbench : 655}, {device : 'iPhone 5',geekbench : 1571} ]");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", builder.toString());
		writeJSON(response, result);
	}

}
