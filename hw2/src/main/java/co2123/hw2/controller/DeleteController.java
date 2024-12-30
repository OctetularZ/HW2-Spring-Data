package co2123.hw2.controller;

import co2123.hw2.model.Pupil;
import co2123.hw2.model.School;
import co2123.hw2.repo.GradeRepository;
import co2123.hw2.repo.PupilRepository;
import co2123.hw2.repo.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeleteController {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PupilRepository pupilRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @RequestMapping(value = "/deleteSchool")
    public String deleteSchool(@RequestParam("id") int id) {
        schoolRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/deletePupil")
    public String deletePupil(@RequestParam("name") String name) {
        // Find the pupil by name
        Pupil pupil = pupilRepository.findById(name).orElse(null);

        if (pupil == null) {
            return "redirect:/";
        }

        // Remove the pupil from all associated schools
        List<School> associatedSchools = pupil.getSchools();
        for (School school : associatedSchools) {
            school.getPupils().remove(pupil);
            if (school.getRepresentative() == pupil) {
                school.setRepresentative(null);
            }
            schoolRepository.save(school); // Update the school in the database
        }

        // Delete the pupil
        pupilRepository.delete(pupil);

        return "redirect:/";
    }

    @RequestMapping(value = "/deleteGrade")
    public String deleteGrade(@RequestParam("identifier") int identifier) {
        gradeRepository.deleteById(identifier);
        return "redirect:/";
    }
}
