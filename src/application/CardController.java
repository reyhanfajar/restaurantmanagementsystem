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
		foodPrice.setText(formatPrice(food.getFoodPrice()));
	}
	
	// Example: 150000 -> Rp150.000
	public String formatPrice(double price) {
        String tempPrice = Integer.toString((int) price);

        String formattedPrice = "";
        int counter = 0;
        for (int i = tempPrice.length()-1; i >= 0; i--) {
            if ((counter != 0) && (counter % 3 == 0)) {
                formattedPrice += ".";
            }
            formattedPrice += tempPrice.charAt(i);
            counter += 1;
        }
        String reversed = "";
        for (int i = formattedPrice.length()-1; i >= 0; i--)
            reversed += formattedPrice.charAt(i);

        return "Rp" + reversed;
    }
}
