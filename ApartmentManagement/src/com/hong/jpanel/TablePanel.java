package com.hong.jpanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

public class TablePanel extends JPanel{
	private JTable table;
	private String name;
	private List<Integer> rowList = new ArrayList<Integer>();
	private List<Integer> delete_rowlist = new ArrayList<Integer>();
	public boolean isUpdateed = false;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getRowList() {
		return rowList;
	}

	public void setRowList(List<Integer> rowList) {
		this.rowList = rowList;
	}

	public List<Integer> getDelete_rowlist() {
		return delete_rowlist;
	}

	public void setDelete_rowlist(List<Integer> delete_rowlist) {
		this.delete_rowlist = delete_rowlist;
	}

	public boolean isUpdateed() {
		return isUpdateed;
	}

	public void setUpdateed(boolean isUpdateed) {
		this.isUpdateed = isUpdateed;
	}

}
