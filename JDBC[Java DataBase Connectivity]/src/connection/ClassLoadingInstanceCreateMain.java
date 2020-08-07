package connection;

import java.sql.Driver;
import java.sql.DriverManager;

public class ClassLoadingInstanceCreateMain {

	public static void main(String[] args) throws Exception {
		/*
		StrongDriver strongDriver = new StrongDriver();
		DriverManager.registerDriver(strongDriver);
		Connection con = DriverManager.getConnection("jdbc:strong:...","user","pass");
		*/
		
		/*
		Class driverClazz = Class.forName("connection.StrongDriver");
		Driver driver = (Driver)driverClazz.newInstance();   //기본 생성자 호출
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("","","");
		 */
		Class.forName("connection.StrongDriver");
		
	}

}
