package com.itwill.guest.test;

import java.util.Date;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImplMyBatis;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDaoImplMyBatis();
		System.out.println("--------0.selectAll--------");
		System.out.println("###"+guestDao.selectAll());
		System.out.println("--------0.selectByNo-------");
		System.out.println("###"+guestDao.selectByNo(10));
		System.out.println("--------1.insert---------");
		System.out.println("###"+guestDao
				.insertGuest(
						new Guest(-9090, "정종헌", new Date()+"", "g@gmail.com", "http:// ", "월요일", "화요일")));
		
//		Guest guest=guestDao.selectByNo(4);
//		guest.setGuest_name("김변경");		
//		System.out.println("2.update");
//		System.out.println(guestDao.updateGuest(guest));
	}	

}
