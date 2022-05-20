package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.entidades.Editorial;
import egg.web.libreria.entidades.Libro;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.repositorios.LibroRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {

    private LibroRepositorio libroRepositorio;

    @Transactional
    public void guardar(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) throws ErrorServicio {
        
        if (isbn == null || isbn.toString().trim().isEmpty()) {
        throw new ErrorServicio("El isbn del libro no puede ser nulo");
        }
        if (titulo == null || titulo.isEmpty()) {
        throw new ErrorServicio("El titulo del libro no puede ser nulo");
        }
        if (anio == null || anio.toString().isEmpty()) {
        throw new ErrorServicio("El año del libro no puede ser nulo");
        }
         Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libro.setAlta(alta);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

    @Transactional
    public void modificar(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) throws ErrorServicio {
        Optional<Libro> respuesta = libroRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Libro libro = libroRepositorio.findById(id).get();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(alta);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            libroRepositorio.save(libro);
        } else {
            throw new ErrorServicio("No se encontró el libro");
        }
    }
}
