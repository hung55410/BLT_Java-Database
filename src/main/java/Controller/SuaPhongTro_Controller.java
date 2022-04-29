package Controller;

import Main.DatabaseConnection;
import Main.DayTro;
import Main.PhongTro;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
    void Button_ConfirmOnAction_SuaPhongTro(ActionEvent event) {
        String sql = "UPDATE phongtro SET tenphong = ? , songuoitro = ?, giaphong = ? WHERE maphong = ?";
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, TextField_SuaTenPhongTro.getText());
            preparedStatement.setInt(2,  Integer.parseInt(TextField_SuaSLNguoiTrongPhongTro.getText()));
            preparedStatement.setString(3, TextField_SuaGiaPhongTro.getText());
            preparedStatement.setString(4, TextField_SuaMaPhongTro.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            Data_PhongTro.set(Data_PhongTro.indexOf(Selected_PhongTro), new PhongTro(TextField_SuaMaPhongTro.getText(),TextField_SuaTenPhongTro.getText(), Integer.parseInt(TextField_SuaSLNguoiTrongPhongTro.getText()), TextField_SuaGiaPhongTro.getText()));
            Stage stage = (Stage) GiaoDienSuaPhongTro.getScene().getWindow();
            stage.close();
            System.out.println("Update thanh cong");
        } catch (Exception e) {
            System.out.println("Update that bai");
        }
    }
}
