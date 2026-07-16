
package org.gabrielescobedo.system;

import javafx.application.Application;
import javafx.scene.Scene;   
import javafx.stage.Stage;
import org.gabrielescobedo.view.CalculadoraView;
 
 
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        CalculadoraView calculadora = new CalculadoraView();

        // Se le pasa la vista directamente a la escena
        Scene scene = new Scene(calculadora.getView(), 260, 390);

        primaryStage.setTitle("CalculadoraFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
