package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentById-------");
		System.out.println("###"+studentDao.findStudentById(3));
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("###"+studentDao.findAllStudents());
		System.out.println("-------findStudentByIdResultMap-------");
	    System.out.println("###"+studentDao.findStudentByIdResultMap(3));
//		System.out.println("---------insertStudent(Dto)--------------");
//		Student student1 = new Student(8000,"김팔","eight@gmail.com",new Date());
//		System.out.println("###"+studentDao.insertStudent(student1));
	    System.out.println("---------insertStudentBySequence1---------");
		Student student2 = new Student(null,"김시퀀스1","s1@gmail.com", new Date());
		System.out.println("###"+studentDao.insertStudentBySequence1(student2));
		System.out.println("-->"+student2.getStudId());
		
		Student student3 = new Student(null,"김시퀀스2","s2@gmail.com", new Date());
	    System.out.println("---------insertStudentBySequence2---------");
	    System.out.println("###"+studentDao.insertStudentBySequence2(student3));
	    System.out.println("insert PK-->"+student3.getStudId());
		/*
		System.out.println("---------findAllStudents---------");
		System.out.println("------------findAllStudentsMap-------------");
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("---------findStudentByIdWithAddress----------");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------insertStudentParameterMap(parameter Map)----");
		System.out.println("---------updateStudent-------------------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------delete Student------------------");
		System.out.println("---------findStudentCount----------------");
		*/

	}
}
