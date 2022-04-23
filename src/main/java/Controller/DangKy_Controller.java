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
import Main.DatabaseConnection;
import Main.Main;
public class DangKy_Controller {
    @FXML
    private AnchorPane GiaoDienDangKy;
    @FXML
    private void Button_BackLoginOnAction (ActionEvent event) {
        try {
            Stage stage = (Stage) GiaoDienDangKy.getScene().getWindow();
            stage.close();

            stage.setTitle("Quản lý phòng trọ");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienDangNhap.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void Button_DangKyOnAction (ActionEvent event) {

    } // overight
}
