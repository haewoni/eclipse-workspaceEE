package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import basic.JDBCFlowMain;
import dao.common.ConnectionFactory;

public class AddressDao {
	
	public int create(Address insertAddress) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.INSERT);
		pstmt.setString(1, insertAddress.getId());
		pstmt.setString(2, insertAddress.getName());
		pstmt.setString(3, insertAddress.getPhone());
		pstmt.setString(4, insertAddress.getAddress());
		int insertRowCount=pstmt.executeUpdate();
		
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return insertRowCount;
	}
	public int delete(int no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.DELETE);
		pstmt.setInt(1, no);
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	
	public int update(Address updateAddress)  throws Exception{
			Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.UPDATE);
		pstmt.setString(1, updateAddress.getId());
		pstmt.setString(2, updateAddress.getName());
		pstmt.setString(3, updateAddress.getPhone());
		pstmt.setString(4, updateAddress.getAddress());
		pstmt.setInt(5, updateAddress.getNo());
		int updateRowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return updateRowCount;
	}
	
	public Address selectByNo(int fno) throws Exception {
		Address findAddress=null;
		
		
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(selectSql);
		pstmt.setInt(1,fno);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			findAddress=new Address(rs.getInt("no"),
									rs.getString("id"), 
									rs.getString("name"), 
									rs.getString("phone"), 
									rs.getString("address"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return findAddress;
	}
	public ArrayList<Address> selectAll() throws Exception {
		ArrayList<Address> findAddressList=new ArrayList<Address>();
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(selectSql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			findAddressList.add(new Address(rs.getInt("no"),
									rs.getString("id"), 
									rs.getString("name"), 
									rs.getString("phone"), 
									rs.getString("address")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return findAddressList;
	}
}











