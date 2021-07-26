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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetailsController implements Initializable{
    
    @FXML private Label serviceLabel;
    @FXML private Label categoryLabel;
    @FXML private Label dateLabel;
    private Data selectedService;

    
    public void initData(Data data)
    {
        selectedService = data;
        serviceLabel.setText(selectedService.getServiceName());
        categoryLabel.setText(selectedService.getCategoryName());
        dateLabel.setText(selectedService.getDateAdded().toString());
    }
     public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        loadContent(event, "addPanel");
    }
     
    private void loadContent(ActionEvent event, String page) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        Scene tableViewScene = new Scene(ViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
