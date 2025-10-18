package com.pedro.ej04_04;

import java.util.ArrayList;

public interface CalculosService {
    
    boolean esPrimo(int numero);

    public double calcularHipotenusa(double x, double y);

    public ArrayList<Integer> calcularDivisores(int x);

    public void limpiar();


}
