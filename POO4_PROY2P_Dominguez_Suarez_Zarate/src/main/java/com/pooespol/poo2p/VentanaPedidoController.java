package com.pooespol.poo2p;

import modelo.Comida;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Pedido;

public class VentanaPedidoController implements Initializable {

    public ArrayList<Comida> Lista = new ArrayList<>();

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
    private TableView<Pedido> TablaPedidos;
    
    @FXML
    private VBox vBD;
    
    @FXML
    private VBox vBP;

    @FXML
    private VBox vBC;

    @FXML
    private VBox vBB;
    
    @FXML
    private TableColumn<Pedido,String> PedidoDescripcion;
    
    @FXML
    private TableColumn<Pedido,Integer> PedidoCantidad;
    
    @FXML
    private TableColumn<Pedido,Double> PedidoPrecio;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        root.setStyle("-fx-background-color:white;");
        CargarTipoComida();
        MostrarComidaPorTipo();
        Limpiar();
    }

    public void CargarTipoComida() {
        cbxOpcionesTipo.getItems().add("PIQUEO Q");
        cbxOpcionesTipo.getItems().add("PLATO FUERTE F");
        cbxOpcionesTipo.getItems().add("BEBIDA B");
        cbxOpcionesTipo.getItems().add("POSTRE P");
    }

    public void MostrarComidaPorTipo() {
        cbxOpcionesTipo.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            String OpcionEscogida = (String) cbxOpcionesTipo.getValue();

            switch (OpcionEscogida) {
                case "PIQUEO Q":
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("Q")) {
                            Lista.add(i);
                        }
                    }
                    break;
                case "PLATO FUERTE F":
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("F")) {
                            Lista.add(i);
                        }
                    }
                    break;
                case "BEBIDA B":
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("B")) {
                            Lista.add(i);
                        }
                    }
                    break;
                case "POSTRE P":
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("P")) {
                            Lista.add(i);
                        }
                    }
                    break;
            }//fin switch
            //System.out.println(Lista);
            AgregarComidaPorTipo();
//            Lista.clear();

        } //fin handle

        );//fin controladorevento

    }

    public void AgregarComidaPorTipo() {
        vBD.getChildren().clear();
        vBP.getChildren().clear();
        vBC.getChildren().clear();
        vBB.getChildren().clear();
        Label lbDescripcion = new Label();
        lbDescripcion.setText("Descripcion");
        lbDescripcion.setPadding(new Insets(5));
        Label lbPrecio = new Label();
        lbPrecio.setText("Precio");
        lbPrecio.setPadding(new Insets(5));
        Label lbCantidad = new Label();
        lbCantidad.setText("Cantidad");
        lbCantidad.setPadding(new Insets(5));
        Label lbVacio = new Label();
        lbVacio.setText(" hghghy");
        lbVacio.setPadding(new Insets(5));
        vBD.getChildren().add(lbDescripcion);
        vBP.getChildren().add(lbPrecio);
        vBC.getChildren().add(lbCantidad);
        vBB.getChildren().add(lbVacio);
        for (Comida k : Lista) {
            Label contenedor = new Label();
            Label precio = new Label();
            TextField cantidad = new TextField();
            cantidad.setPadding(new Insets(10));
            Button btnAgregar = new Button();
            contenedor.setText(k.getDescripcion());
            contenedor.setPadding(new Insets(10));
            //contenedor.setPrefWidth(15);
            precio.setText(String.valueOf(k.getPrecio()));
            precio.setPadding(new Insets(10));
            btnAgregar.setText("Agregar");
            btnAgregar.setPadding(new Insets(10));
            vBD.getChildren().add(contenedor);
            vBP.getChildren().add(precio);
            vBC.getChildren().add(cantidad);
            vBB.getChildren().add(btnAgregar);
            
//            String texto=cantidad.getText();
//            int cantidad2=Integer.valueOf(texto);
//            System.out.println(cantidad2.getClass());
//            double subtotal=k.getPrecio();

            //TRATANDO DE METER ELEMENTOS EN LA TABLA DE PEDIDO
            btnAgregar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
                cargarListaPedido("holaaaaaaa",2,4353);

            });//eventHandler
        }// for
        Lista.clear();

    }//metodo

    public void Limpiar() {
        btnLimpiar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            vBD.getChildren().clear();
            vBP.getChildren().clear();
            vBC.getChildren().clear();
            vBB.getChildren().clear();
            TablaPedidos.getItems().clear();
            txtTotal.setText("0.00");
            txtSubtotal.setText("0.00");
            txtIva.setText("0.00");
        });
    }//INCOMPLETO

    @FXML
    public void cambiarVentanaDireccion(ActionEvent event) {
        VBox root2=new VBox();
        Stage stage=new Stage();
        Scene scene=new Scene(root2,600,452);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Direccion");

        Stage stage2=(Stage)btnContinuar.getScene().getWindow();
        stage2.close();

        Label titulo=new Label("Dirección de entrega");
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size:30; -fx-font-family: System; -fx-text-fill: #ffa500 ");
        
        HBox hbox1=new HBox();
        Label label=new Label("Dirección:");
        TextField direccion=new TextField();
        direccion.setPrefHeight(25);
        direccion.setPrefWidth(497);
        hbox1.getChildren().addAll(label,direccion);
        hbox1.setAlignment(Pos.TOP_LEFT);
        hbox1.setSpacing(10);
        
        Label detalle=new Label("Detalle de pago");
        detalle.setStyle("-fx-font-weight: bold; -fx-font-size:30; -fx-font-family: System;-fx-text-fill: #ffa500");
        
        HBox hbox2=new HBox();
        RadioButton efectivo=new RadioButton("Efectivo");
        RadioButton tarjeta=new RadioButton("Tarjeta de crédito");
        hbox2.getChildren().addAll(efectivo,tarjeta);
        hbox2.setAlignment(Pos.TOP_LEFT);
        hbox2.setSpacing(20);
        
        HBox agregarDatos=new HBox();
        
        Label descripcionPago=new Label("Aqui debe ir la descripcion del pago");
        
        HBox hbox4=new HBox();
        Button continuar=new Button("Continuar");
        continuar.setStyle("-fx-background-color: #fda10e; -fx-font-weight: bold;"); 
        Button limpiar=new Button("Limpiar");
        limpiar.setStyle("-fx-background-color: #fda10e; -fx-font-weight: bold;");
        hbox4.getChildren().addAll(continuar,limpiar);
        hbox4.setAlignment(Pos.CENTER);
        hbox4.setSpacing(30);

        root2.getChildren().addAll(titulo,hbox1,detalle,hbox2,agregarDatos,descripcionPago,hbox4);
        root2.setStyle("-fx-background-color: white");
        root2.setAlignment(Pos.TOP_LEFT);
        root2.setPadding(new Insets(20,20,20,20));
        root2.setSpacing(20);
        
        
        

    }

    
    public void cargarListaPedido(String descripcion, int cantidad,double valor){
////        lista=FXCollections.observableArrayList(
//        new Pedido(descripcion,cantidad,valor));
//        TablaPedidos.getItems().add(new Pedido(descripcion,cantidad,valor));
//        TablaPedidos.setEditable(true);
    }
    
}//clase
