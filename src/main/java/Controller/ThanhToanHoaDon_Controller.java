package Controller;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ThanhToanHoaDon_Controller {
    @FXML
    public ScrollPane ThanhToanHoaDon;

    //    Navbar
    @FXML
    private Button button_QuanLyPhong, button_ThanhToanHoaDon, button_DoanhThu;

    public void button_QuanLyPhongOnAction (ActionEvent event) {
        try {
            Stage stage = (Stage) ThanhToanHoaDon.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ManHinhChinh1.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Quản lý phòng trọ");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void button_ThanhToanHoaDonOnAction (ActionEvent event) {
        try {
            Stage stage = (Stage) ThanhToanHoaDon.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienThanhToanHoaDon.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Thanh toán hóa đơn");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void button_DoanhThuOnAction (ActionEvent event) {
        try {
            Stage stage = (Stage) ThanhToanHoaDon.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienDoanhThu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Doanh thu");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
