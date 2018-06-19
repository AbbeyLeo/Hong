/**
 * 
 */
package com.hong.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import com.hong.jpanel.TablePanel;

/**
 * @author Abbey
 *
 */
public class JTableDeleteMouseAction implements MouseListener {
	TablePanel tb;
	boolean isNewRow = true;
	List<Integer> delete_rowlist = new ArrayList<Integer>();
	public JTableDeleteMouseAction(TablePanel tb)
	{
		this.tb = tb;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() == 1 && e.getButton() ==MouseEvent.BUTTON1)
		{
			delete_rowlist.clear();
			for(int i = 0;i<tb.getTable().getSelectedRows().length;i++)
			{
				delete_rowlist.add(tb.getTable().getSelectedRows()[i]);
			}
			tb.setDelete_rowlist(delete_rowlist);
			//System.out.println(delete_rowlist.size());
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() == 1 && e.getButton() ==MouseEvent.BUTTON1)
		{
			delete_rowlist.clear();
			for(int i = 0;i<tb.getTable().getSelectedRows().length;i++)
			{
				delete_rowlist.add(tb.getTable().getSelectedRows()[i]);
			}
			tb.setDelete_rowlist(delete_rowlist);
			//System.out.println(delete_rowlist.size());
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() == 1 && e.getButton() ==MouseEvent.BUTTON1)
		{
			delete_rowlist.clear();
			for(int i = 0;i<tb.getTable().getSelectedRows().length;i++)
			{
				delete_rowlist.add(tb.getTable().getSelectedRows()[i]);
			}
			tb.setDelete_rowlist(delete_rowlist);
			//System.out.println(delete_rowlist.size());
		}
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
