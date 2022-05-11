package Controller;

import Main.DatabaseConnection;
import Main.KhachHang;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class SuaKhachThue_Controller {
    @FXML
    private AnchorPane GiaoDienSuaKhachThue;

    @FXML
    private TextField TextField_SuaCCCD_CMND_KhachThue;

    @FXML
    private TextField TextField_SuaHovaTen_KhachThue;

    @FXML
    private TextField TextField_SuaQueQuan_KhachThue;

    @FXML
    private TextField TextField_SuaSDT_KhachThue;
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
    void SuaKhachThue(KhachHang Data_KhachHang) {
        Selected_KhachHang = Data_KhachHang;
        TextField_SuaCCCD_CMND_KhachThue.setText(Selected_KhachHang.getCCCD());
        TextField_SuaHovaTen_KhachThue.setText(Selected_KhachHang.getHoTenKhachHang());
        if (Selected_KhachHang.getGT().equals("Nam")) {
            RadioButton_SuaGT_Nam.setSelected(true);
        } else if (Selected_KhachHang.getGT().equals("Nu")) {
            RadioButton_SuaGT_Nu.setSelected(true);
        }
        TextField_SuaQueQuan_KhachThue.setText(Selected_KhachHang.getQueQuan());
        TextField_SuaSDT_KhachThue.setText(Selected_KhachHang.getSDT());
    }

    @FXML
    void Button_CancelOnAction_SuaKhachThue(ActionEvent event) {
        Stage stage = (Stage) GiaoDienSuaKhachThue.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Button_ConfirmOnAction_SuaKhachThue(ActionEvent event) {
        if (ChuaNhapDayDuThongTin()) {
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
                preparedStatement.setString(1, TextField_SuaHovaTen_KhachThue.getText());
                preparedStatement.setString(2, RadioButton_SuaGioiTinh);
                preparedStatement.setString(3, TextField_SuaSDT_KhachThue.getText());
                preparedStatement.setString(4, TextField_SuaQueQuan_KhachThue.getText());
                preparedStatement.setString(5, Selected_KhachHang.getNgayBatDauO());
                preparedStatement.setString(6, Data_KhachHang.get(0).getMaPhongTro());
                preparedStatement.setString(7, TextField_SuaCCCD_CMND_KhachThue.getText());
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                Data_KhachHang.set(Data_KhachHang.indexOf(Selected_KhachHang), new KhachHang(TextField_SuaHovaTen_KhachThue.getText(), TextField_SuaCCCD_CMND_KhachThue.getText(), RadioButton_SuaGioiTinh, TextField_SuaSDT_KhachThue.getText(), TextField_SuaQueQuan_KhachThue.getText(), Selected_KhachHang.getNgayBatDauO(), Data_KhachHang.get(0).getMaPhongTro()));
                Stage stage = (Stage) GiaoDienSuaKhachThue.getScene().getWindow();
                stage.close();
                SuaThanhCong();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public boolean ChuaNhapDayDuThongTin() {
        if (TextField_SuaHovaTen_KhachThue.getText().isEmpty() || TextField_SuaSDT_KhachThue.getText().isEmpty() || TextField_SuaQueQuan_KhachThue.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
            return false;
        }
        if (!TextField_SuaSDT_KhachThue.getText().matches("^[0-9]*$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập số điện thoại là số");
            alert.showAndWait();
            return false;
        }
        if (TextField_SuaSDT_KhachThue.getText().length() != 10) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập số điện thoại là 10 số");
            alert.showAndWait();
            return false;
        }
        return true;
    }
    public boolean SuaThanhCong() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sửa Thành Công");
        alert.setHeaderText("Bạn đã sửa thành công");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }
}
