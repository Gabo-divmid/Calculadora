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

        if (calculoTerminado && (entrada.matches("[0-9]") || entrada.equals("."))){
             opcion1 = "";
             operador = "";
             opcion2 = "";
        }
        
        if (entrada.matches("[0-9]") || entrada.equals(".")) {
            calculoTerminado = false;
            
            if (operador.isEmpty()){
                if (entrada.equals(".") && opcion1.contains(".")) return; 
                if (entrada.equals(".") && opcion1.isEmpty()) opcion1 = "0";
                opcion1 += entrada;
            } else {
                if (entrada.equals(".") && opcion2.contains(".")) return; 
                if (entrada.equals(".") && opcion2.isEmpty()) opcion2 = "0";
                opcion2 += entrada;
            }
            actualizarPantalla(pant); 
        } 
        else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/") || entrada.equals("^")) { 
            calculoTerminado = false;
            if (opcion1.endsWith(".")) opcion1 += "0";
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
        else if (entrada.equals("%")) {

            if (!operador.isEmpty() && !opcion2.isEmpty()) {
                opcion2 = resultadoPorcentajeInstantaneo(opcion1, opcion2);
            } 
            else if (!opcion1.isEmpty() && operador.isEmpty()) {
                opcion1 = resultadoPorcentajeDirecto(opcion1);
                calculoTerminado = true;
            }
            actualizarPantalla(pant);
        }
        else if (entrada.equals("=")){
            if (opcion1.endsWith(".")) opcion1 += "0";
            if (opcion2.endsWith(".")) opcion2 += "0";

            if (operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
            } else if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
            } else if (operador.equals("*")) {
                opcion1 = resultadoMultiplicacion(opcion1, opcion2);
            } else if (operador.equals("/")) {
                opcion1 = resultadoDivision(opcion1, opcion2);
            } else if (operador.equals("^")) {
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
         double datoUno = Double.parseDouble(numeroUno);
         double datoDos = Double.parseDouble(numeroDos);
         return String.valueOf(datoUno + datoDos);
    }

    private String resultadoResta(String numeroUno, String numeroDos){
         double datoUno = Double.parseDouble(numeroUno);
         double datoDos = Double.parseDouble(numeroDos);
         return String.valueOf(datoUno - datoDos);
    }

    private String resultadoMultiplicacion(String numeroUno, String numeroDos){
         double datoUno = Double.parseDouble(numeroUno);
         double datoDos = Double.parseDouble(numeroDos);
         return String.valueOf(datoUno * datoDos);
    }

    private String resultadoDivision(String numeroUno, String numeroDos){
         double datoUno = Double.parseDouble(numeroUno);
         double datoDos = Double.parseDouble(numeroDos);
         if (datoDos == 0) return "Error"; 
         return String.valueOf(datoUno / datoDos);
    }

    private String resultadoRaizCuadrada(String numero) {
        if (numero.isEmpty() || numero.equals("Error")) return "0";
        double dato = Double.parseDouble(numero);
        if (dato < 0) return "Error";
        return String.valueOf(Math.sqrt(dato));
    }

    private String resultadoPotencia(String baseStr, String exponenteStr) {
        if (baseStr.isEmpty() || baseStr.equals("Error")) return "Error";
        if (exponenteStr.isEmpty()) return baseStr;
        double base = Double.parseDouble(baseStr);
        double exponente = Double.parseDouble(exponenteStr);
        return String.valueOf(Math.pow(base, exponente));
    }
    private String resultadoPorcentajeInstantaneo(String numeroBase, String numeroPorc) {
        double base = Double.parseDouble(numeroBase);
        double porc = Double.parseDouble(numeroPorc);
        return String.valueOf((base * porc) / 100);
    }
    private String resultadoPorcentajeDirecto(String numero) {
        double dato = Double.parseDouble(numero);
        return String.valueOf(dato / 100);
    }
}