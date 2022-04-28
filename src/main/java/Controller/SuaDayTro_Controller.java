package Controller;

import Main.DatabaseConnection;
import Main.DayTro;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class SuaDayTro_Controller implements Initializable {


    @FXML
    private AnchorPane GiaoDienSuaDayTro;

    @FXML
    private TextField TextField_SuaDiaChi;

    @FXML
    private TextField TextField_SuaMaDayTro;

    @FXML
    private TextField TextField_SuaSLphong;

    @FXML
    private TextField TextField_SuaTenDayTro;

    private DayTro Selected_DayTro;
    private ObservableList<DayTro> Data_DayTro;

    public void setItems(ObservableList<DayTro> Data_DayTro) {
        this.Data_DayTro = Data_DayTro;
    }

    @FXML
    void suadaytro1(DayTro Data_DayTro) {
        Selected_DayTro = Data_DayTro;
        TextField_SuaDiaChi.setText(Selected_DayTro.getDiaChi());
        TextField_SuaMaDayTro.setText(Selected_DayTro.getMaDayTro());
        TextField_SuaSLphong.setText(Integer.toString(Selected_DayTro.getSLphong()));
        TextField_SuaTenDayTro.setText(Selected_DayTro.getTenDayTro());
    }
    @FXML
    public void Button_ConfirmOnAction_SuaDayTro(ActionEvent event) {
        String sql = "UPDATE daytro SET ten = ? , Slphong = ?, diachi = ? WHERE madaytro = ?";
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, TextField_SuaTenDayTro.getText());
            preparedStatement.setString(2, TextField_SuaSLphong.getText());
            preparedStatement.setString(3, TextField_SuaDiaChi.getText());
            preparedStatement.setString(4, TextField_SuaMaDayTro.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            Data_DayTro.set(Data_DayTro.indexOf(Selected_DayTro), new DayTro(TextField_SuaMaDayTro.getText(), TextField_SuaTenDayTro.getText(), Integer.parseInt(TextField_SuaSLphong.getText()), TextField_SuaDiaChi.getText()));
            Stage stage = (Stage) GiaoDienSuaDayTro.getScene().getWindow();
            stage.close();
            System.out.println("Update thanh cong");
        } catch (Exception e) {
            System.out.println("Update that bai");
        }
    }
    @FXML
     void Button_CancelOnAction_SuaDayTro(ActionEvent event) {
        Stage stage = (Stage) GiaoDienSuaDayTro.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
