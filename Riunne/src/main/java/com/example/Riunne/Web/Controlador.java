package com.example.Riunne.Web;

import com.example.Riunne.Dominio.Articulo;
import com.example.Riunne.Servicio.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class Controlador {

    /*articulo service es una interfaz por ende no se puede instanciar
    * Spring lo que hace es buscar el tipo del dato en este caso
    * es la interfaz ArticuloService y cuando se da cuenta que es una
    * interfaz va a buscar una instancia de la implementacion que
    * se ha marcado con la anotacion Service
    * Lo mismo con ArticuloDao pero en ese caso spring crea la
    * implementacion automaticamente*/
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user ){
        var articulos = articuloService.listarArticulos();
        model.addAttribute("articulos", articulos);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Articulo articulo){
        return "layout/modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Articulo articulo, Errors errores){
        if(errores.hasErrors()){
            return "layout/modificar";
        }
        articuloService.guardar(articulo);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_articulo}")
    public String editar(Articulo articulo,Model model){
        articulo = articuloService.encontrarArticulo(articulo);
        model.addAttribute("articulo",articulo);
        return "layout/modificar";
    }

    @GetMapping("/eliminar/{id_articulo}")
    public String eliminar(Articulo articulo){
        articuloService.eliminar(articulo);
        return "redirect:/";
    }


}
