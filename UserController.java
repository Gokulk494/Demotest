package eight.controller;

import eight.model.User;
import eight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/index")
    public String processRegistration(User user) {
        userRepository.save(user);
        // Redirect to login page after registration
        return "redirect:/login";
    }
}

