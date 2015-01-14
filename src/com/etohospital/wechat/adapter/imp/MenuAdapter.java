package com.etohospital.wechat.adapter.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.etohospital.utils.EmptyUtil;
import com.etohospital.wechat.WechatConstant;
import com.etohospital.wechat.adapter.IMenuAdapter;
import com.etohospital.wechat.adapter.IMessageAdapter;
import com.etohospital.wechat.pojo.button.Menu;

public class MenuAdapter implements IMenuAdapter {

	private static Logger logger = LoggerFactory.getLogger(MenuAdapter.class);
	private static IMessageAdapter MessageAdapter = new MessageAdapter(); 

	/**
	 * 创建或者更新微信公众号菜单
	 * @param menu
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean createMenu(Menu menu, String accessToken) throws Exception
	{
		// 拼装创建菜单的url
		String requestUrl = WechatConstant.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);

		// 将菜单对象转换成json字符�?
		String jsonMenu = JSON.toJSONString(menu);

		logger.info(jsonMenu);
		// 调用接口创建菜单
		JSONObject jsonObject = MessageAdapter.httpRequest(requestUrl, "POST", jsonMenu);

		return checkError(jsonObject) == 0 ? true : false;
	}

	/**
	 * 删除微信公众号菜单
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean deleteMenu(String accessToken) throws Exception
	{
		
		String requestUrl = WechatConstant.MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);

		// 调用接口创建菜单
		JSONObject jsonObject = MessageAdapter.httpRequest(requestUrl, "GET", null);

		return checkError(jsonObject) == 0 ? true : false;
	}

	@Override
	public String getMenu(String accessToken) throws Exception
	{
		String requestUrl = WechatConstant.MENU_GET_URL.replace("ACCESS_TOKEN", accessToken);

		// 发起GET请求查询菜单
		JSONObject jsonObject = MessageAdapter.httpRequest(requestUrl, "GET", null);

		return EmptyUtil.isNotEmpty(jsonObject) ? jsonObject.toString() : null;
	}
	

	/**
	 * 获取菜单信息
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	private int checkError(JSONObject jsonObject)
	{
		int result = 0;
		
		if (EmptyUtil.isNotEmpty(jsonObject) && 0 != jsonObject.getInteger("errcode"))
		{
			result = jsonObject.getInteger("errcode");
			
			logger.error("创建菜单失败 errcode:{} errmsg:{}", result, jsonObject.getString("errmsg"));
		}
		return result;
	}
}
