/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import conn.Conn;
import crud.Create;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.MBarang;
import model.MSuplier;
import crud.Read;
import crud.Create;
import crud.Update;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author TRISNA NURDIANA
 */
public class SuplierController implements Initializable {
    
    String tambah_supplier = "Tambah Pemasok";
    String edit_Supplier = "Edit Pemasok";
    String hapus_Supplier = "Hapus Pemasok";
    
    Connection con;
    Statement stm;
    ResultSet rs;
    
    Read read = new Read();
    Create crete = new Create();
    Update update = new Update();
    ObservableList<MSuplier> listDataPemasok;
    

    @FXML
    private TextField TFNama;
    @FXML
    private TextField TFKontak;
    @FXML
    private TextArea TAAlamat;
    @FXML
    private Button BTambah;
    Create create = new Create();
    @FXML
    private AnchorPane APBarang;
    @FXML
    private VBox lblpemasok;
    @FXML
    private JFXTextField TFSearch;
    @FXML
    private TableView<MSuplier> TVpemasok;
    @FXML
    private TableColumn<MSuplier, String> colno;
    @FXML
    private TableColumn<MSuplier, String> colnama;
    @FXML
    private TableColumn<MSuplier, String> colalamat;
    @FXML
    private TableColumn<MSuplier, String> colkontak;
    @FXML
    private JFXButton Bedit;
    @FXML
    private JFXButton Bhapus;
    @FXML
    private Label lblid;
    @FXML
    private Text form;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Conn db = new Conn();
        db.config();
        con = db.con;
        stm = db.stm;
        BTambah.setText(tambah_supplier);
        Bedit.setText(edit_Supplier);
        Bhapus.setText(hapus_Supplier);
        Bedit.setVisible(false);
        Bedit.setDisable(true);
        Bhapus.setVisible(false);
        Bhapus.setDisable(true);
        selectTable();
        actionSelect();
    }    
    @FXML
    private void actionTambah(ActionEvent event)
    {
        MSuplier m = new MSuplier();
        m.setNama(TFNama.getText());
        m.setAlamat(TAAlamat.getText());
        m.setKontak(TFKontak.getText());
        create.insertSuplier(m);
        selectTable();
        actionSelect();
        TFKontak.setText("");
        TFNama.setText("");
        TAAlamat.setText("");
        TFSearch.setText("");
    }

    @FXML
    private void rilissearch(KeyEvent event) {
        try{
            String sql = "Select * from pemasok where nama Like '%"+TFSearch.getText()+"%' OR alamat Like '%"+TFSearch.getText()+"%' OR kontak Like '%"+TFSearch.getText()+"'%";
            
        }catch(Exception e)
        {
            
        }
    }

    @FXML
    private void kliktabel(MouseEvent event) {
        try{
            MSuplier ambil = TVpemasok.getSelectionModel().getSelectedItems().get(0);
            TFNama.setText(ambil.getNama());
            TFKontak.setText(ambil.getKontak());
            TAAlamat.setText(ambil.getAlamat());
            lblid.setText(ambil.getid());
            form.setText("Form Edit Dan Hapus Pemasok");
            BTambah.setVisible(false);
            BTambah.setDisable(true);
            Bhapus.setVisible(true);
            Bhapus.setDisable(false);
            Bedit.setDisable(false);
            Bedit.setVisible(true);
        }catch(Exception e)
        {
            
        }
    }
    
    public void selectTable()
    {
        TVpemasok.setPlaceholder(new Label("DATA TIDAK DITEMUKAN"));
        colno.setCellValueFactory(
                (TableColumn.CellDataFeatures<MSuplier, String> cellData) ->
                        cellData.getValue().NoPro());
        colnama.setCellValueFactory(
                (TableColumn.CellDataFeatures<MSuplier, String> cellData) ->
                        cellData.getValue().NamaPro());
        colalamat.setCellValueFactory(
                (TableColumn.CellDataFeatures<MSuplier, String> cellData) ->
                        cellData.getValue().AlamatPro());
        colkontak.setCellValueFactory(
                (TableColumn.CellDataFeatures<MSuplier, String> cellData) ->
                        cellData.getValue().KontakPro());
        /*colStock.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().StockPro());
        colTglEks.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().TglEksPro());*/
        listDataPemasok = FXCollections.observableArrayList();
        TVpemasok.getSelectionModel().clearSelection();
    }
    public void actionSelect()
    {
        listDataPemasok = read.getAllSupplier();
        TVpemasok.setItems(listDataPemasok);
    }

    @FXML
    private void actionEdit(ActionEvent event) {
        try{
            String sql = "Update pemasok set nama = '"+TFNama.getText()+"', alamat = '"+TAAlamat.getText()+"', kontak = '"+TFKontak.getText()+"' Where id_pemasok = '"+lblid.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
            actionSelect();
            selectTable();
            form.setText("Form Tambah Pemasok");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
            e.printStackTrace();
        }
        BTambah.setVisible(true);
        BTambah.setDisable(false);
        Bedit.setVisible(false);
        Bedit.setDisable(true);
        Bhapus.setDisable(true);
        Bhapus.setVisible(false);
        TFKontak.setText("");
        TFNama.setText("");
        TAAlamat.setText("");
        TFSearch.setText("");
    }

    @FXML
    private void actionHapus(ActionEvent event) {
        try{
            String sql = "Delete from pemasok where id_pemasok = '"+lblid.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            actionSelect();
            selectTable();
            form.setText("Dorm Tambah Pemasok");
            
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hapus Data Gagal");
        }
        BTambah.setVisible(true);
        BTambah.setDisable(false);
        Bedit.setVisible(false);
        Bedit.setDisable(true);
        Bhapus.setDisable(true);
        Bhapus.setVisible(false);
        TFKontak.setText("");
        TFNama.setText("");
        TAAlamat.setText("");
        TFSearch.setText("");
    }
}
