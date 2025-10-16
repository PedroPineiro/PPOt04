package com.pedro.ej04_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NumerosController {

    @Autowired
    private NumerosService numerosService;

    @GetMapping({"/", "/list"})
    public String showList(Model model) {
        model.addAttribute("cantidadTotal", numerosService.getLista().size());
        model.addAttribute("listaNumeros", numerosService.getLista());
        return "listview";
    }

    @GetMapping("/new")
    public String showNew() {
        numerosService.generarNumero();
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id) {
        numerosService.eliminarNumero(id);
        return "redirect:/list";
    }
}
