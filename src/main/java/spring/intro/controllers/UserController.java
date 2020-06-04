package spring.intro.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/inject")
    public String injectData() {
        userService.add(new User("John", "Wick", "john_wick@gmail.com"));
        userService.add(new User("Brad", "Pitt", "brad_pitt@gmail.com"));
        userService.add(new User("Milla", "Jovovich", "milla_jovovich@gmail.com"));
        userService.add(new User("Nicolas", "Cage", "nicolass_cage@gmail.com"));
        return "Data injected!";
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return getUserDto(userService.get(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> list = new ArrayList<>();
        List<User> userList = userService.listUsers();
        for (User user : userList) {
            list.add(getUserDto(user));
        }
        return list;
    }

    private UserResponseDto getUserDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setName(user.getFirstName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
