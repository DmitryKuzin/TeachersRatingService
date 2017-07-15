package ru.kpfu.itis.teachersrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.teachersrating.model.Institute;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long> {
}
