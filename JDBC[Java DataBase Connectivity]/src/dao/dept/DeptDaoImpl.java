package dao.dept;

import java.lang.invoke.ConstantCallSite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class DeptDaoImpl implements DeptDao{
	
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user = "javapython30";
	String password = "javapython30";
	
	@Override
	public void insert(Dept department) throws Exception {
		String insertSql = "insert into dept values(?,?,?)";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setInt(1, department.getDeptno());
		pstmt.setString(2, department.getDname());
		pstmt.setString(3, department.getLoc());
		con.close();
		pstmt.close();
		
	}

	@Override
	public Dept selectByNo(int deptno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
