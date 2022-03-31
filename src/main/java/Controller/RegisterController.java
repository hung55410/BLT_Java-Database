package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import sample.login2.DatabaseConnection;
import sample.login2.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class RegisterController {
    @FXML
    private Button buttonBackLogin, button_Register;
    @FXML
    private TextField textField_UserName;
    @FXML
    private PasswordField passField_Password, passField_confirmPassword;
    @FXML
    private Label message_UserName, message_Password, message_confirmPassword;


//  Bắt sự kiện
    public void buttonBackLoginOnAction(ActionEvent e) {
        try {
            Stage stage1 = (Stage) buttonBackLogin.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Quản lý phòng trọ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {

        }
    }

//  bắt sự kiện
    public void button_RegisterOnAction(ActionEvent e) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyUser = "SELECT count(1) FROM login.useraccount WHERE Username = '" + textField_UserName.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(verifyUser);

            if(textField_UserName.getText().isBlank() == true) {
                username_Null();
            } else if(textField_UserName.getText().isBlank() == false) {
                while(resultSet.next()) {
                    if(resultSet.getInt(1) == 1) {
                        message_UserName.setText("Tên đăng nhập đã tồn tại");
                        textField_UserName.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");

                        if(passField_Password.getText().isBlank() == true) {
                            password_Null();
                        } else if(passField_Password.getText().length() < 6) {
                            message_Password.setText("Mật khẩu phải có ít nhất 6 ký tự");
                            passField_Password.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
                        } else if(passField_Password.getText().length() >20) {
                            message_Password.setText("Mật khẩu không được quá 20 ký tự");
                            passField_Password.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
                        } else if(passField_Password.getText().isBlank() == false) {
                            password_NotNull();
                        }
                        if(passField_confirmPassword.getText().isBlank() == true) {
                            confirmPassword_Null();
                        } else if(passField_Password.getText().equals(passField_confirmPassword.getText()) == false) {
                            message_confirmPassword.setText("Mật khẩu không trùng khớp");
                            passField_confirmPassword.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
                        } else if(passField_Password.getText().equals(passField_confirmPassword.getText()) == true) {
                            confirmPassword_NotNull();
                        }
                    } else if(resultSet.getInt(1) == 0) {
                        try {
                            Stage stage1 = (Stage) buttonBackLogin.getScene().getWindow();
                            stage1.close();
                            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register_2.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            Stage stage = new Stage();
                            stage.setTitle("Quản lý phòng trọ");
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {

                        }
                    }
                }
            }
        } catch (SQLException ex) {

        }
    }

//  Kiểm tra form người dùng nhập
    public void validateForm() {
        checkUserName();
        checkPassword();
        checkConfirmPassword();
    }

// kiểm tra tên đăng nhập
    public void checkUserName() {
//      Kiểm tra tên đăng nhập có trống hay không
        if(textField_UserName.getText().isBlank() == true) {
            username_Null();
        } else {
            //      Kiểm tra trùng tên đăng nhập
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String verifyUser = "SELECT count(1) FROM login.useraccount WHERE Username = '" + textField_UserName.getText() + "'";

            try {
                Statement statement = connectDB.createStatement();
                ResultSet resultSetUser = statement.executeQuery(verifyUser);

                while (resultSetUser.next()) {
                    if (resultSetUser.getInt(1) == 1){
                        message_UserName.setText("Tên đăng nhập đã tồn tại");
                        textField_UserName.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
                    } else if (resultSetUser.getInt(1) == 0) {
                        if(textField_UserName.getText().isBlank() == true) {
                            username_Null();
                        } else if (textField_UserName.getText().isBlank() == false) {
                            username_NotNull();
                        }
                        if(passField_Password.getText().isBlank() == true) {
                            password_Null();
                        } else if(passField_Password.getText().isBlank() == false) {
                            password_NotNull();
                        }
                        if(passField_confirmPassword.getText().isBlank() == true) {
                            confirmPassword_Null();
                        } else if (passField_confirmPassword.getText().isBlank() == false) {
                            confirmPassword_NotNull();
                        }
                    }
                }

            } catch (SQLException e) { }
        }
    }
// kiểm tra mật khẩu
    public void checkPassword() {
//      kiểm tra ô nhập mật khẩu có trống không
        if(passField_Password.getText().isBlank() == true) {
            password_Null();
        } else {
            //      kiểm tra mật khẩu có độ dài từ 6 đến 20 ký tự
            if(passField_Password.getText().length() < 6 || passField_Password.getText().length() > 20) {
                message_Password.setText("Mật khẩu phải có độ dài từ 6 đến 20 ký tự");
                passField_Password.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
            } else {
                password_NotNull();
            }
        }
    }
// Kiêm tra xác nhận mật khẩu
    public void checkConfirmPassword() {
//      kiểm tra ô nhập xác nhận mật khẩu có trống không
        if(passField_confirmPassword.getText().isBlank() == true) {
            confirmPassword_Null();
        } else {
            //      kiểm tra xác nhận mật khẩu có trùng với mật khẩu không
            if(passField_Password.getText().equals(passField_confirmPassword.getText()) == false) {
                message_confirmPassword.setText("Xác nhận mật khẩu không trùng với mật khẩu");
                passField_confirmPassword.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
            } else {
                confirmPassword_NotNull();
            }
        }
    }


//    Start common
    public void username_Null() {
        message_UserName.setText("Tên đăng nhập không được để trống");
        textField_UserName.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void username_NotNull() {
        message_UserName.setText("");
        textField_UserName.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void password_Null() {
        message_Password.setText("Mật khẩu không được để trống");
        passField_Password.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void password_NotNull() {
        message_Password.setText("");
        passField_Password.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void confirmPassword_Null() {
        message_confirmPassword.setText("Xác nhận mật khẩu không được để trống");
        passField_confirmPassword.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void confirmPassword_NotNull() {
        message_confirmPassword.setText("");
        passField_confirmPassword.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
//    End common
}
