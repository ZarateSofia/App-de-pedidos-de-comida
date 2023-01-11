package com.pooespol.poo2p;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class VentanaPedidoController implements Initializable {

    public ArrayList<Comida> Lista = new ArrayList<>();



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.setStyle("-fx-background-color:white;");
        CargarTipoComida();
        MostrarComidaPorTipo();
        Limpiar();
        switchToVentanaDireccion();


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
    @FXML
    private GridPane TablaComida;
    @FXML
    private TableView TablaPedidos;
    

    public void CargarTipoComida() {
        cbxOpcionesTipo.getItems().add("PIQUEO Q");
        cbxOpcionesTipo.getItems().add("PLATO FUERTE F");
        cbxOpcionesTipo.getItems().add("BEBIDA B");
        cbxOpcionesTipo.getItems().add("POSTRE P");
    }

    public void MostrarComidaPorTipo(){
        cbxOpcionesTipo.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            String OpcionEscogida=(String)cbxOpcionesTipo.getValue();
            switch(OpcionEscogida){
                case "PIQUEO Q":
                    for(Comida i:Comida.CargarMenu()){
                        if(i.getTipo().equals("Q")){
                            Lista.add(i);
                        }
                    }
                    try{
                        AgregarComidaPorTipo();
                    }catch(RuntimeException e1){
                        System.out.println(e1.getMessage());
                    }
                    
                    break;
                case "PLATO FUERTE F":
                    for(Comida i:Comida.CargarMenu()){
                        if(i.getTipo().equals("F")){
                            Lista.add(i);
                        }
                    }
                    try{
                        AgregarComidaPorTipo();
                    }catch(RuntimeException e1){
                        System.out.println(e1.getMessage());
                    }
                    break;
                case "BEBIDA B":
                    for(Comida i:Comida.CargarMenu()){
                        if(i.getTipo().equals("B")){
                            Lista.add(i);
                        }
                    }
                    try{
                        AgregarComidaPorTipo();
                    }catch(RuntimeException e1){
                        System.out.println(e1.getMessage());
                    }
                    break;
                case "POSTRE P":
                    for(Comida i:Comida.CargarMenu()){
                        if(i.getTipo().equals("P")){
                            Lista.add(i);
                        }
                    }
                    try{
                        AgregarComidaPorTipo();
                    }catch(RuntimeException e1){
                        System.out.println(e1.getMessage());
                    }
                    break;
                    
            }//fin siwitch

        } //fin handle
              
        );//fin controladorevento

    }
    
    public void AgregarComidaPorTipo(){
        TablaComida.getChildren().clear();
        TablaComida.setGridLinesVisible(false);
        Label lbDescripcion=new Label();
        lbDescripcion.setText("Descripcion");
        Label lbPrecio = new Label();
        lbPrecio.setText("Precio");
        Label lbCantidad = new Label();
        lbCantidad.setText("Cantidad");
        TablaComida.add(lbDescripcion,0,0);
        TablaComida.add(lbPrecio,1,0);
        TablaComida.add(lbCantidad,2,0);
        for(int i=1;i<Lista.size()+1;i++){
            for(Comida j:Lista){
                Label contenedor=new Label();
                Label precio=new Label();
                TextField cantidad=new TextField();
                Button btnAgregar=new Button();
                btnAgregar.setText("Agregar");
                contenedor.setText(j.getDescripcion());
                precio.setText(String.valueOf(j.getPrecio()));
                //contenedor.setAlignment(Pos.CENTER);
                TablaComida.add(contenedor, 0, i);
                TablaComida.add(precio,1,i);
                TablaComida.add(cantidad,2,i);
                TablaComida.add(btnAgregar,3,i);
                i++;
                
                //TRATANDO DE METER ELEMENTOS EN LA TABLA DE PEDIDO
                btnAgregar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
                    if(cantidad.getText()!=null){
                        TablaPedidos.getItems().addAll(j.getDescripcion(),cantidad.getText(),String.valueOf(j.getPrecio()));
                    }else{
                        
                    }
                });

                
            }
        Lista.clear();
        }//for i
        
  
    }//metodo
    
    public void Limpiar(){
        btnLimpiar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            TablaComida.getChildren().clear(); 
            TablaPedidos.getItems().clear();
            txtTotal.setText("0.00");
            txtSubtotal.setText("0.00");
            txtIva.setText("0.00");
        });
    }//INCOMPLETO
    
    
    private void switchToVentanaDireccion(){
        btnContinuar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            try {
                App.setRoot("VentanaDireccion");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
    }
    
}//clase
