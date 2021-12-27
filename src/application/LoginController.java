package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
    
    private static Stage featureStage;
    
    public static Stage getFeatureStage() {
		return featureStage;
	}

	public static void setFeatureStage(Stage featureStage) {
		LoginController.featureStage = featureStage;
	}

    @FXML
    protected void onLoginButtonClick() throws IOException {
        // Fake account
        AdminAccount adminAccount = new AdminAccount("admin", "admin");

        username = usernameText.getText();
        password = passwordText.getText();

        // Read account database
        if (username.equals(adminAccount.getUserName()) && password.equals(adminAccount.getPassword())) {
            labelText.setVisible(false);
            // Change scene
            Main.getMainStage().close();
			SampleController.getLoginStage().close();
			
            Pane root = FXMLLoader.load(getClass().getResource("Feature.fxml"));
            featureStage = new Stage(); 
            featureStage.setScene(new Scene(root));
            featureStage.show();
            
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