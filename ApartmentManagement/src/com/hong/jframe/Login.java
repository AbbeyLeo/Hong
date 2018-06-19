package com.hong.jframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hong.action.FocusStartThread;
import com.hong.action_of_login.LoginAction;
import com.hong.action_of_login.NameFocusAction;
import com.hong.action_of_login.PasswordFocusAction;

public class Login extends javax.swing.JFrame {
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel un;
    private javax.swing.JLabel pwd;
    private javax.swing.JLabel UsernameAlert;
    private javax.swing.JLabel passwordAlert;
    private javax.swing.JLabel title;
    private javax.swing.JTextField username;
    private JPasswordField password;
    public Thread  NameThread = new Thread(new FocusStartThread(UsernameAlert));
	public Thread PasswordThread = new Thread(new FocusStartThread(passwordAlert));
    // End of variables declaration//GEN-END:variables

	public JTextField getUsername() {
		return username;
	}
	public JLabel getUsernameAlert() {
		return UsernameAlert;
	}
	public void setUsernameAlert(JLabel usernameAlert) {
		UsernameAlert = usernameAlert;
	}
	public JLabel getPasswordAlert() {
		return passwordAlert;
	}
	public void setPasswordAlert(JLabel passwordAlert) {
		this.passwordAlert = passwordAlert;
	}
	public void setUsername(JTextField username) {
		this.username = username;
	}
	public JTextField getPassword() {
		return password;
	}
	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	
    public Login() {
    	super("宿舍管理系统");
        initComponents();
        NameFocusAction NameAction = new NameFocusAction(this);
		username.addFocusListener(NameAction);
		
		PasswordFocusAction passwordAction = new PasswordFocusAction(this);
		password.addFocusListener(passwordAction);
		
		
		NameThread.start();
		PasswordThread.start();
		
		LoginAction LoginAction = new LoginAction(this);
		loginButton.addActionListener(LoginAction);
		
		this.setResizable(false);
		setVisible(true);
		
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        un = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        pwd = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        UsernameAlert = new javax.swing.JLabel();
        passwordAlert = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        un.setText("用户名：");

        pwd.setText("密码：");

        UsernameAlert.setText("*用户名长度在5-8个字符");
        UsernameAlert.setForeground(Color.GREEN);

        passwordAlert.setText("*密码长度在6-10个字符");
        passwordAlert.setForeground(Color.GREEN);

        loginButton.setText("登录");

        resetButton.setText("重置");

        title.setText("请登录管理系统");
        
        Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		this.setLocation((width+300)/3,  height/4);
		
		

		
		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(un, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordAlert, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(un, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsernameAlert))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordAlert))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JButton getLoginButton() {
		return loginButton;
	}
	public javax.swing.JButton getResetButton() {
		return resetButton;
	}
	
	/*public static void main(String args[]) {
   	 Login L = new Login();
   }*/
}