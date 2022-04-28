package Controller;

import Main.DatabaseConnection;
import Main.Main;
import Main.KhachHang;
import Main.DayTro;
import Main.PhongTro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ManHinhChinh_Controller implements Initializable {
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
    private ScrollPane ManHinhChinh;
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
            loaddata_KhachHang();
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
        Data_DayTro.clear();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "SELECT * FROM daytro";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Data_DayTro.add(new DayTro(resultSet.getString("madaytro"), resultSet.getString("ten"), resultSet.getInt("SLphong"), resultSet.getString("diachi")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableView_DayTro.setItems(Data_DayTro);
    }

    public void setcelltable_phongtro() {
        TenPhongTro.setCellValueFactory(new PropertyValueFactory<PhongTro, String>("tenPhongTro"));
        MaPhongTro.setCellValueFactory(new PropertyValueFactory<PhongTro, String>("maPhongTro"));
        GiaPhongTro.setCellValueFactory(new PropertyValueFactory<PhongTro, String>("giaPhongTro"));
        SoNguoiTro.setCellValueFactory(new PropertyValueFactory<PhongTro, Integer>("soNguoiTro"));
    }
    public void loaddata_phongtro() {
        Data_PhongTro.clear();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "SELECT * FROM phongtro";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Data_PhongTro.add(new PhongTro(resultSet.getString("maphong"), resultSet.getString("tenphong"), resultSet.getInt("songuoitro"), resultSet.getString("giaphong")));
            }
        } catch (Exception e) {
            System.out.println("Lỗi loaddata_phongtro");
        }
        tableView_PhongTro.setItems(Data_PhongTro);
    }

        public void setcelltable_KhachHang() {
        try{
            HovaTen.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("hoTenKhachHang"));
            CCCD.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("CCCD"));
            GioiTinh.setCellValueFactory(new PropertyValueFactory<KhachHang, Boolean>("GT"));
            SDT.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("SDT"));
            QueQuan.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("queQuan"));
            NgayBatDauO.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("ngayBatDauO"));
        }catch (Exception e){
            System.out.println("Lỗi setcelltable_KhachHang");
        }
    }
    public void loaddata_KhachHang() {
        Data_KhachHang.clear();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "SELECT * FROM KHACHHANG";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Data_KhachHang.add(new KhachHang(resultSet.getString("hoten"),resultSet.getString("CCCD") , resultSet.getBoolean("GT"), resultSet.getString("SDT"), resultSet.getString("quequan"), resultSet.getString("ngaybdo")));
            }
        } catch (Exception e) {
            System.out.println("Lỗi loaddata_khachhang");
        }
        tableview_KhachHang.setItems(Data_KhachHang);
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

    //loi xoa day tro
    @FXML
    private void Button_XoaDayTroOnAction(ActionEvent event) throws IOException {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String sql = "DELETE FROM daytro WHERE madaytro = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tableView_DayTro.getSelectionModel().getSelectedItem().getMaDayTro());
            tableView_DayTro.getItems().remove(tableView_DayTro.getSelectionModel().getSelectedItem());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi xóa day tro");
        }
    }

    public void Button_ThemPhongTroOnAction(ActionEvent event) {
    }

    public void Button_SuaPhongTroOnAction(ActionEvent event) {
    }

    public void Button_XoaPhongTroOnAction(ActionEvent event) {
    }

    public void Button_ThemKhachThueOnAction(ActionEvent event) {
    }

    public void Button_SuaKhachThueOnAction(ActionEvent event) {
    }

    public void Button_XoaKhachThueOnAction(ActionEvent event) {
    }
}
