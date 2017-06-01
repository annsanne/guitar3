package dao;


public class dataAccess {

	private static String db="sql";
    public static GuitarDao createGuitarDao() {
		GuitarDao result=null;
		switch (db) {
		case "sql":
			result=new sqldao.GuitarDaoimpl();
			break;
		   case "mysql":
		result=new mysqldao.GuitarDaoimpl();
			break;
		}
		return result;
	}
}
