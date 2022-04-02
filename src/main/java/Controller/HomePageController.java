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
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class HomePageController {

    @FXML
    private FontAwesomeIconView icon_title;
    @FXML
    private Label label_title;
    @FXML
    private Button button_homePage, button_roomManager, button_setting, button_aboutUs, button_account, button_search;
    @FXML
    private MenuItem menuItem_account, menuItem_exit;
    @FXML
    private AnchorPane page_homePage, page_roomManager, page_setting, page_aboutUs, page_account, page_search;
//  Start Home
    public void button_homePageOnAction(ActionEvent e) {
        page_roomManager.setVisible(false);
        page_setting.setVisible(false);
        page_aboutUs.setVisible(false);
        page_account.setVisible(false);
        page_homePage.setVisible(true);
        page_search.setVisible(false);

        button_homePage.setStyle("-fx-background-color: #21bab5; -fx-padding: 12 24");
        button_roomManager.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_setting.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_aboutUs.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_account.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_search.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");

        icon_title.setGlyphName("HOME");
        icon_title.setSize("20");
        label_title.setText("Trang chủ");
        label_title.setStyle("-fx-font-size: 16; -fx-font-weight: bold");
    }
    public void button_searchOnAction(ActionEvent e){
        page_homePage.setVisible(false);
        page_roomManager.setVisible(false);
        page_setting.setVisible(false);
        page_aboutUs.setVisible(false);
        page_account.setVisible(false);
        page_search.setVisible(true);

        button_homePage.setStyle("-fx-background-color: #163A5F; -fx-padding: 12 24");
        button_roomManager.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_setting.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_aboutUs.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_account.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_search.setStyle("-fx-background-color:  #21bab5; -fx-padding: 12 24");

        icon_title.setGlyphName("SEARCH");
        icon_title.setSize("20");
        label_title.setText("Tìm kiếm");
        label_title.setStyle("-fx-font-size: 16; -fx-font-weight: bold");
    }
    public void button_roomManagerOnAction(ActionEvent e){
        page_homePage.setVisible(false);
        page_setting.setVisible(false);
        page_aboutUs.setVisible(false);
        page_account.setVisible(false);
        page_roomManager.setVisible(true);
        page_search.setVisible(false);

        button_homePage.setStyle("-fx-background-color: #163A5F; -fx-padding: 12 24");
        button_roomManager.setStyle("-fx-background-color:  #21bab5; -fx-padding: 12 24");
        button_setting.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_aboutUs.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_account.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_search.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");

        icon_title.setGlyphName("ARCHIVE");
        icon_title.setSize("16");
        label_title.setText("Quản lý phòng");
        label_title.setStyle("-fx-font-size: 16; -fx-font-weight: bold");
    }
    public void button_settingOnAction(ActionEvent e){
        page_homePage.setVisible(false);
        page_setting.setVisible(true);
        page_aboutUs.setVisible(false);
        page_account.setVisible(false);
        page_roomManager.setVisible(false);
        page_search.setVisible(false);

        button_homePage.setStyle("-fx-background-color: #163A5F; -fx-padding: 12 24");
        button_roomManager.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_setting.setStyle("-fx-background-color:  #21bab5; -fx-padding: 12 24");
        button_aboutUs.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_account.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_search.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");

        icon_title.setGlyphName("COG");
        icon_title.setSize("16");
        label_title.setText("Cài đặt");
        label_title.setStyle("-fx-font-size: 16; -fx-font-weight: bold");
    }
    public void button_aboutUsOnAction(ActionEvent e){
        page_homePage.setVisible(false);
        page_setting.setVisible(false);
        page_aboutUs.setVisible(true);
        page_account.setVisible(false);
        page_roomManager.setVisible(false);
        page_search.setVisible(false);

        button_homePage.setStyle("-fx-background-color: #163A5F; -fx-padding: 12 24");
        button_roomManager.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_setting.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_aboutUs.setStyle("-fx-background-color:  #21bab5; -fx-padding: 12 24");
        button_account.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_search.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");

        icon_title.setGlyphName("INFO_CIRCLE");
        icon_title.setSize("16");
        label_title.setText("About Us");
        label_title.setStyle("-fx-font-size: 16; -fx-font-weight: bold");
    }
    public void button_accountOnAction(ActionEvent e){
        page_homePage.setVisible(false);
        page_setting.setVisible(false);
        page_aboutUs.setVisible(false);
        page_account.setVisible(true);
        page_roomManager.setVisible(false);
        page_search.setVisible(false);

        button_homePage.setStyle("-fx-background-color: #163A5F; -fx-padding: 12 24");
        button_roomManager.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_setting.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_aboutUs.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_account.setStyle("-fx-background-color:  #21bab5; -fx-padding: 12 24");
        button_search.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");

        icon_title.setGlyphName("USER");
        icon_title.setSize("16");
        label_title.setText("Tài khoản");
        label_title.setStyle("-fx-font-size: 16; -fx-font-weight: bold");
    }
//  end Home

//  Start Search
//  End Search

//  Start RoomManager
//  End RoomManager

//  Start Setting
//  End Setting

//  Start AboutUs
//  End AboutUs

//  Start Account
//  End Account


    public void menuItem_accountOnAction(ActionEvent e){
        page_homePage.setVisible(false);
        page_setting.setVisible(false);
        page_aboutUs.setVisible(false);
        page_account.setVisible(true);
        page_roomManager.setVisible(false);

        button_homePage.setStyle("-fx-background-color: #163A5F; -fx-padding: 12 24");
        button_roomManager.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_setting.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_aboutUs.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");
        button_account.setStyle("-fx-background-color:  #21bab5; -fx-padding: 12 24");
        button_search.setStyle("-fx-background-color:  #163A5F; -fx-padding: 12 24");

        icon_title.setGlyphName("USER");
        icon_title.setSize("16");
        label_title.setText("Tài khoản");
        label_title.setStyle("-fx-font-size: 16; -fx-font-weight: bold");
    }
    public void menuItem_exitOnAction(ActionEvent e){
        System.exit(0);
    }

}
