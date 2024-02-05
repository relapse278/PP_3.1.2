package com.example.PP_312.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.PP_312.model.User;
import com.example.PP_312.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @PostMapping("/users")
    public String createUser(@RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("email") String email) {
        User user = new User(name, surname, email);
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/add")
    public String showAddUserView(){
        return "add";
    }

    @GetMapping("users/delete")
    public String removeUser(@RequestParam("id") long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String editUser(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

//    @PostMapping("/users/edit")
//    public String updateUser(@RequestParam long id,
//                             @RequestParam String firstName,
//                             @RequestParam String lastName,
//                             @RequestParam String email) {
//        User updatedUser = userService.getUserById(id);
//        updatedUser.setFirstName(firstName);
//        updatedUser.setLastName(lastName);
//        updatedUser.setEmail(email);
//        userService.updateUser(updatedUser);
//        return "redirect:/users";
//    }
    @PostMapping("/users/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        User updatedUser = userService.getUserById(user.getId());
//        final User updatedUser = new ObjectMapper().setDateFormat(simpleDateFormat).readValue(user, User.class);
//        User updatedUser = objectMapper.readValue(user, User.class);
//        User updatedUser = userService.getUserById(user.getId());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        userService.updateUser(updatedUser);
        return "redirect:/users";
    }
}