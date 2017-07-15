package ru.kpfu.itis.teachersrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.teachersrating.model.StudentGroup;

import java.util.List;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    List<StudentGroup> findStudentGroupsByInstituteId(Long instituteId);

    List<StudentGroup> findStudentGroupsByTeachersId(Long teacherId);

    StudentGroup findStudentGroupByStudentsId(Long studentId);
}
