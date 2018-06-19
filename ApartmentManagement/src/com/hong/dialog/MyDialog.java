package com.hong.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyDialog extends JDialog{
	JFrame f;
	JLabel l;
	public MyDialog(JFrame F,String content)
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		f=F;
		l=new JLabel(content,JLabel.CENTER);
		add(l,JLabel.CENTER);
		
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		this.setLocation(width/3, height/3);
		setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
		setSize(300,100);
		setVisible(true);
		
		
	}
}