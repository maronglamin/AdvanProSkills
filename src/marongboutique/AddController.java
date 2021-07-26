package marongboutique;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddController implements Initializable {
    
    @FXML private TableView<Data> tableView;
    @FXML private TableColumn<Data, String> serviceColumn;
    @FXML private TableColumn<Data, String> categoryColumn;
    @FXML private TableColumn<Data, LocalDate> dateColumn;
    
    @FXML private TextField NameTextField;
    @FXML private TextField categoryTextField;
    @FXML private DatePicker dataAddedDatePicker;
    @FXML private Button detailedViewButton;

    @FXML void changeCategoryCellEvent(CellEditEvent edittedCell) {
        Data selectedValue =  tableView.getSelectionModel().getSelectedItem();
        selectedValue.setCategoryName(edittedCell.getNewValue().toString());
    }

    /**
     * load a scene through a controller class call its method.
     * @param event
     * @throws IOException 
     */
    @FXML void changeSceneToDetailedServiceView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("serviceDetailView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
        DetailsController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * edit a table cell when the user click the row on the table
     * @param edittedCell 
     */
    @FXML void changeServiceNameCellEvent(CellEditEvent edittedCell) {
        Data selectedValue =  tableView.getSelectionModel().getSelectedItem();
        selectedValue.setServiceName(edittedCell.getNewValue().toString());
    }

    /**
     * delete a select row of data
     * @param event 
     */
    @FXML void deleteButtonPushed(ActionEvent event) {
        ObservableList<Data> selectedRows, allInfo;
        allInfo = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (Data info: selectedRows)
        {
            allInfo.remove(info);
        }
    }

    /**
     * add a new record to the table view 
     * @param event 
     */
    @FXML void newServiceButtonPushed(ActionEvent event) {
        Data newData = new Data(NameTextField.getText(),
                                      categoryTextField.getText(),
                                      dataAddedDatePicker.getValue());
        
        //Get all the items from the table as a list, then add the new person to
        //the list
        tableView.getItems().add(newData);
    }

    /**
     * enable the detail views button
     * @param event 
     */
    @FXML void userClickedOnTable(MouseEvent event) {
        this.detailedViewButton.setDisable(false);
    }
    /**
     * redirect to the dashboard interface
     * @param event
     * @throws IOException 
     */
    @FXML public void backTodashboard(ActionEvent event) throws IOException {
        loadContent(event, "boutique");
    }
    /**
     * get the fxml file and load the content on a scene
     * @param event
     * @param page
     * @throws IOException 
     */ 
    private void loadContent(ActionEvent event, String page) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        Scene tableViewScene = new Scene(ViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
     }
    /**
     * create an array list to hold the data 
     * @return service 
     */
     public ObservableList<Data>  getService()
    {
        ObservableList<Data> service = FXCollections.observableArrayList();
        service.add(new Data("BMW","Car rental service",LocalDate.of(2021, Month.DECEMBER, 12)));
        service.add(new Data("RANGE ROVER","Car rental service",LocalDate.of(2021, Month.JULY, 30)));
        service.add(new Data("LAND ROVER","Car rental service",LocalDate.of(2021, Month.MAY, 8)));
        service.add(new Data("Two apartment","Housing service",LocalDate.of(2021, Month.MAY, 16)));
        service.add(new Data("single room","Housing service",LocalDate.of(2021, Month.MAY, 14)));
        service.add(new Data("Two bed rooms","Housing service",LocalDate.of(2021, Month.MAY, 15)));
        service.add(new Data("Cocoa col","Refreshment",LocalDate.of(2021, Month.MAY, 31)));
        service.add(new Data("Fanta","Refreshment",LocalDate.of(2021, Month.MAY, 2)));
        service.add(new Data("Vinto","Refreshment",LocalDate.of(2021, Month.MAY, 6)));

        
        return service;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        serviceColumn.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dataAdded"));
        
        //load dummy data
        tableView.setItems(getService());
        
        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        serviceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //Disable the detailed person view button until a row is selected
        this.detailedViewButton.setDisable(true);

    }
    
}
