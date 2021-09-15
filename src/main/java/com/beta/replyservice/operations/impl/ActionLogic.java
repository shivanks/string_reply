package com.beta.replyservice.operations.impl;

import com.beta.replyservice.operations.IActionLogic;
import lombok.Data;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.security.MessageDigest;

@Component
@Data
public class ActionLogic implements IActionLogic {
    private static final Logger log = LoggerFactory.getLogger(ActionLogic.class);
    @SneakyThrows
    @Override
    public String HashingMD5(String message) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(message.getBytes());
        byte[] bytesToHex = md.digest();
        String myHash = bytesToHex(bytesToHex);
        return myHash;
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    @Override
    public String Reverse(String message) {
        StringBuffer str= new StringBuffer(message);
        str.reverse();
        return str.toString();
    }
}
