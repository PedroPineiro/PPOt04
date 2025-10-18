package com.pedro.ej04_05;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    private final ArrayList<String> expresion = new ArrayList<>();
    private String operando1 = "";
    private String operando2 = "";
    private int num1;
    private int num2;
    private int resultado;
    private Estados estados = Estados.OPERANDO1;
    
    public void añadirDigito(String num){
        switch (estados) {
            case OPERANDO1 -> operando1 = operando1.concat(num);
            case OPERANDO2 -> operando2 = operando2.concat(num);
            default -> System.err.println("Error");
        }
    }

    public void operar(String operador){
        if (estados == Estados.OPERANDO1 && !operando1.isEmpty()) {
            expresion.add(operando1);
            expresion.add(operador);
            estados = Estados.OPERANDO2;
        }
        else{
            System.err.println("Error operando");
        }
    }

    public void calcularResultado(){
        try {
            if (estados == Estados.OPERANDO2 && !operando2.isEmpty()) {
            expresion.add(operando2);
            num1 = Integer.parseInt(expresion.get(0));
            num2 = Integer.parseInt(expresion.get(2));
            if (expresion.get(1).equals("+")) {
                resultado = num1 + num2;
                estados = Estados.RESULTADO;
            } else if(expresion.get(1).equals("-")){
                resultado = num1 - num2;
                estados = Estados.RESULTADO;
            }
            } else {
            System.err.println("Error");
            }
        } catch (NumberFormatException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    public void limpiar(){
        expresion.clear();
        operando1="";
        operando2="";
        num1=0;
        num2=0;
        resultado=0;
        estados = Estados.OPERANDO1;
    }

    public ArrayList<String> getExpresion() {
        return expresion;
    }

    public String getOperando1() {
        return operando1;
    }

    public String getOperando2() {
        return operando2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getResultado() {
        return resultado;
    }

    public Estados getEstados() {
        return estados;
    }

    

}
