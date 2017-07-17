package ru.kpfu.itis.teachersrating.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.teachersrating.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("select t from StudentGroup sg inner join sg.teachers t where sg.id = ?1")
    List<User> findTeachersByGroupId(Long groupId);

    @Query("select u from User u where u.role = ru.kpfu.itis.teachersrating.model.Role.ROLE_TEACHER")
    List<User> findTeachers();

    @Query("select u from User u where u.role = ru.kpfu.itis.teachersrating.model.Role.ROLE_TEACHER")
    Page<User> findTeachers(Pageable pageable);

    @Query("select distinct t from Institute i join i.groups g join g.teachers t where i.id = ?1")
    List<User> findTeachersByInstituteId(Long instituteId);

    @Query("select distinct t from Institute i join i.groups g join g.teachers t where i.id = ?1")
    Page<User> findTeachersByInstituteId(Long instituteId, Pageable pageable);
}
