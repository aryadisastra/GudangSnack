/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import crud.Create;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import model.MBarang;

/**
 * FXML Controller class
 *
 * @author TRISNA NURDIANA
 */
public class TambahBarangController implements Initializable {

    @FXML
    private AnchorPane APBarang;
    @FXML
    private JFXTextField TFIdBarang;
    @FXML
    private JFXTextField TFNamaBarang;
    @FXML
    private JFXTextArea TADeskripsi;
    @FXML
    private JFXTextField TFHargaBeli;
    @FXML
    private JFXTextField TFHargaJual;
    @FXML
    private JFXTextField TFStock;
    @FXML
    private JFXComboBox<String> CBSatuan;
    @FXML
    private JFXDatePicker DEks;
    @FXML
    private JFXComboBox<String> CBSuplier;
    @FXML
    private JFXButton BTambah;
    
    Create create = new Create();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        start();
    }    
    public void start()
    {
        CBSatuan.setEditable(true);
        CBSuplier.setEditable(true);
    }
    @FXML
    private void actionTambah(ActionEvent event)
    {
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        MBarang m = new MBarang();
        m.setId(TFIdBarang.getText());
        m.setNama(TFNamaBarang.getText());
        m.setDeskripsi(TADeskripsi.getText());
        m.setHargaBeli(TFHargaBeli.getText());
        m.setHargaJual(TFHargaJual.getText());
        m.setStock(TFStock.getText());
        m.setSatuan(CBSatuan.getValue());
        m.setTglMasuk(dateFormat.format(date));
        /////////////////////////////////////////////////////////////////////////
        Integer year = DEks.getValue().getYear();
        Integer month = DEks.getValue().getMonthValue();
        Integer day = DEks.getValue().getDayOfMonth();
        String ek = ""+year+"-"+month+"-"+(day);
        System.out.println(ek);
        /////////////////////////////////////////////////////////////////////////
        m.setTglEks(ek);
        m.setPemasok(CBSuplier.getValue());
        create.insertBarang(m);
    }
   
    
}
