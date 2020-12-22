
package javafxapplication2;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLDocument2Controller {
    public void ViewVoitures(ActionEvent e)throws IOException,SQLException
    {
        Stage primaryStage =new Stage();
           Parent root=FXMLLoader.load(getClass().getResource("ViewVoitures.fxml"));
           Scene scene=new Scene(root,850,600);
           primaryStage.setScene(scene);
           primaryStage.show();
    }    
    public void InsertVoitures(ActionEvent e)throws IOException,SQLException
    {
        Stage primaryStage =new Stage();
           Parent root=FXMLLoader.load(getClass().getResource("InsertVoiture.fxml"));
           Scene scene=new Scene(root,800,580);
           primaryStage.setScene(scene);
           primaryStage.show();
    }    
    public void UpdatVoiutre(ActionEvent e)throws IOException,SQLException
    {
        Stage primaryStage =new Stage();
           Parent root=FXMLLoader.load(getClass().getResource("Update.fxml"));
           Scene scene=new Scene(root,800,800);
           primaryStage.setScene(scene);
           primaryStage.show();
    }    
    public void DeleteVoiutre(ActionEvent e)throws IOException,SQLException
    {
        Stage primaryStage =new Stage();
           Parent root=FXMLLoader.load(getClass().getResource("Delete.fxml"));
           Scene scene=new Scene(root,830,510);
           primaryStage.setScene(scene);
           primaryStage.show();
    }   
    
}
