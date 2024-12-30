package co2123.hw2.repo;

import co2123.hw2.model.Pupil;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface PupilRepository extends CrudRepository<Pupil, String> {
    List<Pupil> findByName(String name); // Find pupils by name
}
