package com.beta.replyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Builder
@Data
@AllArgsConstructor
public class SplitMessageAndOperation {

    private String operation;
    private String message;
    public SplitMessageAndOperation(){}
}
