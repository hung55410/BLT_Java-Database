package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ThemKhachThue_Controller {

    @FXML
    private AnchorPane GiaoDienThemKhachThue;

    @FXML
    private TextField TextField_CCCD_CMND_KhachThue;

    @FXML
    private TextField TextField_HovaTen_KhachThue;

    @FXML
    private TextField TextField_QueQuan_KhachThue;

    @FXML
    private TextField TextField_SDT_KhachThue;

    @FXML
    void Button_CancelOnAction_ThemKhachThue(ActionEvent event) {
        Stage stage = (Stage) GiaoDienThemKhachThue.getScene().getWindow();
        stage.close();
    }
    @FXML
    void Button_ConfirmOnAction_ThemKhachThue(ActionEvent event) {

    }
}
