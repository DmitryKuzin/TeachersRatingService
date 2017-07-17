package ru.kpfu.itis.teachersrating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.teachersrating.model.Institute;
import ru.kpfu.itis.teachersrating.model.StudentGroup;
import ru.kpfu.itis.teachersrating.model.User;
import ru.kpfu.itis.teachersrating.repository.StudentGroupRepository;
import ru.kpfu.itis.teachersrating.service.StudentGroupService;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Override
    public List<StudentGroup> getByInstitute(Institute institute) {
        return studentGroupRepository.findStudentGroupsByInstituteId(institute.getId());
    }

    @Override
    public List<StudentGroup> getByTeacher(User teacher) {
        return studentGroupRepository.findStudentGroupsByTeachersId(teacher.getId());
    }
}
