package com.jeefw.service.sys.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jeefw.dao.sys.AuthorityDao;
import com.jeefw.dao.sys.RoleAuthorityDao;
import com.jeefw.dao.sys.RoleDao;
import com.jeefw.model.sys.Authority;
import com.jeefw.model.sys.Role;
import com.jeefw.model.sys.RoleAuthority;
import com.jeefw.service.sys.AuthorityService;

import core.service.BaseService;

/**
 * 菜单的业务逻辑层的实现
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Service
public class AuthorityServiceImpl extends BaseService<Authority> implements AuthorityService {

	private AuthorityDao authorityDao;
	@Resource
	private RoleAuthorityDao roleAuthorityDao;
	@Resource
	private RoleDao roleDao;

	@Resource
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
		this.dao = authorityDao;
	}

	// 获取多级菜单
	public List<Authority> queryAllMenuList(String globalRoleKey) {
		List<RoleAuthority> roleAuthorityList = roleAuthorityDao.queryByProerties("roleKey", globalRoleKey);
		List<String> menuCodeList = new ArrayList<String>();
		for (int j = 0; j < roleAuthorityList.size(); j++) {
			menuCodeList.add(roleAuthorityList.get(j).getMenuCode());
		}

		Map<String, String> sortedCondition = new HashMap<String, String>();
		sortedCondition.put("sequence", "ASC");
		List<Authority> mainMenuList = authorityDao.queryByProerties("parentMenuCode", "0", sortedCondition);

		List<Authority> allAuthority = authorityDao.doQueryAll();
		Set<String> parentMenuCodeSet = new HashSet<String>();
		for (int i = 0; i < allAuthority.size(); i++) {
			parentMenuCodeSet.add(allAuthority.get(i).getParentMenuCode());
		}

		List<Authority> authorityList = new ArrayList<Authority>();
		for (Authority entity : mainMenuList) {
			Authority authority = new Authority();
			authority.setId(entity.getId());
			authority.setMenuCode(entity.getMenuCode());
			authority.setMenuName(entity.getMenuName());
			authority.setMenuClass(entity.getMenuClass());
			authority.setDataUrl(entity.getDataUrl());
			authority.setSequence(entity.getSequence());
			authority.setParentMenuCode(entity.getParentMenuCode());
			List<Authority> subAuthorityList = authorityDao.queryByProerties("parentMenuCode", entity.getMenuCode());
			List<Authority> resultSubAuthorityList = new ArrayList<Authority>();
			for (int i = 0; i < subAuthorityList.size(); i++) {
				if (menuCodeList.contains(subAuthorityList.get(i).getMenuCode())) {
					resultSubAuthorityList.add(subAuthorityList.get(i));
					if (parentMenuCodeSet.contains(subAuthorityList.get(i).getMenuCode())) {
						List<Authority> subSubAuthorityList = authorityDao.queryByProerties("parentMenuCode", subAuthorityList.get(i).getMenuCode());
						subAuthorityList.get(i).setSubAuthorityList(subSubAuthorityList);
					}
				}
			}
			authority.setSubAuthorityList(resultSubAuthorityList);
			if (subAuthorityList.size() == 0) {
				authorityList.add(null);
			} else {
				authorityList.add(authority);
			}
		}
		return authorityList;
	}

	// 获取按钮权限数据
	public String getAuthorityButtonList(String menuCode) {
		List<Role> roleList = roleDao.doQueryAll();
		StringBuilder sb = new StringBuilder();
		Map<String, String> allRoles = new HashMap<String, String>();
		for (Role role : roleList) {
			allRoles.put(role.getRoleKey(), role.getRoleValue());
			for (Iterator iterator = role.getPermissions().iterator(); iterator.hasNext();) {
				String str = (String) iterator.next();
				String[] sections = str.split(":");
				for (int i = 0; i < sections.length; i++) {
					if (sections[i].equals(menuCode)) {
						String roleKey = sections[0];
						String[] buttons = sections[2].split(",");
						sb.append(allRoles.get(roleKey) + "：");
						ArrayList<String> allButtons = new ArrayList<String>(Arrays.asList("edit", "add", "delete", "search", "view", "export"));
						for (int j = 0; j < buttons.length; j++) {
							if (buttons[j].equals("edit")) {
								sb.append("<label><input id='" + roleKey + "-" + buttons[j] + "' name='form-field-checkbox' type='checkbox' class='ace' checked /><span class='lbl'>编辑</span></label>");
								allButtons.remove(buttons[j].toString());
							} else if (buttons[j].equals("add")) {
								sb.append("<label><input id='" + roleKey + "-" + buttons[j] + "' name='form-field-checkbox' type='checkbox' class='ace' checked /><span class='lbl'>添加</span></label>");
								allButtons.remove(buttons[j].toString());
							} else if (buttons[j].equals("view")) {
								sb.append("<label><input id='" + roleKey + "-" + buttons[j] + "' name='form-field-checkbox' type='checkbox' class='ace' checked /><span class='lbl'>查看</span></label>");
								allButtons.remove(buttons[j].toString());
							} else if (buttons[j].equals("delete")) {
								sb.append("<label><input id='" + roleKey + "-" + buttons[j] + "' name='form-field-checkbox' type='checkbox' class='ace' checked /><span class='lbl'>删除</span></label>");
								allButtons.remove(buttons[j].toString());
							} else if (buttons[j].equals("search")) {
								sb.append("<label><input id='" + roleKey + "-" + buttons[j] + "' name='form-field-checkbox' type='checkbox' class='ace' checked /><span class='lbl'>查找</span></label>");
								allButtons.remove(buttons[j].toString());
							} else if (buttons[j].equals("export")) {
								sb.append("<label><input id='" + roleKey + "-" + buttons[j] + "' name='form-field-checkbox' type='checkbox' class='ace' checked /><span class='lbl'>导出</span></label>");
								allButtons.remove(buttons[j].toString());
							}
						}
						for (int z = 0; z < allButtons.size(); z++) {
							if (allButtons.get(z).equals("edit")) {
								sb.append("<label><input id='" + roleKey + "-" + allButtons.get(z) + "' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>编辑</span></label>");
							} else if (allButtons.get(z).equals("add")) {
								sb.append("<label><input id='" + roleKey + "-" + allButtons.get(z) + "' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>添加</span></label>");
							} else if (allButtons.get(z).equals("view")) {
								sb.append("<label><input id='" + roleKey + "-" + allButtons.get(z) + "' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>查看</span></label>");
							} else if (allButtons.get(z).equals("delete")) {
								sb.append("<label><input id='" + roleKey + "-" + allButtons.get(z) + "' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>删除</span></label>");
							} else if (allButtons.get(z).equals("search")) {
								sb.append("<label><input id='" + roleKey + "-" + allButtons.get(z) + "' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>查找</span></label>");
							} else if (allButtons.get(z).equals("export")) {
								sb.append("<label><input id='" + roleKey + "-" + allButtons.get(z) + "' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>导出</span></label>");
							}
						}
						sb.append("<input name='form-field-checkbox' type='hidden' />");
						sb.append("<br/>");
						allRoles.remove(roleKey);
					}
				}
			}
			for (int n = 0; n < allRoles.size(); n++) {
				String restRoleKey = allRoles.entrySet().iterator().next().getKey();
				sb.append(allRoles.entrySet().iterator().next().getValue() + "：");
				sb.append("<label><input id='" + restRoleKey + "-" + "add' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>添加</span></label>");
				sb.append("<label><input id='" + restRoleKey + "-" + "edit' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>编辑</span></label>");
				sb.append("<label><input id='" + restRoleKey + "-" + "delete' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>删除</span></label>");
				sb.append("<label><input id='" + restRoleKey + "-" + "view' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>查看</span></label>");
				sb.append("<label><input id='" + restRoleKey + "-" + "search' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>查找</span></label>");
				sb.append("<label><input id='" + restRoleKey + "-" + "export' name='form-field-checkbox' type='checkbox' class='ace' /><span class='lbl'>导出</span></label>");
				sb.append("<input name='form-field-checkbox' type='hidden' />");
				sb.append("<br/>");
				allRoles.remove(allRoles.entrySet().iterator().next().getKey());
			}
		}
		return sb.toString();
	}

	// 保存角色权限
	public void saveAuthorityButtonList(String checkboxList, String menuCode) {
		Map<String, String> destinationMap = new HashMap<String, String>();
		String[] allRoleAuthority = checkboxList.split("AND");
		for (int i = 0; i < allRoleAuthority.length; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			String[] roleButtonStatusAuthority = allRoleAuthority[i].split(";");
			String role = allRoleAuthority[i].subSequence(0, allRoleAuthority[i].indexOf("-")).toString();
			stringBuilder.append(role + ":");
			stringBuilder.append(menuCode + ":");
			for (int j = 0; j < roleButtonStatusAuthority.length; j++) {
				String[] buttonStatusAuthority = roleButtonStatusAuthority[j].split(",");
				String[] roleButtonAuthority = buttonStatusAuthority[0].split("-");
				if (roleButtonAuthority[1].equals("edit") && buttonStatusAuthority[1].equals("true")) {
					stringBuilder.append("edit,");
				} else if (roleButtonAuthority[1].equals("add") && buttonStatusAuthority[1].equals("true")) {
					stringBuilder.append("add,");
				} else if (roleButtonAuthority[1].equals("view") && buttonStatusAuthority[1].equals("true")) {
					stringBuilder.append("view,");
				} else if (roleButtonAuthority[1].equals("delete") && buttonStatusAuthority[1].equals("true")) {
					stringBuilder.append("delete,");
				} else if (roleButtonAuthority[1].equals("search") && buttonStatusAuthority[1].equals("true")) {
					stringBuilder.append("search,");
				} else if (roleButtonAuthority[1].equals("export") && buttonStatusAuthority[1].equals("true")) {
					stringBuilder.append("export,");
				} else {
					stringBuilder.append("none,");
				}
			}
			destinationMap.put(role, stringBuilder.toString());
		}

		roleDao.deleteRolePermissionByMenuCode(menuCode);
		for (Iterator mapIterator = destinationMap.entrySet().iterator(); mapIterator.hasNext();) {
			Map.Entry<String, String> map = (Entry<String, String>) mapIterator.next();
			Role r = roleDao.getByProerties("roleKey", map.getKey());
			roleDao.saveRolePermission(r.getId(), map.getValue());
		}
	}

}
