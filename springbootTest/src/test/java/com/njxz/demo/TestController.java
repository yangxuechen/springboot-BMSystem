package com.njxz.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/filter")
    public String testFilter(){
        return "filter is ok";
    }
}
