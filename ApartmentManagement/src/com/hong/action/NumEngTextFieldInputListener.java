package com.hong.action;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class NumEngTextFieldInputListener implements CaretListener {
 
    @Override
    public void caretUpdate(CaretEvent e) {
        JTextField textField = (JTextField) e.getSource(); // 获得触发事件的 JTextField
        String text = textField.getText();
        if (text.length() == 0) {
            return;
        }
        char ch = text.charAt(text.length() - 1);
        if (!(ch >= '0' && ch <= '9' // 数字
                || ch >= 'A' && ch <= 'z' // 字母
                )) { 
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // 去掉 JTextField 中的末尾字符
                    textField.setText(text.substring(0, text.length() - 1));
                }
            });
        }
    }
 
}