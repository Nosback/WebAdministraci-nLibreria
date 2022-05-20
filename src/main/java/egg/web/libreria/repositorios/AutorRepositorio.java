
package egg.web.libreria.repositorios;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
    @Query("SELECT n FROM Autor n WHERE n.nombre = :nombre")
    public List<Autor> buscarPorNombre(@Param("nombre") String nombre);
    
    // En esta Query estoy uniendo tablas que no tienen relación para listar todos los autores por editorial
    @Query("SELECT a FROM Autor a JOIN Editorial e WHERE e.nombre = :nombre")
    public List<Autor> buscarAutoresPorEditorial(@Param("nombre") String nombre);
}
