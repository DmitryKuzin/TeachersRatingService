package ru.kpfu.itis.teachersrating.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.teachersrating.model.TeacherRating;

import java.util.List;

@Repository
public interface TeacherRatingRepository extends JpaRepository<TeacherRating, Long> {

    @Query("select tr from TeacherRating tr where exists " +
            "(select distinct t from Institute i join i.groups g join g.teachers t where tr.teacher = t and i.id = ?1)")
    List<TeacherRating> findTeacherRatingsByInstituteId(Long instituteId);

    @Query("select tr from TeacherRating tr where exists " +
            "(select distinct t from Institute i join i.groups g join g.teachers t where tr.teacher = t and i.id = ?1)")
    Page<TeacherRating> findTeacherRatingsByInstituteId(Long instituteId, Pageable pageable);
}
