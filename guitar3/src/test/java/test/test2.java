package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import dbutil.sqldb;
import entity.Guitar;
import entity.GuitarSpec;
import entity.Inventory;


public class test2 {
	@Test
	public void test() {
	       sqldb dbUtil=new sqldb();
	        Inventory inventory=new Inventory();
	        ResultSet rs=dbUtil.executeQuery("select * from guitar",new Object[]{});
	        try {
	            while(rs.next()){
	                String serialNumber=rs.getString(1);
	                Double price=rs.getDouble(2);
	                GuitarSpec spec1=new GuitarSpec();	
	                spec1.setBuilder(rs.getString(3));
	                spec1.setModel(rs.getString(4));
	                spec1.setType( rs.getString(5));
	                spec1.setNumStrings(rs.getString(6));
	                spec1.setBackWood( rs.getString(7));
	                spec1.setTopWood( rs.getString(8));
	                inventory.addGuitar(serialNumber, price, spec1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        @SuppressWarnings({ "rawtypes", "unchecked" })
	        GuitarSpec spec=new GuitarSpec("","","fender","","","3");
			List<Guitar> list=new LinkedList();
	        list=inventory.search(spec);
	        if (!list.isEmpty()) {
	            System.out.println("�ֿ��е�������:");
	            for (Iterator i = list.iterator(); i.hasNext(); ) {
	              Guitar guitar = (Guitar)i.next();
	              GuitarSpec aspec = guitar.getSpec();
	              System.out.println(
	                aspec.getBuilder()
	                +aspec.getModel() 
	                +aspec.getType() + "����"
	                +aspec.getBackWood() 
	                +aspec.getTopWood() 
	                +guitar.getPrice() );
	            }
	          } else {
	            System.out.println("�ֿ���û��������");
	          }		
	}

}
