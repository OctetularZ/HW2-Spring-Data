package co2123.hw2.repo;

import co2123.hw2.model.School;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface SchoolRepository extends CrudRepository<School, Integer> {
    List<School> findByLocation(String location); // Find schools by location

    List<School> findByRepresentativeName(String name); // Find schools by the representative's name
}
