package it.polito.tdp.vgdatatool.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.vgdatatool.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VGDataToolController {
	
	private Model model = new Model();
	
	public void setModel(Model model) {
		this.model=model;
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

    }

    @FXML
    void doMixSales(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert handleDataSales != null : "fx:id=\"handleDataSales\" was not injected: check your FXML file 'VGDataTool.fxml'.";
        assert handleMixSales != null : "fx:id=\"handleMixSales\" was not injected: check your FXML file 'VGDataTool.fxml'.";

    }
}
