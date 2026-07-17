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
             calculoTerminado = true;
             return;
        }

        if (calculoTerminado && entrada.matches("[0-9]")){
             opcion1 = "";
             operador = "";
             opcion2 = "";
        }
        
        if (entrada.matches("[0-9]")) {
            calculoTerminado = false;
            if (operador.isEmpty()){
               opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pant); 
        } 
        // Agregamos el símbolo "^" a la lista de operadores tradicionales
        else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/") || entrada.equals("^")) { 
            calculoTerminado = false;
            operador = entrada;
            actualizarPantalla(pant);
        } 
        else if (entrada.equals("√")) {
            if (!opcion2.isEmpty()) {
                opcion2 = resultadoRaizCuadrada(opcion2);
            } else if (!opcion1.isEmpty()) {
                opcion1 = resultadoRaizCuadrada(opcion1);
                operador = ""; 
            }
            calculoTerminado = true; 
            actualizarPantalla(pant);
        }
        else if (entrada.equals("=")){
            if (operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
            } else if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
            } else if (operador.equals("*")) {
                opcion1 = resultadoMultiplicacion(opcion1, opcion2);
            } else if (operador.equals("/")) {
                opcion1 = resultadoDivision(opcion1, opcion2);
            } 
            else if (operador.equals("^")) {
                opcion1 = resultadoPotencia(opcion1, opcion2);
            }
            operador = "";
            opcion2 = "";
            calculoTerminado = true; 
            actualizarPantalla(pant);
        }
    }
    private void actualizarPantalla(Label pantalla) {
        if (opcion1.equals("Error")) {
            pantalla.setText("Error");
            return;
        }
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

    private String resultadoDivision(String numeroUno, String numeroDos){
         double datoUno = Double.parseDouble(numeroUno);
         double datoDos = Double.parseDouble(numeroDos);

         if (datoDos == 0) {
             return "Error"; 
         }

         double division = datoUno / datoDos;
         return String.valueOf(division);
    }

    private String resultadoRaizCuadrada(String numero) {
        if (numero.isEmpty() || numero.equals("Error")) {
            return "0";
        }
        double dato = Double.parseDouble(numero);
        if (dato < 0) {
            return "Error";
        }
        double raiz = Math.sqrt(dato);
        return String.valueOf(raiz);
    }
    private String resultadoPotencia(String baseStr, String exponenteStr) {
        if (baseStr.isEmpty() || baseStr.equals("Error")) return "Error";
        if (exponenteStr.isEmpty()) return baseStr;
        double base = Double.parseDouble(baseStr);
        double exponente = Double.parseDouble(exponenteStr);
        double resultado = Math.pow(base, exponente);
        return String.valueOf(resultado);
    }
}