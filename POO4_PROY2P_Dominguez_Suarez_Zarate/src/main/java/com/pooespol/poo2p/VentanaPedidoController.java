package com.pooespol.poo2p;

import java.io.FileInputStream;
import modelo.Comida;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
    private TableColumn<Pedido,String> PedidoCantidad;
    
    @FXML
    private TableColumn<Pedido,String> PedidoPrecio;
    
//    ObservableList<Pedido> data =FXCollections.observableArrayList(new Pedido("A", 3,9.0),new Pedido("B",2,5.6));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        root.setStyle("-fx-background-color:white;");
        CargarTipoComida();
        MostrarComidaPorTipo();
        Limpiar();
    }

    public void CargarTipoComida() {
        cbxOpcionesTipo.getItems().add("PIQUEO");
        cbxOpcionesTipo.getItems().add("PLATO FUERTE");
        cbxOpcionesTipo.getItems().add("BEBIDA");
        cbxOpcionesTipo.getItems().add("POSTRE");
    }

    public void MostrarComidaPorTipo() {
        cbxOpcionesTipo.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            String OpcionEscogida = (String) cbxOpcionesTipo.getValue();

            switch (OpcionEscogida) {
                case "PIQUEO":
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("Q")) {
                            Lista.add(i);
                        }
                    }
                    break;
                case "PLATO FUERTE":
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("F")) {
                            Lista.add(i);
                        }
                    }
                    break;
                case "BEBIDA":
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("B")) {
                            Lista.add(i);
                        }
                    }
                    break;
                case "POSTRE":
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
        lbDescripcion.setStyle("-fx-font-weight: bold");
        lbDescripcion.setPadding(new Insets(5));
        Label lbPrecio = new Label();
        lbPrecio.setText("Precio");
        lbPrecio.setStyle("-fx-font-weight: bold");
        lbPrecio.setPadding(new Insets(5));
        Label lbCantidad = new Label();
        lbCantidad.setText("Cantidad");
        lbCantidad.setStyle("-fx-font-weight: bold");
        lbCantidad.setPadding(new Insets(5));
        Label lbVacio = new Label();
        lbVacio.setText(" ");
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
//            contenedor.setPrefWidth(15);
            precio.setText(String.valueOf(k.getPrecio()));
            precio.setPadding(new Insets(10));
            btnAgregar.setText("Agregar");
            btnAgregar.setPadding(new Insets(10));
            
//            double subtotal=k.getPrecio()*Integer.valueOf(cantidad.getText());
            
            vBD.getChildren().add(contenedor);
            vBP.getChildren().add(precio);
            vBC.getChildren().add(cantidad);

            //TRATANDO DE METER ELEMENTOS EN LA TABLA DE PEDIDO
            btnAgregar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
                cargarListaPedido(k.getDescripcion(),cantidad.getText(),"odio");

            });//eventHandler
            
            vBB.getChildren().add(btnAgregar);
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
        
        continuar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                
                Stage stage3=(Stage)continuar.getScene().getWindow();
                stage3.close();
                
                cargarVentanaFinal(2);
            }
            
            
            
        });

    }

    
    public void cargarListaPedido(String descripcion,String cantidad,String total){
        
//        ObservableList<Pedido> data =FXCollections.observableArrayList(new Pedido(descripcion,cantidad,total));

        TablaPedidos.setEditable(true);
        
//        TableColumn PedidoDescripcion = new TableColumn("Descripcion");
        PedidoDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        
//        TableColumn PedidoCantidad = new TableColumn("Cantidad");
        PedidoCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        
//        TableColumn PedidoPrecio = new TableColumn("Precio");
        PedidoPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
 
//        TablaPedidos.setItems(data);
        TablaPedidos.getItems().add(new Pedido(descripcion,cantidad,total));
   
//        TablaPedidos.getColumns().addAll(PedidoDescripcion, PedidoCantidad,PedidoPrecio);
    }
    
    
    public void cargarVentanaFinal(int pedido){
        VBox rootFinal=new VBox();
        rootFinal.setAlignment(Pos.CENTER);
        rootFinal.setStyle("-fx-background-color: white");
        
        Label lblAgradecimiento=new Label();
        lblAgradecimiento.setText("¡Muchas Gracias!");
        lblAgradecimiento.setPadding(new Insets(30));
        lblAgradecimiento.setAlignment(Pos.CENTER);
        lblAgradecimiento.setPadding(new Insets(80,0,15,30));
        lblAgradecimiento.setTextFill(Color.ORANGE);
        lblAgradecimiento.setFont(new Font(30));
        
        Label lbpedido=new Label();
        lbpedido.setText("Su pedido Nro "+pedido+" ha sido pagado y ahora empezaremos a prepararlo");
        lbpedido.setAlignment(Pos.CENTER);
        lbpedido.setPadding(new Insets(0,0,10,70));
        lbpedido.setFont(new Font(15));
        
        Label lbtiempo=new Label();
        lbtiempo.setText("En aproximadamente 30 minutos llegará a su destino");
        lbtiempo.setAlignment(Pos.CENTER);
        lbtiempo.setPadding(new Insets(0,35,0,20));
        lbtiempo.setFont(new Font(15));
        
        Label msgfinal=new Label();
        msgfinal.setText("Gracias por preferirnos");
        msgfinal.setAlignment(Pos.CENTER);
        msgfinal.setPadding(new Insets(10,35,0,20));
        msgfinal.setFont(new Font(15));
        
        ImageView imgv=new ImageView();
        try(FileInputStream input=new FileInputStream(App.rutaImage+"FotoRepartidor2.jpeg")){
            Image image=new Image(input,250,250,false,false);
            imgv.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
        
        Label lbcerrando=new Label();
        lbcerrando.setText("Cerrando en 3....."); 
        lbcerrando.setAlignment(Pos.BOTTOM_RIGHT);
        
        rootFinal.getChildren().addAll(lblAgradecimiento,lbpedido,lbtiempo,msgfinal,imgv,lbcerrando);
        
        Stage escenario=new Stage();
        Scene escena=new Scene(rootFinal,600,550);
        escenario.setScene(escena);
        escenario.show();
        
        Thread t=new Thread(new Runnable(){
            int i=6;
            @Override
            public void run() {
                while(i>=0){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lbcerrando.setText("Cerrando en "+i);
                            if(i==0){
                                escenario.close();
                            }else{

                            }
                        }                
                    });
                    i--;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }   
                }               
            }   
        });
        
        t.setDaemon(true);
        t.start();
        
    }
}//clase
