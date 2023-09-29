package com.matthewa.restfuldemo;

import javax.validation.constraints.Min;

import jakarta.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Min(value=0, message="Account balance cannot be negative")
    private Integer balance;
}
