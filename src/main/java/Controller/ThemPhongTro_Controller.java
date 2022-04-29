package Controller;

import Main.DatabaseConnection;
import Main.PhongTro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ThemPhongTro_Controller implements Initializable {
    @FXML
    private AnchorPane GiaoDienThemPhongTro;

    @FXML
    private TextField TextField_GiaPhongTro;

    @FXML
    private TextField TextField_MaPhongTro;

    @FXML
    private TextField TextField_SLPhongNguoiTrongPhong;

    @FXML
    private TextField TextField_TenPhongTro;

    @FXML
    private Label error_ChuaNhapDayDuThongTin;

    @FXML
    private ComboBox ComboBox_PhongTro;
    private ObservableList<PhongTro> Data_PhongTro;

    public void setItems(ObservableList<PhongTro> Data_PhongTro) {
        this.Data_PhongTro = Data_PhongTro;
    }

    @FXML
    void Button_CancelOnAction_ThemPhongTro(ActionEvent event) {
        Stage stage = (Stage) GiaoDienThemPhongTro.getScene().getWindow();
        stage.close();
    }
    @FXML
    void Button_ConfirmOnAction_ThemPhongTro(ActionEvent event) {
        String sql = "insert into PHONGTRO(maphong,tenphong,songuoitro,giaphong,madaytro) values(?,?,?,?,'MaDay_01')";
        String maphongtro = TextField_MaPhongTro.getText();
        String giaphongtro = TextField_GiaPhongTro.getText();
        String tenphongtro = TextField_TenPhongTro.getText();
        int soluongnguoitrongphong = Integer.parseInt(TextField_SLPhongNguoiTrongPhong.getText());
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maphongtro);
            preparedStatement.setString(2, tenphongtro);
            preparedStatement.setInt(3, soluongnguoitrongphong);
            preparedStatement.setString(4, giaphongtro);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            Data_PhongTro.add(new PhongTro(TextField_MaPhongTro.getText(), TextField_TenPhongTro.getText(), Integer.parseInt(TextField_SLPhongNguoiTrongPhong.getText()), TextField_GiaPhongTro.getText()));
            Stage stage = (Stage) GiaoDienThemPhongTro.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            System.out.println("Loi them day tro");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Data_PhongTro = FXCollections.observableArrayList();
        options_selectchutro();
    }
    public void options_selectchutro() {
        try {
            String sql = "SELECT madaytro FROM daytro";
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String madaytro = resultSet.getString("madaytro");
                ComboBox_PhongTro.getItems().add(madaytro);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
