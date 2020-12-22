
package javafxapplication2;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



    public class ViewVoitures implements Initializable {
        
    @FXML
    private TableView<Voiture> table;

    @FXML
    private TableColumn<Voiture,Integer> Matricule;  
    @FXML
    private TableColumn<Voiture,String> Modele;
    @FXML
    private TableColumn<Voiture,String> Marque;  
    @FXML
    private TableColumn<Voiture,Float> Kilometrage; 
    @FXML
    private TableColumn<Voiture,String> Couleur;
    
   public	ObservableList<Voiture> data = FXCollections.observableArrayList();
  

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
		String query = "SELECT * FROM `voitures` WHERE 1";
		Connection con = connectVoitures.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
		
		ResultSet rs = preparedStatement.executeQuery();
               
		
		
		while (rs.next()) {
			data.add(new Voiture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5) ));
                       
                       
			}
 
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
                Matricule.setCellValueFactory(new PropertyValueFactory<Voiture,Integer>("Matricule"));                 
		Modele.setCellValueFactory(new PropertyValueFactory<Voiture,String>("Modele"));
		Marque.setCellValueFactory(new PropertyValueFactory<Voiture,String>("Marque"));
		Kilometrage.setCellValueFactory(new PropertyValueFactory<Voiture,Float>("Kilometrage"));
		Couleur.setCellValueFactory(new PropertyValueFactory<Voiture,String>("Couleur"));
                
		
				
 	table.setItems(data);


    }    
    
    
    
    
}
