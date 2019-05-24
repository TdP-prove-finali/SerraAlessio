package it.polito.tdp.vgdatatool.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.vgdatatool.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DataAnalysisSalesController {
	
    private Model model = new Model();
    private Stage stage;
	
    public void setModel(Model model,Stage stage) {
		this.model=model;
		this.stage=stage;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> boxGenre;

    @FXML
    private TextField txtYear;

    @FXML
    private Slider sliderValue;

    @FXML
    private ComboBox<?> boxAreas;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button handleBack;

    @FXML
    private Button handleAnalize;

    @FXML
    void doAnalize(ActionEvent event) {

    }

    @FXML
    void doBack(ActionEvent event) {
    	
    	//Go to DataAnalysisSalesController
    	try {
    		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("VGDataTool.fxml"));
		BorderPane root = (BorderPane)loader.load();
		
		VGDataToolController controller = loader.getController();
		
		//Set the model
		Model model = new Model();
		controller.setModel(model,this.stage);
		
		Scene scene = new Scene(root,330,177);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		//Set title 
		stage.setTitle(" VGDataTool");
		
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
        assert boxGenre != null : "fx:id=\"boxGenre\" was not injected: check your FXML file 'DataAnalysisSales.fxml'.";
        assert txtYear != null : "fx:id=\"txtYear\" was not injected: check your FXML file 'DataAnalysisSales.fxml'.";
        assert sliderValue != null : "fx:id=\"sliderValue\" was not injected: check your FXML file 'DataAnalysisSales.fxml'.";
        assert boxAreas != null : "fx:id=\"boxAreas\" was not injected: check your FXML file 'DataAnalysisSales.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DataAnalysisSales.fxml'.";
        assert handleBack != null : "fx:id=\"handleBack\" was not injected: check your FXML file 'DataAnalysisSales.fxml'.";
        assert handleAnalize != null : "fx:id=\"handleAnalize\" was not injected: check your FXML file 'DataAnalysisSales.fxml'.";

    }
}
