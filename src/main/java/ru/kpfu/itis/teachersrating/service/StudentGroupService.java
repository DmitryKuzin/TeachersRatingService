package ru.kpfu.itis.teachersrating.service;

import ru.kpfu.itis.teachersrating.model.Institute;
import ru.kpfu.itis.teachersrating.model.StudentGroup;
import ru.kpfu.itis.teachersrating.model.User;

import java.util.List;

public interface StudentGroupService {
    List<StudentGroup> getByInstitute(Institute institute);
    List<StudentGroup> getByTeacher(User teacher);
    StudentGroup getById(Long id);
}
