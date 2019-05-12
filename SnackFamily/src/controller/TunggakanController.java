/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author TRISNA NURDIANA
 */
public class TunggakanController implements Initializable {

    @FXML
    private AnchorPane APBeranda;
    @FXML
    private ScrollPane SPTunggak;
    @FXML
    private ToggleGroup RBChoice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void moveBayar(ActionEvent event)
    {
         try
        {
            AnchorPane sp = FXMLLoader.load(getClass().getResource("/fxml/bayarTunggakan.fxml"));
            SPTunggak.setContent(sp);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }
    
}
