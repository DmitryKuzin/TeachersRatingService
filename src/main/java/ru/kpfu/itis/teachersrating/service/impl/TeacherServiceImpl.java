package ru.kpfu.itis.teachersrating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.teachersrating.model.StudentGroup;
import ru.kpfu.itis.teachersrating.model.User;
import ru.kpfu.itis.teachersrating.repository.UserRepository;
import ru.kpfu.itis.teachersrating.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findTeachers();
    }

    @Override
    public List<User> getByStudentGroup(StudentGroup group) {
        return userRepository.findTeachersByGroupId(group.getId());
    }

    @Override
    public User get(String username) {
        return userRepository.findByUsername(username);
    }
}
