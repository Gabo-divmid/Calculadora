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
private final CalculadoraController Controller;


public CalculadoraView() {
       Controller = new CalculadoraController();
    
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
Button btnDos = nuevoBoton("2");
Button btnTres = nuevoBoton("3");
Button btnCuatro = nuevoBoton("4");
Button btnCinco = nuevoBoton("5");
Button btnSeis = nuevoBoton("6");
Button btnSiete = nuevoBoton("7");
Button btnOcho = nuevoBoton("8");
Button btnNueve = nuevoBoton("9");
Button btnCero = nuevoBoton("0");
Button btnMenos = nuevoBoton("-");
Button btnMas = nuevoBoton("+");
Button btnMult = nuevoBoton("*");
Button btnDiv = nuevoBoton("/");
Button btnIgual = nuevoBoton("=");
Button btnRaiz = nuevoBoton("√");
Button btnporcentaje = nuevoBoton("%");
Button btnpotencia = nuevoBoton("^");
Button btnpuntod = nuevoBoton(".");
Button btnC = nuevoBoton("C");

cuadroBotones.add(btnUno, 0, 3);
cuadroBotones.add(btnDos, 1, 3);
cuadroBotones.add(btnTres, 2, 3);
cuadroBotones.add(btnCuatro, 0, 4);
cuadroBotones.add(btnCinco,1, 4);
cuadroBotones.add(btnSeis, 2, 4);
cuadroBotones.add(btnSiete, 0, 5);
cuadroBotones.add(btnOcho, 1, 5);
cuadroBotones.add(btnNueve, 2, 5);
cuadroBotones.add(btnCero, 1, 6);
cuadroBotones.add(btnMas, 3, 5);
cuadroBotones.add(btnMenos, 3, 4);
cuadroBotones.add(btnIgual, 3, 6);
cuadroBotones.add(btnC, 3, 3);
cuadroBotones.add(btnMult, 0, 6);
cuadroBotones.add(btnDiv, 2, 6);
cuadroBotones.add(btnRaiz, 0, 7);
cuadroBotones.add(btnpuntod, 1, 7);
cuadroBotones.add(btnporcentaje, 2, 7);
cuadroBotones.add(btnpotencia, 3, 7);

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
        btn.setOnAction(e-> Controller.procesoDeEntrada(texto,pantalla));
        return btn;
        
    }
}

