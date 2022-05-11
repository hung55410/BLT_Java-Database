package Controller;

import Main.DatabaseConnection;
import Main.KhachHang;
import Main.PhongTro;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ThemKhachThue_Controller {
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
    @FXML
    private DatePicker date;

    @FXML
    private Label error_ChuaNhapDayDuThongTin;

    public void setItems(ObservableList<KhachHang> Data_KhachHang) {
        this.Data_KhachHang = Data_KhachHang;
    }

    public void setItems1(ObservableList<PhongTro> Data_PhongTro) {
        this.Data_PhongTro = Data_PhongTro;
    }

    @FXML
    void Button_CancelOnAction_ThemKhachThue(ActionEvent event) {
        Stage stage = (Stage) GiaoDienThemKhachThue.getScene().getWindow();
        stage.close();
    }

    public PhongTro Selected_PhongTro;
    private String maphong;
    private String madaytro;

    public void LayDataTuPhongTro(PhongTro Data_PhongTro) {
        Selected_PhongTro = Data_PhongTro;
        maphong = Selected_PhongTro.getMaPhongTro();
        madaytro = Selected_PhongTro.getMaDayTro();
    }

    @FXML
    void Button_ConfirmOnAction_ThemKhachThue(ActionEvent event) {
        int x = 0;
        if (ChuaNhapDayDuThongTin()) {
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
                preparedStatement.setString(6, date.getEditor().getText());
                preparedStatement.setString(7, maphong);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                Data_KhachHang.add(new KhachHang(TextField_HovaTen_KhachThue.getText(), TextField_CCCD_CMND_KhachThue.getText(), RadioButton_GioiTinh, TextField_SDT_KhachThue.getText(), TextField_QueQuan_KhachThue.getText(), date.getEditor().getText(), maphong));
                Stage stage = (Stage) GiaoDienThemKhachThue.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            x = 1;
        }
        if (x == 1) {
            try {
                String sql1 = "Update phongtro set songuoitro = songuoitro + 1 where maphong = ?";
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql1);
                ps.setString(1, maphong);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("Lỗi update songuoitro trong phongtro");
            }
            try {
                String sql2 = "SELECT * FROM phongtro where madaytro = ?";
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql2);
                ps.setString(1, madaytro);
                ResultSet rs = ps.executeQuery();
                Data_PhongTro.clear();
                while (rs.next()) {
                    Data_PhongTro.add(new PhongTro(rs.getString("maphong"), rs.getString("tenphong"), rs.getInt("songuoitro"), rs.getString("giaphong"),rs.getString("madaytro")));
                }
                ThemThanhCong();
            } catch (Exception e) {
                System.out.println("Lỗi select them khach htue ");
            }
        }
    }

    public boolean ChuaNhapDayDuThongTin() {
        if (TextField_CCCD_CMND_KhachThue.getText().isEmpty() || TextField_HovaTen_KhachThue.getText().isEmpty() || TextField_SDT_KhachThue.getText().isEmpty() || TextField_QueQuan_KhachThue.getText().isEmpty() || date.getEditor().getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
            return false;
        }
        if(!TextField_CCCD_CMND_KhachThue.getText().matches("^[0-9]*$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập CCCD_CMND là số");
            alert.showAndWait();
            return false;
        }
        if(!TextField_SDT_KhachThue.getText().matches("^[0-9]*$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập số điện thoại là số");
            alert.showAndWait();
            return false;
        }
        if( TextField_SDT_KhachThue.getText().length() != 10){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập số điện thoại là 10 số");
            alert.showAndWait();
            return false;
        }
        return true;
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

