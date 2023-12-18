package com.koreait.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/api/")
    public String main() {
        return "HELLO";
    }

    @GetMapping("/api/login")
    public void login() {
        // 로그인 관련 동작을 추가하려면 여기에 코드를 작성합니다.
    }

}
