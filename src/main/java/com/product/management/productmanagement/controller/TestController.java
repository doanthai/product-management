package com.product.management.productmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class TestController {

    @GetMapping("/test")
    public Timestamp test() {
        return new Timestamp(System.currentTimeMillis());
    }
}
