/**
 * 
 */
package com.hong.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hong.jframe.AddStudentJFrame;

/**
 * @author Abbey
 *
 */
public class TimeRun implements Runnable {
	AddStudentJFrame f;
	public TimeRun(AddStudentJFrame f)
	{
		this.f = f;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){ 
			 try{
				 
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
				 String str = df.format(new Date());// new Date()为获取当前系统时间 
				 f.getStu_date_tf().setText(str);
				 Thread.sleep(1000);//休眠1毫秒
				 
			 }catch(Throwable t){ 
			  t.printStackTrace(); 
			  } 
			 } 
	}

}
