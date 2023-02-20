package rendujava.rendu.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rendujava.rendu.Model.Dessin;

import java.util.List;
import java.util.Optional;

@Repository
public interface DessinRepository extends CrudRepository<Dessin, Integer> {

    Optional<Dessin> findById(int Id);
    Optional<Dessin> findByName(String Name);
    List<Dessin> findAll();
}
