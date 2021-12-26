package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Food;

public class SampleController implements Initializable {
	@FXML
    private Button btnAdmin;

    @FXML
    private GridPane foodContainer;
	 
	private List<Food> foodsList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		foodsList = new ArrayList<>(foodList());
		
		int column = 0;
		int row = 1;
		
		try { 
			// load all items in the list to GridPane
			for (Food food : foodsList) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("Card.fxml"));
				VBox foodBox = fxmlLoader.load();
				CardController cardController = fxmlLoader.getController();
				cardController.setData(food);
				
				if (column == 4) {
					column = 0;
					++row;
				} 
				
				System.out.println("(" + column + ", " + row + ")");
				foodContainer.add(foodBox, column++, row);
				// top, right, bottom, left
				if (row <= 2)
					GridPane.setMargin(foodBox, new Insets(230, 5, 20, 20)); 
				else 
					GridPane.setMargin(foodBox, new Insets(15, 5, 20, 20));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private double yOffset = 0;
    private double xOffset = 0;
    
    /*
     * Show login window
     */
	@FXML
	void btnAdminPressed(ActionEvent event) {
		try {
			Pane rootLogin = FXMLLoader.load(getClass().getResource("login-view.fxml"));
	        Stage stage = new Stage(); 
	        stage.initModality(Modality.APPLICATION_MODAL);
	       
	        
	        rootLogin.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) { 
	                xOffset = mouseEvent.getSceneX();
	                yOffset = mouseEvent.getSceneY();
	            }
	        });
	       
	        rootLogin.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	                stage.setX(mouseEvent.getSceneX() - xOffset);
	                stage.setY(mouseEvent.getSceneY() - yOffset);
	            }
	        });
		    //stage.initStyle(StageStyle.DECORATED.UNDECORATED);
	       
	    	stage.setTitle("Login");
	        stage.setScene(new Scene(rootLogin));
	        stage.show(); 
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	private List<Food> foodList() {
		/*
		List<Food> tempList = new ArrayList<>();
		tempList.add(new Food(0, "/img/mashed_potatoes.png", "Mashed Potatoes", 30000));
		tempList.add(new Food(1, "/img/cheese_burger.png", "Cheese Burger", 25000));
		tempList.add(new Food(2, "/img/french_fries.png", "French Fries", 15000));
		tempList.add(new Food(3, "/img/pepperoni_pizza.png", "Pepperoni Pizza", 115000));
		tempList.add(new Food(3, "/img/ice_cream.png", "Ice Cream", 10000));
		writeJsonData("food.json", tempList);
		*/
		
		List<Food> foodsList = new ArrayList<>();
		Food[] food = readJsonData("food.json");
		for (int i = 0; i < food.length; i++) {
			foodsList.add(food[i]);
		}
		
		return foodsList;
	}
	
	public Food[] readJsonData(String filepath)  {
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(filepath));
			Food[] data = gson.fromJson(reader, Food[].class); 
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* doest't work
	public void appendJsonData(String filepath, List<Food> adddedList) {
		Gson gson = new Gson();
		List<Food> foods = gson.fromJson("JSON STRING", new TypeToken<List<Food>>() {}.getType());
		
		for (int i = 0; i < foods.size(); i++) {
			foods.add(adddedList.get(i));
		}

		try (Writer writer = new FileWriter(filepath, true)) {
		    Gson gsonBuilder = new GsonBuilder().create();
		    gsonBuilder.toJson(foods, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	
	public void writeJsonData(String filepath, List<Food> foodsList) {
		try (Writer writer = new FileWriter(filepath)) {
		    Gson gsonBuilder = new GsonBuilder().create();
		    gsonBuilder.toJson(foodsList, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//untuk mengelist food yang telah di add pembeli
	private ObservableList<application.Food> orderedFood = FXCollections.observableArrayList();

	//ambil data orderedfood
	public ObservableList<application.Food> getOrderedFood() {
		return orderedFood;
	}

	@FXML
	private Button checkOutButtonClick;

	@FXML
	//ke method pembayaran bila Check Out di klik
	public void checkOutButtonClick(){
		//membuat tombol Check Out tidak bisa di klik bila order tidak ada isinya
		//tapi karena masih error, jadi ku bikin invisible
		//harusnya pake button.setDisable(true), cuma bingung gatau gimana pakenya
		checkOutButtonClick.setVisible(false);
		if(orderedFood != null){
			checkOutButtonClick.setVisible(true); //kalau ada isinya jadi kelihatan tombolnya
		}
	}
}
