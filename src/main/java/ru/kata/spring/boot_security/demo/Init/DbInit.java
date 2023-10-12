package ru.kata.spring.boot_security.demo.Init;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
public class DbInit {//todo: класс нужно убрать (совсем убрать). Наполнение и перераскатка таблиц - должна осуществляться написанным скриптом .sql.
                    //todo Скрипт должен отрабатывать при запуске приложения, должны быть для этого изменены properties в части касающейся
    private final UserService userService;
    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostConstruct
    private void postConstruct() {
        Role roleAdmin = new Role((long)1,"ADMIN");
        Role roleUser = new Role( (long)2,"USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        User user = new User("user",  2, "user", Set.of(roleUser));
        User admin = new User("admin",  1, "admin", Set.of(roleAdmin, roleUser));
        userService.register(user);
        userService.register(admin);
    }
}
