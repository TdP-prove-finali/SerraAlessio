package it.polito.tdp.vgdatatool.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.vgdatatool.model.Genre;
import it.polito.tdp.vgdatatool.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BestMixController{
	
    private Model model = new Model();
    private Stage stage;
	
    public void setModel(Model model,Stage stage) {
		this.model=model;
		this.stage=stage;

		//Set process time invisible before the start of the algorithm
		processTime.setOpacity(0.0);
		
		//Initialize pieChart
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(new PieChart.Data("Empty", 100));	
		pieChart.setData(pieChartData);
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLenght;

    @FXML
    private TextField txtYear;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextField txtBudget;

    @FXML
    private PieChart pieChart;

    @FXML
    private Button handleBack;

    @FXML
    private Button handleAnalize;

    @FXML
    private Label processTime;

    @FXML
    void doAnalize(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	try {
    	
    	int lenght = Integer.parseInt(txtLenght.getText());
    	int budget = Integer.parseInt(txtBudget.getText());
    	
    	List<Genre> result = model.recursion(lenght, budget);
    	
    	if (result != null) {
    		txtResult.appendText("The best combination for "+budget+"$ is:\n");
    		
    		//Print result
    		for (int i=0 ; i<result.size()-1;i++) {
    			txtResult.appendText((i+1)+") "+result.get(i).toString()+"\n");
    		}
    	}
    	else txtResult.appendText("NO combination for this lenght and \nthis budget found!");
    	
    	}catch (NumberFormatException nbe) {
    		txtResult.appendText("Insert correct values!\n");
    	}
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
        assert txtLenght != null : "fx:id=\"txtLenght\" was not injected: check your FXML file 'BestMix.fxml'.";
        assert txtYear != null : "fx:id=\"txtYear\" was not injected: check your FXML file 'BestMix.fxml'.";
        assert txtBudget != null : "fx:id=\"txtBudget\" was not injected: check your FXML file 'BestMix.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'BestMix.fxml'.";
        assert pieChart != null : "fx:id=\"pieChart\" was not injected: check your FXML file 'BestMix.fxml'.";
        assert handleBack != null : "fx:id=\"handleBack\" was not injected: check your FXML file 'BestMix.fxml'.";
        assert handleAnalize != null : "fx:id=\"handleAnalize\" was not injected: check your FXML file 'BestMix.fxml'.";
        assert processTime != null : "fx:id=\"processTime\" was not injected: check your FXML file 'BestMix.fxml'.";

    }
}
