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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class BuyController implements Initializable {

    @FXML private CheckBox bmwCarCheckBox;
    @FXML private CheckBox rangeRoverCheckBox;
    @FXML private CheckBox landRoverCheckBox;
    @FXML private Label OrderLabel;
    
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;
    
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;
    
    @FXML private RadioButton individualRadioButton;
    @FXML private RadioButton familyRadioButton;
    @FXML private RadioButton teamRadioButton;
    @FXML private RadioButton tripRadioButton;
    @FXML private Label radioButtonLabel;
    private ToggleGroup ToggleGroup;


    @FXML void OrderButtonPushed(ActionEvent event) {
        String order = "Toppings are:";
        
        if (bmwCarCheckBox.isSelected())
            order += "\nBMW is in your cart, \nthe rental price is D700\n";

        if (rangeRoverCheckBox.isSelected())
            order += "\nRang Rover is in your cart, \nthe rental price is D800\n";
        
        if (landRoverCheckBox.isSelected())
            order += "\nLand Rover is in your cart, \nthe rental price is D1,000\n";

        this.OrderLabel.setText(order);
    }

    @FXML void changeScreenButtonPushed(ActionEvent event) throws IOException {
        loadContent(event, "detailsView");
    }

    @FXML void comboBoxWasUpdated(ActionEvent event) {
        this.comboBoxLabel.setText("Drink selected: \n" + comboBox.getValue().toString() + "\nSales amount: \nD15.50");

    }

    @FXML void houseButtonPushed(ActionEvent event) {
        choiceBoxLabel.setText("Your selected house for rental is:\n"+choiceBox.getValue().toString()+ "\nRental price:\n D20 per hours");

    }

    @FXML void radioButtonChanged(ActionEvent event) {
        if (this.ToggleGroup.getSelectedToggle().equals(this.individualRadioButton))
            radioButtonLabel.setText("The selected user type is:\n Individual user");
        
        if (this.ToggleGroup.getSelectedToggle().equals(this.familyRadioButton))
            radioButtonLabel.setText("The selected user type is:\n family users");
        
        if (this.ToggleGroup.getSelectedToggle().equals(this.teamRadioButton))
            radioButtonLabel.setText("The selected user type is:\n Team users");
        
        if (this.ToggleGroup.getSelectedToggle().equals(this.tripRadioButton))
            radioButtonLabel.setText("The selected user type is:\n trip on survey users");
        
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
    
    @FXML public void backTodashboard(ActionEvent event) throws IOException {
    loadContent(event, "boutique");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrderLabel.setText("");
        
        //This items are for configuring the ChoiceBox example
        choiceBoxLabel.setText("");
        choiceBox.getItems().addAll("Two apartments","single room","Two bed rooms");
        choiceBox.setValue("click to select");
        
        //this items are for configuring the ComboBox
        comboBox.getItems().addAll("Cocoa cola","Fanta","Vinto");
        comboBox.setVisibleRowCount(3);
        comboBox.setEditable(true);
        comboBox.setPromptText("Choose a drink");
        comboBoxLabel.setText("");
        
        //These items are for configuring the RadioButtons
        radioButtonLabel.setText("");
        ToggleGroup = new ToggleGroup();
        this.individualRadioButton.setToggleGroup(ToggleGroup);
        this.familyRadioButton.setToggleGroup(ToggleGroup);
        this.teamRadioButton.setToggleGroup(ToggleGroup);
        this.tripRadioButton.setToggleGroup(ToggleGroup);
    }
    
}
