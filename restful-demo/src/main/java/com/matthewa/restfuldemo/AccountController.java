package com.matthewa.restfuldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthewa.restfuldemo.data.AccountRepository;

@RestController
@RequestMapping(path="/account", produces="application/json")
public class AccountController {
    @Autowired
    private AccountRepository accountRepo;


}
