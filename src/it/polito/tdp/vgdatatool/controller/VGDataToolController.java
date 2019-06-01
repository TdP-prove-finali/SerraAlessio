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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VGDataToolController {
	
	private Model model = new Model();
	private Stage stage;
	
	
	public void setModel(Model model,Stage stage) {
		this.model=model;
		this.stage=stage; //in modo da rimanere sempre sullo stage iniziale
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button handleDataSales;

    @FXML
    private Button handleMixSales;

    @FXML
    void doDataSales(ActionEvent event) {
    	
    	//Go to DataAnalysisSalesController
    	try {
    		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DataAnalysisSales.fxml"));
		BorderPane root = (BorderPane)loader.load();
		
		DataAnalysisSalesController controller = loader.getController();
		
		//Set the model
		Model model = new Model();
		controller.setModel(model,this.stage);
		
		Scene scene = new Scene(root,534,339);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		//Set title 
		stage.setTitle(" Data Analysis Sales");
		
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void doMixSales(ActionEvent event) {
    	
       	//Go to BestMixController
    	try {
    		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("BestMix.fxml"));
		BorderPane root = (BorderPane)loader.load();
		
		BestMixController controller = loader.getController();
		
		//Set the model
		Model model = new Model();
		controller.setModel(model,this.stage);
		
		Scene scene = new Scene(root,559,347);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		//Set title 
		stage.setTitle(" Best Mix Tool");
		
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
        assert handleDataSales != null : "fx:id=\"handleDataSales\" was not injected: check your FXML file 'VGDataTool.fxml'.";
        assert handleMixSales != null : "fx:id=\"handleMixSales\" was not injected: check your FXML file 'VGDataTool.fxml'.";

    }
}
