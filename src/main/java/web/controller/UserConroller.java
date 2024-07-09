package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;
@Controller
public class UserConroller {

    private UserService userServiceImp;
    @Autowired
    public UserConroller(UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
    model.addAttribute("users", userServiceImp.getAllUsers());
    return "users";
}
    @GetMapping("/show")
    public String showEditUser(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("showUser", userServiceImp.getUser(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String showEditUser(@ModelAttribute("showUser") User user) {
userServiceImp.updateUser(user);
return "redirect:/";
    }

    @GetMapping("/remove")
  public String removeUserId (@RequestParam(value = "id") int id, Model model) {
    userServiceImp.deleteUser(id);
    return "redirect:/";
    }



@GetMapping("/add")
public String addUser(Model model) {
    model.addAttribute("user", new User());
    return "addUser";
}
@PostMapping("/save")
public String saveUser(@ModelAttribute("user") User user) {
    userServiceImp.addNewUser(user);
    return "redirect:/";
}




}
