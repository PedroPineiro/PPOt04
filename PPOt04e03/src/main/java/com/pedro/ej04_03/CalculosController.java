package com.pedro.ej04_03;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String esPrimo(@RequestParam int numero, Model model) {
        boolean resultadoEsPrimo = calculosService.esPrimo(numero);
        model.addAttribute("resultadoEsPrimo", resultadoEsPrimo);
        model.addAttribute("numero", numero);
        return "resultadoPrimo";
    }
    
    
    @GetMapping("/hipotenusa/{x}/{y}")
    public String hipotenusa(@PathVariable int x, @PathVariable int y, Model model) {
        double resultadoHipotenusa = calculosService.calcularHipotenusa(x, y);
        model.addAttribute("resultadoHipotenusa",resultadoHipotenusa);
        return "resultadoHipotenusa";
    }

    @GetMapping("/divisores/{x}")
    public String divisores(@PathVariable int x, Model model) {
        calculosService.limpiar();
        ArrayList<Integer> listaDivisores = calculosService.calcularDivisores(x);
        model.addAttribute("listaDivisores", listaDivisores);
        return "resultadoDivisores";
    }
}