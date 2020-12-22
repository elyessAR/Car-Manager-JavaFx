
package javafxapplication2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
 

public class connectVoitures {
	
	

	
	
	
	static Connection con=null;

	public static Connection getConnection(){

        

        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost/newdb","root","");
            }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
	
	
	
	
	
	
	public static int save(Voiture V){
		
		int st = 0;
		
		try {
			String query = "INSERT INTO `voitures`( `Matricule`, `Modele`, `Marque`, `Kilometrage`, `Couleur`)VALUES (?,?,?,?,?)";
			Connection con = connectVoitures.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
                        preparedStatement.setInt(1, V.getMatricule());
			preparedStatement.setString(2, V.getModele());
			preparedStatement.setString(3, V.getMarque());
			preparedStatement.setFloat(4, V.getKilometrage());
			preparedStatement.setString(5, V.getCouleur());
			
			
			st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
		
	}
	
	
	
public static int update(Voiture V){
		
		int st = 0;
		
		try {
			String query = "UPDATE `voitures` SET `Matricule`=?,`Modele`=?,`Marque`=?,`Kilometrage`=?,`Couleur`=? WHERE Matricule= ?";
			Connection con = connectVoitures.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
                        preparedStatement.setInt(1, V.getMatricule());
			preparedStatement.setString(2, V.getModele());
			preparedStatement.setString(3, V.getMarque());
			preparedStatement.setFloat(4, V.getKilometrage());
			preparedStatement.setString(5, V.getCouleur());
						
			st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
		
	}
	
	
public static int delete(int Matricule){
	
	int st = 0;
	
	try {
		String query = "DELETE FROM `voitures` WHERE Matricule=?";
		Connection con = connectVoitures.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
		 
		preparedStatement.setInt(1, Matricule);
		
		st = preparedStatement.executeUpdate();
		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return st;
	
}
	
	
	
public static Voiture  getVoitureMatricule(int mat){
	
	Voiture V = new Voiture();
	
	try {
		String query = "SELECT * FROM `voitures` WHERE Matricule=?";
		Connection con = connectVoitures.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
		
		preparedStatement.setInt(1, mat);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
  			
			V.setMatricule(resultSet.getInt(1));
			V.setModele(resultSet.getString(2));
			V.setMarque(resultSet.getString(3));
			V.setKilometrage(resultSet.getFloat(4));
			V.setCouleur(resultSet.getString(5));
						
  
			
			
			
		}

		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return V;
	
}



public static List<Voiture>  getVoiture(){
	
	List<Voiture> list = new ArrayList<Voiture>();
 
	
	try {
		String query = "SELECT * FROM `voitures` WHERE 1";
		Connection con = connectVoitures.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		
		while (resultSet.next()) {
			Voiture V = new Voiture();
			
			V.setMatricule(resultSet.getInt(1));
			V.setModele(resultSet.getString(2));
			V.setMarque(resultSet.getString(3));
			V.setKilometrage(resultSet.getFloat(4));
			V.setCouleur(resultSet.getString(5));
						
		}

		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
}	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
}
