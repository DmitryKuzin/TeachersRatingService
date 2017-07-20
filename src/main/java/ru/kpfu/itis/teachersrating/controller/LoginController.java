package ru.kpfu.itis.teachersrating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.teachersrating.model.User;
import ru.kpfu.itis.teachersrating.service.impl.UserAuthServiceImpl;

/**
 * Created by ainur on 19.07.2017.
 */
@Controller
public class LoginController {

    @Autowired
    UserAuthServiceImpl userAuthService;

    /**
     * Страница авторизации
     *
     * @return - название файла страницы авторизации
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * Авторизация пользователя
     *
     * @param password - пароль пользователя
     * @param phone    - номер телефона
     * @param map      - ModelMap для возвращения ошибок
     * @return - названия страниц
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String login(@RequestParam("password") String password,
                        @RequestParam("phone") String phone,
                        ModelMap map) {
        User user = userAuthService.getUserByPhone(phone);
        if (user == null) {
            map.put("error", "Такого пользователя не существует");
            return "login";
        }

        if (!user.isConfirmed()) {
            map.put("error", "Пользователь не подтвержден");
            return "login";
        }

        if (userAuthService.checkUserPassword(user.getPassword(), password)) {
            userAuthService.login(user);
            return "redirect:/";
        }

        map.put("error", "Пароль не совпадает");
        return "login";
    }
}
