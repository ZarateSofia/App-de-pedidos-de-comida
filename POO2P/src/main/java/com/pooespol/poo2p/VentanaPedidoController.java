
package com.pooespol.poo2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class VentanaPedidoController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.setStyle("-fx-background-color:white;");
        
    }
    @FXML
    private ComboBox cbxOpcionesTipo;
    @FXML
    private ComboBox cbxOpcionesOrdenar;
    @FXML 
    private GridPane root;
    @FXML
    private TextField txtSubtotal;
    @FXML
    private TextField txtIva;
    @FXML
    private TextField txtTotal;
    @FXML
    private Button btnContinuar;
    @FXML
    private Button btnLimpiar;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
