package ru.kpfu.itis.teachersrating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.teachersrating.exception.ResourceNotFoundException;
import ru.kpfu.itis.teachersrating.model.Institute;
import ru.kpfu.itis.teachersrating.model.Rating;
import ru.kpfu.itis.teachersrating.model.StudentGroup;
import ru.kpfu.itis.teachersrating.model.User;
import ru.kpfu.itis.teachersrating.service.*;

import java.security.Principal;
import java.util.List;

@Controller
public class TeacherRatingController {

    @Autowired
    private InstituteService instituteService;

    @Autowired
    private StudentGroupService studentGroupService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/institutes", method = RequestMethod.GET)
    public String allInstitutesPage(Model model) {
        model.addAttribute("institutes", instituteService.getAll());
        return "institutes";
    }

    @RequestMapping(value = "/institutes/{instituteId}/groups", method = RequestMethod.GET)
    public String institutePage(@PathVariable Long instituteId, Model model) {
        Institute institute = instituteService.getById(instituteId);
        if (institute == null) {
            throw new ResourceNotFoundException();
        }
        List<StudentGroup> studentGroups = studentGroupService.getByInstitute(institute);
        model.addAttribute("institute", institute);
        model.addAttribute("studentGroups", studentGroups);
        return "instituteGroups";
    }

    @RequestMapping(value = "/institutes/{instituteId}/groups/{groupId}/teachers", method = RequestMethod.GET)
    public String teachersPage(@PathVariable Long instituteId, @PathVariable Long groupId, Model model) {
        Institute institute = instituteService.getById(instituteId);
        StudentGroup group = studentGroupService.getById(groupId);
        if (institute == null || group == null) {
            throw new ResourceNotFoundException();
        }
        List<User> teachers = teacherService.getByStudentGroup(group);
        model.addAttribute("institute", institute);
        model.addAttribute("group", group);
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    //TODO:страница голосования
    @RequestMapping(value = "/vote/teachers/{teacherId}", method = RequestMethod.GET)
    public String teacherVotingPage(@PathVariable Long teacherId, Model model, Principal principal) {
        User teacher = teacherService.getById(teacherId);
        if (teacher == null) {
            throw new ResourceNotFoundException();
        }
        String name = principal.getName();
        User user = teacherService.get(name);
        Rating rating = ratingService.getByTeacherAndStudent(teacher, user);
        model.addAttribute("teacher", teacher);
        model.addAttribute("rating", rating);
        return "teacherVote";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public String notFoundException() {
        return "404";
    }

}
