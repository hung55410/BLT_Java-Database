package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SuaKhachThue_Controller {

    @FXML
    private VBox GiaoDienSuaKhachThue;

    @FXML
    private TextField TextField_SuaCCCD_CMND_KhachThue;

    @FXML
    private TextField TextField_SuaHovaTen_KhachThue;

    @FXML
    private TextField TextField_SuaQueQuan_KhachThue;

    @FXML
    private TextField TextField_SuaSDT_KhachThue;

    @FXML
    void Button_CancelOnAction_SuaKhachThue(ActionEvent event) {
        Stage stage = (Stage) GiaoDienSuaKhachThue.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Button_ConfirmOnAction_SuaKhachThue(ActionEvent event) {

    }

}
