package ru.kpfu.itis.teachersrating.service;

import ru.kpfu.itis.teachersrating.model.StudentGroup;
import ru.kpfu.itis.teachersrating.model.User;

import java.util.List;

public interface TeacherService {
    List<User> getAll();
    List<User> getByStudentGroup(StudentGroup group);
    User get(String username);
    User getById(Long id);
}
