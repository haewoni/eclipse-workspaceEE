package com.itwill.user;

public class UserDaoTestMain {
	public static void main(String[] args) {
		
	UserDaoMyBatis userDao = new UserDaoMyBatis();
	System.out.println("------findUserList------");
	System.out.println("###"+userDao.findUserList());;
 }
}