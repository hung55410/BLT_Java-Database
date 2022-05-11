package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Main.Main;
import Main.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DangKy_Controller {
    @FXML
    private AnchorPane GiaoDienDangKy;
    @FXML
    private TextField txt_TenDangNhap;
    @FXML
    private PasswordField txt_MatKhau;
    @FXML
    private TextField txt_HoTen;
    @FXML
    private DatePicker txt_NgaySinh;
    @FXML
    private RadioButton rb_Nam;
    @FXML
    private RadioButton rb_Nu;
    @FXML
    private TextField txt_DienThoai;
    @FXML
    private TextField txt_DiaChi;
    @FXML
    private Label label_ThongBao;

    @FXML
    private void Button_BackLoginOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) GiaoDienDangKy.getScene().getWindow();
            stage.close();
            stage.setTitle("Quản lý phòng trọ");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GiaoDienDangNhap.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    boolean info() {
        if (txt_TenDangNhap.getText().isEmpty() || txt_MatKhau.getText().isEmpty() || txt_HoTen.getText().isEmpty() || txt_NgaySinh.getValue() == null || txt_DienThoai.getText().isEmpty() || txt_DiaChi.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    String gioitinh() {
        if (rb_Nam.isSelected() == true) {
            return "Nam";
        } else {
            return "Nu";
        }
    }

    @FXML
    public void Button_DangKyOnAction(ActionEvent event) {
        if (info() == true) {
            String sql = "INSERT INTO CHUTRO(madinhdanh,matkhau,hoten,GT,sdt,diachi,ngaysinh) VALUES(?,?,?,?,?,?,?)";
            String madinhdanh = txt_TenDangNhap.getText();
            String matkhau = txt_MatKhau.getText();
            String hoten = txt_HoTen.getText();
            String ngaysinh = txt_NgaySinh.getValue().toString();
            String GT = gioitinh();
            String sdt = txt_DienThoai.getText();
            String diachi = txt_DiaChi.getText();
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, madinhdanh);
                preparedStatement.setString(2, matkhau);
                preparedStatement.setString(3, hoten);
                preparedStatement.setString(4, GT);
                preparedStatement.setString(5, sdt);
                preparedStatement.setString(6, diachi);
                preparedStatement.setString(7, ngaysinh);
                preparedStatement.executeUpdate();
                Stage stage = (Stage) GiaoDienDangKy.getScene().getWindow();
                stage.close();
                stage.setTitle("Quản lý phòng trọ");

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("GiaoDienDangNhap.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage1 = new Stage();
                stage1.setScene(scene);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setContentText("Đăng ký thành công");
                alert.setHeaderText(null);
                alert.showAndWait();

                stage1.show();
            } catch (SQLException | IOException ex) {
                label_ThongBao.setText("Tên đăng nhập đã tồn tại! Vui lòng nhập lại");
                System.out.println("Loi dang ki");
                ex.printStackTrace();
            }
        } else if (info() == false) {
            label_ThongBao.setText("Vui lòng nhập đầy đủ thông tin");
        }
    }
}

