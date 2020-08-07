package dao.address;

import java.util.ArrayList;

/*
이름      널?       유형            
------- -------- ------------- 
NO      NOT NULL NUMBER(4)     
ID               VARCHAR2(20)  
NAME             VARCHAR2(50)  
PHONE            VARCHAR2(50)  
ADDRESS          VARCHAR2(100) 
 */
public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao3 addressDao3=new AddressDao3();
		System.out.println("-----------1.create-----------");
		int insertRowCount =
				addressDao3.create(1111,"yyyy","JACKIE","917-774-9652","NY");
		System.out.println("create:"+insertRowCount);
		
		
		
		System.out.println("-----------2.update-----------------");
	
		System.out.println("update:"+updateRowCount);
		
		
		
		System.out.println("------------3.delete---------------------");
		System.out.println("delete:"+addressDao3.delete(33));
		
		
		
		System.out.println("------------4.selectByNo----------------");
		Address findAddress=addressDao3.selectByNo(4);
		
		
		
		System.out.println("------------5.selectAll--------------------");
		ArrayList<Address> findAddressList=addressDao3.selectAll();
		
		
	}

}
