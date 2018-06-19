/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hong.jlabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.hong.util.CircleButton;
import com.hong.util.CreatecdIcon;

/**
 *
 * @author Abbey
 */
public class ApartmentTitleLabel extends javax.swing.JPanel {
	 	private CircleButton apart_add_bt;
	    private CircleButton apart_delete_bt;
	    private CircleButton apart_update_bt;
	    private JButton system_exit;
	    
    public ApartmentTitleLabel() {
        initComponents();
    }

    private void initComponents() {

        apart_add_bt = new CircleButton();
        apart_update_bt = new CircleButton();
        apart_delete_bt = new CircleButton();
        system_exit = new JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        //apart_add_bt.setText("添加宿舍");
        ImageIcon addImageIcon = CreatecdIcon.add("apart_add2.png");
        apart_add_bt.setIcon(addImageIcon);
        apart_add_bt.setHideActionText(true);
        apart_add_bt.setBorder(null);
        apart_add_bt.setContentAreaFilled(false);
        //apart_add_bt.setBackground(new Color(0,228,255));
        apart_add_bt.setSize(90, 52);

        //apart_update_bt.setText("修改宿舍");
        ImageIcon editImageIcon = CreatecdIcon.add("apart_edit1.png");
        apart_update_bt.setIcon(editImageIcon);
        apart_update_bt.setHideActionText(true);
        apart_update_bt.setBorder(null);
        apart_update_bt.setContentAreaFilled(false);
        apart_update_bt.setBackground(new Color(0,228,255));

        //apart_delete_bt.setText("删除宿舍");
        ImageIcon delImageIcon = CreatecdIcon.add("apart_del1.png");
        apart_delete_bt.setIcon(delImageIcon);
        apart_delete_bt.setHideActionText(true);
        apart_delete_bt.setBorder(null);
        apart_delete_bt.setContentAreaFilled(false);
        apart_delete_bt.setBackground(new Color(0,228,255));
        

        //system_exit.setText("退出系统");
        ImageIcon exitImageIcon = CreatecdIcon.add("exit.png",60,60);
        system_exit.setIcon(exitImageIcon);
        system_exit.setHideActionText(true);
        system_exit.setBorder(null);
        system_exit.setContentAreaFilled(false);
        system_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(apart_add_bt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(apart_update_bt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(apart_delete_bt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(system_exit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(apart_delete_bt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(apart_update_bt, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
            .addComponent(system_exit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(apart_add_bt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void apart_add_btActionPerformed(ActionEvent evt) {//GEN-FIRST:event_apart_add_btActionPerformed
        // TODO add your handling code here:
    	
    }//GEN-LAST:event_apart_add_btActionPerformed

    private void apart_update_btActionPerformed(ActionEvent evt) {//GEN-FIRST:event_apart_update_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apart_update_btActionPerformed

    private void apart_delete_btActionPerformed(ActionEvent evt) {//GEN-FIRST:event_apart_delete_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apart_delete_btActionPerformed

	public CircleButton getApart_add_bt() {
		return apart_add_bt;
	}

	public CircleButton getApart_delete_bt() {
		return apart_delete_bt;
	}

	public CircleButton getApart_update_bt() {
		return apart_update_bt;
	}

	public JButton getSystem_exit() {
		return system_exit;
	}
}
