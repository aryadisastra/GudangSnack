/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conn.Conn;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import model.MBarang;

/**
 * FXML Controller class
 *
 * @author TRISNA NURDIANA
 */
public class EditBarangController implements Initializable {

    String id;
    @FXML
    private AnchorPane APBarang;
    @FXML
    private TextField TFIdBarang;
    @FXML
    private TextField TFNamaBarang;
    @FXML
    private TextArea TADeskripsi;
    @FXML
    private TextField TFHargaBeli;
    @FXML
    private TextField TFHargaJual;
    @FXML
    private TextField TFStock;
    @FXML
    private ComboBox<String> CBSatuan;
    @FXML
    private DatePicker DEks;
    @FXML
    private ComboBox<String> CBSuplier;
    @FXML
    private Button BEdit;
    PreparedStatement ps;
    Conn con = new Conn();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dateFormat();
    }   
    public void setText(String value)
    {
        this.id = value;
        start();
    }
    @FXML
    private void actionEdit(ActionEvent event) 
    {
        
    }
    public void start()
    {
        MBarang  m = new MBarang();
        try
        {
            String sql = "select *,year(tglEks) as year,month(tglEks) as month, dayOfMonth(tglEks) as day from barang where idBarang='"+id+"'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            if(rs.next())
            {
                TFIdBarang.setText(rs.getString("idBarang"));
                TFNamaBarang.setText(rs.getString("namaBarang"));
                TADeskripsi.setText(rs.getString("deskripsi"));
                TFHargaBeli.setText(rs.getString("hargaBeli"));
                TFHargaJual.setText(rs.getString("hargaJual"));
                TFStock.setText(rs.getString("stock"));
                CBSatuan.getItems().add(rs.getString("satuan"));
                CBSatuan.getSelectionModel().select(rs.getString("satuan"));
                Integer year,month,day;
                year = Integer.parseInt(rs.getString("year"));
                month = Integer.parseInt(rs.getString("month"));
                day = Integer.parseInt(rs.getString("day"));
                DEks.setValue(LocalDate.of(year, month, day));
                CBSuplier.getItems().add(rs.getString("noPemasok"));
                CBSuplier.getSelectionModel().select(0);
            }
        }
        catch(Exception e)
        {e.printStackTrace();}
    }
    public void dateFormat()
    {
        
                StringConverter<LocalDate> converter = new StringConverter<LocalDate>(){
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    @Override
                    public String toString(LocalDate date) {
                        if(date != null)
                        {
                            return dateFormatter.format(date);
                        }
                        else
                        {
                            return"";
                        }
                    }

                    @Override
                    public LocalDate fromString(String string) {
                        if(string != null && !string.isEmpty())
                        {
                            return LocalDate.parse(string, dateFormatter);
                        }
                        else
                        {
                            return null;
                        }
                    }
                    
                };
                DEks.setConverter(converter);
    }
    
}
