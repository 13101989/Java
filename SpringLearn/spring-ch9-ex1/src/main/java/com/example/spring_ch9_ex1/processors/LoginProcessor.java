package com.example.spring_ch9_ex1.processors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        if ("valentin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
