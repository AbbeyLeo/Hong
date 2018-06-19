/**
 * 
 */
package com.hong.action;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;

import com.hong.Dao.ApartmentDao;
import com.hong.Dao.ApartmentDaoImpl;
import com.hong.jframe.AddApartmentJFrame;

/**
 * @author Abbey
 *
 */
public class AddApartmentFocusListener implements FocusListener {
	ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
	AddApartmentJFrame ajf;
	public AddApartmentFocusListener(JFrame ajf)
	{
		this.ajf = (AddApartmentJFrame) ajf;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ajf.getApart_code_tf())
		{
			ajf.codeThread.suspend();
			if(ajf.getApart_code_tf().getText().equals(""))
			{
				ajf.getApart_code_label_alarm().setText("*请输入宿舍号");
				ajf.getApart_code_label_alarm().setForeground(new Color(160, 220, 250));
			}
		
		if((e.getSource() == ajf.getApart_build_name_tf()))
		{
			ajf.categoryThread.suspend();
			if(ajf.getApart_build_name_tf().getText().equals(""))
			{
				ajf.getApart_build_name_label_alarm().setText("*请输入宿舍楼");
				ajf.getApart_build_name_label_alarm().setForeground(new Color(160, 220, 250));
			}
			ajf.categoryThread.resume();
		}
		if((e.getSource() == ajf.getApart_max_person_tf()))
		{
			ajf.categoryThread.suspend();
			if(ajf.getApart_max_person_tf().getText().equals(""))
			{
				ajf.getMax_person_alarm().setText("*请输入限住人数");
				ajf.getMax_person_alarm().setForeground(new Color(160, 220, 250));
			}
			ajf.categoryThread.resume();
		}
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ajf.getApart_code_tf())
		{
			ajf.codeThread.suspend();
			if(ajf.getApart_code_tf().getText().equals(""))
			{
				ajf.getApart_code_label_alarm().setText("*不能为空");
				ajf.getApart_code_label_alarm().setForeground(Color.RED);
			}
			else
			{
				ajf.getApart_code_label_alarm().setText("*可添加");
				ajf.getApart_code_label_alarm().setForeground(new Color(160, 220, 250));
			}
			
			if(apartdao.findApartmentByCode(ajf.getApart_code_tf().getText()).getApart_code() != null && !ajf.getApart_code_tf().getText().equals(""))
			{
				ajf.getApart_code_label_alarm().setText("*该宿舍号已存在");
				ajf.getApart_code_label_alarm().setForeground(Color.RED);
			}
			else
			{
				ajf.getApart_code_label_alarm().setText("*可添加");
				ajf.getApart_code_label_alarm().setForeground(new Color(160, 220, 250));
			}
			ajf.codeThread.resume();
		}
		if((e.getSource() == ajf.getApart_build_name_tf()))
		{
			ajf.categoryThread.suspend();
			if(ajf.getApart_build_name_tf().getText().equals(""))
			{
				ajf.getApart_build_name_label_alarm().setText("*不能为空");
				ajf.getApart_build_name_label_alarm().setForeground(Color.RED);
			}
			else
			{
				ajf.getApart_build_name_label_alarm().setText("*可添加");
				ajf.getApart_build_name_label_alarm().setForeground(new Color(160, 220, 250));
			}
			ajf.categoryThread.resume();
		}
		if((e.getSource() == ajf.getApart_max_person_tf()))
		{
			ajf.categoryThread.suspend();
			if(ajf.getApart_max_person_tf().getText().equals(""))
			{
				ajf.getMax_person_alarm().setText("*不能为空");
				ajf.getMax_person_alarm().setForeground(Color.RED);
			}
			else
			{
				ajf.getMax_person_alarm().setText("*可添加");
				ajf.getMax_person_alarm().setForeground(new Color(160, 220, 250));
			}
			ajf.categoryThread.resume();
		}
	}

}
