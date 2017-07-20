package ru.kpfu.itis.teachersrating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.teachersrating.model.User;

import java.util.Collections;

/**
 * Created by ainur on 19.07.2017.
 */
@Service
public class UserAuthServiceImpl {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Получение пользователя по номеру телефона
     *
     * @param phone - номер телефона
     * @return - найденный пользователь, null если не найден
     */
    public User getUserByPhone(String phone) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://registationserv.herokuapp.com/user/phone/" + phone, User.class);
    }

    /**
     * Проверяет одинаковость паролей
     *
     * @param encoded - зашифрованный пароль
     * @param raw     - нешифрованный пароль
     * @return - true если совпадают
     */
    public boolean checkUserPassword(String encoded, String raw) {
        return passwordEncoder.matches(raw, encoded);
    }

    /**
     * Авторизует пользователя
     *
     * @param user - пользователь
     */
    public void login(User user) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user, null, Collections.singleton(createAuthority(user)));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private GrantedAuthority createAuthority(User user) {
        return new SimpleGrantedAuthority(user.getRole().name());
    }
}
