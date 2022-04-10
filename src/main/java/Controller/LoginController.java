package Controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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

//    Start HomePage
    @FXML
    private Button button_home, button_search, button_setting, button_account;
    @FXML
    private Label title_header;
    @FXML
    private FontAwesomeIconView title_icon;
    @FXML
    private HBox bg_button_home, bg_button_search, bg_button_setting, bg_button_account;
    @FXML
    private AnchorPane page_home, page_search, page_setting, page_account;

    public void button_homeOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: #21BAB5");
        bg_button_search.setStyle("-fx-background-color: Transparent");
        bg_button_setting.setStyle("-fx-background-color: Transparent;");
        bg_button_account.setStyle("-fx-background-color: Transparent;");

        title_icon.setGlyphName("HOME");
        String title = button_home.getText().toUpperCase();
        title_header.setText(title);

        page_home.setVisible(true);
        page_search.setVisible(false);
        page_setting.setVisible(false);
        page_account.setVisible(false);
    }

    public void button_searchOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: Transparent");
        bg_button_search.setStyle("-fx-background-color:  #21BAB5");
        bg_button_setting.setStyle("-fx-background-color: Transparent;");
        bg_button_account.setStyle("-fx-background-color: Transparent;");

        title_icon.setGlyphName("SEARCH");
        String title = button_search.getText().toUpperCase();
        title_header.setText(title);

        page_home.setVisible(false);
        page_search.setVisible(true);
        page_setting.setVisible(false);
        page_account.setVisible(false);
    }

    public void button_settingOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: Transparent");
        bg_button_search.setStyle("-fx-background-color: Transparent");
        bg_button_setting.setStyle("-fx-background-color: #21BAB5");
        bg_button_account.setStyle("-fx-background-color: Transparent;");

        title_icon.setGlyphName("COG");
        String title = button_setting.getText().toUpperCase();
        title_header.setText(title);

        page_home.setVisible(false);
        page_search.setVisible(false);
        page_setting.setVisible(true);
        page_account.setVisible(false);

    }

    public void button_accountOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: Transparent");
        bg_button_search.setStyle("-fx-background-color: Transparent");
        bg_button_setting.setStyle("-fx-background-color: Transparent;");
        bg_button_account.setStyle("-fx-background-color: #21BAB5");

        title_icon.setGlyphName("USER");
        String title = button_account.getText().toUpperCase();
        title_header.setText(title);

        page_home.setVisible(false);
        page_search.setVisible(false);
        page_setting.setVisible(false);
        page_account.setVisible(true);
    }
//    End HomePage

//    Start add room

//    End add room
}