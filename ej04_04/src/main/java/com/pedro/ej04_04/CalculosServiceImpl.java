package com.pedro.ej04_04;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CalculosServiceImpl implements CalculosService {

    final ArrayList<Integer> divisores = new ArrayList<>();
    
    @Override
    public boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    @Override
    public double calcularHipotenusa(double x, double y){
        return Math.hypot(x, y);
    }

    @Override
    public ArrayList<Integer> calcularDivisores(int x){
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                divisores.add(i);
            }
        }
        return divisores;
    }

    @Override
    public void limpiar(){
        divisores.clear();
    }
}
