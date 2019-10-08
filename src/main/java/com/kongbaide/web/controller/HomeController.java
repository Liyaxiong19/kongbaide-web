package com.kongbaide.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaxiong.li on 2019/10/8.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
