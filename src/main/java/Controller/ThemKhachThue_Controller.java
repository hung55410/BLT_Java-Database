package Controller;

import Main.DatabaseConnection;
import Main.KhachHang;
import Main.PhongTro;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class ThemKhachThue_Controller{
    @FXML
    private ToggleGroup gender;
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
    private RadioButton RadioButton_Nam;

    @FXML
    private RadioButton RadioButton_Nu;
    @FXML
    private ObservableList<KhachHang> Data_KhachHang;
    @FXML
    private ObservableList<PhongTro> Data_PhongTro;
    @FXML
    private String RadioButton_GioiTinh;

    public void setItems(ObservableList<KhachHang> Data_KhachHang) {
        this.Data_KhachHang = Data_KhachHang;
    }

    @FXML
    void Button_CancelOnAction_ThemKhachThue(ActionEvent event) {
        Stage stage = (Stage) GiaoDienThemKhachThue.getScene().getWindow();
        stage.close();
    }

    public PhongTro Selected_PhongTro;
    private String maphong;

    public void LayDataTuPhongTro(PhongTro Data_PhongTro) {
        Selected_PhongTro = Data_PhongTro;
        maphong = Selected_PhongTro.getMaPhongTro();
    }
    @FXML
    void Button_ConfirmOnAction_ThemKhachThue(ActionEvent event) {
        String sql = "insert into KHACHHANG(CCCD,hoten,GT,SDT,quequan,ngaybdo,maphong) values(?,?,?,?,?,?,?);";
        if (RadioButton_Nam.isSelected()) {
            RadioButton_GioiTinh = RadioButton_Nam.getText();
        } else if (RadioButton_Nu.isSelected()) {
            RadioButton_GioiTinh = RadioButton_Nu.getText();
        }
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, TextField_CCCD_CMND_KhachThue.getText());
            preparedStatement.setString(2, TextField_HovaTen_KhachThue.getText());
            preparedStatement.setString(3, RadioButton_GioiTinh);
            preparedStatement.setString(4, TextField_SDT_KhachThue.getText());
            preparedStatement.setString(5, TextField_QueQuan_KhachThue.getText());
            preparedStatement.setString(6, "");
            preparedStatement.setString(7, maphong);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            Data_KhachHang.add(new KhachHang(TextField_HovaTen_KhachThue.getText(), TextField_CCCD_CMND_KhachThue.getText(), RadioButton_GioiTinh, TextField_SDT_KhachThue.getText(), TextField_QueQuan_KhachThue.getText(), "", maphong));
            Stage stage = (Stage) GiaoDienThemKhachThue.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

