package com.matthewa.restfuldemo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matthewa.restfuldemo.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}