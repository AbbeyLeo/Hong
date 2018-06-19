package com.hong.action_of_login;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.hong.jframe.Login;

public class PasswordFocusAction implements FocusListener{
	private Login f;
	public PasswordFocusAction(Login F)
	{
		f = F;
	}
	public void focusGained(FocusEvent e) {
		f.PasswordThread.suspend();
		f.getPasswordAlert().setText("*密码长度6~10个字符");
		f.getPasswordAlert().setForeground(Color.GREEN);
		f.PasswordThread.resume();
	}

	public void focusLost(FocusEvent e) {
		String Password = f.getPassword().getText();
		if(Password.equals(""))
		{
			f.PasswordThread.suspend();
			f.getPasswordAlert().setText("*密码不能为空");
			f.getPasswordAlert().setForeground(Color.RED);
			f.PasswordThread.resume();
		}
		else if(Password.length()<6||Password.length()>10)
		{
			f.PasswordThread.suspend();
			f.getPasswordAlert().setText("*密码长度为6~10个字符");
			f.getPasswordAlert().setForeground(Color.RED);
			f.PasswordThread.resume();
		}
		else{
			f.PasswordThread.suspend();
			f.getPasswordAlert().setText("*符合要求");
			f.getPasswordAlert().setForeground(Color.GREEN);
			f.PasswordThread.resume();
		}
	}

}