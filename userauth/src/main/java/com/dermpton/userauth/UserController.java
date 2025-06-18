package com.dermpton.userauth;


import com.dermpton.userauth.data.AppQuery;
import com.dermpton.userauth.model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    private TextField fieldUserName;
    
    @FXML
    private PasswordField fieldPass;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private User user;
    
    private static Stage stage;
    
    
    @FXML
    private void login(){
        try {
            Dialog<User> dialog = new Dialog<>();
            dialog.setTitle("Login Confirmation");
            dialog.setHeaderText("Login Attempt");
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(getStage());
            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(okButton);
            AppQuery query = new AppQuery();

            Boolean ans = query.validateUser(new User(fieldUserName.getText(), fieldPass.getText()));

            if (ans) {
                Label goodlabel = new Label("Login Successful" + ", Welcome: " + fieldUserName.getText());
                dialog.getDialogPane().setContent(goodlabel);
                dialog.showAndWait();
                reset();
                
            } else {
                Label label = new Label("Wrong Username or Password, Try Again");
                dialog.getDialogPane().setContent(label);
                dialog.showAndWait();
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void reset(){
        fieldPass.clear();
        fieldUserName.clear();
    }
    

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage aStage) {
        stage = aStage;
    }

}
