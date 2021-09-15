package com.beta.replyservice.utility;

import org.springframework.stereotype.Component;

@Component
public interface IrequestValidation {
     boolean requestValidation(String requestMessage);
}
