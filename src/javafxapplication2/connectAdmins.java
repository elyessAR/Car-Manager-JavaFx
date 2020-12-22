package javafxapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class connectAdmins {
    static Connection con=null;
    
    public static Connection getConnection(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost/newdb","root","");
            //System.out.println("connected");
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    
    
    public static List<Admins> getAdmins(){
    List<Admins> list=new ArrayList<Admins>();
    try{
        String query="SELECT*FROM `admins` WHERE 1";
        Connection con=connectAdmins.getConnection();
        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);     
        ResultSet rs=preparedStatement.executeQuery(query);
        while (rs.next()){
            
            Admins A=new Admins();
            
            A.setID(rs.getInt(1));
            A.setUsername(rs.getString(2));
            A.setPassword(rs.getString(3));
            
            list.add(A);
            
        }
        con.close();
        }catch(SQLException e){
                e.printStackTrace();
                
                }
     
   return list;
    }
        
        
    
    
    
    
}
