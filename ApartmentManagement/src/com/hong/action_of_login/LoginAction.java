package com.hong.action_of_login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.hong.Dao.UserDao;
import com.hong.Dao.UserDaoImpl;
import com.hong.bean.User;
import com.hong.dialog.MyDialog;
import com.hong.jframe.Login;
import com.hong.jframe.MainJFrame;

public class LoginAction implements ActionListener{
	private Login f;
	private JTextField UsrnameField;
	private JTextField PswordField;
	private String UserName = "";
	private String Password = "";
	private User user;
	public LoginAction(JFrame F)
	{
		f =(Login) F;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		UsrnameField = f.getUsername();
		PswordField = f.getPassword();
		UserName = f.getUsername().getText();
		Password = f.getPassword().getText();
		user = new User();
		if(e.getSource() == f.getLoginButton())
		{
			if(UserName.equals("")||Password.equals(""))
			{
				UsrnameField.requestFocus();
				PswordField.requestFocus();
				PswordField.requestDefaultFocus();
				return;
			}
			else if(UserName.equals(""))
			{
				UsrnameField.requestFocus();
				PswordField.requestFocus();
				PswordField.requestDefaultFocus();
				return;
			}
			else if(UserName.length()<5||UserName.length()>8)
			{
				UsrnameField.requestFocus();
				PswordField.requestFocus();
				PswordField.requestDefaultFocus();
				return;
			}
			else if(Password.equals(""))
			{
				UsrnameField.requestFocus();
				PswordField.requestFocus();
				PswordField.requestDefaultFocus();
				return;
			}
			else if(Password.length()<4||Password.length()>10)
			{
				UsrnameField.requestFocus();
				PswordField.requestFocus();
				PswordField.requestDefaultFocus();
				return;
			}
			else
			{
				UserDaoImpl UsDao = new UserDaoImpl();
				user = UsDao.getUserbyUsername(UserName);
				if(!Password.equals(user.getPassword()))
				{
					MyDialog md=new MyDialog(f,"用户名或密码错误");
					md.setVisible(true);
					
				}
				else
				{
					f.setVisible(false);
					java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			            	System.out.println("登录成功");
			            	new MainJFrame().setVisible(true);
			            }
			        });
				}
				
			}
		}
	}
	
}
