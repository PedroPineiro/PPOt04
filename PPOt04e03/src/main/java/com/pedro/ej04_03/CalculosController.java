package com.pedro.ej04_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/calculos")
public class CalculosController {

    @Autowired
    private CalculosService calculosService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/primo")
    public String esPrimo(@RequestParam int numero) {
        boolean resultadoEsPrimo = calculosService.esPrimo(numero);
        return "resultadoPrimo";
    }
    
    
    @GetMapping("/hipotenusa/{x}/{y}")
    public String hipotenusa(@PathVariable int x, @PathVariable int y) {
        return "resultadoHipotenusa";
    }

    @GetMapping("/divisores/{x}")
    public String divisores(@PathVariable int x) {
        return "resultadoDivisores";
    }
    
    

    
}