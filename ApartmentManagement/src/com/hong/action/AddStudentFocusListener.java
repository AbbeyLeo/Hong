package com.hong.action;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.hong.Dao.StudentDao;
import com.hong.Dao.StudentDaoImpl;
import com.hong.jframe.AddStudentJFrame;

public class AddStudentFocusListener implements FocusListener{
	AddStudentJFrame asjf;
	StudentDaoImpl studao = new StudentDaoImpl();
	public AddStudentFocusListener(AddStudentJFrame asjf)
	{
		this.asjf = asjf;
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == asjf.getStu_id_tf())
		{
			asjf.idThread.suspend();
			if(asjf.getStu_id_tf().getText().equals(""))
			{
				asjf.getStu_id_alarm().setText("*请填写学号");
				asjf.getStu_id_alarm().setForeground(new Color(160,220,240));
			}
			
			else if(studao.findStudentById(Integer.parseInt(asjf.getStu_id_tf().getText())) != null)
			{
				asjf.getStu_id_alarm().setText(studao.findStudentById(Integer.parseInt(asjf.getStu_id_tf().getText())).getStu_name());
				asjf.getStu_id_alarm().setForeground(Color.RED);
			}
			asjf.idThread.resume();
		}
		if((e.getSource() == asjf.getStu_name_tf()))
		{
			asjf.idThread.suspend();
			if(asjf.getStu_name_tf().getText().equals(""))
			{
				asjf.getStu_name_alarm().setText("*请填写姓名");
				asjf.getStu_name_alarm().setForeground(new Color(160,220,240));
			}
			asjf.idThread.resume();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == asjf.getStu_id_tf())
		{
			asjf.idThread.suspend();
			if(asjf.getStu_id_tf().getText().equals(""))
			{
				asjf.getStu_id_alarm().setText("*不能为空");
				asjf.getStu_id_alarm().setForeground(Color.RED);
			}
			else
			{
				asjf.getStu_id_alarm().setText("*可添加");
				asjf.getStu_id_alarm().setForeground(new Color(160,220,240));
			}
			
			if(studao.findStudentById(Integer.parseInt(asjf.getStu_id_tf().getText())) != null)
			{
				asjf.getStu_id_alarm().setText(studao.findStudentById(Integer.parseInt(asjf.getStu_id_tf().getText())).getStu_name());
				asjf.getStu_id_alarm().setForeground(Color.RED);
			}
			else
			{
				asjf.getStu_id_alarm().setText("*可添加");
				asjf.getStu_id_alarm().setForeground(new Color(160,220,240));
			}
			asjf.idThread.resume();
		}
		if((e.getSource() == asjf.getStu_name_tf()))
		{
			asjf.idThread.suspend();
			if(asjf.getStu_name_tf().getText().equals(""))
			{
				asjf.getStu_name_alarm().setText("*不能为空");
				asjf.getStu_name_alarm().setForeground(Color.RED);
			}
			else
			{
				asjf.getStu_name_alarm().setText("*可添加");
				asjf.getStu_name_alarm().setForeground(new Color(160,220,240));
			}
			asjf.idThread.resume();
		}
		return;
	}
}

