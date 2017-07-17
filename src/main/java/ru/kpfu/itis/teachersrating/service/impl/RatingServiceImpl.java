package ru.kpfu.itis.teachersrating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.teachersrating.model.Rating;
import ru.kpfu.itis.teachersrating.model.User;
import ru.kpfu.itis.teachersrating.repository.RatingRepository;
import ru.kpfu.itis.teachersrating.service.RatingService;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating getByTeacherAndStudent(User teacher, User student) {
        return ratingRepository.findRatingByTeacherIdAndStudentId(teacher.getId(), student.getId());
    }

    @Override
    public List<Rating> getByTeacher(User teacher) {
        return ratingRepository.findRatingsByTeacherId(teacher.getId());
    }

    @Override
    public Rating vote(Rating rating) {
        return ratingRepository.save(rating);
    }
}
