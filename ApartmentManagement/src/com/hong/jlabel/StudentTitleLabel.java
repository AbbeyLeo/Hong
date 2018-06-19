/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hong.jlabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.hong.util.CircleButton;
import com.hong.util.CreatecdIcon;

/**
 *
 * @author Abbey
 */
public class StudentTitleLabel extends javax.swing.JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private CircleButton stu_add_bt;
    private CircleButton stu_delete_bt;
    private CircleButton stu_update_bt;
    private JButton system_exit;
    // End of variables declaration//GEN-END:variables

    public StudentTitleLabel() {
        initComponents();
    }

    private void initComponents() {

        stu_add_bt = new CircleButton();
        stu_update_bt = new CircleButton();
        stu_delete_bt = new CircleButton();
        system_exit = new JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        //stu_add_bt.setText("添加学生");
        ImageIcon addImageIcon = CreatecdIcon.add("stu_add.png");
        stu_add_bt.setIcon(addImageIcon);
        stu_add_bt.setHideActionText(true);
        stu_add_bt.setBorder(null);
        stu_add_bt.setContentAreaFilled(false);
        stu_add_bt.setSize(90, 52);

        //stu_update_bt.setText("修改学生");
        ImageIcon editImageIcon = CreatecdIcon.add("stu_edit.png");
        stu_update_bt.setIcon(editImageIcon);
        stu_update_bt.setHideActionText(true);
        stu_update_bt.setBorder(null);
        stu_update_bt.setContentAreaFilled(false);
        stu_update_bt.setSize(90, 52);
        
        stu_delete_bt.setText("删除学生");
        ImageIcon deleteImageIcon = CreatecdIcon.add("stu_delete.png");
        stu_delete_bt.setIcon(deleteImageIcon);
        stu_delete_bt.setHideActionText(true);
        stu_delete_bt.setBorder(null);
        stu_delete_bt.setContentAreaFilled(false);
        stu_delete_bt.setSize(90, 52);

      //system_exit.setText("退出系统");
        ImageIcon exitImageIcon = CreatecdIcon.add("exit.png",60,60);
        system_exit.setIcon(exitImageIcon);
        system_exit.setHideActionText(true);
        system_exit.setBorder(null);
        system_exit.setContentAreaFilled(false);
        system_exit.setBackground(Color.WHITE);
        system_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(stu_add_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(stu_update_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(stu_delete_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(system_exit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(stu_add_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addComponent(stu_update_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
            .addComponent(system_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stu_delete_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

	public javax.swing.JButton getStu_add_bt() {
		return stu_add_bt;
	}

	public javax.swing.JButton getStu_delete_bt() {
		return stu_delete_bt;
	}

	public javax.swing.JButton getStu_update_bt() {
		return stu_update_bt;
	}

	public javax.swing.JButton getSystem_exit() {
		return system_exit;
	}
}
