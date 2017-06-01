package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import dbutil.mysqldb;
import dbutil.sqldb;
import entity.Guitar;
import entity.GuitarSpec;



public class test1 {
	@Test
	public void test() {
		mysqldb dbUtil=new mysqldb();
	       Guitar guitar1=null;
	        ResultSet rs=sqldb.executeQuery("select * from guitar",new Object[]{});
	        try {
	            while(rs.next()){
	            	guitar1 =new Guitar(null, 0, null);
	                String serialNumber=rs.getString(1);
	                Double price=rs.getDouble(2);
	                GuitarSpec spec1=new GuitarSpec();	
	                spec1.setBuilder(rs.getString(3));
	                spec1.setModel(rs.getString(4));
	                spec1.setType( rs.getString(5));
	                spec1.setNumStrings(rs.getString(6));
	                spec1.setBackWood( rs.getString(7));
	                spec1.setTopWood( rs.getString(8));
	                guitar1.setSerialNumber(serialNumber);
	                guitar1.setPrice(price);
	                guitar1.setSpec(spec1);
	                System.out.println(guitar1.getSerialNumber()+ " " +guitar1.getPrice()+guitar1.getSpec().getBuilder()+ " " +guitar1.getSpec().getModel()+ " " +guitar1.getSpec().getType()+ " " +guitar1.getSpec().getNumStrings()+ " " +guitar1.getSpec().getBackWood()+ " " +guitar1.getSpec().getTopWood()+"\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();	        	
	        }
	}
}
	
	
	
