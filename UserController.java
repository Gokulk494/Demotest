// src/main/java/eight/controller/UserController.java

package eight.controller;

import eight.model.User;
import eight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

  

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/thank-you";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> processLogin(@ModelAttribute("user") User user) {
        Map<String, String> response = new HashMap<>();

        User loggedInUser = userService.loginUser(user.getGmail(), user.getPassword());

        if (loggedInUser != null) {
            response.put("success", "true");
        } else {
            response.put("error", "Invalid username or password");
        }

        return response;
    }

    @GetMapping("/thank-you")
    public String showThankYouPage() {
        return "thank-you :: thankYouContent";
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping("/reset-password")
    @ResponseBody
    public Map<String, String> resetPassword(@RequestParam("gmail") String gmail) {
        // Logic for resetting the password (simplified for illustration)
        Map<String, String> response = new HashMap<>();

        // Simulate successful password reset
        response.put("success", "true");

        return response;
    }

    
        
    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {
        if (principal != null) {
            // The user is authenticated, proceed with your logic
            String username = principal.getName();
            // Add your logic to fetch user details and pass them to the model
            // For example:
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
            return "profile";
        } else {
            // The user is not authenticated, redirect to the login page or handle it accordingly
            return "redirect:/login";
        }
    }


    @GetMapping("/profile-form")
    public String profileForm(Model model) {
        // Add logic for profile form if needed
        return "profile-form";
    }
}
