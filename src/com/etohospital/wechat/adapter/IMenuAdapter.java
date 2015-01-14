package com.etohospital.wechat.adapter;

import com.etohospital.wechat.pojo.button.Menu;

public interface IMenuAdapter {

	/**
	 * �������߸���΢�Ź��ںŲ˵�
	 * @param menu
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	boolean createMenu(Menu menu, String accessToken) throws Exception;
	
	/**
	 * ɾ��΢�Ź��ںŲ˵�
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	boolean deleteMenu(String accessToken) throws Exception;
	
	/**
	 * ��ȡ�˵���Ϣ
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	String getMenu(String accessToken) throws Exception;
}
