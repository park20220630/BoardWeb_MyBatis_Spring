package com.springbook.biz.util;

import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	// MyBatis�� ����ϱ� ���ؼ� SqlSessionFactoryBean�� �ݵ�� �ʿ�
	private static SqlSessionFactory sessionFactory = null;
	
	
	static {
		try {
			if(sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);  // ���� ���� �а� ��ü ����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
		public static SqlSession getSqlSessionInstance() {
			return sessionFactory.openSession();
		}
}
