package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Order;

public class OrderController {
    @FXML
    private Label labelAmount;

    @FXML
    private Label labelFoodName;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelRelativeTotal;
    
    @FXML
    private void click(ActionEvent actionEvent) {
    	myListener.onClickListener(food);
    }
    
    private Food food;
    private MyListener myListener;
    
    public void setData(Order order, MyListener myListener) {
    	String amount = "x " + Integer.toString(order.getAmount());
    	String price = CardController.formatPrice(order.getPrice());
    	String total = CardController.formatPrice(order.getPrice() * order.getAmount());
    	
    	this.myListener = myListener;
    	
    	labelAmount.setText(amount);
    	labelFoodName.setText(order.getName());
    	labelPrice.setText(price);
    	labelRelativeTotal.setText(total);
	}
}

