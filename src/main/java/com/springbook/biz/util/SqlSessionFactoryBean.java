package com.springbook.biz.util;

import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	// MyBatis를 사용하기 위해서 SqlSessionFactoryBean은 반드시 필요
	private static SqlSessionFactory sessionFactory = null;
	
	
	static {
		try {
			if(sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);  // 설정 정보 읽고 객체 생성
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
		public static SqlSession getSqlSessionInstance() {
			return sessionFactory.openSession();
		}
}
