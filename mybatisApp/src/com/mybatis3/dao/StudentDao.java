package com.mybatis3.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	public StudentDao(){
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@@ INSERT BY SEQUENCE @@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public int insertStudentBySequence1(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount=sqlSession.insert(NAMESPACE+"insertStudentBySequence1", student);
		sqlSession.close();
		return insertRowCount;
	}
	
	public int insertStudentBySequence2(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount=sqlSession.insert(NAMESPACE+"insertStudentBySequence", student);
		sqlSession.close();
		return insertRowCount;
	}
	
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@ INSERT @@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public int insertStudent(Student student) {
		/*
		 <<sqlSessionFactory.openSession(true)>>
		 
		 * true  :  autocommit true
		 * 	   		sqlSession.close();		
		 * false : autocommit false
		 *     		sqlSession.commit();
		 *     		sqlSession.close();
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount=sqlSession.insert(NAMESPACE+"insertStudent", student);
		sqlSession.close();
		return insertRowCount;
	}
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@ SELECT @@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		Student findStudent=
				sqlSession
				.selectOne(NAMESPACE+"findStudentByIdResultMap",
						studId);
		
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	public Student findStudentById(Integer studId) {
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		Student findStudent=
				sqlSession
				.selectOne(NAMESPACE+"findStudentById",
						studId);
		
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	public List<Student> findAllStudents(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.
				selectList(NAMESPACE+"findAllStudents");
		sqlSession.close();
		return studentList;
	}
	
	
}












