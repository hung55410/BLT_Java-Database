package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.login2.DatabaseConnection;
import sample.login2.Main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class LoginController {
    @FXML
    private Button buttonLogin, buttonRegister;
    @FXML
    private Label message_Password, message_UserName, message_User_Password;
    @FXML
    private TextField textField_UserName;
    @FXML
    private PasswordField passField_Password;


    public void buttonLoginOnAction(ActionEvent e) {
        checkLogin();
    }

    public void buttonRegisterOnAccount(ActionEvent e) {
        try {
            Stage stage1 = (Stage) buttonRegister.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Quản lý phòng trọ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e1) {
                e1.printStackTrace();
        }
    }

//  kiểm tra thông tin đăng nhập
    public void checkLogin() {
//      kiểm tra tên đăng nhập và mật khẩu có đúng với csdl không
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "SELECT count(1) FROM login.useraccount WHERE Username = '" + textField_UserName.getText() + "' AND Password = '" + passField_Password.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(verifyLogin);
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    Stage stage1 = (Stage) buttonLogin.getScene().getWindow();
                    stage1.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("homePage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Quản lý phòng trọ");
                    stage.setScene(scene);
                    stage.show();
                } else {
                    if(textField_UserName.getText().isBlank() == true) {
                        username_Null();
                    } else if(textField_UserName.getText().isBlank() == false) {
                        username_true();
                    }
                    if(passField_Password.getText().isBlank() == true) {
                        password_Null();
                    } else if (passField_Password.getText().isBlank() == false) {
                        password_true();
                    }
                    if (textField_UserName.getText().isBlank() == false && passField_Password.getText().isBlank() == false && resultSet.getInt(1) == 0) {
                        user_password();
                    }
                }
            }
        } catch (Exception e) {

        }
    }

//    Start common
    public void username_Null() {
        message_UserName.setText("Tên tài khoản không được trống");
        message_User_Password.setText("");
        textField_UserName.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void username_true() {
        message_UserName.setText("");
        message_User_Password.setText("");
        textField_UserName.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void password_Null() {
        message_Password.setText("Mật khẩu không được trống");
        message_User_Password.setText("");
        passField_Password.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void password_true() {
        message_Password.setText("");
        message_User_Password.setText("");
        passField_Password.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void user_password() {
        message_User_Password.setText("Tên tài khoản hoặc mật khẩu không đúng");
        message_UserName.setText("");
        message_Password.setText("");
        textField_UserName.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
        passField_Password.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
//    End common
}