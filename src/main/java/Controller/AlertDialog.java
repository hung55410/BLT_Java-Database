package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class AlertDialog {
    @FXML
    private AnchorPane ThongBao;
    @FXML
    private Label message;

    @FXML
    void Huy(ActionEvent event) {
        Stage stage = (Stage) ThongBao.getScene().getWindow();
        stage.close();
        System.out.println("Huy");
    }
    @FXML
    void XacNhan(ActionEvent event) {
        Stage stage = (Stage) ThongBao.getScene().getWindow();
        stage.close();
        System.out.println("XacNhan");
    }
}
