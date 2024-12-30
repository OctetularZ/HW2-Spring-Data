package co2123.hw2.controller;

import co2123.hw2.model.Grade;
import co2123.hw2.repo.GradeRepository;
import co2123.hw2.repo.PupilRepository;
import co2123.hw2.repo.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PupilRepository pupilRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @RequestMapping(value = "/listSchool")
    public String listSchool(Model model) {
        model.addAttribute("data", schoolRepository.findAll());
        model.addAttribute("title", "Schools");
        return "list";
    }

    @RequestMapping(value = "/listPupil")
    public String listPupil(Model model) {
        model.addAttribute("data", pupilRepository.findAll());
        model.addAttribute("title", "Pupils");
        return "list";
    }

    @RequestMapping(value = "/listGrade")
    public String listGrade(Model model) {
        model.addAttribute("data", gradeRepository.findAll());
        model.addAttribute("title", "Grades");
        return "list";
    }
}
