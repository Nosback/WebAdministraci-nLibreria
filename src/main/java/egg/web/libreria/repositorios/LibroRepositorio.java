
package egg.web.libreria.repositorios;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.entidades.Editorial;
import egg.web.libreria.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public List<Libro> buscarLibroPorTitulo(@Param("titulo") String titulo);
    
    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    public Libro buscarLibroPorIsbn(@Param("isbn") Long isbn);
    
    // En esta Query estoy realizando la busqueda con dos parametros de a misma clase 
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo AND l.anio = :anio")
    public List<Libro> buscarLibroPorTituloYAnio(@Param("titulo") String titulo, @Param("anio") Integer anio);
    
    // En esta Query estoy utilizando la relación 
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro> buscarLibroPorAutor(@Param("nombre") Autor nombre);
    
    // En esta Query estoy utilizando la relación 
    @Query("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombre")
    public List<Libro> buscarLibroPorEditorial(@Param("nombre") Editorial nombre);
    
    
}
