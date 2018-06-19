package com.hong.test;
import javax.swing.UIManager;

import com.hong.Dao.ApartmentDao;
import com.hong.Dao.ApartmentDaoImpl;
import com.hong.Dao.StudentDao;
import com.hong.Dao.StudentDaoImpl;
import com.hong.jframe.Login;
import com.hong.jframe.MainJFrame;

public class Start {

	  public static void main(String args[]) {

	    	try {
		        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    java.awt.EventQueue.invokeLater(new Runnable() {

		        public void run() {
		            new Login().setVisible(true);
		        }
		    });
		}

}