/**
 * 
 */
package com.hong.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.hong.jframe.AddApartmentJFrame;
import com.hong.jframe.AddStudentJFrame;
import com.hong.jframe.MainJFrame;

/**
 * @author Abbey
 *
 */
public class AddActionListener implements ActionListener {
	MainJFrame f;
	public AddActionListener(MainJFrame f)
	{
		this.f = f;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == f.getStudentTitleLabel().getStu_add_bt())
		{
			try {
		        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
		    java.awt.EventQueue.invokeLater(new Runnable() {

		        public void run() {
		            JFrame addFrame = new AddStudentJFrame(f);
		            addFrame.setVisible(true);
		            //f.setEnabled(false);
		        }
		    });
		}
		if(e.getSource() == f.getApartmentTitleLabel().getApart_add_bt())
		{
			try {
		        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
		    java.awt.EventQueue.invokeLater(new Runnable() {

		        public void run() {
		            JFrame addFrame = new AddApartmentJFrame(f);
		            addFrame.setVisible(true);
		            //f.setEnabled(false);
		        }
		    });
		}
	}

}
