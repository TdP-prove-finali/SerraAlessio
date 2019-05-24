package it.polito.tdp.vgdatatool.controller;
	
import it.polito.tdp.vgdatatool.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("VGDataTool.fxml"));
			BorderPane root = (BorderPane)loader.load();
			VGDataToolController controller = loader.getController();
			
			//Set the model
			Model model = new Model();
			controller.setModel(model,primaryStage);
			
			Scene scene = new Scene(root,330,177);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//Set title 
			primaryStage.setTitle(" VGDataTool");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
