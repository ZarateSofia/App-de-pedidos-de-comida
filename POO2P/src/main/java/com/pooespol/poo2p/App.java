package com.pooespol.poo2p;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    public static String ruta ="src/main/resources/com/pooespol/poo2p/";

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