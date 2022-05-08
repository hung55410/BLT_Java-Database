package Controller;

import Main.DatabaseConnection;
import Main.DayTro;
import Main.KhachHang;
import Main.PhongTro;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SuaKhachThue_Controller {

    @FXML
    private AnchorPane GiaoDienSuaKhachThue;

    @FXML
    private TextField TextField_SuaCCCD_CMND_KhachHang;

    @FXML
    private TextField TextField_SuaHovaTen_KhachHang;

    @FXML
    private TextField TextField_SuaQueQuan_KhachHang;

    @FXML
    private TextField TextField_SuaSDT_KhachHang;

    @FXML
    private RadioButton RadioButton_SuaGT_Nam;

    @FXML
    private RadioButton RadioButton_SuaGT_Nu;
    private KhachHang Selected_KhachHang;
    private ObservableList<KhachHang> Data_KhachHang;
    private String RadioButton_SuaGioiTinh;

    public void setItems(ObservableList<KhachHang> Data_KhachHang) {
        this.Data_KhachHang = Data_KhachHang;
    }
    @FXML
    void SuaKhachThue(KhachHang Data_KhachThue) {
        Selected_KhachHang = Data_KhachThue;
        TextField_SuaCCCD_CMND_KhachHang.setText(Selected_KhachHang.getCCCD());
        TextField_SuaHovaTen_KhachHang.setText(Selected_KhachHang.getHoTenKhachHang());
        if(Selected_KhachHang.getGT().equals("Nam")){
            RadioButton_SuaGT_Nam.setSelected(true);
        }else if (Selected_KhachHang.getGT().equals("Nu")){
            RadioButton_SuaGT_Nu.setSelected(true);
        }
        TextField_SuaQueQuan_KhachHang.setText(Selected_KhachHang.getQueQuan());
        TextField_SuaSDT_KhachHang.setText(Selected_KhachHang.getSDT());
    }
    @FXML
    void Button_CancelOnAction_SuaKhachThue(ActionEvent event) {
        Stage stage = (Stage) GiaoDienSuaKhachThue.getScene().getWindow();
        stage.close();
    }
    @FXML
    void Button_ConfirmOnAction_SuaKhachThue(ActionEvent event) {
        if (RadioButton_SuaGT_Nam.isSelected()) {
            RadioButton_SuaGioiTinh = RadioButton_SuaGT_Nam.getText();
        } else if (RadioButton_SuaGT_Nu.isSelected()) {
            RadioButton_SuaGioiTinh = RadioButton_SuaGT_Nu.getText();
        }
        String sql = "UPDATE khachhang SET hoten = ? , GT = ?, SDT = ?, quequan = ?, ngaybdo = ?, maphong = ?  WHERE CCCD = ?";
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, TextField_SuaHovaTen_KhachHang.getText());
            preparedStatement.setString(2, RadioButton_SuaGioiTinh);
            preparedStatement.setString(3, TextField_SuaSDT_KhachHang.getText());
            preparedStatement.setString(4, TextField_SuaQueQuan_KhachHang.getText());
            preparedStatement.setString(5, "");
            preparedStatement.setString(6, Data_KhachHang.get(0).getMaPhongTro());
            preparedStatement.setString(7, TextField_SuaCCCD_CMND_KhachHang.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            Data_KhachHang.set(Data_KhachHang.indexOf(Selected_KhachHang), new KhachHang(TextField_SuaHovaTen_KhachHang.getText(),TextField_SuaCCCD_CMND_KhachHang.getText(), RadioButton_SuaGioiTinh, TextField_SuaSDT_KhachHang.getText(),TextField_SuaQueQuan_KhachHang.getText(),"", Data_KhachHang.get(0).getMaPhongTro()));
            Stage stage = (Stage) GiaoDienSuaKhachThue.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
