package ru.kpfu.itis.teachersrating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.teachersrating.model.Institute;
import ru.kpfu.itis.teachersrating.model.TeacherRating;
import ru.kpfu.itis.teachersrating.repository.TeacherRatingRepository;
import ru.kpfu.itis.teachersrating.service.TeacherRatingService;

import java.util.List;

@Service
public class TeacherRatingServiceImpl implements TeacherRatingService {
    @Autowired
    private TeacherRatingRepository teacherRatingRepository;

    @Override
    public List<TeacherRating> getTeachersRatingsByInstitute(Institute institute) {
        return teacherRatingRepository.findTeacherRatingsByInstituteId(institute.getId());
    }
}
