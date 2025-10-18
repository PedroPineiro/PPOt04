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
    public String esPrimo(@RequestParam(required=false) Integer numero, Model model) {
        try {
            if (numero == null) {
                throw new IllegalArgumentException("Se tiene que mandar un parámetro");
            }
            else if(numero < 0) {
                throw new IllegalArgumentException("El número no puede ser negativo.");
            }
            else{
                boolean resultadoEsPrimo = calculosService.esPrimo(numero);
                model.addAttribute("resultadoEsPrimo", resultadoEsPrimo);
                model.addAttribute("numero", numero);
                return "resultadoPrimo";
            }
            
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensajeError", e.getMessage());
            return "errorView";
        } 
    }
    
    
    @GetMapping("/hipotenusa/{x}/{y}")
    public String hipotenusa(@PathVariable int x, @PathVariable int y, Model model) {
        try {
            if(x > 0 && y > 0){
                double resultadoHipotenusa = calculosService.calcularHipotenusa(x, y);
                model.addAttribute("resultadoHipotenusa",resultadoHipotenusa);
                return "resultadoHipotenusa";
            }
            else{
                throw new IllegalArgumentException("Los catetos deben mayores que 0.");
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensajeError", e.getMessage());
            return "errorView";
        }
    }

    @GetMapping("/divisores/{x}")
    public String divisores(@PathVariable int x, Model model) {
        try {
            if(x > 0){
                calculosService.limpiar();
                ArrayList<Integer> listaDivisores = calculosService.calcularDivisores(x);
                model.addAttribute("listaDivisores", listaDivisores);
                return "resultadoDivisores";
            } else{
                throw new IllegalArgumentException("El número debe ser mayor que 0.");
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensajeError", e.getMessage());
            return "errorView";
        }
    }
}