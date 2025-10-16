package com.pedro.ej04_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class MathController {

    @Autowired
    private MathService mathService;

    private String txtStatus=null;

    @GetMapping({"/index","/","","/home"})
    public String showList(Model model) {
        if(txtStatus !=null){
            model.addAttribute("txtError", txtStatus);
            txtStatus = null;
        }
        return "index";
    }

    @GetMapping("/calcularHipotenusa/{cat1}/{cat2}") 
        public String showHipotenusa(@PathVariable String cat1,@PathVariable String cat2, Model model) { 
            double cateto1, cateto2; 
            try { 
                //Pasamos los parámetros de String a Double
                cateto1 = Double.parseDouble(cat1);
                cateto2 = Double.parseDouble(cat2); 
                model.addAttribute("resultado", 
                mathService.calcularHipotenusa(cateto1, cateto2)); //otra excepción
                
                return "resultadoView"; 
                
                // Captura inválida por introducir letras/símbolos/etc en ved de números
            } catch (NumberFormatException nfe) { 
                txtStatus="Error en parámetros de entrada, al menos alguno de los catetos no es un número"; 
                return "redirect:/"; 
                
                //Capturas de Ecepciones personalizadas
            } catch (RuntimeException ex) {txtStatus=ex.getMessage(); 
                return "redirect:/";
            } 
    } 
    
}


// APUNTES
// el @Scope("session") se añade en el service
// un service es la logica de negocio, vemos lo que pide el cliente, metodos