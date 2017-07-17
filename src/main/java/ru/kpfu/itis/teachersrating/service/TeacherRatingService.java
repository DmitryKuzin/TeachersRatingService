package ru.kpfu.itis.teachersrating.service;

import ru.kpfu.itis.teachersrating.model.Institute;
import ru.kpfu.itis.teachersrating.model.TeacherRating;

import java.util.List;

public interface TeacherRatingService {
    List<TeacherRating> getTeachersRatingsByInstitute(Institute institute);
}
