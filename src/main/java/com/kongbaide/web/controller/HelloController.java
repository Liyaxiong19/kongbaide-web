package com.kongbaide.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaxiong.li on 2019/10/8.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "12345";
    }
}
