package com.matthewa.restfuldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthewa.restfuldemo.data.UserRepository;

@RestController
@RequestMapping(path="/user", produces="application/json")
public class UserController {

    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        userRepo.save(user);
        return "User added";
    }

    @DeleteMapping
    public String deleteUser(@Param("id") Long id) {
        userRepo.deleteById(id);
        return "User deleted";
    }

}
