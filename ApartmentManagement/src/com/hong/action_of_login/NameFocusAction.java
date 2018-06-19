package com.hong.action_of_login;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.hong.jframe.Login;

public class NameFocusAction implements FocusListener{
	private Login f;
	public NameFocusAction(Login F)
	{
		f = F;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		f.NameThread.suspend();
		f.getUsernameAlert().setText("*用户名长度为5~8个字符");
		f.getUsernameAlert().setForeground(Color.GREEN);
		f.NameThread.resume();
	}

	@Override
	public void focusLost(FocusEvent e) {
		String Name = f.getUsername().getText();
		if(Name.equals(""))
		{
			f.NameThread.suspend();
			f.getUsernameAlert().setText("*请填写用户名");
			f.getUsernameAlert().setForeground(Color.RED);
			f.NameThread.resume();
			return;
		}
		else if(Name.length()<5||Name.length()>8)
		{
			f.NameThread.suspend();
			f.getUsernameAlert().setText("*用户名长度为5~8个字符");
			f.getUsernameAlert().setForeground(Color.RED);
			f.NameThread.resume();
			return;
		}
		else{
			f.NameThread.suspend();
			f.getUsernameAlert().setText("*符合要求");
			f.getUsernameAlert().setForeground(Color.GREEN);
			f.NameThread.resume();
		}
	}
}