package com.pedro.ej04_01;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class NumerosService {

    private final Set<Integer> lista = new LinkedHashSet<>();
    private final Random random = new Random();

    public Set<Integer> getLista() {
        return lista;
    }

    public void generarNumero(){
        boolean añadido;
        do {
            añadido = lista.add(random.nextInt(100) + 1);
        } while (!añadido);
    }

    public void eliminarNumero(Integer id){
        lista.remove(id);
    }
}
