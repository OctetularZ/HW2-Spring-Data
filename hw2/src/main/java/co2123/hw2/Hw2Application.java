package co2123.hw2;

import co2123.hw2.model.Grade;
import co2123.hw2.model.Pupil;
import co2123.hw2.model.School;
import co2123.hw2.repo.GradeRepository;
import co2123.hw2.repo.PupilRepository;
import co2123.hw2.repo.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw2Application implements CommandLineRunner {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PupilRepository pupilRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Grade> grades = new ArrayList<>();
        List<Pupil> pupils = new ArrayList<>();
        List<School> schools = new ArrayList<>();

        Grade grade = new Grade();
        grade.setIdentifier(1);
        grade.setMark(70);

        grade = gradeRepository.save(grade);
        grades.add(grade);

        Pupil pupil = new Pupil();
        pupil.setName("Randy");
        pupil.setSchools(schools);
        pupil.setGrades(grades);
        pupil.setBest(grade);

        pupil = pupilRepository.save(pupil);

        School school = new School();
        school.setId(1);
        school.setLocation("Leicester");
        school.setPupils(pupils);
        school.setRepresentative(pupil);

        school = schoolRepository.save(school);

        pupil.getSchools().add(school);
        pupilRepository.save(pupil);
        school.getPupils().add(pupil);
        schoolRepository.save(school);
    }
}
