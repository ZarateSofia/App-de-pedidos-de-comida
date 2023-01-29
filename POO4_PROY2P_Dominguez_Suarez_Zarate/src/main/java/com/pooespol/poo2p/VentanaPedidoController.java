package com.pooespol.poo2p;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import modelo.Comida;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.ValorInsuficienteException;

/**
 * Esta clase es un controlador de una VentanaPedido.fxml
 * @author Gamer
 */
public class VentanaPedidoController implements Initializable {
    /**
     * En esta lista se guardara la comida que el clienta vea, dependiendo del tipo que escoja
     */
    public ArrayList<Comida> Lista = new ArrayList<>();
    
    /**
     * Lista donde se guardara lo que el cliente elija
     */
    public ArrayList<Pedido> ListaPedido = new ArrayList<>();
    public double Subtotal = 0;
    public double Iva = 0;
    public double Total = 0;
    int idPedido;
    String direccion;
    String tipo;
    /**
     * cliente que se encuentra haciendo su pedido
     */
    Cliente cl = VentanaInicioController.devolverCliente();

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
    private TableColumn<Pedido, String> PedidoDescripcion;

    @FXML
    private TableColumn<Pedido, String> PedidoCantidad;

    @FXML
    private TableColumn<Pedido, String> PedidoPrecio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        root.setStyle("-fx-background-color:white;");
        CargarTipoComida();
        cbxOpcionesOrdenar.getItems().addAll("PRECIO","NOMBRE");
        MostrarComidaPorTipo();
        Limpiar();
    }
/**
 * Opciones que tendra el cliente para elejir el tipo de comida que quiera
 */
    public void CargarTipoComida() {
        cbxOpcionesTipo.getItems().add("PIQUEO");
        cbxOpcionesTipo.getItems().add("PLATO FUERTE");
        cbxOpcionesTipo.getItems().add("BEBIDA");
        cbxOpcionesTipo.getItems().add("POSTRE");
    }


    public void MostrarComidaPorOrdenamiento() {

    }//VACIO

    /**
     * Dependiendo del tipo de comida que elija el cliente, se guardara la comida del mismo tipo que sera guardada en una lista para ser mostrada
     */
    public void MostrarComidaPorTipo() {
        cbxOpcionesTipo.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            String OpcionEscogida = (String) cbxOpcionesTipo.getValue();
            cbxOpcionesOrdenar.setDisable(false);
            switch (OpcionEscogida) {
                case "PIQUEO":
//                    CargarTipoOrdenamiento();
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("Q")) {
                            Lista.add(i);
                            
                            
                        }
                    }
                    break;
                case "PLATO FUERTE":                    
//                    CargarTipoOrdenamiento();
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("F")) {
                            Lista.add(i);
                            
                        }
                    }
                    break;
                case "BEBIDA":
//                    CargarTipoOrdenamiento();
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("B")) {
                            Lista.add(i);
                            
                        }
                    }
                    break;
                case "POSTRE":
//                    CargarTipoOrdenamiento();
                    for (Comida i : App.ListaComida) {
                        if (i.getTipo().equals("P")) {
                            Lista.add(i);
                            
                        }
                    }
                    break;
            }//fin switch
            
            AgregarComidaPorTipo();

        } //fin handle

        );//fin controladorevento

    }
/**
 * Se mostrara por ventana la comida del tipo que el cliente elijió, con la opción de poder agregar esa comida a un pedido que haga
 */
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
            precio.setText(String.valueOf(k.getPrecio()));
            precio.setPadding(new Insets(10));
            btnAgregar.setText("Agregar");
            btnAgregar.setPadding(new Insets(10));

            vBD.getChildren().add(contenedor);
            vBP.getChildren().add(precio);
            vBC.getChildren().add(cantidad);

            //TRATANDO DE METER ELEMENTOS EN LA TABLA DE PEDIDO
            btnAgregar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
                try {
                    if((Integer.valueOf(cantidad.getText()))!=0){
                        double precioPorCantidad = k.getPrecio() * Integer.parseInt(cantidad.getText());
                        cargarListaPedido(k.getDescripcion(), cantidad.getText(), precioPorCantidad);
                        ListaPedido.add(new Pedido(k.getDescripcion(), cantidad.getText(), precioPorCantidad));
                        Subtotal += precioPorCantidad;
                        txtSubtotal.setText(String.valueOf(Subtotal));
                        System.out.println(ListaPedido);
                        Iva = Subtotal * 0.12;
                        txtIva.setText(String.valueOf(Iva));
                        Total = Subtotal + Iva;
                        txtTotal.setText(String.valueOf(Total));
                    }else{
                        throw new ValorInsuficienteException("Ingrese una cantidad valida");
                    }
                    
                } catch (RuntimeException e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setContentText("Cantidad Incorrecta. Escoja de nuevo");
                    Optional<ButtonType> opciones = alerta.showAndWait();

                } catch (ValorInsuficienteException ex) {
                    System.out.println(ex.getMessage());
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("ValorInsufiecienteException");
                    alerta.setContentText(ex.getMessage());
                    Optional<ButtonType> opciones2 = alerta.showAndWait();
                }

            });//eventHandler

            vBB.getChildren().add(btnAgregar);
        }// for
        Lista.clear();

    }//metodo

    /**
     * Limpia la ventana del usuario para poder mostrar otras comidas
     */
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
            Total=0;
            Subtotal=0;
            Iva=0;
            ListaPedido.clear(); //NO SE ME LIMPIA LA LISTA***
        });
    }

    /**
     * Se abrira una nueva ventana para completar el pedido que tenga el cliente
     * @param event. Se ejecutará el metodo una vez reciba un evento 
     */
    @FXML
    public void cambiarVentanaDireccion(ActionEvent event) {
        // Cuando se da continuar se escriben los archivos
        if(!(txtTotal.getText().isEmpty()) && !(txtTotal.getText().equals("0.00"))){
            idPedido = (int) (Math.random() * 9999 + 1111);
            Pedido pO = new Pedido(ListaPedido, cl, "null", Subtotal, Iva, Total);
            EscribirArchivoPedido(idPedido, cl.getNombre(), Total);
            EscribirArchivoPedidoSerialido(pO, idPedido);

            VBox root2 = new VBox();
            Stage stage = new Stage();
            Scene scene = new Scene(root2, 600, 452); //600,452
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Direccion");

            Stage stage2 = (Stage) btnContinuar.getScene().getWindow();
            stage2.close();

            Label titulo = new Label("Dirección de entrega");
            titulo.setStyle("-fx-font-weight: bold; -fx-font-size:30; -fx-font-family: System; -fx-text-fill: #ffa500 ");

            HBox hbox1 = new HBox();
            Label label = new Label("Dirección:");
            TextField direccion2 = new TextField();
            direccion2.setPrefHeight(25);
            direccion2.setPrefWidth(497);
            hbox1.getChildren().addAll(label, direccion2);
            hbox1.setAlignment(Pos.TOP_LEFT);
            hbox1.setSpacing(10);

            Label detalle = new Label("Detalle de pago");
            detalle.setStyle("-fx-font-weight: bold; -fx-font-size:30; -fx-font-family: System;-fx-text-fill: #ffa500");

            HBox hbox2 = new HBox();
            RadioButton efectivo = new RadioButton("Efectivo");
            RadioButton tarjeta = new RadioButton("Tarjeta de crédito");
            hbox2.getChildren().addAll(efectivo, tarjeta);
            hbox2.setAlignment(Pos.TOP_LEFT);
            hbox2.setSpacing(20);

            Label descripcionPago = new Label();

            HBox seccionPago = new HBox();
            HBox hbox4 = new HBox();
            Button continuar = new Button("Continuar");
            continuar.setStyle("-fx-background-color: #fda10e; -fx-font-weight: bold;");
            Button limpiar = new Button("Limpiar");
            limpiar.setStyle("-fx-background-color: #fda10e; -fx-font-weight: bold;");
            hbox4.getChildren().addAll(continuar, limpiar);
            hbox4.setAlignment(Pos.CENTER);
            hbox4.setSpacing(30);

            root2.getChildren().addAll(titulo, hbox1, detalle, hbox2, seccionPago, descripcionPago, hbox4);
            root2.setStyle("-fx-background-color: white");
            root2.setAlignment(Pos.TOP_LEFT);
            root2.setPadding(new Insets(20, 20, 20, 20));
            root2.setSpacing(20);

            ToggleGroup metodosPagar=new ToggleGroup();
            efectivo.setToggleGroup(metodosPagar);
            tarjeta.setToggleGroup(metodosPagar);
            
            VBox labels = new VBox();
            Label lbtitular = new Label();
            Label lbnumero = new Label();
            Label lbCaducidad = new Label();
            Label lbCVV = new Label();
            labels.getChildren().addAll(lbtitular, lbnumero,lbCaducidad,lbCVV);
            
            VBox textfields = new VBox();
            TextField txtTitular = new TextField();
            TextField txtnumero = new TextField();
            TextField txtCaducidad = new TextField();
            TextField txtCVV = new TextField();
            textfields.getChildren().addAll(txtTitular, txtnumero,txtCaducidad,txtCVV);
            
            seccionPago.setVisible(false);

            //METODO PAGO
            
            efectivo.addEventHandler(ActionEvent.ACTION, (Event t)->{
                tipo = "E";
                seccionPago.getChildren().clear();
                descripcionPago.setText("Tendrá que pagar un total de " + Total + " dólares" + "\n" + "Asegurese de tener el dinero completo por si el repartidor "
                        + "no tiene cambio");
            });
            tarjeta.addEventHandler(ActionEvent.ACTION, (Event t)->{
                seccionPago.setVisible(true);
                
                seccionPago.getChildren().clear();
                tipo = "C";
                
                lbtitular.setText("Titular");
                lbnumero.setText("Número");
                lbCaducidad.setText("Caducidad");
                lbCVV.setText("CVV");                               
                
                labels.setSpacing(15);
                
                textfields.setSpacing(8);
                
                seccionPago.setSpacing(10);

                descripcionPago.setText("Tendrá que pagar un total de " + (Total + (Total * 0.05)) + " por el incremento del 5% por uso de tarjeta");
 
                seccionPago.getChildren().addAll(labels,textfields);
            });
            

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("Por favor, llene todos los datos");
            continuar.setOnAction((ActionEvent t) -> {
                if((!efectivo.isSelected() | !tarjeta.isSelected()) && direccion2.getText().isEmpty()){
                    Optional<ButtonType> opciones = alerta.showAndWait();
                    
                }else if(tarjeta.isSelected() && (txtTitular.getText().isEmpty() | txtnumero.getText().isEmpty() |
                    txtCaducidad.getText().isEmpty() | txtCVV.getText().isEmpty())){
                    Optional<ButtonType> opciones = alerta.showAndWait();
                    
//                }else if(!(cl.getTarjetaCredito().equals(txtnumero.getText()))){
//                    Alert alerta2 = new Alert(Alert.AlertType.ERROR);
//                    alerta2.setTitle("Error");
//                    alerta2.setContentText("Tarjeta de credito incorrecta");
//                    Optional<ButtonType> opciones = alerta2.showAndWait();
//                    
                }else{
                    int idPago = (int) (Math.random() * 9999 + 1111);
                    try ( BufferedWriter bfw = new BufferedWriter(new FileWriter("Pagos.txt", true))) {
                        LocalDate fechahoy=LocalDate.now();
                        bfw.write("\n"+idPago+","+idPedido+","+cl.getNombre()+","+Total+","+fechahoy+","+tipo);

                    } catch (IOException ex) {
                        System.out.println("Error al escribir el archivo");
                    }

                    Stage stage3 = (Stage) continuar.getScene().getWindow();
                    stage3.close();

                    cargarVentanaFinal(idPedido);
                }

            });
            
            limpiar.setOnAction((ActionEvent t) -> {
                direccion2.setText(null);
                efectivo.setSelected(false);
                tarjeta.setSelected(false);
                seccionPago.getChildren().clear();
                descripcionPago.setText(null);
                txtTitular.clear();
                txtnumero.clear();
                txtCaducidad.clear();
                txtCVV.clear();
            });
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("No ha escogido ninguna opcion");
            Optional<ButtonType> opciones = alerta.showAndWait();
        }
    }//METODO
       
/**
 * Se mostrará en una tabla, todas las comidas que el cliente quiere ordenar para su pedido, incluyendo la cantidad y precio de cada comida
 * @param descripcion. La descripcion de la comida a mostrar
 * @param cantidad. Cantidad de unidades que se desee ordenar
 * @param total. Precio total por todas las unidades de cada comida 
 */
    public void cargarListaPedido(String descripcion, String cantidad, double total) {

        TablaPedidos.setEditable(true);

        PedidoDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        PedidoCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        PedidoPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TablaPedidos.getItems().add(new Pedido(descripcion, cantidad, total));

    }

    /**
     * Ventada a mostrar una vez realizado el pedido 
     * @param pedido. El pedido a ser enviado
     */
    public void cargarVentanaFinal(int pedido) {
        VBox rootFinal = new VBox();
        rootFinal.setAlignment(Pos.CENTER);
        rootFinal.setStyle("-fx-background-color: white");
        rootFinal.setSpacing(20);

        Label lblAgradecimiento = new Label();
        lblAgradecimiento.setText("¡Muchas Gracias!");
        lblAgradecimiento.setTextFill(Color.ORANGE);
        lblAgradecimiento.setStyle("-fx-font-weight: bold; -fx-text-fill: orange; -fx-font-size:30");
        
        
        VBox texto=new VBox();
        texto.setSpacing(5);
        texto.setAlignment(Pos.CENTER);
        
        Label lbpedido = new Label();
        lbpedido.setText("Su pedido Nro " + pedido + " ha sido pagado y ahora empezaremos a prepararlo");
        lbpedido.setFont(new Font(15));

        
        Label lbtiempo = new Label();
        lbtiempo.setText("En aproximadamente 30 minutos llegará a su destino");
        lbtiempo.setFont(new Font(15));

        Label msgfinal = new Label();
        msgfinal.setText("Gracias por preferirnos");
        msgfinal.setFont(new Font(15));

        texto.getChildren().addAll(lbpedido,lbtiempo,msgfinal);
        
        ImageView imgv = new ImageView();
        try ( FileInputStream input = new FileInputStream(App.rutaImage + "FotoRepartidor2.jpeg")) {
            Image image = new Image(input, 250, 250, false, false);
            imgv.setImage(image);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        
        VBox segundos2=new VBox();
        Label lbcerrando = new Label();
        lbcerrando.setText("Cerrando en 3.....");
        lbcerrando.setPadding(new Insets(0, 35, 0, 20));
        segundos2.setAlignment(Pos.BOTTOM_RIGHT);
        segundos2.getChildren().add(lbcerrando);
        
        rootFinal.getChildren().addAll(lblAgradecimiento,texto, imgv, segundos2);

        Stage escenario = new Stage();
        Scene escena = new Scene(rootFinal, 600, 500);
        escenario.setScene(escena);
        escenario.show();

        Thread t = new Thread(new Runnable() {
            int i = 6;

            @Override
            public void run() {
                while (i >= 0) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lbcerrando.setText("Cerrando en " + i);
                            if (i == 0) {
                                escenario.close();
                            } else {

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

    /**
     * Agrega los pedidos que han sido realizados
     * @param idpedido. Identificador del pedido
     * @param nombreCliente. Cliente que realizó el pedido
     * @param total. El total de ese pedido 
     */
    public void EscribirArchivoPedido(int idpedido, String nombreCliente, double total) {
        try ( BufferedWriter bfw = new BufferedWriter(new FileWriter("Pedidos.txt", true))) {
            bfw.write("\n"+idpedido + "," + nombreCliente + "," + total);

        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo");
        }
    }

    /**
     * Escribe un archivo seralizado del pedido que fue enviado
     * @param p. Pedido a serializar
     * @param idPedido. Identificador del pedido a serializar 
     */
    public void EscribirArchivoPedidoSerialido(Pedido p, int idPedido) {
        try ( ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("pedido" + idPedido + ".bin"))) {
            obj.writeObject(p);
        } catch (IOException e) {
        }
    }

}//clase
