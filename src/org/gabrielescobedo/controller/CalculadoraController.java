
package org.gabrielescobedo.controller;

import javafx.scene.control.Label;
 
public class CalculadoraController {
 
    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = true;
 
    public CalculadoraController() {
    }
 
    public void procesoDeEntrada(String entrada, Label pant) {
        if (entrada.equals("C")){
             opcion1 = "";
             operador = "";
             opcion2 = "";
             pant.setText("");
        }

        if ( calculoTerminado && entrada.matches("[0-9]")){
             opcion1 = "";
             operador = "";
             opcion2 = "";
        }
        calculoTerminado = false;
 
        if (entrada.matches("[0-9]")) {
            if  (operador.isEmpty()){
               opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pant); 
        } 

        else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/")) { 
            operador = entrada;
            actualizarPantalla(pant);
        } else if (entrada.equals("=")){
            if (operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
            } else if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
            } else if (operador.equals("*")) {
                opcion1 = resultadoMultiplicacion(opcion1, opcion2);
            } else if (operador.equals("/")) {
                opcion1 = resultadoDiv(opcion1, opcion2);
            }
            operador = "";
            opcion2 = "";
            calculoTerminado = true; 
            actualizarPantalla(pant);
        }
    }
 
    private void actualizarPantalla(Label pantalla) {
        if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }
 
 
    private String resultadoSuma(String numeroUno, String numeroDos){
         int datoUno = Integer.parseInt(numeroUno);
         int datoDos = Integer.parseInt(numeroDos);
         int suma = datoUno + datoDos;
         return String.valueOf(suma);
    }
 
    private String resultadoResta(String numeroUno, String numeroDos){
         int datoUno = Integer.parseInt(numeroUno);
         int datoDos = Integer.parseInt(numeroDos);
         int resta = datoUno - datoDos;
         return String.valueOf(resta);
    }
 
    private String resultadoMultiplicacion(String numeroUno, String numeroDos){
         int datoUno = Integer.parseInt(numeroUno);
         int datoDos = Integer.parseInt(numeroDos);
         int multiplicacion = datoUno * datoDos;
         return String.valueOf(multiplicacion);
    }
 
    private String resultadoDiv(String numeroUno, String numeroDos){
         double datoUno = Double.parseDouble(numeroUno);
         double datoDos = Double.parseDouble(numeroDos);
         double div = datoUno / datoDos;
         return String.valueOf(div);
    }
}