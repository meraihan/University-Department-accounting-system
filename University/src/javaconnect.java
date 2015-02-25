/**
 *
 * @author Sayed Mahmud Raihan
 */
import java.sql.*;

public class javaconnect {

    public static Connection rw() {
        String str = "";
        String jdbc_driver = "com.mysql.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost/university";
        
        String user = "root";
        String pass = "";
        
        Connection con = null;
        Statement stat = null;
        
        try{
            //register the driver .....
            Class.forName(jdbc_driver);
            //create connection ....
//            System.out.println("OK");
            con = DriverManager.getConnection(jdbc_url,user,pass);
            //create statement ....
//            System.out.println("OK");
            stat = con.createStatement();
            
            
            
           
            
            
            
            return con;
            
            
        }catch(Exception e){
            System.out.println("problem");
        }
        return con;
        
        
    }
//    public static void main(String[] Args){
////        readInformationFromDatabase rd = new readInformationFromDatabase();
//        String str = readInformationFromDatabase.readInformationFromDatabase();
//        System.out.println(str);
//    }

    static Connection rd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
