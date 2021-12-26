package application;

import model.Food;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.*;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class FeatureController {
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField foodName;
	@FXML
	private TextField price;
	@FXML
	private TextField id;

	@FXML
	private ImageView dpImage;
	
	private static String imageSource;
	//apply new food
	public void apply(ActionEvent e) {
		
			addJson();
		}

	//attach image file
	public void attach(ActionEvent e) {
		FileChooser fc = new FileChooser();
		
		File selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile != null) {
			
		
				imageSource = "/img/"+selectedFile.getName();
				
			try {
				InputStream stream = new FileInputStream(selectedFile.getAbsolutePath());
				Image image = new Image(stream);
				System.out.println(selectedFile.getName());
				dpImage.setImage(image);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else {
			System.out.println("file is not valid!");
		}
	}
	//delete food
	public void delete(ActionEvent e) {
		deleteJson();
	}
	//logout admin window
	public void logout(ActionEvent e) throws IOException {
		
		//change scene
		root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		 /*
		  root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  */
	}
	
	public String getFoodName() { return foodName.getText().toString(); }

	public Double getPrice() { 
		String foodPrice =  price.getText().toString();
		return Double.parseDouble(foodPrice); }
	
	public int getId() { 
	 String foodId = id.getText().toString();
	 return Integer.parseInt(foodId); }
		
	public void writeJson(String filepath, List<Food> foodsList)
	{
		try(Writer writer = new FileWriter(filepath)){
			Gson gsonBuilder = new GsonBuilder().create();
			gsonBuilder.toJson(foodsList, writer);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public Food[] readJson(String filepath) {
		
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(filepath));
			Food[] data = gson.fromJson(reader, Food[].class);
			return data;
	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	//delete particular object from json file
	public void deleteJson() {
		
		Food[] list = readJson("food.json");
		List<Food> objList = new ArrayList<>();
		for(Food l : list)
		{
			objList.add(l);
		}
		for(int i=0 ; i < list.length; i++) {
			
			if(list[i].getId() == getId()) {
				objList.remove(i);
			}
		}
		 //add all objects to json file
		 writeJson("food.json", objList);
	
	}
	//add new object to json file
	public void addJson() {
		
		Food[] list = readJson("food.json");
		List<Food> objList = new ArrayList<>();
		for(Food l : list)
		{
			objList.add(l);
		}
		objList.add(new Food(getId(), imageSource, getFoodName(), getPrice()));
		 writeJson("food.json", objList);
		
	}
}

