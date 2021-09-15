package com.beta.replyservice.operations.impl;


import com.beta.replyservice.domain.ReplyMessage;
import com.beta.replyservice.domain.SplitMessageAndOperation;
import com.beta.replyservice.operations.IPerformOperationOnMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PerformOperationOnMessage implements IPerformOperationOnMessage {

    private final ActionLogic actionLogic ;
    @Override
    public ReplyMessage perform(SplitMessageAndOperation splitMessageAndOperation) {
       return action(splitMessageAndOperation.getOperation(),splitMessageAndOperation.getMessage());

    }

    @Override
    public ReplyMessage action(String operation, String message) {

        for(int i=0;i<operation.length();i++){

            message=   checkoperation(operation.charAt(i),message);

        }
        return ReplyMessage.builder().message(message).build();
    }

    private String  checkoperation(char charAt, String message) {

        return charAt == '1' ? actionLogic.Reverse(message) : actionLogic.HashingMD5(message);
    }
}
