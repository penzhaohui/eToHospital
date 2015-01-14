package com.etohospital.wechat.adapter;

import com.etohospital.wechat.pojo.button.Menu;

public interface IMenuAdapter {

	/**
	 * 创建或者更新微信公众号菜单
	 * @param menu
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	boolean createMenu(Menu menu, String accessToken) throws Exception;
	
	/**
	 * 删除微信公众号菜单
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	boolean deleteMenu(String accessToken) throws Exception;
	
	/**
	 * 获取菜单信息
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	String getMenu(String accessToken) throws Exception;
}
