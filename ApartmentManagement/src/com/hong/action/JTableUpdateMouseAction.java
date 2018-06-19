/**
 * 
 */
package com.hong.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;

import com.hong.Dao.ApartmentDao;
import com.hong.Dao.ApartmentDaoImpl;
import com.hong.Dao.StudentDao;
import com.hong.Dao.StudentDaoImpl;
import com.hong.bean.Apartment;
import com.hong.bean.Student;
import com.hong.jpanel.TablePanel;

/**
 * @author Abbey
 *
 */
public class JTableUpdateMouseAction implements MouseListener{
	TablePanel tb;
	int rowNum;
	int columnNum;
	boolean isNewRow = true;
	List<Integer> rowlist = new ArrayList<Integer>();
	String tempValues;
	public JTableUpdateMouseAction(TablePanel tb)
	{
		this.tb = tb;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("start");
		if(tb.isUpdateed == true)
		{
			rowlist.clear();
			tb.isUpdateed = false;
		}
		if(e.getClickCount() == 1 && e.getButton() ==MouseEvent.BUTTON1)
		{
			rowNum = tb.getTable().getSelectedRow();
			columnNum = tb.getTable().getSelectedColumn();
			int i = 0;
			if(rowlist.size() != 0)
			{
				while(i<rowlist.size())
				{
					isNewRow = true;
					if(rowlist.get(i) == rowNum)
					{
						isNewRow = false;
						break;
					}
					i++;
					
				}
				
			}
			else
			{
				isNewRow = true;
			}
			
			if(isNewRow)
			{
				if(tb.getName().equals("apartment"))
				{
					ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
					String code = tb.getTable().getValueAt(rowNum, 0)+"";
					Apartment apartment = apartdao.findApartmentByCode(code);
					tb.setRowList(rowlist);
				}
				if(tb.getName().equals("student"))
				{
					StudentDaoImpl studao = new StudentDaoImpl();
					int id = Integer.parseInt(tb.getTable().getValueAt(rowNum, 0)+"");
					Student student = studao.findStudentById(id);
					tb.setRowList(rowlist);
				}
				rowlist.add(rowNum);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
