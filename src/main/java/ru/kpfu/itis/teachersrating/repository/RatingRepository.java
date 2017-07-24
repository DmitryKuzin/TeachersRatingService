package ru.kpfu.itis.teachersrating.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.teachersrating.model.TeacherRating;
import ru.kpfu.itis.teachersrating.model.Rating;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    Rating findRatingByTeacherIdAndStudentId(Long teacherId, Long studentId);

    List<Rating> findRatingsByTeacherId(Long teacherId);

    @Query("select new ru.kpfu.itis.teachersrating.model.TeacherRating(u.id, u.firstName," +
            "u.lastName, u.patronymic, u.imagePath, u.description," +
            "avg(r.value), count(r)) from Rating r right join r.teacher u where exists" +
            "(select distinct t from Institute i join i.groups g join g.teachers t where u = t and i.id = ?1)" +
            "group by u.id, u.firstName," +
            "u.lastName, u.patronymic, u.imagePath, u.description")
    List<TeacherRating> findAllTeachersRatingsByInstituteId(Long id);
}
