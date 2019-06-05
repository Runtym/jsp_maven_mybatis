package com.osf.test.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.osf.test.dao.impl.MemberDAOImpl;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static SqlSessionFactory ssFactory;
	static {
		InputStream is = MemberDAOImpl.class.getClassLoader()
				.getResourceAsStream("config/mybatis-config.xml");
		SqlSessionFactoryBuilder ssfBuilder 
				= new SqlSessionFactoryBuilder();
		ssFactory = ssfBuilder.build(is);
	}
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		SqlSession ss = ssFactory.openSession();
		List<Map<String,String>> tList = 
				ss.selectList("com.osf.test.Test.selectList");
		pw.println(tList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
