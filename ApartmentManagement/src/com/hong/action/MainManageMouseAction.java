/**
 * 
 */
package com.hong.action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import com.hong.Dao.ApartmentDaoImpl;
import com.hong.Dao.StudentDaoImpl;
import com.hong.jframe.MainJFrame;

/**
 * @author Abbey
 *
 */
public class MainManageMouseAction implements MouseListener {
	MainJFrame f;
	public MainManageMouseAction(MainJFrame f)
	{
		this.f = f;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		f.getApart_manage_lb().setBackground(new java.awt.Color(100, 100, 255));
		f.getApart_manage_lb().setForeground(new java.awt.Color(255, 255, 255));
		f.getStu_manage_lb().setBackground(new java.awt.Color(100, 100, 255));
		f.getStu_manage_lb().setForeground(new java.awt.Color(255, 255, 255));
		if(e.getSource() == f.getStu_manage_lb())
		{
			f.getStu_manage_lb().setBackground(new java.awt.Color(255, 255, 255));
			f.getStu_manage_lb().setForeground(new java.awt.Color(160, 220, 250));
			f.nowPage = "student";
			f.card.show(f.getMain_center_lb(), "student_table");
			f.card1.show(f.getTable_action_label(), "stu_action_lb");
			try {
				f.getStudentTablePanel().getStu_table_model().showResult(new StudentDaoImpl().findAllStudents());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == f.getApart_manage_lb())
		{
			f.getApart_manage_lb().setBackground(new java.awt.Color(255, 255, 255));
			f.getApart_manage_lb().setForeground(new java.awt.Color(160, 220, 250));
			f.nowPage = "apartment";
			f.card.show(f.getMain_center_lb(), "apartment_table");
			f.card1.show(f.getTable_action_label(), "apart_action_lb");
			try {
				f.getApartmentTablePanel().getApart_table_model().showResult(new ApartmentDaoImpl().findAllApartment());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
