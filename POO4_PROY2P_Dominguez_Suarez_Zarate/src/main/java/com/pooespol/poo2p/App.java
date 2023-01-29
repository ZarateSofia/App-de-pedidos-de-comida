package com.pooespol.poo2p;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Comida;


/**
 * JavaFX App
 */
public class App extends Application {
    /**
     * Escenario donde esta el root con la informacion a mostrar
     */
    public static Scene scene;
    
    /**
     * Ruta de las imagenes
     */
    public static String rutaImage ="src/main/resources/images/";
    
    /**
     * Ruta de los archivos
     */
    public static String rutaFile ="src/main/resources/files/";
    
    /**
     * Lista de todas las comidas 
     */
    public static ArrayList<Comida> ListaComida=Comida.CargarMenu();

    /**
     * Mostramos la ventana principal
     * @param stage. Escenario a ser mostrado
     * @throws Exception Excepcion verificada que es lanzada por el metodo
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader=new FXMLLoader(App.class.getResource("VentanaInicio.fxml"));
        Parent root=fxmLoader.load();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
      
        
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    

    public static void main(String[] args) {
        launch();
    }

}