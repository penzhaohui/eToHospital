package com.etohospital.wechat.pojo.message.response;

import java.util.List;


public class NewsMessage extends BaseMessage
{
	private int _articleCount;	
	private List<Article> _articles;

	public int getArticleCount()
	{
		return _articleCount;
	}
	public void setArticleCount(int articleCount)
	{
		_articleCount = articleCount;
	}
	public List<Article> getArticles()
	{
		return _articles;
	}
	public void setArticles(List<Article> articles)
	{
		_articles = articles;
	}
}
