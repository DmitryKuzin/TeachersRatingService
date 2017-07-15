package ru.kpfu.itis.teachersrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.teachersrating.model.PhoneVerificationToken;

@Repository
public interface PhoneVerificationTokenRepository extends JpaRepository<PhoneVerificationToken, Long> {

    PhoneVerificationToken findByUser(String username);

    PhoneVerificationToken findByToken(String token);
}
