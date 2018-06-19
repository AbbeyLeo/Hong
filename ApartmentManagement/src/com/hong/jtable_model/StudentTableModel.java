/**
 * 
 */
package com.hong.jtable_model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.hong.bean.Student;

/**
 * @author Abbey
 *
 */
public class StudentTableModel extends AbstractTableModel{
	private Vector vect = new Vector<Student>();  
	private  String [] title = {"学号","姓名","宿舍号/名","性别","入住日期"};
	private List<Student> studentList = new ArrayList<Student>();
	
	
	public int getColumnCount()
	{
		return title.length;
	}
	public int getRowCount() {
		return vect.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((Vector) vect.get(rowIndex)).get(columnIndex);
	}
	public String getColumnName(int column) {
		return title[column];
	}
	public boolean isCellEditable(int row, int column) {
		if(column ==0 || column == 6)
		{
			return false;
		}
		else
			return true;
	}
	public void setValueAt(Object value, int row,int col){     
		((Vector) vect.get(row)).remove(col);     
		((Vector) vect.get(row)).add(col,value);   
		this.fireTableCellUpdated(row,col);     
		}
	public void setVector(Vector vec)
	{
		vect = vec;
		this.fireTableDataChanged();
	}
	public void showResult(List<Student> list) throws SQLException {
		vect.removeAllElements();
		
		int ListLength = list.size();
		int i=0;
		fireTableStructureChanged();
		setVector(vect);
		while (i<ListLength) {
			Vector rec_vector = new Vector();
			 int id = list.get(i).getStu_id();
			 String stu_name = list.get(i).getStu_name();
			 String stu_apart_name = list.get(i).getStu_apart_name();
			 String stu_gender = list.get(i).getStu_gender();
			 String stu_date = list.get(i).getStu_date();
			 rec_vector.addElement(id);
			 rec_vector.addElement(stu_name);
			 rec_vector.addElement(stu_apart_name);
			 rec_vector.addElement(stu_gender);
			 rec_vector.addElement(stu_date);
			 vect.addElement(rec_vector);
			i++;
		}
		setVector(vect);
		fireTableStructureChanged();
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
