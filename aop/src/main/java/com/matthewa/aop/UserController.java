package com.matthewa.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public String getAllUsers() {
        System.out.println("getAllUsers from UserController class");
        return "success";
    }
}
