package egg.web.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PortalControlador {

    @GetMapping("")
    public String index(ModelMap modelo) {
        modelo.put("creador", "George");
        return "index.html";
    }

//    @GetMapping("/autores")
//    public String autores() {
//        return "autores.html";
//    }
//
//    @GetMapping("/editoriales")
//    public String editoriales() {
//        return "editoriales.html";
//    }
//
//    @GetMapping("/libros")
//    public String libros() {
//        return "libros.html";
//    }
}
