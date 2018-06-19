/**
 * 
 */
package com.hong.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hong.bean.Apartment;
import com.hong.bean.Student;
import com.hong.dialog.MyDialog;
import com.hong.jframe.AddStudentJFrame;
import com.hong.jframe.MainJFrame;
import com.hong.util.DBTool;

/**
 * @author Abbey
 *
 */
public class StudentDaoImpl{

	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
		Apartment apartment = apartdao.findApartmentByCode(student.getStu_apart_name());
		
		if(student.getStu_apart_name().equals("请选择宿舍!"))
		{
			MyDialog mdl = new MyDialog(new AddStudentJFrame(new MainJFrame()) , "请选择宿舍！");
		}
		else if(apartment.getApart_now_person() >= apartment.getApart_max_person())
		{
			MyDialog mdl = new MyDialog(new AddStudentJFrame() , "宿舍该宿舍满员！");
		}
		else if(!apartment.getApart_category().equals(student.getStu_gender()))
		{
			MyDialog mdl = new MyDialog(new AddStudentJFrame() , "宿舍性别不符！");
		}
		else
		{
			
			SqlSessionFactory sqlSessionFactory;
			try {
				sqlSessionFactory = getSqlSessionFactory();
				//1、获取到的SqlSession不会自动提交数据
				SqlSession openSession = sqlSessionFactory.openSession();
				StudentDao studentMapper = openSession.getMapper(StudentDao.class);
				studentMapper.insertStudent(student);
				openSession.commit();
				openSession.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
		Student student = findStudentById(id);
		Apartment apartment = apartdao.findApartmentByCode(student.getStu_apart_name());
		apartment.setApart_now_person(apartment.getApart_now_person() - 1);
		apartdao.updateApartment(apartment);
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			//1、获取到的SqlSession不会自动提交数据
			SqlSession openSession = sqlSessionFactory.openSession();
			StudentDao studentMapper = openSession.getMapper(StudentDao.class);
			studentMapper.deleteStudent(id);
			openSession.commit();
			openSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student old_student = findStudentById(student.getStu_id());
		ApartmentDaoImpl apartdao = new ApartmentDaoImpl();
		Apartment apartment = apartdao.findApartmentByCode(student.getStu_apart_name());
		System.out.println(apartment.getApart_code());
		if(!student.getStu_gender().equals("男") && !student.getStu_gender().equals("女"))
		{
			new MyDialog(new MainJFrame(), "请输入正确的性别，‘" +student.getStu_id()+ "’修改失败！");
			return;
		}
		if(apartment.getApart_code() == null)
		{
			new MyDialog(new MainJFrame(), "没有该宿舍！");
			return;
		}
		
		else
		{
			if(old_student.getStu_apart_name() != student.getStu_apart_name())
			{
				apartment.setApart_now_person(apartment.getApart_now_person()+1);
				apartdao.updateApartment(apartment);
			}
			if(!old_student.getStu_gender().equals(student.getStu_gender()))
			{
				new MyDialog(new MainJFrame(), "您已经修改了 ‘" + student.getStu_id() + "’的性别！");
			}
			SqlSessionFactory sqlSessionFactory;
			try {
				sqlSessionFactory = getSqlSessionFactory();
				//1、获取到的SqlSession不会自动提交数据
				SqlSession openSession = sqlSessionFactory.openSession();
				StudentDao studentMapper = openSession.getMapper(StudentDao.class);
				studentMapper.updateStudent(student);
				openSession.commit();
				openSession.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			//1、获取到的SqlSession不会自动提交数据
			SqlSession openSession = sqlSessionFactory.openSession();
			StudentDao studentMapper = openSession.getMapper(StudentDao.class);
			Student student = studentMapper.findStudentById(id);
			openSession.commit();
			openSession.close();
			return student;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			//1、获取到的SqlSession不会自动提交数据
			SqlSession openSession = sqlSessionFactory.openSession();
			StudentDao studentMapper = openSession.getMapper(StudentDao.class);
			List<Student> stuList = studentMapper.findAllStudents();
			openSession.commit();
			openSession.close();
			return stuList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> findStudentsByAnything(String anything) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			//1、获取到的SqlSession不会自动提交数据
			SqlSession openSession = sqlSessionFactory.openSession();
			StudentDao studentMapper = openSession.getMapper(StudentDao.class);
			List<Student> stuList = studentMapper.findStudentsByAnything(anything);
			openSession.commit();
			openSession.close();
			return stuList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> findStudentsByApart(String apart) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			//1、获取到的SqlSession不会自动提交数据
			SqlSession openSession = sqlSessionFactory.openSession();
			StudentDao studentMapper = openSession.getMapper(StudentDao.class);
			List<Student> stuList = studentMapper.findStudentsByApart(apart);
			openSession.commit();
			openSession.close();
			return stuList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			return new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
