package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.AdminAccount;

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
        // Fake account
        AdminAccount adminAccount = new AdminAccount("admin", "admin");

        username = usernameText.getText();
        password = passwordText.getText();

        // Read account database
        if (username.equals(adminAccount.getUserName()) && password.equals(adminAccount.getPassword())) {
            labelText.setVisible(false);
            // Change scene
            //
            //
            
            
        }
        // Jika input kosong
        else if (username.isEmpty() || password.isEmpty()) {
            labelText.setVisible(true);
            labelText.setText("Please Enter All Required Information!");
        }
        // Jika input tidak sesuai
        else {
            labelText.setVisible(true);
            labelText.setText("Entered Information is Wrong, Try Again!");
        }
    }
}