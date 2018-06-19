/**
 * 
 */
package com.hong.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import com.hong.Dao.ApartmentDao;
import com.hong.Dao.ApartmentDaoImpl;
import com.hong.Dao.StudentDao;
import com.hong.Dao.StudentDaoImpl;
import com.hong.bean.Apartment;
import com.hong.bean.Student;
import com.hong.jframe.MainJFrame;
import com.hong.jpanel.TablePanel;

/**
 * @author Abbey
 *
 */
public class DeleteActionListener implements ActionListener {
	MainJFrame f;
	TablePanel pl;
	public DeleteActionListener(MainJFrame f)
	{
		this.f = f;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == f.getStudentTitleLabel().getStu_delete_bt() && f.nowPage.equals("student"))
		{
			//f.getStudentTablePanel().getTable()
			pl = f.getStudentTablePanel();
			StudentDaoImpl studao = new StudentDaoImpl();
			ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
			for(int i = 0; i<pl.getDelete_rowlist().size();i++)
			{
				Student student = new Student();
				student.setStu_id(Integer.parseInt(pl.getTable().getValueAt(pl.getDelete_rowlist().get(i),0)+""));
				student.setStu_name(""+pl.getTable().getValueAt(pl.getDelete_rowlist().get(i), 1));
				student.setStu_apart_name(""+pl.getTable().getValueAt(pl.getDelete_rowlist().get(i), 2));
				student.setStu_gender(""+pl.getTable().getValueAt(pl.getDelete_rowlist().get(i), 3));
				student.setStu_date(""+pl.getTable().getValueAt(pl.getDelete_rowlist().get(i), 4));
				studao.deleteStudent(student.getStu_id());
			}
			pl.getRowList().clear();
			try {
				f.getStudentTablePanel().getStu_table_model().showResult(studao.findAllStudents());
				f.getApartmentTablePanel().getApart_table_model().showResult(apartdao.findAllApartment());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == f.getApartmentTitleLabel().getApart_delete_bt() && f.nowPage.equals("apartment"))
		{
			pl = f.getApartmentTablePanel();
			StudentDaoImpl studao = new StudentDaoImpl();
			ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
			for(int i = 0; i<pl.getDelete_rowlist().size();i++)
			{
				Apartment apartment = new Apartment();
				apartment.setApart_id(Integer.parseInt(""+pl.getTable().getValueAt(pl.getDelete_rowlist().get(i), 0)));
				apartment.setApart_code(""+pl.getTable().getValueAt(pl.getDelete_rowlist().get(i), 1));
				apartment.setApart_category(""+pl.getTable().getValueAt(Integer.parseInt(pl.getDelete_rowlist().get(i)+""), 2));
				apartment.setApart_build_name(""+pl.getTable().getValueAt(Integer.parseInt(pl.getDelete_rowlist().get(i)+""), 3));
				apartment.setApart_now_person(Integer.parseInt(""+pl.getTable().getValueAt(Integer.parseInt(pl.getDelete_rowlist().get(i)+""), 4)));
				apartment.setApart_max_person(Integer.parseInt(""+pl.getTable().getValueAt(Integer.parseInt(pl.getDelete_rowlist().get(i)+""), 5)));
				apartdao.deleteApartment(apartment.getApart_id());
				//System.out.println(""+pl.getTable().getValueAt(pl.getRowList().get(i), 1));
			}
			pl.getRowList().clear();
			
			try {
				f.getStudentTablePanel().getStu_table_model().showResult(studao.findAllStudents());
				f.getApartmentTablePanel().getApart_table_model().showResult(apartdao.findAllApartment());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
