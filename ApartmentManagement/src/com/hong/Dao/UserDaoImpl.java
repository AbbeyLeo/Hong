package com.hong.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hong.bean.User;
import com.hong.util.DBTool;

public class UserDaoImpl {

	public User getUserbyUsername(String name) {
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = getSqlSessionFactory();
			//1、获取到的SqlSession不会自动提交数据
			SqlSession openSession = sqlSessionFactory.openSession();
			UserDao userMapper = openSession.getMapper(UserDao.class);
			User user = userMapper.getUserbyUsername(name);
			openSession.commit();
			openSession.close();
			return user;
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
