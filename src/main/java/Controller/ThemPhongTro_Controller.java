package Controller;

import Main.DatabaseConnection;
import Main.DayTro;
import Main.Main;
import Main.PhongTro;
import Main.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
    private ObservableList<PhongTro> Data_PhongTro;
    private ObservableList<DayTro> Data_DayTro;
    private DayTro selectedDayTro;


    public void setItems(ObservableList<PhongTro> Data_PhongTro) {
        this.Data_PhongTro = Data_PhongTro;
    }

    public void setItems1(ObservableList<DayTro> Data_DayTro) {
        this.Data_DayTro = Data_DayTro;
    }

    private String madaytro;

    @FXML
    void Button_CancelOnAction_ThemPhongTro(ActionEvent event) {
        Stage stage = (Stage) GiaoDienThemPhongTro.getScene().getWindow();
        stage.close();
    }

    public void LayDataTuDayTro(DayTro Data_DayTro) {
        selectedDayTro = Data_DayTro;
        madaytro = selectedDayTro.getMaDayTro();
    }

    User data = User.getInstance();

    @FXML
    void Button_ConfirmOnAction_ThemPhongTro(ActionEvent event) {
        int x = 0;
        if (ChuaNhapDayDuThongTin()) {
            String sql = "insert into PHONGTRO(maphong,tenphong,songuoitro,giaphong,madaytro) values(?,?,?,?,?)";
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
                preparedStatement.setString(5, madaytro);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                Data_PhongTro.add(0, new PhongTro(TextField_MaPhongTro.getText(), TextField_TenPhongTro.getText(), Integer.parseInt(TextField_SLPhongNguoiTrongPhong.getText()), TextField_GiaPhongTro.getText(), madaytro));
                Stage stage = (Stage) GiaoDienThemPhongTro.getScene().getWindow();
                stage.close();
            } catch (SQLException e) {
                System.out.println("Loi them day tro");
                e.printStackTrace();
            }
            x = 1;
        }
        if (x == 1) {
            try {
                String sql1 = "Update daytro set SlPhong = SlPhong + 1 where madaytro = ?";
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql1);
                ps.setString(1, madaytro);
                ps.executeUpdate();
                Data_DayTro.clear();
            } catch (Exception e) {
                System.out.println("Lỗi update slphong trong daytro");
            }
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql2 = "SELECT * FROM daytro where madinhdanh = ?";
                PreparedStatement ps = connection.prepareStatement(sql2);
                ps.setString(1, data.getUsername());
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Data_DayTro.add(new DayTro(resultSet.getString("madaytro"), resultSet.getString("ten"), resultSet.getInt("SLphong"), resultSet.getString("diachi"), resultSet.getString("madinhdanh")));
                }
                ThemThanhCong();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public boolean ChuaNhapDayDuThongTin() {
        if (TextField_MaPhongTro.getText().isEmpty() || TextField_TenPhongTro.getText().isEmpty() || TextField_GiaPhongTro.getText().isEmpty() || TextField_SLPhongNguoiTrongPhong.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
            return false;
        }
        if(!TextField_GiaPhongTro.getText().matches("^[0-9]*$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập giá phòng là số");
            alert.showAndWait();
            return false;
        }
        return true;
    }

        @Override
    public void initialize (URL url, ResourceBundle resourceBundle){
    }
    public boolean ThemThanhCong() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thêm Thành Công");
        alert.setHeaderText("Bạn đã thêm thành công");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }
}
