package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class AlertDialog {
    @FXML
    private Button Button_Huy;

    @FXML
    private Button Button_XacNhan;

    @FXML
    private Label message;

    @FXML
    void Huy(ActionEvent event) {
        Button_Huy.getScene().getWindow().hide();
    }
    @FXML
    void XacNhan(ActionEvent event) {
        Stage stage = (Stage) Button_XacNhan.getScene().getWindow();
        stage.close();
    }
}
