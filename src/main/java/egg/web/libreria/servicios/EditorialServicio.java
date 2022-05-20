
package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Editorial;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.repositorios.EditorialRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void guardar(String nombre, Boolean alta) throws ErrorServicio{
        if (nombre == null || nombre.isEmpty()) {
        throw new ErrorServicio("El nombre de la editorial no puede ser nulo");
        }
        if (alta == null || alta.toString().isEmpty()) {
        throw new ErrorServicio("El alta de la editorial no puede ser nula");
        }
    Editorial editorial = new Editorial();
    editorial.setNombre(nombre);
    editorial.setAlta(alta);
    editorialRepositorio.save(editorial);
    }
    
    @Transactional
    public void modificar(String id, String nombre, Boolean alta) throws ErrorServicio {
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial editorial = editorialRepositorio.findById(id).get();
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
            editorialRepositorio.save(editorial);
        } else {
            throw new ErrorServicio("No se encrontró la editorial");
        }
    }
}
