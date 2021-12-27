package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Stage mainStage;
	
	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage paramStage) {
		mainStage = paramStage;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			mainStage = primaryStage;
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root, 1200, 600);
			
			mainStage.setResizable(false);
			mainStage.setTitle("Restaurant Management System");
			mainStage.setScene(scene);
			mainStage.show(); 
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
