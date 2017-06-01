package mysqldao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.GuitarDao;
import dbutil.sqldb;
import dbutil.mysqldb;
import entity.Guitar;
import entity.GuitarSpec;
import entity.Inventory;

public class GuitarDaoimpl implements GuitarDao{
	sqldb dbUtil=new sqldb();
	@Override
	public List<Guitar> search(GuitarSpec spec) {
       
        Inventory inventory=new Inventory();
        ResultSet rs=sqldb.executeQuery("select * from guitar",new Object[]{});
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
		List<Guitar> list=new LinkedList();
        list=inventory.search(spec);
        return list;
    }

	@Override
	public List<Guitar> show() {
		// TODO Auto-generated method stub

	       List<Guitar> AllGuitarList=new ArrayList<Guitar>();
	       Guitar guitar=null;
	        ResultSet rs=sqldb.executeQuery("select * from guitar",new Object[]{});
	        try {
	            while(rs.next()){
	            	guitar =new Guitar(null, 0, null);
	                String serialNumber=rs.getString(1);
	                Double price=rs.getDouble(2);
	                GuitarSpec spec1=new GuitarSpec();	
	                spec1.setBuilder(rs.getString(3));
	                spec1.setModel(rs.getString(4));
	                spec1.setType( rs.getString(5));
	                spec1.setNumStrings(rs.getString(6));
	                spec1.setBackWood( rs.getString(7));
	                spec1.setTopWood( rs.getString(8));
	                guitar.setSerialNumber(serialNumber);
	                guitar.setPrice(price);
	                guitar.setSpec(spec1);
	                AllGuitarList.add(guitar);	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }	        
		return AllGuitarList;
	}
	public boolean add(Guitar guitar) {
		// TODO Auto-generated method stub
		return mysqldb.executeUpdate("insert into guitar values(?,?,?,?,?,?,?,?)", new Object[]{guitar.getSerialNumber(),guitar.getPrice(),guitar.getSpec().getBuilder(),guitar.getSpec().getModel(),guitar.getSpec().getType(),guitar.getSpec().getNumStrings(),guitar.getSpec().getBackWood(),guitar.getSpec().getTopWood()});		
	}
	public boolean delete(Guitar guitar) {
		// TODO Auto-generated method stub
		return mysqldb.executeUpdate("delete from guitar where serialNumber=?", new Object[]{guitar.getSerialNumber()});		
	}

}
