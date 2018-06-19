/**
 * 
 */
package com.hong.jtable_model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.hong.bean.Apartment;

/**
 * @author Abbey
 *
 */
public class ApartmentTableModel extends AbstractTableModel{
	private Vector vect = new Vector<Apartment>();  
	private  String [] title = {"宿舍识别码","宿舍编号","入住性别","宿舍楼","当前人数", "上限人数"};
	private List<Apartment> aprtmentList = new ArrayList<Apartment>();
	
	
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
		if(column ==0 || column == 4)
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
	public void showResult(List<Apartment> list) throws SQLException {
		vect.removeAllElements();
		
		int ListLength = list.size();
		int i=0;
		fireTableStructureChanged();
		setVector(vect);
		while (i<ListLength) {
			Vector rec_vector = new Vector();
			int apart_id = list.get(i).getApart_id();
			String apart_code = list.get(i).getApart_code();
			String apart_category = list.get(i).getApart_category();
			String apart_build_name = list.get(i).getApart_build_name();
			int apart_now_person = list.get(i).getApart_now_person();
			int apart_max_person = list.get(i).getApart_max_person();
			rec_vector.addElement(apart_id);
			rec_vector.addElement(apart_code);
			rec_vector.addElement(apart_category);
			rec_vector.addElement(apart_build_name);
			rec_vector.addElement(apart_now_person);
			rec_vector.addElement(apart_max_person);
			vect.addElement(rec_vector);
			i++;
		}
		setVector(vect);
		fireTableStructureChanged();
	}
	public List<Apartment> getAprtmentList() {
		return aprtmentList;
	}
	public void setAprtmentList(List<Apartment> aprtmentList) {
		this.aprtmentList = aprtmentList;
	}
	
}
