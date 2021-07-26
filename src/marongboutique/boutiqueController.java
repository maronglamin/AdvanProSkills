package marongboutique;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class boutiqueController implements Initializable {
    
    @FXML public void dashboardPanel(ActionEvent event) throws IOException {
        loadContent(event, "boutique");
    }
    
    @FXML public void backTodashboard(ActionEvent event) throws IOException {
        loadContent(event, "boutique");
    }
    
     @FXML public void addPanel(ActionEvent event) throws IOException {
        loadContent(event, "addPanel");
    }

    @FXML void buyPanel(ActionEvent event) throws IOException {
        loadContent(event, "buyPanel");
    }
    

    @FXML void receiptPanel(ActionEvent event) throws IOException {
        loadContent(event, "receiptPanel");
    }

    @FXML void salesPanel(ActionEvent event) throws IOException {
        loadContent(event, "salesPanel");
    }
    
    @FXML void textOrDb(ActionEvent event) throws IOException {
        loadContent(event, "receiptPanel");

    }
    
    // get the fxml file and load the content on a scene 
    private void loadContent(ActionEvent event, String page) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        Scene tableViewScene = new Scene(ViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
     } 
    
    @FXML void openTextForDBSystem(ActionEvent event) throws IOException {
                loadContent(event, "DBviews");
    }

    @FXML void openTextForFileMethod(ActionEvent event) throws IOException {
        loadContent(event, "textFileview");

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    
   
    
}
