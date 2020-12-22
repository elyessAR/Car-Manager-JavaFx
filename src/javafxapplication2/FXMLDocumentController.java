
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



    public class FXMLDocumentController implements Initializable {
    @FXML
    Label DBconlb;
    @FXML
    TextField username;   
    @FXML
    TextField password;
    @FXML
    Label check;
    public void statusDB(ActionEvent e)throws IOException,SQLException
    {
        if(!connectAdmins.getConnection().isClosed()){
        DBconlb.setText("Connected");
        }
        else{
         DBconlb.setText("Not Connected");
        }
    }    
    public void enterCP(ActionEvent e)throws IOException,SQLException
    {
      List<Admins> list =connectAdmins.getAdmins();
      Map<String,String> map=new HashMap<String,String>();    
      for(Admins a:list){
          map.put(a.getUsername(),a.getPassword());
          
          
      }
      
      if (map.containsKey( username.getText()))
      {
      String val2=map.get(username.getText());
       if(val2.equals(password.getText()))
       {
           check.setText("Success!");
           connectAdmins.getConnection();
           Stage primaryStage =new Stage();
           Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
           Scene scene=new Scene(root,960,580);
           primaryStage.setScene(scene);
           primaryStage.show();
       }
       else{
       check.setText("wrong username or password!");}
      }
       else
       {
       check.setText("wrong username or password!");
       }
      }
     
    
    @FXML
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
