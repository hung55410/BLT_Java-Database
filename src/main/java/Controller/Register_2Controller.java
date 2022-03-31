package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.login2.Main;

import java.io.IOException;

public class Register_2Controller {
    @FXML
    private TextField textField_name, textField_numberPhone, textField_address, textField_gender;
    @FXML
    private DatePicker textField_dateTime;
    @FXML
    private Label message_name, message_numberPhone, message_address, message_dateTime, message_gender;
    @FXML
    private Button button_backLogin;

//  start common
    public void name_false() {
        message_name.setText("Vui lòng nhập tên");
        textField_name.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void name_true() {
        message_name.setText("");
        textField_name.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void gender_false() {
        message_gender.setText("Vui lòng nhập giới tính");
        textField_gender.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void gender_true() {
        message_gender.setText("");
        textField_gender.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF");
    }
    public void dateTime_false() {
        message_dateTime.setText("Vui lòng nhập ngày sinh");
        textField_dateTime.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void dateTime_true() {
        message_dateTime.setText("");
        textField_dateTime.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void numberPhone_false() {
        message_numberPhone.setText("Vui lòng nhập số điện thoại");
        textField_numberPhone.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void numberPhone_true() {
        message_numberPhone.setText("");
        textField_numberPhone.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void address_false() {
        message_address.setText("Vui lòng nhập địa chỉ");
        textField_address.setStyle("-fx-border-color: #fd3d39; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
    public void address_true() {
        message_address.setText("");
        textField_address.setStyle("-fx-border-color: #5e5e5e; -fx-padding: 8 8; -fx-background-color: #FFFFFF;");
    }
//    end common

    public void check(){
        if(textField_name.getText().isBlank() == true) {
            name_false();
        } else {
            name_true();
        }
        if(textField_gender.getText().isBlank() == true) {
            gender_false();
        } else {
            gender_true();
        }
        if(textField_dateTime.getValue() == null) {
            dateTime_false();
        } else {
            dateTime_true();
        }
        if(textField_numberPhone.getText().isBlank() == true) {
            numberPhone_false();
        } else {
            numberPhone_true();
        }
        if(textField_address.getText().isBlank() == true) {
            address_false();
        } else {
            address_true();
        }
    }

    public void button_confirmOnAction(ActionEvent e) {
        check();
    }

    public void button_backLoginOnAction(ActionEvent e) {
        try {
            Stage stage1 = (Stage) button_backLogin.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Quản lý phòng trọ");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}