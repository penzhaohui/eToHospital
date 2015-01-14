package com.etohospital.wechat.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.etohospital.wechat.pojo.message.request.ImageMessage;
import com.etohospital.wechat.pojo.message.response.TextMessage;
import com.etohospital.wechat.pojo.message.request.VideoMessage;
import com.etohospital.wechat.pojo.message.request.VoiceMessage;
import com.etohospital.wechat.pojo.message.response.Article;
import com.etohospital.wechat.pojo.message.response.NewsMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;


public class MessageUtil
{

	/**
	 * 解析微信发来的请求XML
     * 
	 * @param request
     *            微信发来的请求
	 * @return 返回请求的xml解析结果
	 * @throws IOException 
	 * @throws DocumentException 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException 
	{
		// 将解析结果存储在HashMap
		Map<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();

		for (Element e : elementList)
		{
			map.put(e.getName(), e.getText());
		}

		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage
	 * @return xml格式的文本消�?
	 */
	public static String messageToXml(TextMessage textMessage)
	{
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 图片消息对象转换成xml
	 * 
	 * @param imageMessage
	 * @return xml格式的文本消�?
	 */
	 public static String messageToXml(ImageMessage imageMessage)
	 {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	 }

	 /**
	  * 语音消息对象转换成xml
	  * 
	  * @param voiceMessage
	  * @return xml格式的文本消�?
	  */
	  public static String messageToXml(VoiceMessage voiceMessage)
	  {
		  xstream.alias("xml", voiceMessage.getClass());
		  return xstream.toXML(voiceMessage);
	  }

	  /**
	   * 视频消息对象转换成xml
	   * 
	   * @param videoMessage
	   * @return xml格式的文本消�?
	   */
	  public static String messageToXml(VideoMessage videoMessage)
	  {
		  xstream.alias("xml", videoMessage.getClass());
		  return xstream.toXML(videoMessage);
	  }

	  /**
	   * 图文消息对象转换成xml
	   * 
	   * @param newsMessage
	   * @return xml格式的图文消�?
	   */
	  public static String messageToXml(NewsMessage newsMessage)
	  {
		  xstream.alias("xml", newsMessage.getClass()); // 设置类的别名,别名�?��跟微信开发文档提供的类型�?��,否则微信服务器解析不�?
		  xstream.alias("item", new Article().getClass());
		  return xstream.toXML(newsMessage);
	  }

	  /**
	   * 扩张XStream,使其支持CDATA�?
	   */
	  private static XStream xstream = new XStream(new XppDriver()
	  {
		  public HierarchicalStreamWriter createWriter(Writer out)
		  {
			  return new PrettyPrintWriter(out)
			  {
				  // 对所有xml节点的转换都增加CDATA标记
				  boolean cdata = true;

				  @SuppressWarnings("unchecked")
				  public void startNode(String name, Class clazz)
				  {
					  super.startNode(name, clazz);
				  }

				  protected void writeText(QuickWriter writer, String text)
				  {
					  if (cdata)
					  {
						  writer.write("<![CDATA[");
						  writer.write(text);
						  writer.write("]]>");
					  }
					  else
					  {
						  writer.write(text);
					  }
				  }
			  };
		  }
	  });
}
