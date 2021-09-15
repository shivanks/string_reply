package com.beta.replyservice.utility.impl;

import com.beta.replyservice.utility.IrequestValidation;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.beta.replyservice.regexConstants.Constants.*;

/**
 *to check for valid string
 **/
@Component
@Builder
public class RequestCheckValidator implements IrequestValidation {

   //method to check if string is valid for 1,2, a to z ,0-9 and '-'
   public boolean requestValidation(String requestMessage) {
       final Pattern pattern = Pattern.compile(OPERATIONCHECK, Pattern.MULTILINE);
       final Matcher matcher = pattern.matcher(requestMessage);
       Boolean bt= matcher.matches();
       if (requestMessage != null && requestMessage != "") {

           if (requestMessage.matches(OPERATIONCHECK)) {
               return Boolean.TRUE;
           } else return Boolean.FALSE;
       }
       return Boolean.FALSE ;
   }



}
