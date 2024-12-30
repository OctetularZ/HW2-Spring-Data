package co2123.hw2.repo;

import co2123.hw2.model.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface GradeRepository extends CrudRepository<Grade, Integer> {
    List<Grade> findByMark(int mark); // Find grades by mark
}
