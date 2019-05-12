/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crud.Read;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import model.MBarang;

/**
 * FXML Controller class
 *
 * @author TRISNA NURDIANA
 */
public class BarangController implements Initializable {

    @FXML
    private ScrollPane SPBarang;
    @FXML
    private AnchorPane APBarang;
    @FXML
    private TableView<MBarang> TVBarang;
    @FXML
    private TableColumn<MBarang, String> colId;
    @FXML
    private TableColumn<MBarang, String> colNama;
    @FXML
    private TableColumn<MBarang, String> colDeskripsi;
    @FXML
    private TableColumn<MBarang, String> colHargaJual;
    @FXML
    private TableColumn<MBarang, String> colStock;
    @FXML
    private TableColumn<MBarang, String> colTglEks;

    ObservableList<MBarang> listDataBarang;
    Read read = new Read();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        actionSelect();
        selectTable();
    }    
    public void selectTable()
    {
        TVBarang.setPlaceholder(new Label("DATA TIDAK DITEMUKAN"));
        colId.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().IdPro());
        colNama.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().NamaPro());
        colDeskripsi.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().DeskripsiPro());
        colHargaJual.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().HargaJualPro());
        colStock.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().StockPro());
        colTglEks.setCellValueFactory(
                (TableColumn.CellDataFeatures<MBarang, String> cellData) ->
                        cellData.getValue().TglEksPro());
        listDataBarang = FXCollections.observableArrayList();
        TVBarang.getSelectionModel().clearSelection();
    }
    public void actionSelect()
    {
        listDataBarang = read.getAllBarang();
        TVBarang.setItems(listDataBarang);
    }
    
    @FXML
    private void klikTable(MouseEvent event)
    {
        try {
            MBarang klik = TVBarang.getSelectionModel().getSelectedItems().get(0);
            
        } 
        catch (Exception e) 
        {
            System.err.println("KLIKTABLEDATAERROR!!");
        }
    }
    @FXML
    private void actionTambah(ActionEvent event) 
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/tambahBarang.fxml"));
        
        try
        {
            MBarang klik = TVBarang.getSelectionModel().getSelectedItems().get(0);
            String id = klik.getId();
           
                if(!id.equals(null))
                {
                    AnchorPane sp = loader.load();
                    SPBarang.setContent(sp);
                }
            
            
        }
        catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(null, "TIDAK ADA DATA TERPILIH!");
            }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void actionEdit(ActionEvent event) 
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/editBarang.fxml"));
        
        try
        {
            MBarang klik = TVBarang.getSelectionModel().getSelectedItems().get(0);
            String id = klik.getId();
                if(!id.equals(null))
                {
                    AnchorPane sp = loader.load();
                    EditBarangController eb = loader.getController();
                    eb.setText(id);
                    SPBarang.setContent(sp);
                    
                }
        }  
        catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(null, "TIDAK ADA DATA TERPILIH!");
            }
        catch(Exception e)
        {e.printStackTrace();}
    }

    @FXML
    private void actionDetail(ActionEvent event) 
    {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/detailBarang.fxml"));
        
        try
        {
            MBarang klik = TVBarang.getSelectionModel().getSelectedItems().get(0);
            String id = klik.getId();
           
                if(!id.equals(null))
                {      
                    loader.load();
                    DetailBarangController d = loader.getController();
                    d.setText(id);
                    Parent p = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(p));
                    stage.show();
                }
        }  
        catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(null, "TIDAK ADA DATA TERPILIH!");
            }
        catch(Exception e)
        {e.printStackTrace();}
        
    }

    
}
