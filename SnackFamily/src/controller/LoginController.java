package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import conn.Conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author viugraph
 */
public class LoginController implements Initializable {
    Stage stage = new Stage();
    Stage klos = new Stage();
    Scene scene;
    String nama;
    Connection con;
    Statement stm;
    ResultSet rs;
    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btnmasuk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Conn db = new Conn();
        db.config();
        con = db.con;
        stm = db.stm;
        
    }    

    @FXML
    private void txtusernameaction(ActionEvent event) {
         try{
            String sql = "Select*from petugas where username = '"+txtusername.getText()+"' AND password = '"+txtpassword.getText()+"'";
            rs =  stm.executeQuery(sql);
            if(rs.next())
            {
            FXMLLoader LoaderA = new FXMLLoader();
            LoaderA.setLocation(getClass().getResource("/fxml/head.fxml"));
            LoaderA.load();
                Node node = (Node)event.getSource();
                            klos = (Stage) node.getScene().getWindow();
                            klos.close();
                            HeadController hedkon= LoaderA.getController();
                            hedkon.ambilnama(rs.getString("nama"));
                            Parent p = LoaderA.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(p));
                            stage.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Gagal Masuk!!");
                alert.setContentText("Anda Mugkin Tidak Memiliki Hak Akses Untuk Masuk Ke sini!");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.getAlertType();
            alert.alertTypeProperty();
        }
    }

    @FXML
    private void txtpasswordaction(ActionEvent event) {
         try{
            String sql = "Select*from petugas where username = '"+txtusername.getText()+"' AND password = '"+txtpassword.getText()+"'";
            rs =  stm.executeQuery(sql);
            if(rs.next())
            {
            FXMLLoader LoaderA = new FXMLLoader();
            LoaderA.setLocation(getClass().getResource("/fxml/head.fxml"));
            LoaderA.load();
                Node node = (Node)event.getSource();
                            klos = (Stage) node.getScene().getWindow();
                            klos.close();
                            HeadController hedkon= LoaderA.getController();
                            hedkon.ambilnama(rs.getString("nama"));
                            Parent p = LoaderA.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(p));
                            stage.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Gagal Masuk!!");
                alert.setContentText("Anda Mugkin Tidak Memiliki Hak Akses Untuk Masuk Ke sini!");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.getAlertType();
            alert.alertTypeProperty();
        }
    }

    @FXML
    private void btnmasukaction(ActionEvent event) {
    try{
            String sql = "Select*from petugas where username = '"+txtusername.getText()+"' AND password = '"+txtpassword.getText()+"'";
            rs =  stm.executeQuery(sql);
            if(rs.next())
            {
            FXMLLoader LoaderA = new FXMLLoader();
            LoaderA.setLocation(getClass().getResource("/fxml/head.fxml"));
            LoaderA.load();
                Node node = (Node)event.getSource();
                            klos = (Stage) node.getScene().getWindow();
                            klos.close();
                            HeadController hedkon= LoaderA.getController();
                            hedkon.ambilnama(rs.getString("nama"));
                            Parent p = LoaderA.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(p));
                            stage.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Gagal Masuk!!");
                alert.setContentText("Anda Mugkin Tidak Memiliki Hak Akses Untuk Masuk Ke sini!");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.getAlertType();
            alert.alertTypeProperty();
        }
    }
    
   
    
}
