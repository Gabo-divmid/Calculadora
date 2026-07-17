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
        if (entrada.equals("C")) {
        actualizarPantalla();
            pant.setText("");
            return;
        }

        if (calculoTerminado && entrada.matches("[0-9]")) {
        actualizarPantalla();
        }
        calculoTerminado = false;

        if (entrada.matches("[0-9]")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla();
        } 
        else if (entrada.equals("√")) {
            if (!opcion1.isEmpty() && operador.isEmpty()) {
                opcion1 = RaizCuadrada(opcion1);
                calculoTerminado = true;
                actualizarPantalla();
            }
        } 
        else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/")) {
            if (!opcion1.isEmpty()) {
                operador = entrada;
                actualizarPantalla();
            }
        } 
        else if (entrada.equals("=")) {
            if (opcion1.isEmpty() || operador.isEmpty() || opcion2.isEmpty()) {
                return; 
            }
            operador = "";
            opcion2 = "";
            calculoTerminado = true;
            actualizarPantalla();
        }
    }

    private void actualizarPantalla() {
        if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }
    }

    private String resultadoSuma(String numeroUno, String numeroDos) {
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        return String.valueOf(datoUno + datoDos);
    }

    private String resultadoResta(String numeroUno, String numeroDos) {
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        return String.valueOf(datoUno - datoDos);
    }

    private String resultadoMultiplicacion(String numeroUno, String numeroDos) {
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        return String.valueOf(datoUno * datoDos);
    }

    private String resultadoDiv(String numeroUno, String numeroDos) {
        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);
        return String.valueOf(datoUno / datoDos);
    }

    private String RaizCuadrada(String numeroUno) {
        try {
            double numero = Double.parseDouble(numeroUno);
            if (numero < 0) {
                return "Error";
            }
            return String.valueOf(Math.sqrt(numero));
        } catch (NumberFormatException e) {
            return "0";
        }
    }
}