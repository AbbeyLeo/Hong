/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hong.jframe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.hong.Dao.ApartmentDao;
import com.hong.Dao.ApartmentDaoImpl;
import com.hong.Dao.StudentDao;
import com.hong.Dao.StudentDaoImpl;
import com.hong.action.AddApartmentFocusListener;
import com.hong.action.FocusStartThread;
import com.hong.action.NumEngStrTextFieldInputListener;
import com.hong.action.NumEngTextFieldInputListener;
import com.hong.action.OnlyNumberTextFieldInputListener;
import com.hong.bean.Apartment;
import com.hong.bean.Student;

/**
 *
 * @author Abbey
 */
public class AddApartmentJFrame extends javax.swing.JFrame {
	MainJFrame parent;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_apart_label;
    private javax.swing.JLabel apart_build_name_label_alarm;
    private javax.swing.JTextField apart_build_name_tf;
    private javax.swing.JLabel apart_category_label_alarm;
    private javax.swing.JLabel apart_code_label_alarm;
    private javax.swing.JTextField apart_code_tf;
    private javax.swing.JTextField apart_max_person_tf;
    private javax.swing.JComboBox<String> apart_category_tf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel max_person_alarm;
    private javax.swing.JButton ok_bt;
    private javax.swing.JLabel ruzhuleibie_label;
    private javax.swing.JLabel sushehao_label;
    private javax.swing.JLabel sushelou_label;
    private javax.swing.JLabel zhidaruzhu_label;
    
    public Thread codeThread = new Thread(new FocusStartThread(apart_code_label_alarm));
    public Thread categoryThread = new Thread(new FocusStartThread(apart_category_label_alarm));
    public Thread buildNameThread = new Thread(new FocusStartThread(apart_build_name_label_alarm));
    public Thread maxPersonThread = new Thread(new FocusStartThread(max_person_alarm));

    public AddApartmentJFrame(MainJFrame parent) {
        
    	initComponents();
    	this.parent = parent;
    }
    public AddApartmentJFrame() {
    	initComponents();
    	Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		this.setLocation(width/3, height/5);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        apart_code_tf = new javax.swing.JTextField();
        add_apart_label = new javax.swing.JLabel();
        sushehao_label = new javax.swing.JLabel();
        apart_code_label_alarm = new javax.swing.JLabel();
        ruzhuleibie_label = new javax.swing.JLabel();
        apart_category_label_alarm = new javax.swing.JLabel();
        sushelou_label = new javax.swing.JLabel();
        apart_build_name_tf = new javax.swing.JTextField();
        apart_build_name_label_alarm = new javax.swing.JLabel();
        ok_bt = new javax.swing.JButton();
        zhidaruzhu_label = new javax.swing.JLabel();
        apart_max_person_tf = new javax.swing.JTextField();
        max_person_alarm = new javax.swing.JLabel();
        apart_category_tf = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        apart_code_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apart_code_tfActionPerformed(evt);
            }
        });
        
        AddApartmentFocusListener aapfl = new AddApartmentFocusListener(this);
        apart_build_name_tf.addFocusListener(aapfl);
        apart_category_tf.addFocusListener(aapfl);
        apart_code_tf.addFocusListener(aapfl);
        apart_max_person_tf.addFocusListener(aapfl);
        apart_build_name_tf.addCaretListener(new NumEngStrTextFieldInputListener());
        apart_code_tf.addCaretListener(new NumEngStrTextFieldInputListener());
        apart_max_person_tf.addCaretListener(new OnlyNumberTextFieldInputListener());
        
        add_apart_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_apart_label.setText("添加宿舍");

        sushehao_label.setText("宿 舍 号：");

        apart_code_label_alarm.setText("*请输入宿舍号");

        ruzhuleibie_label.setText("入住类别：");

        apart_category_label_alarm.setText("*请输入入住类别");

        sushelou_label.setText("宿 舍 楼：");

        apart_build_name_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apart_build_name_tfActionPerformed(evt);
            }
        });

        apart_build_name_label_alarm.setText("*请输入宿舍楼名字");

        ok_bt.setText("确定");
        InsertActionListener ial = new InsertActionListener(this);
        ok_bt.addActionListener(ial);

        zhidaruzhu_label.setText("最大入住人数：");

        apart_max_person_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apart_max_person_tfActionPerformed(evt);
            }
        });

        max_person_alarm.setText("*");

        apart_category_tf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"男", "女" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(add_apart_label, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ok_bt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zhidaruzhu_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apart_max_person_tf))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(ruzhuleibie_label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(apart_category_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(sushehao_label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(apart_code_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(sushelou_label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(apart_build_name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(apart_build_name_label_alarm, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(apart_code_label_alarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apart_category_label_alarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(max_person_alarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add_apart_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apart_code_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sushehao_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apart_code_label_alarm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruzhuleibie_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apart_category_label_alarm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apart_category_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apart_build_name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sushelou_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apart_build_name_label_alarm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(max_person_alarm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(zhidaruzhu_label)
                        .addComponent(apart_max_person_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addComponent(ok_bt)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apart_code_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apart_code_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apart_code_tfActionPerformed

    private void apart_build_name_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apart_build_name_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apart_build_name_tfActionPerformed

    private void apart_max_person_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apart_max_person_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apart_max_person_tfActionPerformed

    /**
     * @param args the command line arguments
     */
/*    public static void main(String args[]) {
        

         Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddApartmentJFrame().setVisible(true);
            }
        });
    }*/

    
    
    

    // End of variables declaration//GEN-END:variables
    
    //添加action
    class InsertActionListener implements ActionListener{
    	AddApartmentJFrame ajf;
    	public InsertActionListener(JFrame jf)
    	{
    		ajf = (AddApartmentJFrame) jf;
    	}
   	@Override
   	public void actionPerformed(ActionEvent e) {
   		// TODO Auto-generated method stub
   		if(apart_code_tf.getText().equals("") || apart_build_name_tf.getText().equals("") || apart_max_person_tf.getText().equals(""))
   			System.out.println("空");
   		else
   		{	
	   		String apart_code = apart_code_tf.getText();
	   		String apart_category =  apart_category_tf.getSelectedItem() + "";
	   		String apart_build_name = apart_build_name_tf.getText();
	   		int apart_max_person =  Integer.parseInt(apart_max_person_tf.getText());
	   		Apartment apartment = new Apartment();
	   		ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
	   		StudentDaoImpl studao = new StudentDaoImpl();
	   		apartment.setApart_code(apart_code);
	   		apartment.setApart_category(apart_category);
	   		apartment.setApart_build_name(apart_build_name);
	   		apartment.setApart_max_person(apart_max_person);
	   		apartdao.insertApartment(apartment);
	   		//ajf.setVisible(false);
	   		try {
	   			parent.getStudentTablePanel().getStu_table_model().showResult(studao.findAllStudents());
				parent.getApartmentTablePanel().getApart_table_model().showResult(apartdao.findAllApartment());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   		}
   	}}



	public javax.swing.JLabel getApart_build_name_label_alarm() {
		return apart_build_name_label_alarm;
	}

	public void setApart_build_name_label_alarm(
			javax.swing.JLabel apart_build_name_label_alarm) {
		this.apart_build_name_label_alarm = apart_build_name_label_alarm;
	}

	public javax.swing.JTextField getApart_build_name_tf() {
		return apart_build_name_tf;
	}

	public void setApart_build_name_tf(javax.swing.JTextField apart_build_name_tf) {
		this.apart_build_name_tf = apart_build_name_tf;
	}

	public javax.swing.JLabel getApart_category_label_alarm() {
		return apart_category_label_alarm;
	}

	public void setApart_category_label_alarm(
			javax.swing.JLabel apart_category_label_alarm) {
		this.apart_category_label_alarm = apart_category_label_alarm;
	}

	public javax.swing.JLabel getApart_code_label_alarm() {
		return apart_code_label_alarm;
	}

	public void setApart_code_label_alarm(javax.swing.JLabel apart_code_label_alarm) {
		this.apart_code_label_alarm = apart_code_label_alarm;
	}

	public javax.swing.JTextField getApart_code_tf() {
		return apart_code_tf;
	}

	public void setApart_code_tf(javax.swing.JTextField apart_code_tf) {
		this.apart_code_tf = apart_code_tf;
	}

	public javax.swing.JTextField getApart_max_person_tf() {
		return apart_max_person_tf;
	}

	public void setApart_max_person_tf(javax.swing.JTextField apart_max_person_tf) {
		this.apart_max_person_tf = apart_max_person_tf;
	}

	public javax.swing.JComboBox<String> getApart_category_tf() {
		return apart_category_tf;
	}

	public void setApart_category_tf(javax.swing.JComboBox<String> apart_category_tf) {
		this.apart_category_tf = apart_category_tf;
	}

	public javax.swing.JLabel getMax_person_alarm() {
		return max_person_alarm;
	}

	public void setMax_person_alarm(javax.swing.JLabel max_person_alarm) {
		this.max_person_alarm = max_person_alarm;
	}
}
