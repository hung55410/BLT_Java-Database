package Controller;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ThemDayTro_Controller {
    @FXML
    private void Button_DangKyOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaodienDangKy.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
