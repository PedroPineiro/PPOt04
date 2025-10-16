package com.pedro.ej04_03;

import org.springframework.stereotype.Service;

@Service
public class CalculosService {
    
    public boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    public double calcularHipotenusa(double x, double y){
        return Math.hypot(x, y);
    }

    public String calcularDivisores(int x){
        StringBuilder divisores = new StringBuilder();
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                divisores.append(i).append(" ");
            }
        }
        return divisores.toString().trim();
    }
}
