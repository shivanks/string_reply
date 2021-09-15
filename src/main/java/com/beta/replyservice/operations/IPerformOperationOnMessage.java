package com.beta.replyservice.operations;

import com.beta.replyservice.domain.ReplyMessage;
import com.beta.replyservice.domain.SplitMessageAndOperation;
import org.springframework.stereotype.Component;

@Component
public interface IPerformOperationOnMessage {

    ReplyMessage perform(SplitMessageAndOperation splitMessageAndOperation);
    ReplyMessage action(String operation, String message);
}
