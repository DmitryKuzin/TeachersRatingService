package ru.kpfu.itis.teachersrating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.teachersrating.model.Institute;
import ru.kpfu.itis.teachersrating.repository.InstituteRepository;
import ru.kpfu.itis.teachersrating.service.InstituteService;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService {
    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public List<Institute> getAll() {
        return instituteRepository.findAll();
    }
}
