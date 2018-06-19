/*
 *
 */
package com.hong.jframe;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.hong.action.AddActionListener;
import com.hong.action.DeleteActionListener;
import com.hong.action.MainManageMouseAction;
import com.hong.action.SearchKeyListener;
import com.hong.action.UpdateActionListener;
import com.hong.jlabel.ApartmentTitleLabel;
import com.hong.jlabel.StudentTitleLabel;
import com.hong.jpanel.ApartmentTablePanel;
import com.hong.jpanel.StudentTablePanel;

/**
 *
 * @author Abbey
 */
public class MainJFrame extends javax.swing.JFrame {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	/**跳转到宿舍管理的按钮*/ 
    private JLabel apart_manage_lb;
    /**装载宿舍的表格的面板*/ 
    private ApartmentTablePanel apartmentTablePanel;
    /**装载宿舍功能按钮的面板*/ 
    private ApartmentTitleLabel apartmentTitleLabel;
    /**主界面中间面板*/ 
    private JPanel main_center_lb;
    
    private JPanel manage_lb;
    /**跳转到学生管理的按钮*/ 
    private JLabel stu_manage_lb;	
    
    private StudentTablePanel studentTablePanel;
    /**装载学生的表格的面板*/ 
    private StudentTitleLabel studentTitleLabel;
    /**装载功能按钮的总面板*/ 
    private JPanel table_action_label;
    /**装载宿舍与学生跳转按钮的总面板*/ 
    private JPanel top_lb;
    
    private javax.swing.JButton search_bt;
    
    private javax.swing.JTextField search_tf;
    
    public String nowPage = "apartment";
    
    
    
    public CardLayout card = new CardLayout();
    public CardLayout card1 = new CardLayout();
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
    	super("宿舍管理系统");
        initComponents();
        Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		this.setLocation(width/12, height/17);
        
       	this.setSize(1100, 650);
    }

    private void initComponents() {

        top_lb = new javax.swing.JPanel();
        manage_lb = new javax.swing.JPanel();
        stu_manage_lb = new javax.swing.JLabel();
        apart_manage_lb = new javax.swing.JLabel();
        table_action_label = new javax.swing.JPanel();
        apartmentTitleLabel = new com.hong.jlabel.ApartmentTitleLabel();
        studentTitleLabel = new com.hong.jlabel.StudentTitleLabel();
        main_center_lb = new javax.swing.JPanel();
        apartmentTablePanel = new com.hong.jpanel.ApartmentTablePanel();
        studentTablePanel = new com.hong.jpanel.StudentTablePanel();
        search_tf = new javax.swing.JTextField();
        search_bt = new javax.swing.JButton();
        
        search_bt.setText("查找");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        top_lb.setBackground(new java.awt.Color(255, 255, 255));
        top_lb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(204, 204, 204)));
        
        manage_lb.setBackground(new java.awt.Color(160, 220, 250));
        manage_lb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        
        stu_manage_lb.setBackground(new java.awt.Color(100, 100, 255));
        stu_manage_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stu_manage_lb.setText("学生管理");
        stu_manage_lb.setToolTipText("学生管理");
        stu_manage_lb.setForeground(new java.awt.Color(255, 255, 255));
        stu_manage_lb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stu_manage_lb.setOpaque(true);

        apart_manage_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apart_manage_lb.setText("宿舍管理");
        apart_manage_lb.setToolTipText("宿舍管理");
        apart_manage_lb.setBackground(new java.awt.Color(255, 255, 255));
        apart_manage_lb.setForeground(new java.awt.Color(160, 220, 250));
        apart_manage_lb.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 153, 0)));
        apart_manage_lb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apart_manage_lb.setOpaque(true);
        
        /**监听器注册*/
        UpdateActionListener l = new UpdateActionListener(this);
        getStudentTitleLabel().getStu_update_bt().addActionListener(l);
        getApartmentTitleLabel().getApart_update_bt().addActionListener(l);
        
        AddActionListener addl = new AddActionListener(this);
        getStudentTitleLabel().getStu_add_bt().addActionListener(addl);
        getApartmentTitleLabel().getApart_add_bt().addActionListener(addl);
        
        DeleteActionListener dell = new DeleteActionListener(this);
        getStudentTitleLabel().getStu_delete_bt().addActionListener(dell);
        getApartmentTitleLabel().getApart_delete_bt().addActionListener(dell);
        
        MainManageMouseAction l1 = new MainManageMouseAction(this);
        apart_manage_lb.addMouseListener(l1);
        stu_manage_lb.addMouseListener(l1);
        
        SearchKeyListener sl = new SearchKeyListener(this);
        search_tf.addKeyListener(sl);
        
        

        GroupLayout manage_lbLayout = new GroupLayout(manage_lb);
        manage_lb.setLayout(manage_lbLayout);
        manage_lbLayout.setHorizontalGroup(
            manage_lbLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, manage_lbLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(stu_manage_lb, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(apart_manage_lb, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250)
                .addComponent(search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manage_lbLayout.setVerticalGroup(
            manage_lbLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(manage_lbLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(stu_manage_lb, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addComponent(apart_manage_lb, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addComponent(search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(search_bt)
            		)
        );

        table_action_label.setBackground(new java.awt.Color(255, 255, 255));
        table_action_label.setLayout(card1);
        table_action_label.add(apartmentTitleLabel, "apart_action_lb");
        table_action_label.add(studentTitleLabel, "stu_action_lb");

        GroupLayout top_lbLayout = new GroupLayout(top_lb);
        top_lb.setLayout(top_lbLayout);
        top_lbLayout.setHorizontalGroup(
            top_lbLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(manage_lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(table_action_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        top_lbLayout.setVerticalGroup(
            top_lbLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(top_lbLayout.createSequentialGroup()
                .addComponent(manage_lb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(table_action_label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        main_center_lb.setLayout(card);
        
        main_center_lb.add(apartmentTablePanel, "apartment_table");
        main_center_lb.add(studentTablePanel, "student_table");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(top_lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main_center_lb, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_lb, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main_center_lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// end initComponents

     /*public static void main(String args[]) {

    	try {
	        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    java.awt.EventQueue.invokeLater(new Runnable() {

	        public void run() {
	            new MainJFrame().setVisible(true);
	        }
	    });
	}*/

	public ApartmentTablePanel getApartmentTablePanel() {
		return apartmentTablePanel;
	}

	public ApartmentTitleLabel getApartmentTitleLabel() {
		return apartmentTitleLabel;
	}

	public StudentTablePanel getStudentTablePanel() {
		return studentTablePanel;
	}

	public StudentTitleLabel getStudentTitleLabel() {
		return studentTitleLabel;
	}

	public JLabel getApart_manage_lb() {
		return apart_manage_lb;
	}

	public JLabel getStu_manage_lb() {
		return stu_manage_lb;
	}

	public JPanel getMain_center_lb() {
		return main_center_lb;
	}

	public JPanel getTable_action_label() {
		return table_action_label;
	}

	public javax.swing.JButton getSearch_bt() {
		return search_bt;
	}

	public javax.swing.JTextField getSearch_tf() {
		return search_tf;
	}
    

    
}
