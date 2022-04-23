package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Main.DatabaseConnection;
import Main.Main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DangNhap_Controller {
    public Button Button_DangNhap;
    @FXML
    private AnchorPane GiaodienDangNhap;
    @FXML
    private TextField TextField_TenDangNhap;
    @FXML
    private PasswordField PasswordField_MatKhau;
    @FXML
    private Label Label_Message;
    @FXML
    private void Button_DangNhapOnAction(ActionEvent event) {
        String userName = TextField_TenDangNhap.getText();
        String password = PasswordField_MatKhau.getText();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        String verifyLogin = "SELECT count(1) FROM login.useraccount WHERE Username = '" + userName + "' AND Password = '" + password + "'";

        if (userName.equals("") || password.equals("")) {
            Label_Message.setText("Vui lòng nhập đầy đủ thông tin");
        } else {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(verifyLogin);
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count == 1) {
                    Stage stage = (Stage) GiaodienDangNhap.getScene().getWindow();
                    stage.close();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("ManHinhChinh.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage stage1 = new Stage();
                    stage1.setScene(scene);
                    stage1.show();
                } else {
                    Label_Message.setText("Tên đăng nhập hoặc mật khẩu không đúng");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void Button_DangKyOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) GiaodienDangNhap.getScene().getWindow();
            stage.close();

            stage.setTitle("Quản lý phòng trọ");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaodienDangKy.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
