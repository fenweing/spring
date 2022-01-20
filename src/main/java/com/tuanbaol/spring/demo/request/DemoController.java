package com.tuanbaol.spring.demo.request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/req")
public class DemoController {
    @GetMapping("/demo")
    public String geRandom() {
        return String.valueOf(Math.random());
    }
}
