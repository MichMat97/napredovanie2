package com.vaii.napredovanie2.controller;

import com.vaii.napredovanie2.entity.User;
import com.vaii.napredovanie2.service.UserDto;
import com.vaii.napredovanie2.service.UserDtoForPasswd;
import com.vaii.napredovanie2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    private SecurityContextHolder securityContextHolder;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home(Principal principal, Model model) {
        if (principal != null) {
            // Get the username of the logged-in user
            String username = principal.getName();
            model.addAttribute("username", username); // Pass username to the view
        }
        return "index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(Principal principal, HttpServletRequest request) {
        if (principal != null) {
            // Ak je používateľ prihlásený, odhlási ho
            SecurityContextHolder.clearContext(); // Čistí prihlásenie
            request.getSession().invalidate(); // Zruší reláciu
        }
        return "login"; // Zobrazí stránku login
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        } else if (userDto.getFirstName().isEmpty() || userDto.getFirstName() == null) {
            result.rejectValue("firstName", null,
                    "Meno musí vyť vyplnené");
        } else if (userDto.getLastName().isEmpty() || userDto.getLastName() == null) {
            result.rejectValue("lastName", null,
                    "Priezvisko musí vyť vyplnené");
        } else if (userDto.getPassword().isEmpty() || userDto.getPassword() == null) {
            result.rejectValue("password", null,
                    "Heslo musí vyť vyplnené");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/editUser")
    public String showEditForm(@RequestParam String email, Model model) {
        // Načítať informácie o používateľovi z databázy podľa userId
        User user = userService.findUserByEmail(email);

        // Pridať používateľa do modelu
        model.addAttribute("user", user);

        // Navigovať na stránku s formulárom na úpravu
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(@Valid @ModelAttribute("user") UserDto userDto) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            // Aktualizovať informácie o používateľovi v databáze
            userService.updateUser(existingUser.getId(), userDto.getFirstName() + " " + userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
        }
        // Presmerovať na inú stránku po úprave
        return "/index";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam String email) {
        User existingUser = userService.findUserByEmail(email);
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            // Aktualizovať informácie o používateľovi v databáze
            userService.deleteUser(existingUser.getEmail());
        }
        // Presmerovať na inú stránku po úprave
        return "/index";
    }


    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Principal principal, Model model) {
        if (principal != null) {
            // Get the username of the logged-in user
            String username = principal.getName();
            model.addAttribute("username", username); // Pass username to the view
        }
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    //zobrazenie editovacieho formu
    @GetMapping("/editUserPasswd")
    public String showEditPasswdForm(@RequestParam String email, Principal principal, Model model) {
        String prislasenyPouzivatel = principal.getName();

        if (!email.equals(prislasenyPouzivatel)) {
            return "redirect:/login";
        }

        // Načítať informácie o používateľovi z databázy podľa userId
        User user = userService.findUserByEmail(email);

        // Pridať používateľa do modelu
        model.addAttribute("user", user);

        // Navigovať na stránku s formulárom na úpravu
        return "editUserPasswd";
    }

    //ulozenie noveho hesla
    @PostMapping("/editUserPasswd")
    public String editUserPasswd(@Valid @ModelAttribute("user") UserDtoForPasswd userDto) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            // Aktualizovať informácie o používateľovi v databáze
            userService.updateUserPasswd(existingUser.getId(), userDto.getEmail(), userDto.getPassword());
        }
        // Presmerovať na inú stránku po úprave
        return "/index";
    }
}