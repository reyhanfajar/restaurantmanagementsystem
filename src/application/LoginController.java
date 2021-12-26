package com.example.restaurantmanagementsystem;

import com.example.restaurantmanagementsystem.Model.AdminAccount;
import com.example.restaurantmanagementsystem.Model.GuestAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.json.*;

public class LoginController {
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button loginButton;
    @FXML
    private Label labelText;

    //Input User
    String username;
    String password;

    @FXML
    protected void onLoginButtonClick() {

        //Fake account
        GuestAccount guestAccount = new GuestAccount("imamazka", "1234");
        AdminAccount adminAccount = new AdminAccount("imamazka", "1234");

        username = usernameText.getText();
        password = passwordText.getText();

        //Read account database
        if (username.equals(guestAccount.getUserName()) && password.equals(guestAccount.getPassword())) {
            labelText.setVisible(false);
            //Change scene
        }
        //Jika input kosong
        else if (username.isEmpty() || password.isEmpty()) {
            labelText.setVisible(true);
            labelText.setText("Please Enter All Required Information!");
        }
        //Jika input tidak sesuai
        else {
            labelText.setVisible(true);
            labelText.setText("Entered Information Wrong, Try Again!");
        }
    }
}