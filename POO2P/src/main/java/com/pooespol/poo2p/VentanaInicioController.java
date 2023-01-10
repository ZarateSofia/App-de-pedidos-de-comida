
package com.pooespol.poo2p;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class VentanaInicioController implements Initializable {

    public ArrayList<Cliente> listacl=Cliente.CargarClientesCl();
    public String[] lista=Cliente.CargarClientes();
    public Cliente cliente;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try(FileInputStream input=new FileInputStream(App.ruta+"FotoRepartidor.jpg")){
        Image image=new Image(input,100,100,false,false);
        imgvFotoRepartidor.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
        try(FileInputStream input=new FileInputStream(App.ruta+"FotoHamburguesa.jpg")){
        Image image=new Image(input,100,100,false,false);
        imgvFotoHamburguesa.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }       
    } 
    
    @FXML
    private  TextField txtUsuario;
    @FXML
    private  TextField txtContraseña;
    @FXML
    private ImageView imgvFotoRepartidor;
    @FXML
    private ImageView imgvFotoHamburguesa;
    @FXML
    private Button btnIngresar;
    @FXML
    private HBox seccionAbajo;


    
    @FXML
    public void Ingresar(ActionEvent action) throws IOException {
        if(ValidarUsuario()){ 
        CargarVentanaBienvenida();
        }
    }
    
    public void CargarVentanaBienvenida(){
        
        //Creación de la nueva ventana
        HBox root=new HBox();
        root.setStyle("-fx-background-color: black");
        ImageView imgv=new ImageView();
        try(FileInputStream input=new FileInputStream(App.ruta+"Hamburguesa1.jpg")){
        Image image=new Image(input,1200,1000,false,false);
        imgv.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
        imgv.setFitWidth(350);
        imgv.setFitHeight(502);
        
        
        Pane VBoxDerecha=new Pane();
        VBoxDerecha.setPrefWidth(334);
        VBoxDerecha.setPrefHeight(500);
     
        
        Label lbBienvenida=new Label();
        lbBienvenida.setPrefWidth(500);
        lbBienvenida.setPrefHeight(150);
        lbBienvenida.setText("Bienvenid@"+" "+CargarNombre());
        lbBienvenida.setTextFill(Color.ORANGE);
        lbBienvenida.setFont(new Font(40));
  
        
        Label lbMsg01=new Label();
        lbMsg01.setPrefWidth(326);
        lbMsg01.setPrefWidth(300);
        lbMsg01.setText("Elige lo que quieras comer");
        lbMsg01.setFont(new Font(20));
        lbMsg01.setTextFill(Color.WHITE);
        lbMsg01.setAlignment(Pos.CENTER);
        lbMsg01.setLayoutY(120);
        
        
        
        Button btnBuscarLocal=new Button();
        btnBuscarLocal.setPrefWidth(300);
        btnBuscarLocal.setPrefHeight(45);
        btnBuscarLocal.setAlignment(Pos.CENTER);
        btnBuscarLocal.setText("Encuentra el local más cercano");
        btnBuscarLocal.setLayoutY(200);
        btnBuscarLocal.setStyle("-fx-background-color:orange;");
        //--CONTROLADOR DE EVENTOS PARA MOSTRAR MAPA//
        btnBuscarLocal.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                MostrarMapa();
            }
        });


        Button btnHacerPedido=new Button();
        btnHacerPedido.setPrefWidth(300);
        btnHacerPedido.setPrefHeight(45);
        btnHacerPedido.setAlignment(Pos.CENTER);
        btnHacerPedido.setText("Haz tu pedido");
        btnHacerPedido.setLayoutY(280);
        btnHacerPedido.setStyle("-fx-background-color:orange;");
        
        //--CONTROLADOR DE EVENTOS PARA CAMBIAR A VENTANA PEDIDO//
        btnHacerPedido.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                App.setRoot("VentanaPedido");
                }catch(IOException e){
                    System.out.println("Algo sucedió al tratar de cambiar a ventanaPedido");
                }
            }
        });

        VBoxDerecha.getChildren().addAll(lbBienvenida,lbMsg01,btnBuscarLocal,btnHacerPedido);
        root.getChildren().addAll(imgv,VBoxDerecha);
//        Scene scene=new Scene(root,750,500);
//        App.scene=new Scene(root,750,500);
//        Stage stage=new Stage();
//        stage.setScene(scene);
//        stage.show(); 
        App.scene.setRoot(root);
        
    }
    
    public boolean ValidarUsuario() {
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();
        String datos = usuario + " " + contraseña;
        if (Arrays.asList(lista).contains(datos)) {

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("Usuario o Contraseña incorrectos");
            Optional<ButtonType> opciones = alerta.showAndWait();
            txtUsuario.clear();
            txtContraseña.clear();
            return false;

        }

        return true;

    }
    
    public String CargarNombre() {
        String nombre="";
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();
        cliente = new Cliente(txtUsuario.getText(), txtContraseña.getText());
        for (Cliente i : listacl) {
            if (i.getUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                cliente = i;
                nombre=cliente.getNombre();
                
            }
        }return nombre;
    }
    
    public void MostrarMapa(){
        Pane paneroot=new Pane();
        ImageView imgvmapa=new ImageView();
        try(FileInputStream input=new FileInputStream(App.ruta+"Mapa2.png")){
        Image image=new Image(input,1000,1000,false,false);
        imgvmapa.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
        imgvmapa.setFitWidth(950);
        imgvmapa.setFitHeight(700);
        Button btnregresar=new Button();
        btnregresar.setPrefWidth(100);
        btnregresar.setPrefHeight(40);
        btnregresar.setAlignment(Pos.CENTER);
        btnregresar.setText("Regresar");
        btnregresar.setLayoutX(850);
        btnregresar.setLayoutY(608);
        btnregresar.setStyle("-fx-background-color:orange;");
        btnregresar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                CargarVentanaBienvenida();
            }
        });
        // PARA PONER LOS SIMBOLOS DE UBICACIÓN
        ImageView imgvubicacion=new ImageView();
        try(FileInputStream input=new FileInputStream(App.ruta+"Ubicacion.png")){
        Image image=new Image(input,50,50,false,false);
        imgvubicacion.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
        imgvubicacion.setLayoutX(300);
        imgvubicacion.setLayoutY(400);
        
        imgvubicacion.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event ){
                
            }
        });
        
        
        paneroot.getChildren().addAll(imgvmapa,btnregresar,imgvubicacion);
        Scene scene=new Scene(paneroot,950,650);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
   
    } //INCOMPLETO
  

    
}







