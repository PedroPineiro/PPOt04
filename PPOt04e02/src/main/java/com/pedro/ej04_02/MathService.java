package com.pedro.ej04_02;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    
    public double calcularHipotenusa(double cat1, double cat2) throws RuntimeException{
        if(cat1<=0 || cat2<=0){
            throw new RuntimeException("Los catetos deben ser mayores que 0");
        }
        else if(cat1>=1000 || cat2>=1000){
            throw new RuntimeException("Los catetos deben ser menores que 1000");
        }
        else{
            return Math.hypot(cat1, cat2);
        }
    }
    
}
