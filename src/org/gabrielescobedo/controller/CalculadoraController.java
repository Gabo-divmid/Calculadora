
package org.gabrielescobedo.controller;

import javafx.scene.control.Label;

//Si
public class CalculadoraController {
    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = true;
    
    public CalculadoraController() {
       
    }
 
    public void porcesoDeEntrada(String entrada, Label pantalla){
        if (entrada.matches("0-9")) {

            opcion1 += entrada;
            
            actualizarPantalla(pantalla);
    }
   }
    private void actualizarPantalla(Label pantalla){
        if(operador.isEmpty()){
            pantalla.setText(opcion1);
        }
    }

}
    