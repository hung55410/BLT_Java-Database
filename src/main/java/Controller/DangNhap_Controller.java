package Controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Main.User;
import Main.DayTro;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Main.DatabaseConnection;
import Main.Main;

import java.io.IOException;
import java.sql.*;

public class DangNhap_Controller {
    @FXML
    private AnchorPane GiaodienDangNhap;
    @FXML
    private TextField TextField_TenDangNhap;
    @FXML
    private PasswordField PasswordField_MatKhau;
    @FXML
    private Label Label_Message;
    @FXML
    private Button button_DangKy;
    @FXML
    private void Button_DangNhapOnAction(ActionEvent event) throws IOException {
//        CHUYEN kieu char sang kieu string
        String userName = TextField_TenDangNhap.getText();
        String password = PasswordField_MatKhau.getText();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        String verifyLogin = "select count(1) as count from chutro where madinhdanh = ? and matkhau = ?";
        if (userName.equals("") || password.equals("")) {
            Label_Message.setText("Vui lòng nhập đầy đủ thông tin");
        }
        else {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(verifyLogin);
                preparedStatement.setString(1,userName);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count == 1) {
                    Stage stage = (Stage) GiaodienDangNhap.getScene().getWindow();
                    stage.close();
                    Stage stage1 = new Stage();
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("ManHinhChinh1.fxml"));
                    Scene scene = new Scene(loader.load());
                    ManHinhChinh_Controller manHinhChinh_controller = loader.getController();
                    manHinhChinh_controller.loaddata_daytro(userName);
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
    public void Button_DangKyOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) GiaodienDangNhap.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienDangKy.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Quản lý phòng trọ");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Dangki");
        }
    }
    //truyền username vào thêm dãy trọ trong database

}
