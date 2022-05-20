package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.repositorios.AutorRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void guardar(String nombre, Boolean alta) throws ErrorServicio {
        if (nombre == null || nombre.trim().isEmpty()) {
        throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
        if (alta == null || alta.toString().isEmpty()) {
        throw new ErrorServicio("El alta del autor no puede ser nulo");
        }
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);
        autorRepositorio.save(autor);
    }

    @Transactional
    public void modificar(String id, String nombre, Boolean alta) throws ErrorServicio {
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = autorRepositorio.findById(id).get();
            autor.setNombre(nombre);
            autor.setAlta(alta);
            autorRepositorio.save(autor);
        } else {
            throw new ErrorServicio("No se encrontró el autor");
        }
    }
}
