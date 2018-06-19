package com.hong.util;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.hong.jframe.MainJFrame;
import com.hong.jlabel.ApartmentTitleLabel;

public class CreatecdIcon {
    public static ImageIcon add(String ImageName) {
        URL IconUrl = MainJFrame.class.getResource("/" + ImageName);// 获得图标资源的URL
        ImageIcon icon = new ImageIcon(IconUrl);// 创建图标
        Image image = icon.getImage().getScaledInstance(90, 52, icon.getImage().SCALE_FAST);
        icon = new ImageIcon(image);
        return icon;// 返回图标
    }
    public static ImageIcon add(String ImageName, int width, int height) {
        URL IconUrl = MainJFrame.class.getResource("/" + ImageName);// 获得图标资源的URL
        ImageIcon icon = new ImageIcon(IconUrl);// 创建图标
        Image image = icon.getImage().getScaledInstance(width, height, icon.getImage().SCALE_FAST);
        icon = new ImageIcon(image);
        return icon;// 返回图标
    }
}
