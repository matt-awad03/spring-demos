package com.matthewa.ingauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class MainController {

    @GetMapping
    public String AuthorisedContent() {
        return "Welcome!";
    }
}
