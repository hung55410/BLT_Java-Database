package Controller;

import Main.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManHinhChinh_Controller implements Initializable {
    @FXML
    public ScrollPane ManHinhChinh;
    @FXML
    private TableColumn<PhongTro, String> TenPhongTro;
    @FXML
    private TableColumn<PhongTro, String> MaPhongTro;
    @FXML
    private TableColumn<PhongTro, Integer> SoNguoiTro;
    @FXML
    private TableColumn<PhongTro, String> GiaPhongTro;
    @FXML
    private TableView<PhongTro> tableView_PhongTro;
    @FXML
    private TableColumn<KhachHang, String> HovaTen;
    @FXML
    private TableColumn<KhachHang, String> CCCD;
    @FXML
    private TableColumn<KhachHang, String> SDT;
    @FXML
    private TableColumn<KhachHang, String> QueQuan;
    @FXML
    private TableColumn<KhachHang, String> NgayBatDauO;
    @FXML
    private TableColumn<KhachHang, Boolean> GioiTinh;
    @FXML
    private TableView<KhachHang> tableview_KhachHang;
    @FXML
    private TableColumn<DayTro, Integer> SLphong;
    @FXML
    private TableColumn<DayTro, String> DiaChi;
    @FXML
    private TableColumn<DayTro, String> MaDayTro;
    @FXML
    private TableColumn<DayTro, String> TenDayTro;
    @FXML
    public TableView<DayTro> tableView_DayTro;
    private ObservableList<DayTro> Data_DayTro;
    private ObservableList<PhongTro> Data_PhongTro;
    private ObservableList<KhachHang> Data_KhachHang;
    User data = User.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            Data_DayTro = FXCollections.observableArrayList();
            setcelltable_daytro();
            loaddata_daytro();
            Data_PhongTro = FXCollections.observableArrayList();
            setcelltable_phongtro();
            loaddata_phongtro();
            Data_KhachHang = FXCollections.observableArrayList();
            setcelltable_KhachHang();
            loaddata_khachhang();
        } catch (Exception e) {
            System.out.println("Loi initialize");
        }
    }

    public void setcelltable_daytro() {
        MaDayTro.setCellValueFactory(new PropertyValueFactory<DayTro, String>("maDayTro"));
        TenDayTro.setCellValueFactory(new PropertyValueFactory<DayTro, String>("tenDayTro"));
        DiaChi.setCellValueFactory(new PropertyValueFactory<DayTro, String>("diaChi"));
        SLphong.setCellValueFactory(new PropertyValueFactory<DayTro, Integer>("SLphong"));
    }

    public void loaddata_daytro() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "SELECT * FROM daytro where madinhdanh = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getUsername());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Data_DayTro.add(new DayTro(resultSet.getString("madaytro"), resultSet.getString("ten"), resultSet.getInt("SLphong"), resultSet.getString("diachi"), resultSet.getString("madinhdanh")));
            }
        } catch (Exception e) {
            System.out.println("Loi loaddata_daytro");
            e.printStackTrace();
        }
        tableView_DayTro.setItems(Data_DayTro);
        tableView_DayTro.getSelectionModel().selectFirst();
    }

    public void loaddata_phongtro() {
        tableView_DayTro.setOnMouseClicked(e -> {
            String check = tableView_DayTro.getSelectionModel().getSelectedItem().getMaDayTro();
            try {
                Data_PhongTro = FXCollections.observableArrayList();
                setcelltable_phongtro();
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM phongtro where madaytro = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, check);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Data_PhongTro.add(new PhongTro(resultSet.getString("maphong"), resultSet.getString("tenphong"), resultSet.getInt("songuoitro"), resultSet.getString("giaphong"), resultSet.getString("madaytro")));
                }
                if (tableview_KhachHang.getSelectionModel().getSelectedItem() != null) {
                    Data_KhachHang.clear();
                }
            } catch (Exception event) {
                System.out.println("Lỗi loaddata_phongtro");
            }
            tableView_PhongTro.setItems(Data_PhongTro);
            tableView_PhongTro.getSelectionModel().selectFirst();
        });
    }

    public void loaddata_khachhang() {
        tableView_PhongTro.setOnMouseClicked(e -> {
            try {
                String checkmaphong = tableView_PhongTro.getSelectionModel().getSelectedItem().getMaPhongTro();
                Data_KhachHang = FXCollections.observableArrayList();
                setcelltable_KhachHang();
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM KHACHHANG where maphong = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, checkmaphong);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Data_KhachHang.add(new KhachHang(resultSet.getString("hoten"), resultSet.getString("CCCD"), resultSet.getString("GT"), resultSet.getString("SDT"), resultSet.getString("quequan"), resultSet.getString("ngaybdo"), resultSet.getString("maphong")));
                }
            } catch (Exception event1) {
                System.out.println("Lỗi loaddata_khachhang");
            }
            tableview_KhachHang.setItems(Data_KhachHang);
            tableview_KhachHang.getSelectionModel().selectFirst();
        });
    }

    public void setcelltable_phongtro() {
        TenPhongTro.setCellValueFactory(new PropertyValueFactory<PhongTro, String>("tenPhongTro"));
        MaPhongTro.setCellValueFactory(new PropertyValueFactory<PhongTro, String>("maPhongTro"));
        GiaPhongTro.setCellValueFactory(new PropertyValueFactory<PhongTro, String>("giaPhongTro"));
        SoNguoiTro.setCellValueFactory(new PropertyValueFactory<PhongTro, Integer>("soNguoiTro"));
    }

    public void setcelltable_KhachHang() {
        HovaTen.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("hoTenKhachHang"));
        CCCD.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("CCCD"));
        GioiTinh.setCellValueFactory(new PropertyValueFactory<KhachHang, Boolean>("GT"));
        SDT.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("SDT"));
        QueQuan.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("queQuan"));
        NgayBatDauO.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("ngayBatDauO"));
    }

    @FXML
    private void Button_ThemDayTroOnAction(ActionEvent event) throws IOException {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienThemDayTro.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ThemDayTro_Controller themDayTro_controller = fxmlLoader.getController();
            themDayTro_controller.setItems(tableView_DayTro.getItems());
            stage.setTitle("Thêm dãy trọ ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Lỗi them day tro");
        }
    }
    @FXML
    private void Button_SuaDayTroOnAction(ActionEvent event) throws IOException {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienSuaDayTro.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            SuaDayTro_Controller suaDayTro_controller = fxmlLoader.getController();
            suaDayTro_controller.suadaytro1(tableView_DayTro.getSelectionModel().getSelectedItem());
            suaDayTro_controller.setItems(tableView_DayTro.getItems());
            stage.setTitle("Sửa dãy trọ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Lỗi sua day tro");
        }
    }

    @FXML
    private void Button_XoaDayTroOnAction(ActionEvent event) throws IOException {
        if (Xoa_DayTro()) {
            String sql = tableView_DayTro.getSelectionModel().getSelectedItem().getMaDayTro();
            for (int i = 0; i < tableView_PhongTro.getItems().size(); i++) {
                if (tableView_PhongTro.getItems().get(i).getMaDayTro().equals(sql)) {
                    try {
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        Connection connection = databaseConnection.getConnection();
                        String sql1 = "DELETE FROM Khachhang WHERE maphong = ?";
                        PreparedStatement ps = connection.prepareStatement(sql1);
                        ps.setString(1, tableView_PhongTro.getItems().get(i).getMaPhongTro());
                        ps.executeUpdate();
                    } catch (Exception e) {
                        System.out.println("Lỗi xóa khách hàng");
                    }
                    try {
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        Connection connection = databaseConnection.getConnection();
                        String sql2 = "DELETE FROM Phongtro WHERE maphong = ?";
                        PreparedStatement ps = connection.prepareStatement(sql2);
                        ps.setString(1, tableView_PhongTro.getItems().get(i).getMaPhongTro());
                        ps.executeUpdate();
                    } catch (Exception e) {
                        System.out.println("Lỗi xóa phòng");
                    }
                }
            }
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql3 = "DELETE FROM daytro WHERE madaytro = ?";
                PreparedStatement ps = connection.prepareStatement(sql3);
                ps.setString(1, tableView_DayTro.getSelectionModel().getSelectedItem().getMaDayTro());
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("Lỗi xóa dãy trọ");
            }
            tableview_KhachHang.getItems().clear();
            tableView_PhongTro.getItems().clear();
            tableView_DayTro.getItems().remove(tableView_DayTro.getSelectionModel().getSelectedItem());
        }
    }

    public void Button_ThemPhongTroOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienThemPhongTro.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ThemPhongTro_Controller themPhongTro_controller = fxmlLoader.getController();
            themPhongTro_controller.LayDataTuDayTro(tableView_DayTro.getSelectionModel().getSelectedItem());
            themPhongTro_controller.setItems(tableView_PhongTro.getItems());
            themPhongTro_controller.setItems1(tableView_DayTro.getItems());
            stage.setTitle("Thêm dãy trọ ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Lỗi them phong tro");
        }
    }

    public void Button_SuaPhongTroOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienSuaPhongTro.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            SuaPhongTro_Controller suaPhongTro_controller = fxmlLoader.getController();
            suaPhongTro_controller.SuaPhongTro(tableView_PhongTro.getSelectionModel().getSelectedItem());
            suaPhongTro_controller.setItems(tableView_PhongTro.getItems());
            stage.setTitle("Sửa phòng trọ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Lỗi sua phong tro");
        }
    }
    public void Button_XoaPhongTroOnAction(ActionEvent event) {
        if (Xoa_PhongTro()) {
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql = "DELETE FROM Khachhang WHERE maphong = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, tableView_PhongTro.getSelectionModel().getSelectedItem().getMaPhongTro());
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("Lỗi xoa phong tro 1");
            }
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql1 = "delete from phongtro where maphong = ?";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setString(1, tableView_PhongTro.getSelectionModel().getSelectedItem().getMaPhongTro());
                tableView_PhongTro.getItems().remove(tableView_PhongTro.getSelectionModel().getSelectedItem());
                ps1.executeUpdate();
            } catch (Exception e) {
                System.out.println("Lỗi xóa phòng tro 2 ");
            }
            try {
                String sql1 = "Update daytro set SLphong = SLphong - 1 where madaytro = ?";
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql1);
                ps.setString(1, tableView_DayTro.getSelectionModel().getSelectedItem().getMaDayTro());
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("Lỗi update slphong trong daytro");
            }
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM daytro where madinhdanh = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, tableView_DayTro.getSelectionModel().getSelectedItem().getMadinhdanh());
                ResultSet resultSet = ps.executeQuery();
                Data_DayTro.clear();
                while (resultSet.next()) {
                    Data_DayTro.add(new DayTro(resultSet.getString("madaytro"), resultSet.getString("ten"), resultSet.getInt("SLphong"), resultSet.getString("diachi"), resultSet.getString("madinhdanh")));
                }
                for (int i = 0; i < Data_DayTro.size(); i++) {
                    if (tableView_PhongTro.getSelectionModel().getSelectedItem() == null) {
                        tableView_DayTro.getSelectionModel().selectFirst();
                    } else if (Data_DayTro.get(i).getMaDayTro().equals(tableView_PhongTro.getSelectionModel().getSelectedItem().getMaDayTro())) {
                        tableView_DayTro.getSelectionModel().select(i);
                    }
                }
            } catch (Exception e) {
                System.out.println("Loi loaddata_daytro");
                e.printStackTrace();
            }
            tableview_KhachHang.getItems().clear();
        }
    }

    public void Button_ThemKhachThueOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienThemKhachThue.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ThemKhachThue_Controller themKhachThue_controller = fxmlLoader.getController();
            themKhachThue_controller.LayDataTuPhongTro(tableView_PhongTro.getSelectionModel().getSelectedItem());
            themKhachThue_controller.setItems(tableview_KhachHang.getItems());
            themKhachThue_controller.setItems1(tableView_PhongTro.getItems());
            stage.setTitle("Thêm Khách Thuê");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Lỗi them khách thuê");
        }
    }
    public void Button_SuaKhachThueOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienSuaKhachThue.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            SuaKhachThue_Controller suaKhachThue_controller = fxmlLoader.getController();
            suaKhachThue_controller.SuaKhachThue(tableview_KhachHang.getSelectionModel().getSelectedItem());
            suaKhachThue_controller.setItems(tableview_KhachHang.getItems());
            stage.setTitle("Sửa Khách Thuê");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Button_XoaKhachThueOnAction(ActionEvent event) {
        if (Xoa_KhacThue()) {
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql = "DELETE FROM khachhang WHERE CCCD = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, tableview_KhachHang.getSelectionModel().getSelectedItem().getCCCD());
                tableview_KhachHang.getItems().remove(tableview_KhachHang.getSelectionModel().getSelectedItem());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Lỗi xóa khách thuê");
            }
            try {
                String sql1 = "Update phongtro set songuoitro = songuoitro - 1 where maphong = ?";
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql1);
                ps.setString(1, tableView_PhongTro.getSelectionModel().getSelectedItem().getMaPhongTro());
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("Lỗi update songuoitro trong phongtro");
            }
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM phongtro where madaytro = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, tableView_DayTro.getSelectionModel().getSelectedItem().getMaDayTro());
                ResultSet resultSet = ps.executeQuery();
                Data_PhongTro.clear();
                while (resultSet.next()) {
                    Data_PhongTro.add(new PhongTro(resultSet.getString("maphong"), resultSet.getString("tenphong"), resultSet.getInt("songuoitro"), resultSet.getString("giaphong"), resultSet.getString("madaytro")));
                }
                for (int i = 0; i < Data_PhongTro.size(); i++) {
                    if (tableview_KhachHang.getSelectionModel().getSelectedItem() == null) {
                        tableView_PhongTro.getSelectionModel().selectFirst();
                    } else if (Data_PhongTro.get(i).getMaPhongTro().equals(tableview_KhachHang.getSelectionModel().getSelectedItem().getMaPhongTro())) {
                        tableView_PhongTro.getSelectionModel().select(i);
                    }
                }
            } catch (Exception e) {
                System.out.println("Loi loaddata_daytro");
                e.printStackTrace();
            }
        }
    }
    public boolean Xoa_KhacThue() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xóa Khách Thuê");
        alert.setHeaderText("Bạn có chắc chắn muốn xóa khách thuê này không?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
    public boolean Xoa_PhongTro() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xóa Phòng Trọ");
        alert.setHeaderText("Bạn có chắc chắn muốn xóa phòng trọ này không?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Xoa_DayTro() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xóa Dãy Trọ");
        alert.setHeaderText("Bạn có chắc chắn muốn xóa dãy trọ này không?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private Button button_QuanLyPhong, button_ThanhToanHoaDon, button_DoanhThu;

    public void button_QuanLyPhongOnAction(ActionEvent event) {
//        try {
//            Stage stage = (Stage) ManHinhChinh.getScene().getWindow();
//            stage.close();
//            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ManHinhChinh1.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            stage.setTitle("Quản lý phòng trọ");
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public void button_ThanhToanHoaDonOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDienThanhToanHoaDon.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Thanh toán hóa đơn");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void button_DoanhThuOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
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
