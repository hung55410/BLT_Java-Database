package Controller;

import Main.DatabaseConnection;
import Main.DayTro;
import Main.PhongTro;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class SuaPhongTro_Controller {
    @FXML
    private AnchorPane GiaoDienSuaPhongTro;

    @FXML
    private TextField TextField_SuaGiaPhongTro;

    @FXML
    private TextField TextField_SuaMaPhongTro;

    @FXML
    private TextField TextField_SuaSLNguoiTrongPhongTro;

    @FXML
    private TextField TextField_SuaTenPhongTro;
    private PhongTro Selected_PhongTro;
    private ObservableList<PhongTro> Data_PhongTro;

    public void setItems(ObservableList<PhongTro> Data_PhongTro) {
        this.Data_PhongTro = Data_PhongTro;
    }

    @FXML
    void SuaPhongTro(PhongTro Data_PhongTro) {
        Selected_PhongTro = Data_PhongTro;
        TextField_SuaMaPhongTro.setText(Selected_PhongTro.getMaPhongTro());
        TextField_SuaTenPhongTro.setText(Selected_PhongTro.getTenPhongTro());
        TextField_SuaSLNguoiTrongPhongTro.setText(Integer.toString(Selected_PhongTro.getSoNguoiTro()));
        TextField_SuaGiaPhongTro.setText(Selected_PhongTro.getGiaPhongTro());
    }

    @FXML
    void Button_CancelOnAction_SuaPhongTro(ActionEvent event) {
        Stage stage = (Stage) GiaoDienSuaPhongTro.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Label error_ChuaNhapDayDuThongTin;

    @FXML
    void Button_ConfirmOnAction_SuaPhongTro(ActionEvent event) {
        if(ChuaNhapDayDuThongTin()){
            String sql = "UPDATE phongtro SET tenphong = ? , songuoitro = ?, giaphong = ?, madaytro = ?  WHERE maphong = ?";
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, TextField_SuaTenPhongTro.getText());
                preparedStatement.setInt(2, Integer.parseInt(TextField_SuaSLNguoiTrongPhongTro.getText()));
                preparedStatement.setString(3, TextField_SuaGiaPhongTro.getText());
                preparedStatement.setString(4, Data_PhongTro.get(0).getMaDayTro());
                preparedStatement.setString(5, TextField_SuaMaPhongTro.getText());
                preparedStatement.executeUpdate();
                preparedStatement.close();
                Data_PhongTro.set(Data_PhongTro.indexOf(Selected_PhongTro), new PhongTro(TextField_SuaMaPhongTro.getText(), TextField_SuaTenPhongTro.getText(), Integer.parseInt(TextField_SuaSLNguoiTrongPhongTro.getText()), TextField_SuaGiaPhongTro.getText()));
                Stage stage = (Stage) GiaoDienSuaPhongTro.getScene().getWindow();
                stage.close();
                SuaThanhCong();
            } catch (Exception e) {
                System.out.println("Update that bai");
            }
        }
    }
    public boolean ChuaNhapDayDuThongTin() {
        if (TextField_SuaTenPhongTro.getText().isEmpty() || TextField_SuaGiaPhongTro.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
            return false;
        }
        if (!TextField_SuaGiaPhongTro.getText().matches("^[0-9]*$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập giá phòng là số");
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
