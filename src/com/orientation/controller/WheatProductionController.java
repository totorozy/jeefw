package com.orientation.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeefw.core.Constant;
import com.jeefw.core.JavaEEFrameworkBaseController;
import com.jeefw.model.sys.Authority;
import com.orientation.model.WheatProduction;
import com.orientation.service.WheatProductionService;

/**
 * 菜单的控制层
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Controller
@RequestMapping("/sys/wheatProduction")
public class WheatProductionController extends JavaEEFrameworkBaseController<WheatProduction> implements Constant {

	@Resource
	private WheatProductionService wheatProductionService;


	// 查询菜单的表格，包括分页、搜索和排序
	//查询2016年小麦产量
	@RequestMapping(value = "/wheatProduction", method = { RequestMethod.POST, RequestMethod.GET })
	public void wheatProduction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer firstResult = Integer.valueOf(request.getParameter("page"));
		Integer maxResults = Integer.valueOf(request.getParameter("rows"));
		String sortedObject = request.getParameter("sidx");
		String sortedValue = request.getParameter("sord");
		String filters = request.getParameter("filters");
		Authority authority = new Authority();
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("menuCode") && result.getString("op").equals("eq")) {
					authority.set$eq_menuCode(result.getString("data"));
				}
				if (result.getString("field").equals("menuName") && result.getString("op").equals("cn")) {
					authority.set$like_menuName(result.getString("data"));
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				authority.setFlag("OR");
			} else {
				authority.setFlag("AND");
			}
		}

	}


}
