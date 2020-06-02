package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("John", "Wick", "john_wick@gmail.com"));
        userService.add(new User("Brad", "Pitt", "brad_pitt@gmail.com"));
        userService.add(new User("Milla", "Jovovich", "milla_jovovich@gmail.com"));
        userService.add(new User("Nicolas", "Cage", "nicolass_cage@gmail.com"));

        userService.listUsers().forEach(System.out::println);
    }
}
