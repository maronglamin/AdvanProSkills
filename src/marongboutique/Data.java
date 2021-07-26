package marongboutique;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Data {
    private SimpleStringProperty serviceName, categoryName;
    private LocalDate dataAdded;

    public Data(String serviceName, String categoryName, LocalDate dataAdded) {
        this.serviceName = new SimpleStringProperty(serviceName);
        this.categoryName = new SimpleStringProperty(categoryName);
        this.dataAdded = dataAdded;
    }
     
    public String getServiceName() {
        return serviceName.get();
    }

    public void setServiceName(String ServiceName) {
        this.serviceName = new SimpleStringProperty(ServiceName);
    }

    public String getCategoryName() {
        return categoryName.get();
    }

    public void setCategoryName(String catName) {
        this.categoryName = new SimpleStringProperty(catName);
    }

    public LocalDate getDateAdded() {
        return dataAdded;
    }
    
    public int getAge()
    {
        return Period.between(dataAdded, LocalDate.now()).getYears();
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dataAdded = dateAdded;
    }
    
    public String toString()
    {
        return String.format("%s %s", serviceName, categoryName);
    }
    
      // get the fxml file and load the content on a scene 
    public void loadContent(ActionEvent event, String page) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        Scene tableViewScene = new Scene(ViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
     }
}
