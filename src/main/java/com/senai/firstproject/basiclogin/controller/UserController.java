package com.senai.firstproject.basiclogin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.senai.firstproject.basiclogin.entities.User;
import com.senai.firstproject.basiclogin.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/listuser")
    public ModelAndView listaUsuarios() {
        ModelAndView modelAndView = new ModelAndView("redirect:/search");
        List<User> userList = userService.listuser();
        modelAndView.addObject("user", userList);
        return modelAndView;
    }
    
    @GetMapping("/register")
    public ModelAndView telaRegister() {
    	ModelAndView modelAndView = new ModelAndView("registro");
        modelAndView.addObject("user", new User());
    	return modelAndView;
    }
    
    @PostMapping("/createuser")
    public ModelAndView cadastrarUsuario(User obj) {
    	userService.insert(obj);
    	ModelAndView modelAndView = new ModelAndView("redirect:listuser");
    	return modelAndView;
    }
    
    @GetMapping(value="/deleteuser/{userId}")
    public ModelAndView deleteUsuario(@PathVariable("userId") Long userId) {
        userService.delete(userId);
        ModelAndView modelAndView = new ModelAndView("redirect:/listuser");
        return modelAndView;
    }
    
    @GetMapping(value="/edituser/{userId}")
    public ModelAndView TelaeditUser(@PathVariable("userId") Long userId) {
        Optional<User> userOptional = userService.findById(userId);
        User user = userOptional.orElse(null); 
        ModelAndView modelAndView = new ModelAndView("editarusuario");
        modelAndView.addObject("user", user); 
        return modelAndView;
    }
    
    @PostMapping("/editarusuario/{userId}")
    @PutMapping("/editarusuario/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Long userId,
                                  @RequestParam("firstname") String firstname,
                                  @RequestParam("lastname") String lastname,
                                  @RequestParam("email") String email,
                                  @RequestParam("numberphone") String numberphone,
                                  @RequestParam("password") String password,
                                  @RequestParam("agreedToTerms") boolean agreedToTerms) {
        // Criar um objeto User com os parâmetros fornecidos
        User updatedUser = new User(userId,firstname,lastname,email,numberphone,password,agreedToTerms);
    
        // Atualizar o usuário com os novos dados
        userService.update(userId, updatedUser);
        
        // Redirecionar para a página de listagem de usuários após a atualização
        return new ModelAndView("redirect:/listuser");
    }
    
    @GetMapping("/search")
    public ModelAndView searchUser(@RequestParam(value = "name", required = false) String name) {
        List<User> userList;
        if (name != null && !name.isEmpty()) {
            userList = userService.searchByName(name);
        } else {
            userList = userService.listuser();
        }
        ModelAndView modelAndView = new ModelAndView("listausuario");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }



}
