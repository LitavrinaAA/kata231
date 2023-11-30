package web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allEmployees = userService.getAllUsers();
        model.addAttribute("allUsers", allEmployees);
        return "all-users";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/user/{id}")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println("сохранить юзера");
        userService.saveUser(user);
        return "redirect:/";
    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        System.out.println("щас позову форму");
        return "user-info";
    }
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        System.out.println("deleteUser: " + id);
        userService.deleteUser(id);
        return "redirect:/";
    }

}
