package com.beta.replyservice.service.impl;

import com.beta.replyservice.domain.ReplyMessage;
import com.beta.replyservice.domain.SplitMessageAndOperation;
import com.beta.replyservice.operations.IPerformOperationOnMessage;
import com.beta.replyservice.operations.impl.PerformOperationOnMessage;
import com.beta.replyservice.service.IReplyMessageService;
import com.beta.replyservice.utility.IrequestValidation;
import com.beta.replyservice.utility.impl.RequestCheckValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.beta.replyservice.regexConstants.Constants.OPERATIONSSEPARATORREGEX;

/**
 * service class
 **/
@Service
@AllArgsConstructor
@Data
public class ReplyMessageService implements IReplyMessageService {
    private static final Logger log = LoggerFactory.getLogger(ReplyMessageService.class);
    private final IrequestValidation requestCheckValidator;
    private final IPerformOperationOnMessage performOperationOnMessage;

    @Autowired
    ReplyMessageService(SplitMessageAndOperation splitMessageAndOperation,IrequestValidation requestCheckValidator,
                        IPerformOperationOnMessage performOperationOnMessage){
        this.requestCheckValidator=requestCheckValidator;
        this.performOperationOnMessage=performOperationOnMessage;


    }

    public ResponseEntity<ReplyMessage> response(String message) {
       String[] operationValue= separate(message);
        Boolean isValid= checkIfValidString(operationValue[0]);
        if(isValid) {
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(separateOperationAndMessage(message));
        }
        else return ResponseEntity.badRequest().body(new ReplyMessage("String is not in proper format"));



    }

    public  ReplyMessage separateOperationAndMessage(String message) {

          String [] splitResult=  separate(message);

        SplitMessageAndOperation splitMessageAndOperation=new SplitMessageAndOperation();
        splitMessageAndOperation.setOperation(splitResult[0]);
        splitMessageAndOperation.setMessage(splitResult[1]);
         return  performOperationOnMessage.perform(splitMessageAndOperation);

    }

    private String [] separate(String message) {
        return message.split(OPERATIONSSEPARATORREGEX);

    }

    public  boolean checkIfValidString(String message) {
        return requestCheckValidator.requestValidation(message);
    }

}
