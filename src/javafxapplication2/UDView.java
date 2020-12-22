
package javafxapplication2;

import java.io.IOException;
import java.text.ParseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


public class UDView {
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
        
        public void getVoiture(ActionEvent e) throws IOException, ParseException{
		
		
		String mat=Matricule.getText();  
	    int m=Integer.parseInt(mat);   
		
	    Voiture V=connectVoitures.getVoitureMatricule(m); 
 
	    
	    Modele.setText(V.getModele());
	    Marque.setText(V.getMarque());
	    Kilometrage.setText(String.valueOf(V.getKilometrage()));
	    Couleur.setText( V.getCouleur());
	     
	  
		
	}
        public void updateVoiture(ActionEvent e) throws IOException, ParseException{
		
		
		String mat=Matricule.getText();  
	    int m=Integer.parseInt(mat);  
	    
	String TextModele          = 	Modele.getText();
	String TextMarque          = 	Marque.getText();
	
	String TextCouleur         = Couleur.getText();
        float fKilometrage = Float.parseFloat(Kilometrage.getText());
        
     
	    Voiture V=new Voiture();  
	    
                V.setMatricule(m);
		V.setModele(TextModele);
		V.setMarque(TextMarque);
		V.setKilometrage(fKilometrage);
		V.setCouleur(TextCouleur);
		
		
	
	
	
	    int status=connectVoitures.update(V);  
        if(status>0){  
        	
        	
  		  Alert alert = new Alert(AlertType.INFORMATION);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("Information Dialog");
  		  alert.setContentText("Record updated successfully!");

  		  alert.showAndWait();
        	
        	
        	// System.out.println(" Record saved successfully! ");
        }else{ 
        	
  		  Alert alert = new Alert(AlertType.ERROR);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("ERROR Dialog");
  		  alert.setContentText("Sorry! unable to update record");

  		  alert.showAndWait();
        	
        	
        	
        	
        //	System.out.println("Sorry! unable to update record");  
        }  
          
	
	
	
	
	
	
	}
    
}
