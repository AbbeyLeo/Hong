/**
 * 
 */
package com.hong.action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import com.hong.Dao.ApartmentDao;
import com.hong.Dao.ApartmentDaoImpl;
import com.hong.Dao.StudentDao;
import com.hong.Dao.StudentDaoImpl;
import com.hong.bean.Apartment;
import com.hong.bean.Student;
import com.hong.jframe.MainJFrame;

/**
 * @author Abbey
 *
 */
public class SearchKeyListener implements KeyListener {
	MainJFrame f;
	StudentDaoImpl studao = new StudentDaoImpl();
	ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
	public SearchKeyListener(MainJFrame f)
	{
		this.f = f;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(f.getSearch_tf().getText().equals("") || f.getSearch_tf().getText() == null)
		{
			return;
		}
		else
		{
			 if(f.nowPage.equals("apartment"))
			{
				String anything = f.getSearch_tf().getText();
				List<Apartment> apartlist = apartdao.findApartmentByAnything(anything);
				try {
					f.getApartmentTablePanel().getApart_table_model().showResult(apartlist);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(f.nowPage.equals("student"))
			{
				String anything = f.getSearch_tf().getText();
				List<Student> studentlist = studao.findStudentsByAnything(anything);
				try {
					f.getStudentTablePanel().getStu_table_model().showResult(studentlist);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
