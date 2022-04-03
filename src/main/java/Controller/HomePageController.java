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

    public void button_homeOnAction(ActionEvent e) {
//      start Text
        title_icon.setGlyphName("HOME");
        title_header.setText("trang chủ");
        String title_header_upcase = title_header.getText().toUpperCase();
        title_header.setText(title_header_upcase);
        title_header.setStyle("-fx-text-fill: #FFF; -fx-font-size: 14px; -fx-font-weight: bold; -fx-font-family: 'Verdana';");
//      end Text

        bg_button_home.setStyle("-fx-background-color: #21BAB5;");
        bg_button_search.setStyle("-fx-background-color: transparent;");
        bg_button_room.setStyle("-fx-background-color: transparent;");
        bg_button_setting.setStyle("-fx-background-color: transparent;");
        bg_button_account.setStyle("-fx-background-color: transparent;");

    }

    public void button_searchOnAction(ActionEvent e) {
        title_icon.setGlyphName("SEARCH");
        title_header.setText("tìm kiếm");
        String title_header_upcase = title_header.getText().toUpperCase();
        title_header.setText(title_header_upcase);
        title_header.setStyle("-fx-text-fill: #FFF; -fx-font-size: 14px; -fx-font-weight: bold; -fx-font-family: 'Verdana';");

        bg_button_home.setStyle("-fx-background-color: transparent;");
        bg_button_search.setStyle("-fx-background-color: #21BAB5;");
        bg_button_room.setStyle("-fx-background-color: transparent;");
        bg_button_setting.setStyle("-fx-background-color: transparent;");
        bg_button_account.setStyle("-fx-background-color: transparent;");

    }

    public void button_roomOnAction(ActionEvent e) {
        title_icon.setGlyphName("ARCHIVE");
        title_header.setText("quản lý phòng");
        String title_header_upcase = title_header.getText().toUpperCase();
        title_header.setText(title_header_upcase);
        title_header.setStyle("-fx-text-fill: #FFF; -fx-font-size: 14px; -fx-font-weight: bold; -fx-font-family: 'Verdana';");

        bg_button_home.setStyle("-fx-background-color: transparent;");
        bg_button_search.setStyle("-fx-background-color: transparent;");
        bg_button_room.setStyle("-fx-background-color: #21BAB5;");
        bg_button_setting.setStyle("-fx-background-color: transparent;");
        bg_button_account.setStyle("-fx-background-color: transparent;");

    }

    public void button_settingOnAction(ActionEvent e) {
        title_icon.setGlyphName("COG");
        title_header.setText("cài đặt");
        String title_header_upcase = title_header.getText().toUpperCase();
        title_header.setText(title_header_upcase);
        title_header.setStyle("-fx-text-fill: #FFF; -fx-font-size: 14px; -fx-font-weight: bold; -fx-font-family: 'Verdana';");

        bg_button_home.setStyle("-fx-background-color: transparent;");
        bg_button_search.setStyle("-fx-background-color: transparent;");
        bg_button_room.setStyle("-fx-background-color: transparent;");
        bg_button_setting.setStyle("-fx-background-color: #21BAB5;");
        bg_button_account.setStyle("-fx-background-color: transparent;");

    }

    public void button_accountOnAction(ActionEvent e) {
        title_icon.setGlyphName("USER");
        title_header.setText("tài khoản");
        String title_header_upcase = title_header.getText().toUpperCase();
        title_header.setText(title_header_upcase);
        title_header.setStyle("-fx-text-fill: #FFF; -fx-font-size: 14px; -fx-font-weight: bold; -fx-font-family: 'Verdana';");

        bg_button_home.setStyle("-fx-background-color: transparent;");
        bg_button_search.setStyle("-fx-background-color: transparent;");
        bg_button_room.setStyle("-fx-background-color: transparent;");
        bg_button_setting.setStyle("-fx-background-color: transparent;");
        bg_button_account.setStyle("-fx-background-color: #21BAB5;");
    }
}
