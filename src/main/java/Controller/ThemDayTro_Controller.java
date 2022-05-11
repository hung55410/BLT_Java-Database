//package Controller;
//
//import Main.DatabaseConnection;
//import Main.daytro;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//public class ThemDayTro_Controller implements Initializable {
//    @FXML
//    private AnchorPane GiaoDienThemPhongTro;
//    @FXML
//    private TextField inputdiachi;
//
//    @FXML
//    private TextField inputmaday;
//
//    @FXML
//    private TextField inputslphong;
//
//    @FXML
//    private TextField inputtenday;
//    @FXML
//    private VBox tableView;
//
//    @FXML
//    private Label error_diachi;
//
//    @FXML
//    private Label error_maday;
//
//    @FXML
//    private Label error_slphong;
//
//    @FXML
//    private Label error_tenday;
//    private ObservableList<daytro> data_daytro;
//
//    public void setItems(ObservableList<daytro> data_daytro) {
//        this.data_daytro = data_daytro;
//    }
//
//    @FXML
//    void submit(ActionEvent event)  throws IOException {
//        boolean ismadaytroempty = Validation.TextFieldVallidation.isTextFieldnotEmpty(inputmaday, error_maday, "Mã day tro không được để trống");
//        boolean istendaytroempty = Validation.TextFieldVallidation.isTextFieldnotEmpty(inputtenday, error_tenday, "Tên day tro không được để trống");
//        boolean isslphongempty = Validation.TextFieldVallidation.isTextFieldTypeNumber(inputslphong, error_slphong, "Số lượng phòng không được để trống");
//        boolean isdiachiempty = Validation.TextFieldVallidation.isTextFieldnotEmpty(inputdiachi, error_diachi, "Địa chỉ không được để trống");
//        if (ismadaytroempty && istendaytroempty && isslphongempty && isdiachiempty) {
//            String sql = "INSERT INTO daytro(madaytro,ten,diachi,SlPhong,madinhdanh) VALUES(?,?,?,?,'hung')";
//            String madaytro = inputmaday.getText();
//            int slphong = Integer.parseInt(inputslphong.getText());
//            String ten = inputtenday.getText();
//            String diachi = inputdiachi.getText();
//            try {
//                DatabaseConnection databaseConnection = new DatabaseConnection();
//                Connection connection = databaseConnection.getConnection();
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, madaytro);
//                preparedStatement.setString(2, ten);
//                preparedStatement.setString(3, diachi);
//                preparedStatement.setInt(4, slphong);
//                preparedStatement.executeUpdate();
//                preparedStatement.close();
//                data_daytro.add(new daytro(inputmaday.getText(), inputtenday.getText(), Integer.parseInt(inputslphong.getText()), inputdiachi.getText()));
//                Stage stage = (Stage) GiaoDienThemPhongTro.getScene().getWindow();
//                stage.close();
//            } catch (SQLException e) {
//                System.out.println("Loi them day tro");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//    }
//
//
//}
package Controller;

import Main.DatabaseConnection;
import Main.DayTro;
import Main.PhongTro;
import Main.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class ThemDayTro_Controller implements Initializable {
    @FXML
    private AnchorPane GiaoDienThemDayTro;

    @FXML
    private TextField TextField_DiaChi;

    @FXML
    private TextField TextField_MaDayTro;
    @FXML
    private TextField TextField_SLphong;
    @FXML
    private TextField TextField_TenDayTro;
    @FXML
    private Label error_ChuaNhapDayDuThongTin;
    private ObservableList<DayTro> Data_DayTro;

    public void setItems(ObservableList<DayTro> Data_DayTro) {
        this.Data_DayTro = Data_DayTro;
    }

    User data = User.getInstance();

    //    private String username;
//    public void LayDataTuUser(User Data_User){
//        Selected_User = Data_User;
//        username = Selected_User.getUsername();
//    }
    @FXML
    void Button_ConfirmOnAction_DayTro(ActionEvent event) throws IOException {
        if (ChuaNhapDayDuThongTin()) {
            String sql = "INSERT INTO daytro(madaytro,ten,diachi,SlPhong,madinhdanh) VALUES(?,?,?,?,?)";
            String madaytro = TextField_MaDayTro.getText();
            int slphong = 0;
            String ten = TextField_TenDayTro.getText();
            String diachi = TextField_DiaChi.getText();
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, madaytro);
                preparedStatement.setString(2, ten);
                preparedStatement.setString(3, diachi);
                preparedStatement.setInt(4, slphong);
                preparedStatement.setString(5, data.getUsername());
                preparedStatement.executeUpdate();
                preparedStatement.close();
                Data_DayTro.add(new DayTro(TextField_MaDayTro.getText(), TextField_TenDayTro.getText(), Integer.parseInt(TextField_SLphong.getText()), TextField_DiaChi.getText(), data.getUsername()));
                Stage stage = (Stage) GiaoDienThemDayTro.getScene().getWindow();
                stage.close();
                ThemThanhCong();
            } catch (SQLException e) {
                System.out.println("Loi them day tro");
                e.printStackTrace();
            }
        }
    }
    public boolean ChuaNhapDayDuThongTin() {
        if(TextField_MaDayTro.getText().isEmpty() || TextField_TenDayTro.getText().isEmpty() || TextField_DiaChi.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
            return false;
        }
        return true;
    }
    @FXML
    void Button_CancelOnAction_DayTro(ActionEvent event) {
        Stage stage = (Stage) GiaoDienThemDayTro.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

