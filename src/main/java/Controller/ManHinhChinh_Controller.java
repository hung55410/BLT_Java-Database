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

public class ManHinhChinh_Controller {
    @FXML
    private void Button_ThemDayTroOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienThemDayTro.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_SuaDayTroOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienSuaDayTro.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_XoaDayTroOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienXoaDayTro.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_ThemPhongTroOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienThemPhongTro.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_SuaPhongTroOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienSuaPhongTro.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_XoaPhongTroOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienXoaPhongTro.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_ThemKhachThueOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienThemKhachThue.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_SuaKhachThueOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienSuaKhachThue.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Button_XoaKhachThueOnAction (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienXoaKhachThue.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
