package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Food;

public class SampleController implements Initializable {
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
				//System.out.println(food.getImgSource());
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("Card.fxml"));
				VBox foodBox = fxmlLoader.load();
				CardController cardController = fxmlLoader.getController();
				cardController.setData(food);
				
				if (column == 6) {
					column = 0;
					++row;
				}
				
				foodContainer.add(foodBox, column++, row);
				GridPane.setMargin(foodBox, new Insets(250, 20, 20, 20));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Food> foodList() {
		List<Food> foodsList = new ArrayList<>();
		
		Food food = new Food();
		food.setFoodName("Frech Fries");
		food.setFoodPrice("Rp 15000");
		food.setImgSource("/img/french_fries.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Pepperoni Pizza");
		food.setFoodPrice("Rp 99000");
		food.setImgSource("/img/pepperoni_pizza.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Cheese Burger");
		food.setFoodPrice("Rp 20000");
		food.setImgSource("/img/cheese_burger.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Ice Cream");
		food.setFoodPrice("Rp 10000");
		food.setImgSource("/img/ice_cream.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Mashed Potatoes");
		food.setFoodPrice("Rp 18500");
		food.setImgSource("/img/mashed_potatoes.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Pepperoni Pizza");
		food.setFoodPrice("Rp 99000");
		food.setImgSource("/img/pepperoni_pizza.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Cheese Burger");
		food.setFoodPrice("Rp 20000");
		food.setImgSource("/img/cheese_burger.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Ice Cream");
		food.setFoodPrice("Rp 10000");
		food.setImgSource("/img/ice_cream.png");
		foodsList.add(food);
		
		food = new Food();
		food.setFoodName("Mashed Potatoes");
		food.setFoodPrice("Rp 18500");
		food.setImgSource("/img/mashed_potatoes.png");
		foodsList.add(food);
		
		
		return foodsList;
	}
}
