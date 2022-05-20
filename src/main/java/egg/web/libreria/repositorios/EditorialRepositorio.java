
package egg.web.libreria.repositorios;

import egg.web.libreria.entidades.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {
    @Query("SELECT n FROM Editorial n WHERE n.nombre = :nombre")
    public List<Editorial> buscarPorNombre(@Param("nombre") String nombre);
}
