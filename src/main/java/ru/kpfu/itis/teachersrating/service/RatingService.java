package ru.kpfu.itis.teachersrating.service;

import ru.kpfu.itis.teachersrating.model.Rating;
import ru.kpfu.itis.teachersrating.model.User;

import java.util.List;

public interface RatingService {
    Rating getByTeacherAndStudent(User teacher, User student);
    List<Rating> getByTeacher(User teacher);
}
