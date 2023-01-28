package com.pooespol.poo2p;

import modelo.Comida;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
//    @FXML
//    private HBOX TablaComida;
    @FXML
    private TableView<Comida> TablaPedidos;
    @FXML
    private VBox vBD;
    @FXML
    private VBox vBP;

    @FXML
    private VBox vBC;

    @FXML
    private VBox vBB;
    @FXML
    private TableColumn<Comida, String> PedidoDescripcion;
    @FXML
    private TableColumn PedidoCantidad;
    @FXML
    private TableColumn PedidoPrecio;

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
        lbCantidad.setText("");
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

            //TRATANDO DE METER ELEMENTOS EN LA TABLA DE PEDIDO
            btnAgregar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
                System.out.println(cantidad.getText());

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

    private void switchToVentanaDireccion() {
        btnContinuar.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            try {
                App.setRoot("VentanaDireccion");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Algo paso");
            }
        });

    }

}//clase
