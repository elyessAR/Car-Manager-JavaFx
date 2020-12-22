
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InsertVoitures {
       @FXML
       private TextField Matricule;
        
        @FXML
	private TextField Modele;
	@FXML
	private TextField Marque;
	@FXML
	private TextField Kilometrage;
	@FXML
	private TextField Couleur;
        public void insertData(ActionEvent e) throws IOException{
        String TextMatricule            = 	Matricule.getText();    
        String TextModele           = 	Modele.getText();
	String TextMarque          = 	Marque.getText();
	String TextKilometrage     = Kilometrage.getText();
	String TextCouleur         = Couleur.getText();
        int iMatricule=Integer.parseInt(TextMatricule);
        float fKilometrage = Float.parseFloat(TextKilometrage);
        Voiture V=new Voiture();
        V.setMatricule(iMatricule);
        V.setModele(TextModele);
	V.setMarque(TextMarque);
	V.setKilometrage(fKilometrage);
	V.setCouleur(TextCouleur);
        
        int status=connectVoitures.save(V);
        if(status>0){
            Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("Information Dialog");
		  alert.setContentText("Record saved successfully!");

		  alert.showAndWait();
		   

        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("ERROR Dialog");
		  alert.setContentText("Sorry! unable to save record");

		  alert.showAndWait();
    	  
    	  
    	  
    	    
      }  

        
        }
        
        }
        

	
    
