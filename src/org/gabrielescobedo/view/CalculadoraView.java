package org.gabrielescobedo.view;
   
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene. layout. GridPane;
import javafx.scene.layout. VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.gabrielescobedo.controller.CalculadoraController;

public class CalculadoraView {
    
private final VBox view;
private final Label pantalla;
private final   GridPane cuadroBotones;
 
//Controller
private CalculadoraController Controlador;
    Controlador = new CalculadoraController;
 
public CalculadoraView() {
view = new VBox(15);
view.setPadding(new Insets(15));
view.setAlignment(Pos.CENTER);
view.setStyle("-fx-background-color: #0992C8;");
 
pantalla = new Label("0");
pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
pantalla.setAlignment(Pos.CENTER_RIGHT);
pantalla.setPrefSize(220, 50);
 
cuadroBotones = new GridPane();
cuadroBotones.setHgap(10);// Interlineado cuadricula
cuadroBotones.setVgap(10);
cuadroBotones.setAlignment(Pos.CENTER);
view.getChildren().addAll(pantalla, cuadroBotones);//Alineado al centro

Button btnUno = nuevoBoton("1");
btnUno
Button btnDos = nuevoBoton("2");
Button btnTres = nuevoBoton("3");
Button btnCuatro = nuevoBoton("4");
Button btnCinco = nuevoBoton("5");
Button btnSeis = nuevoBoton("6");
Button btnSiete = nuevoBoton("7");
Button btnOcho = nuevoBoton("8");
Button btnNueve = nuevoBoton("9");
Button btnMenos = nuevoBoton("-");
Button btnMas = nuevoBoton("+");
Button btnMultiplicacion = nuevoBoton("x");

cuadroBotones.add(btnUno, 0, 3);
cuadroBotones.add(btnDos, 1, 3);
cuadroBotones.add(btnTres, 2, 3);
cuadroBotones.add(btnCuatro, 0, 4);
cuadroBotones.add(btnCinco,1, 4);
cuadroBotones.add(btnSeis, 2, 4);
cuadroBotones.add(btnSiete, 0, 5);
cuadroBotones.add(btnOcho, 1, 5);
cuadroBotones.add(btnNueve, 2, 5);
cuadroBotones.add(btnMas, 3, 3);
cuadroBotones.add(btnMenos, 3, 4);
cuadroBotones.add(btnMultiplicacion, 3, 5);
        }
public VBox  getView(){
return view;
}
    private Button nuevoBoton (String texto){
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setStyle("-fX-Dackground-color. #6B8E25, -fx-text-filt:white, -ft-background-radi0s : 5px, -fx-cursor: hand;");
        btn.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));
        btn.setOnMousePressed(e ->{
        btn.setStyle("-fx-background-color: #055270;");
        btn.setTranslateY(2);
});
        btn.setOnMouseReleased(e ->{
        btn.setStyle("-fx-background-color:#055270;");
        btn.setTranslateY(0);
});
        btn.setOnAction(e-> controller.procesoDeEntrada(texto,pantalla));
        return btn;
        
    }
}

