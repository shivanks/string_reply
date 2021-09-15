package com.beta.replyservice.service;

import com.beta.replyservice.domain.ReplyMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IReplyMessageService {
    ResponseEntity<ReplyMessage> response(String message);
     boolean checkIfValidString(String message);
    ReplyMessage separateOperationAndMessage(String message);

}
