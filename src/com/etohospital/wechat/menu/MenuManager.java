package com.etohospital.wechat.menu;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.utils.EmptyUtil;
import com.etohospital.wechat.AccessToken;
import com.etohospital.wechat.WechatConstant;
import com.etohospital.wechat.adapter.IMenuAdapter;
import com.etohospital.wechat.adapter.imp.MenuAdapter;
import com.etohospital.wechat.pojo.button.Button;
import com.etohospital.wechat.pojo.button.Menu;
import com.etohospital.wechat.pojo.button.ViewButton;
import com.etohospital.wechat.utils.WechatUtil;

public class MenuManager {
	
	private static Logger logger = LoggerFactory.getLogger(MenuManager.class);
	
	public static void main(String[] args) throws Exception
	{
		boolean needGen = true;
		// 调用接口获取access_token
		AccessToken token = WechatUtil.getAccessToken();

		String menuJSON = MenuManager.retrieveMenu(token);
		System.out.println("Menu JSON:" + menuJSON);

		if (needGen)
		{
			boolean result = generateMenu(token);

			if (result)
			{
				System.out.println("Sucessfully generate menu");
				String menuJSON2 = MenuManager.retrieveMenu(token);
				System.out.println("Menu JSON:" + menuJSON2);
			}
		}
	}

	public static String retrieveMenu(AccessToken token) throws Exception
	{
		if (EmptyUtil.isNotEmpty(token))
		{
			IMenuAdapter menuAdapter = new MenuAdapter();
			String menuStr = menuAdapter.getMenu(token.getAccessToken());

			if (EmptyUtil.isNotEmpty(menuStr))
			{
				logger.info("菜单获取成功");
				logger.info(menuStr);

				return menuStr;
			}
			else
			{
				logger.info("菜单获取失败");
			}
		}

		return null;
	}

	public static boolean generateMenu(AccessToken token) throws Exception
	{
		IMenuAdapter menuAdapter = new MenuAdapter();

		if (EmptyUtil.isNotEmpty(token))
		{
			// 先删除当前的菜单
			if (menuAdapter.deleteMenu(token.getAccessToken())) {
				
				// 调用接口创建菜单 ，并判断菜单创建结果
				if (menuAdapter.createMenu(formMenuJSON(), token.getAccessToken())) {
					logger.info("菜单创建成功");
				} else {
					logger.info("菜单创建失败");
					return false;
				}
			}
		}

		return true;
	}

	private static Menu formMenuJSON() throws UnsupportedEncodingException
	{
		//ClickButton menuCustomer = new ClickButton();
		//menuCustomer.setName("用户");
		//menuCustomer.setType("click");
		//menuCustomer.setKey("customer");
		
		ViewButton menuCustomer = new ViewButton();
		menuCustomer.setName("用户");
		menuCustomer.setType("view");		
		//menuCustomer.setUrl(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "customer_home.jsp"));
		//menuCustomer.setUrl(WXUtil.getFullURL("v1?redirectTo=customer"));
		//menuCustomer.setUrl(OAuthUtil.createCodeUrl("snsapi_base", "customer"));
		menuCustomer.setUrl(WechatConstant.OAUTH2_AUTH_URL.replace("STATE", "customer"));
		
		
		//ClickButton menuHealthConsultant = new ClickButton();
		//menuHealthConsultant.setName("健康客服");
		//menuHealthConsultant.setType("click");
		//menuHealthConsultant.setKey("healthconsultant");
		
		ViewButton menuHealthConsultant = new ViewButton();
		menuHealthConsultant.setName("健康客服");
		menuHealthConsultant.setType("view");
		//menuHealthConsultant.setUrl(WXUtil.getFullURL("healthconsultant_home.jsp"));
		//menuHealthConsultant.setUrl(WXUtil.getFullURL("v1?redirectTo=healthconsultant"));
		//menuCustomer.setUrl(OAuthUtil.createCodeUrl("snsapi_base", "healthconsultant"));
		menuHealthConsultant.setUrl(WechatConstant.OAUTH2_AUTH_URL.replace("STATE", "healthconsultant"));
		
		//ClickButton menuDoctor = new ClickButton();
		//menuDoctor.setName("健康专家");
		//menuDoctor.setType("click");
		//menuDoctor.setKey("doctor");
		
		ViewButton menuDoctor = new ViewButton();
		menuDoctor.setName("健康专家");
		menuDoctor.setType("view");
		//menuDoctor.setUrl(WXUtil.getFullURL("v1?redirectTo=doctor"));
		//menuDoctor.setUrl(WXUtil.getFullURL("doctor_home.jsp"));
		//menuDoctor.setUrl(OAuthUtil.createCodeUrl("snsapi_base", "doctor"));
		menuDoctor.setUrl(WechatConstant.OAUTH2_AUTH_URL.replace("STATE", "doctor"));

		Menu mainMenu = new Menu();
		List<Button> menuItems = new ArrayList<Button>();
		menuItems.add(menuCustomer);
		menuItems.add(menuHealthConsultant);
		menuItems.add(menuDoctor);
		mainMenu.setButton(menuItems);
		
		return mainMenu;
	}
}
