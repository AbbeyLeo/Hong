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
import java.util.Vector;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hong.bean.Apartment;
import com.hong.bean.Student;
import com.hong.dialog.MyDialog;
import com.hong.jframe.MainJFrame;
import com.hong.util.DBTool;

/**
 * @author Abbey
 *
 */
public class ApartmentDaoImpl {

	/* (non-Javadoc)
	 * @see com.hong.Dao.ApartmentDao#insertApartment(com.hong.bean.Apartment)
	 */
	public void insertApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			//1、获取到的SqlSession不会自动提交数据
			SqlSession openSession = sqlSessionFactory.openSession();
			ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
			apartmentMapper.insertApartment(apartment);
			openSession.commit();
			openSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.hong.Dao.ApartmentDao#deleteApartment(com.hong.bean.Apartment)
	 */
	public void deleteApartment(int id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory;
			try {
				sqlSessionFactory = getSqlSessionFactory();
				SqlSession openSession = sqlSessionFactory.openSession();
				ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
				apartmentMapper.deleteApartment(id);
				openSession.commit();
				openSession.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/* (non-Javadoc)
	 * @see com.hong.Dao.ApartmentDao#updateApartment(com.hong.bean.Apartment)
	 */
	public void updateApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			SqlSession openSession = sqlSessionFactory.openSession();
			ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
			apartmentMapper.updateApartment(apartment);
			openSession.commit();
			openSession.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateApartmentByCode(Apartment apartment) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			SqlSession openSession = sqlSessionFactory.openSession();
			ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
			apartmentMapper.updateApartmentByCode(apartment);
			openSession.commit();
			openSession.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/* (non-Javadoc)
	 * @see com.hong.Dao.ApartmentDao#findApartmentById(int)
	 */
	public Apartment findApartmentByCode(String code) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			SqlSession openSession = sqlSessionFactory.openSession();
			ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
			Apartment apartment = apartmentMapper.findApartmentByCode(code);
			openSession.commit();
			openSession.close();
			return apartment;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hong.Dao.ApartmentDao#findAllApartment()
	 */
	public List<Apartment> findAllApartment() {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			SqlSession openSession = sqlSessionFactory.openSession();
			ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
			List<Apartment> apartList = apartmentMapper.findAllApartment();
			openSession.commit();
			openSession.close();
			return apartList;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hong.Dao.ApartmentDao#findApartmentByAnything(java.lang.String)
	 */
	public List<Apartment> findApartmentByAnything(String anything) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			SqlSession openSession = sqlSessionFactory.openSession();
			ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
			List<Apartment> apartList = apartmentMapper.findApartmentByAnything("%"+anything+"%");
			openSession.commit();
			openSession.close();
			return apartList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public Vector findApartmentCode() {
		List<Apartment> listApart = findAllApartment();
		Vector vect = new Vector();
		vect.removeAllElements();
		vect.addElement("请选择宿舍!");
		for(int i = 0; i < listApart.size(); i++)
		{
			vect.addElement(listApart.get(i).getApart_code());
		}
		return vect;
	}

	public Apartment findApartmentById(int id) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			SqlSession openSession = sqlSessionFactory.openSession();
			ApartmentDao apartmentMapper = openSession.getMapper(ApartmentDao.class);
			Apartment apartment = apartmentMapper.findApartmentById(id);
			openSession.commit();
			openSession.close();
			return apartment;
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
