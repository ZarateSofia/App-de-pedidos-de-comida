package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader=new FXMLLoader(App.class.getResource("InicioSesion.fxml"));
        Parent root=fxmLoader.load();
        scene=new Scene(root,640,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Inicio de Sesion");
 
    }
    public static void main(String[] args) {
        launch();
    }

}