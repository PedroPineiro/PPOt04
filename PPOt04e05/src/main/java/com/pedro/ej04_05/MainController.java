package com.pedro.ej04_05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    
    private final MainService mainService = new MainService();
    
    @GetMapping({"/", "/home", "/index"})
    public String index(Model model) {
        model.addAttribute("operando1", mainService.getOperando1());
        model.addAttribute("operando2", mainService.getOperando2());
        model.addAttribute("estados", mainService.getEstados());
        model.addAttribute("Estados", Estados.class);
        if (mainService.getEstados() == Estados.RESULTADO) {
            model.addAttribute("resultado", mainService.getResultado());
        }
        return "indexView";
    }

    @GetMapping("/digito/{num}")
    public String añadirDigito(@PathVariable String num) {
        mainService.añadirDigito(num);
        return "redirect:/";
    }

    @GetMapping("/operacion/{operador}")
    public String operar(@PathVariable String operador) {
        mainService.operar(operador);
        return "redirect:/";
    }

    @GetMapping("/resultado")
    public String calcularResultado(Model model) {
        mainService.calcularResultado();
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String limpiar() {
        mainService.limpiar();
        return "redirect:/";
    }
}
