package Controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class HomePageController {

    @FXML
    private Button button_home, button_search, button_room, button_setting, button_account;

    @FXML
    private Label title_header;

    @FXML
    private FontAwesomeIconView title_icon;

    @FXML
    private HBox bg_button_home, bg_button_search, bg_button_room, bg_button_setting, bg_button_account;

    @FXML
    private AnchorPane page_home, page_search;

    public void button_homeOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: #21BAB5");
        bg_button_search.setStyle("-fx-background-color: Transparent");
        bg_button_room.setStyle("-fx-background-color: Transparent;");
        bg_button_setting.setStyle("-fx-background-color: Transparent;");
        bg_button_account.setStyle("-fx-background-color: Transparent;");

        page_home.setVisible(true);
        page_search.setVisible(false);
    }

    public void button_searchOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: Transparent");
        bg_button_search.setStyle("-fx-background-color:  #21BAB5");
        bg_button_room.setStyle("-fx-background-color: Transparent;");
        bg_button_setting.setStyle("-fx-background-color: Transparent;");
        bg_button_account.setStyle("-fx-background-color: Transparent;");

        title_header.setText("Tìm kiếm");

        page_home.setVisible(false);
        page_search.setVisible(true);
    }

    public void button_roomOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: Transparent");
        bg_button_search.setStyle("-fx-background-color: Transparent");
        bg_button_room.setStyle("-fx-background-color: #21BAB5");
        bg_button_setting.setStyle("-fx-background-color: Transparent;");
        bg_button_account.setStyle("-fx-background-color: Transparent;");
    }

    public void button_settingOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: Transparent");
        bg_button_search.setStyle("-fx-background-color: Transparent");
        bg_button_room.setStyle("-fx-background-color: Transparent;");
        bg_button_setting.setStyle("-fx-background-color: #21BAB5");
        bg_button_account.setStyle("-fx-background-color: Transparent;");
    }

    public void button_accountOnAction(ActionEvent e) {
        button_home.setStyle("-fx-font-family: 'Verdana'; -fx-font-weight: Bold; -fx-text-fill: #FFF; fx-alignment: Center-left; -fx-background-color: Transperent; -fx-alignment: Left;");
        bg_button_home.setStyle("-fx-background-color: Transparent");
        bg_button_search.setStyle("-fx-background-color: Transparent");
        bg_button_room.setStyle("-fx-background-color: Transparent;");
        bg_button_setting.setStyle("-fx-background-color: Transparent;");
        bg_button_account.setStyle("-fx-background-color: #21BAB5");
    }
}
