package egg.web.libreria.controladores;

import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/autores")
    public String ruta() {
        return "autores.html";
    }                   

//    @GetMapping("/registrar")
//    public String guardar() {
//        return "registrar.html";
//    }

    @PostMapping("/autores")
    public String formulario(@RequestParam String nombre) throws ErrorServicio {
        try {
            autorServicio.guardar(nombre, true);
        } catch (ErrorServicio e) {
            e.getMessage();
            return "autores.html";
        }
        return "autores.html";
    }

}
