package model;

//import dbjson.Serializable;

//public class Food extends Serializable {
public class Food {
	private int id;
	private String imgSource;
	private String foodName;
	private double foodPrice;
	
	public Food(int id, String imgSource, String foodName, double foodPrice) {
		super();
		this.id = id;
		this.imgSource = imgSource;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImgSource() {
		return imgSource;
	}
	
	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	
	public String getFoodName() {
		return foodName;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public double getFoodPrice() {
		return foodPrice;
	}
	
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
}
	
