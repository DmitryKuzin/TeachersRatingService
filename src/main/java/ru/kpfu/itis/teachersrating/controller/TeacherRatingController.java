package ru.kpfu.itis.teachersrating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/rating", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Rating teacherVotingPage(@RequestParam("teacherId") Long teacherId, Principal principal) {
        User teacher = teacherService.getById(teacherId);
        if (teacher == null) {
            throw new ResourceNotFoundException();
        }
        String name = principal.getName();
        User user = teacherService.get(name);
        Rating rating = null;
        if (user != null) {
            rating = ratingService.getByTeacherAndStudent(teacher, user);
        }
        if (rating == null) {
            rating = new Rating();
            rating.setTeacher(teacher);
        }
        return rating;
    }

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public ResponseEntity<Void> teacherRate(@RequestParam("teacherId") Long teacherId,
                                            @RequestParam("rate") Integer rate, Principal principal) {
        String name = principal.getName();
        User user = teacherService.get(name);
        User teacher = teacherService.getById(teacherId);
        if (teacher == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        Rating rating = null;
        if (user != null) {
            rating = ratingService.getByTeacherAndStudent(teacher, user);
        }
        if (rating == null) {
            rating = new Rating();
            rating.setTeacher(teacher);
            rating.setStudent(user);
        }
        rating.setValue(rate);
        ratingService.vote(rating);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public String notFoundException() {
        return "404";
    }

}
