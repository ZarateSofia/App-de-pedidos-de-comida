
package com.pooespol.poo2p;


import modelo.Cliente;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Local;


public class VentanaInicioController implements Initializable {
    public ArrayList<Cliente> listaClientes=Cliente.CargarClientesCl();
//    public String[] listaDatosClientes=Cliente.CargarClientes();
    static Cliente cliente;
    
    @FXML
    private VBox VBoxroot;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarEstiloVentanaInicio();
    } 


    public void agregarEstiloVentanaInicio(){
        VBoxroot.setStyle("-fx-background-color: white");
        try(FileInputStream input=new FileInputStream(App.rutaImage+"FotoRepartidor.jpg")){
            Image image=new Image(input,100,100,false,false);
            imgvFotoRepartidor.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
        
        try(FileInputStream input=new FileInputStream(App.rutaImage+"FotoHamburguesa.jpg")){
            Image image=new Image(input,100,100,false,false);
            imgvFotoHamburguesa.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
    }
    
    @FXML
    public void Ingresar(ActionEvent action) throws IOException {
        if(ValidarUsuario()==true){ 
            CargarVentanaBienvenida();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("Usuario o Contraseña incorrectos");
            Optional<ButtonType> opciones = alerta.showAndWait();
            txtUsuario.clear();
            txtContraseña.clear();
        }
    }
    
    public void CargarVentanaBienvenida(){
        //Creación de la nueva ventana 
//        CargarCliente();
        HBox root=new HBox();
        root.setStyle("-fx-background-color: black");
        ImageView imgv=new ImageView();
        try(FileInputStream input=new FileInputStream(App.rutaImage+"Hamburguesa1.jpg")){
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
        lbBienvenida.setText("Bienvenid@"+" "+cliente.getNombre());
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
                    //App.setRoot("VentanaPedido");
                    FXMLLoader fxmLoader=new FXMLLoader(App.class.getResource("VentanaPedido.fxml"));
                    Parent root1=fxmLoader.load();
                    Scene scene = new Scene(root1, 750, 500);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

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
//        String datos = usuario + " " + contraseña;
//        if (Arrays.asList(listaDatosClientes).contains(datos)) {
//
//        } else {
//            Alert alerta = new Alert(Alert.AlertType.ERROR);
//            alerta.setTitle("Error");
//            alerta.setContentText("Usuario o Contraseña incorrectos");
//            Optional<ButtonType> opciones = alerta.showAndWait();
//            txtUsuario.clear();
//            txtContraseña.clear();
//            return false;
//        }
//        return true;

        boolean validar=false;
        for (Cliente c:listaClientes){
            if(c.getUsuario().equals(usuario) && c.getContraseña().equals(contraseña)){
                validar=true;
                cliente=c;
            }
        }
        return validar;

        
    }
    
    //comente este metodo porque me di cuenta
    // que en el anterior podemos inicializar la variable cliente:))))
    
//    public  void CargarCliente() {
////        String nombre="";
//        String usuario = txtUsuario.getText();
//        String contraseña = txtContraseña.getText();
////        cliente = new Cliente(txtUsuario.getText(), txtContraseña.getText());
//        for (Cliente i : listaClientes) {
//            if (i.getUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
//                cliente = i;
////                nombre=cliente.getNombre();
//            }
//        }
////        return cliente;
//    }
    
    public void MostrarMapa(){
        Pane paneroot=new Pane();
        ImageView imgvmapa=new ImageView();
        try(FileInputStream input=new FileInputStream(App.rutaImage+"Mapa2.png")){
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
        
        paneroot.getChildren().addAll(imgvmapa,btnregresar);
        Scene scene=new Scene(paneroot,950,650);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        
        btnregresar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                stage.close();
                CargarVentanaBienvenida();
            }
        });
 
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Local> listaLocales=Local.cargarLocales();
                for(Local l:listaLocales){
                    //numero aleatorio
                    long aleatorio = ((int)(Math.random()*10+1))*1000;
                    ImageView imgvubicacion=new ImageView();
                    // PARA PONER LOS SIMBOLOS DE UBICACIÓN
                    try(FileInputStream input=new FileInputStream(App.rutaImage+"Ubicacion.png")){
                        Image image=new Image(input,50,50,false,false);
                        imgvubicacion.setImage(image);
                    }catch(IOException e){
                        System.out.println("Archivo no encontrado"); 
                    }//try para poner imagen  

                    try{
                        Thread.sleep(aleatorio);
                        System.out.println(aleatorio);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }//try-catch para sleep
                    
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            imgvubicacion.setLayoutX(l.getCoordenadaX());
                            imgvubicacion.setLayoutY(l.getCoordenadaY());
                            paneroot.getChildren().add(imgvubicacion);
                        }//metodo run de platform
                    });//run 2
                    
                    imgvubicacion.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event ){
                            VBox popup=new VBox();
                            HBox hbox=new HBox();
                            Label nombreLocal=new Label(l.getNombre());
                            Label horario=new Label(l.getHorario());
                            Label direccion=new Label(l.getDireccion());
                            Label segundos=new Label();
                            Button aceptar=new Button("Aceptar");
                            hbox.getChildren().addAll(segundos,aceptar);
                            hbox.setSpacing(80);
                            aceptar.setStyle("-fx-background-color: skyblue");
                            nombreLocal.setStyle("-fx-font-weight: bold");
                            horario.setStyle("-fx-font-weight: bold");
                            direccion.setStyle("-fx-font-weight: bold");
                            segundos.setStyle("-fx-font-weight: bold");    
                            aceptar.setStyle("-fx-font-weight: bold");

                            Scene scene2=new Scene(popup,322,168);
                            Stage stage2=new Stage();
                            stage2.setScene(scene2);
                            stage2.show();

                            Thread t2 = new Thread(new Runnable() {
                                int i=6;

                                @Override
                                public void run() {
                                    while(i>=0){
                                        Platform.runLater(new Runnable() {
                                            @Override
                                            public void run() {
                                                segundos.setText("Mostrando "+i+" segundos");
                                                if(i==0){
                                                    stage2.close();
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

                            t2.setDaemon(true);
                            t2.start();

                            popup.getChildren().addAll(nombreLocal,horario,direccion,hbox);
                            popup.setStyle("-fx-background-color: orange");
                            popup.setSpacing(20);
                            popup.setPadding(new Insets(20, 20, 20, 20));

                            aceptar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t) {
                                    Stage stage = (Stage) aceptar.getScene().getWindow();
                                    stage.close();
                                }//handle para boton aceptar
                            });//clase anonima boton aceptar
                        }//handle para imgvubicacion
                    });//clase anonima imgvubicacion
            
                }//for
            }// run 1
        });
        
        t.setDaemon(true);
        t.start();
   
    } //INCOMPLETO
  
    
        
}







