package com.etohospital.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etohospital.wechat.MessageConstant;
import com.etohospital.wechat.WechatConstant;
import com.etohospital.wechat.pojo.message.response.Article;
import com.etohospital.wechat.pojo.message.response.NewsMessage;
import com.etohospital.wechat.pojo.message.response.TextMessage;
import com.etohospital.wechat.utils.MessageUtil;
import com.etohospital.wechat.utils.WechatUtil;

@WebServlet("/v1/wechat")
public class WechatServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
			
	public WechatServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 解决中文乱码问题：http://blog.csdn.net/xiazdong/article/details/7217022
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		
		// 获取来自微信服务器的四个验证参数
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		String redirectTo = request.getParameter("redirectTo");
						
		try
		{
			PrintWriter pw = response.getWriter();
			
			if(signature == null || timestamp == null || nonce == null || echostr == null)
			{
				pw.print("暂不支持此请求");
				return;
			}

			// 请求校验，若校验成功返回echostr
			if (WechatUtil.checkSignature(signature, timestamp, nonce))
			{
				pw.print(echostr);
			}				
				
			pw.print(echostr);
			pw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		response.setCharacterEncoding("UTF-8");

		// 获取来自微信服务器的四个验证参数
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");		
		
		try
		{
			PrintWriter pw = response.getWriter();

			// 请求校验，若校验成功返回echostr
			if (WechatUtil.checkSignature(signature, timestamp, nonce))
			{
				Map<String, String> requestMap = MessageUtil.parseXml(request);
				
				// 从微信开发者平台，将会传入如下五种信息
				// 单击【普通客户】按钮：{FromUserName=ootUQs7W9qWBXdCpnp4GqFvnnX6s, EventKey=customer, Event=CLICK, CreateTime=1420522241, ToUserName=gh_11305cd99486, MsgType=event}
				// 单击【健康客服】按钮：{FromUserName=ootUQs7W9qWBXdCpnp4GqFvnnX6s, EventKey=healthconsultant, Event=CLICK, CreateTime=1420522721, ToUserName=gh_11305cd99486, MsgType=event}
				// 单击【健康专家】按钮：{FromUserName=ootUQs7W9qWBXdCpnp4GqFvnnX6s, EventKey=doctor, Event=CLICK, CreateTime=1420522786, ToUserName=gh_11305cd99486, MsgType=event}
				// 微信用户输入文本消息：{MsgId=6101099158403514332, FromUserName=ootUQs7W9qWBXdCpnp4GqFvnnX6s, CreateTime=1420522844, Content=123567, ToUserName=gh_11305cd99486, MsgType=text}
				// 微信用户输入语音消息：{MsgId=6101099403216650249, Format=amr, FromUserName=ootUQs7W9qWBXdCpnp4GqFvnnX6s, Recognition=, CreateTime=1420522901, MediaId=zKgYDpP87P47JseHrlwxVXtLMt_d7NX8a1R3dQXVtT47jquc4UgdirVSytrZB3SM, ToUserName=gh_11305cd99486, MsgType=voice}
				// 微信用户【取消关注】：{FromUserName=ootUQs7W9qWBXdCpnp4GqFvnnX6s, EventKey=, Event=unsubscribe, CreateTime=1420524161, ToUserName=gh_11305cd99486, MsgType=event}
				// 微信用户【关注】：   	 {FromUserName=ootUQs7W9qWBXdCpnp4GqFvnnX6s, EventKey=, Event=subscribe, CreateTime=1420524251, ToUserName=gh_11305cd99486, MsgType=event}
					
				// 发送方账号(open_id)
				String toUserName = requestMap.get("FromUserName");
				// 公众账号
				String fromUserName = requestMap.get("ToUserName");
				// 消息类型
				String msgType = requestMap.get("MsgType");
				// 发送时间
				String createTime = requestMap.get("CreateTime");
				
				String message = "";
				
				//Obtain the session object, create a new session if doesn't exist
				HttpSession session = request.getSession(true);
				session.setAttribute("open_id", toUserName);
				 
				// 1，文本消息
				if (MessageConstant.REQ_MESSAGE_TYPE_TEXT.equalsIgnoreCase(msgType))
				{
					message = getTextMessage(toUserName, fromUserName, "Echo: " + toUserName + "sent " + requestMap.get("Content").trim());
				}
				// 2，图片消息
				else if (MessageConstant.REQ_MESSAGE_TYPE_IMAGE.equalsIgnoreCase(msgType))
				{
				}
				// 3. 推送事件
				else if (MessageConstant.REQ_MESSAGE_TYPE_EVENT.equals(msgType))
				{
					String event = requestMap.get("Event");
					String eventKey = requestMap.get("EventKey");

					if ("click".equalsIgnoreCase(event)) {							
						if ("customer".equalsIgnoreCase(eventKey)) {
						} else if ("healthconsultant".equalsIgnoreCase(eventKey)) {
						} else if ("doctor".equalsIgnoreCase(eventKey)) {
						}
					} 
					// 关注微信公众号
					else if ("subscribe".equalsIgnoreCase(event)) {
						message = sendMessageToUser(toUserName, fromUserName, getWelcomeMessage());
					} 
					// 取消微信公众号
					else if ("unsubscribe".equalsIgnoreCase(event)) {
					}
				}
					
				// 处理微信请求
				pw.print(message);
			}

			pw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private String getRegisterMsg()
	{
		return "您还没有注册，请<a href=\"register.htm\">点击注册<a>";
	}

	private String getTextMessage(String toUserName, String fromUserName, String content)
	{
		TextMessage tm = new TextMessage();

		tm.setFromUserName(fromUserName);
		tm.setToUserName(toUserName);
		tm.setContent(content);
		tm.setCreateTime(new Date().getTime());
		tm.setMsgType(MessageConstant.RESP_MESSAGE_TYPE_TEXT);
		tm.setFuncFlag(0);

		return MessageUtil.messageToXml(tm);
	}

	private String sendMessageToUser(String toUserName, String fromUserName, List<Article> articles)
	{
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(toUserName);
		newsMessage.setFromUserName(fromUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageConstant.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
		newsMessage.setArticleCount(articles.size());
		newsMessage.setArticles(articles);

		return MessageUtil.messageToXml(newsMessage);
	}
		
	private List<Article> getWelcomeMessage()
	{
		List<Article> articles = new ArrayList<Article>();
		Article item1 = new Article();
		item1.setPicUrl(WechatConstant.MOBILE_ROOT_URL + "/static/image/edoc.jpg");
		item1.setTitle("点击注册您的易就医账号");
		item1.setUrl(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "register.jsp"));

		Article item2 = new Article();
		item2.setPicUrl(WechatConstant.MOBILE_ROOT_URL + "/static/image/edoc-1.jpg");
		item2.setTitle("公司介绍");
		item2.setUrl(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "#"));

		Article item3 = new Article();
		item3.setPicUrl(WechatConstant.MOBILE_ROOT_URL + "/static/image/edoc-2.jpg");
		item3.setTitle("功能介绍");
		item3.setUrl(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "consultant_list.htm"));

		Article item4 = new Article();
		item4.setPicUrl(WechatConstant.MOBILE_ROOT_URL + "/static/image/edoc-3.png");
		item4.setTitle("联系我们");
		item4.setUrl("www.baidu.com");
		
		Article item5 = new Article();
		item5.setPicUrl(WechatConstant.MOBILE_ROOT_URL + "/static/image/edoc-11.png");
		item5.setTitle("评价与建议");
		item5.setUrl(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "contact.jsp"));
		articles.add(item1);
		articles.add(item2);
		articles.add(item3);
		articles.add(item4);
		articles.add(item5);
		return articles;
	}
}
