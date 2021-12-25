package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Food;

public class CardController {
	@FXML
	private ImageView foodImage;
	
	@FXML
	private Label foodName;
	
	@FXML
	private Label foodPrice;
	
	public void setData(Food food) {
		Image image = new Image(this.getClass().getResourceAsStream(food.getImgSource()));
		foodImage.setImage(image);
		
		foodName.setText(food.getFoodName());
		foodPrice.setText(food.getFoodPrice());
	}
}
