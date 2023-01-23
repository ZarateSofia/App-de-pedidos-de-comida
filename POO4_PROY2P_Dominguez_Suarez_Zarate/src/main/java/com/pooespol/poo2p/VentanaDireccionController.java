/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class VentanaDireccionController implements Initializable {

    @FXML
    private Label tfDireccion;
    @FXML
    private ToggleGroup metodoPagar;
    @FXML
    private RadioButton rbEfectivo;
    @FXML
    private RadioButton rbTarjetaCredito;
    @FXML
    private VBox paneAgregarTexto;
    @FXML
    private Label lbTotalPagar;
    @FXML
    private Button btContinuar;
    @FXML
    private Button btLimpiar;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
