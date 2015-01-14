package com.etohospital.wechat.pojo.button;

import java.util.List;

public class ComplexButton extends Button
{
	private List<Button> _subButton;

	public List<Button> getSub_button()
	{
		return _subButton;
	}
	public void setSub_button(List<Button> subButton)
	{
		this._subButton = subButton;
	}

}
