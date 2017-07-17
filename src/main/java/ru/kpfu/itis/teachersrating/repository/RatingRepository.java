package ru.kpfu.itis.teachersrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.teachersrating.model.Rating;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Rating findRatingByTeacherIdAndStudentId(Long teacherId, Long studentId);

    List<Rating> findRatingsByTeacherId(Long teacherId);
}
