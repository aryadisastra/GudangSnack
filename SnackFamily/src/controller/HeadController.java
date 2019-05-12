/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author TRISNA NURDIANA
 */
public class HeadController implements Initializable {

    private final String beranda ="Beranda";
    private final String barang ="Daftar Barang"; 
    private final String pelanggan ="Daftar Pelanggan"; 
    private final String suplier ="Daftar Suplier"; 
    private final String penjualan ="Penjualan"; 
    private final String pembelian ="Pembelian";  
    private final String tunggak ="Tunggakan"; 
    private final String settings ="Pengaturan";
    @FXML
    private HBox PBeranda;
    @FXML
    private HBox PJual;
    @FXML
    private HBox PDaftarBarang;
    @FXML
    private HBox PDaftarSuplier;
    @FXML
    private HBox PDaftarPelanggan;
    @FXML
    private HBox PTunggak;
    @FXML
    private HBox PSettings;
    @FXML
    private Text TTitle;
    @FXML
    private ScrollPane SPUtama;
    @FXML
    private HBox PBeli;
    @FXML
    private Text lblnama;

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
        try
        {
    
            TTitle.setText(beranda);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/beranda.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void moveBeranda(MouseEvent event) 
    {
        try
        {
            TTitle.setText(beranda);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/beranda.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void moveJual(MouseEvent event) 
    {
         try
        {
            TTitle.setText(penjualan);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/jual.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void moveBeli(MouseEvent event) 
    {
        
        try
        {
            TTitle.setText(pembelian);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/beli.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void moveBarang(MouseEvent event) 
    {
        try
        {
            TTitle.setText(barang);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/barang.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void moveSuplier(MouseEvent event) 
    {
        
        try
        {
            TTitle.setText(suplier);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/suplier.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void movePelanggan(MouseEvent event) 
    {
        
        try
        {
            TTitle.setText(pelanggan);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/pelanggan.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void moveTunggak(MouseEvent event) 
    {
        try
        {
            TTitle.setText(tunggak);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/tunggakan.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void moveSettings(MouseEvent event) 
    {
        try
        {
            TTitle.setText(settings);
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/settings.fxml"));
            SPUtama.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }
    
    public void ambilnama(String nama)
    {
        this.lblnama.setText(nama);
    }
    
}
