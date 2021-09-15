package com.beta.replyservice.operations;

import org.springframework.stereotype.Component;

@Component
public interface IActionLogic {
    public String HashingMD5(String message);
    public String Reverse(String message);
}
