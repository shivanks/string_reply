package com.beta.replyservice.rest;

import com.beta.replyservice.domain.ReplyMessage;
import com.beta.replyservice.service.impl.ReplyMessageService;
import com.beta.replyservice.utility.impl.RequestCheckValidator;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * test url in postman :localhost:8080/v2/reply/12-kbzw9ru
 * o/p :
 * {
 *     "message": "5a8973b3b1fafaeaadf10e195c6e1dd4"
 * }
 * feature brnch ->> feature-String-operations
 */

@RestController
@RequestMapping("/v2")
public class ReplyController {
	private  final RequestCheckValidator requestCheckValidator ;
	private final ReplyMessageService replyMessageService;
	  private static final Logger log =LoggerFactory.getLogger(ReplyController.class);
	@Autowired
	ReplyController(RequestCheckValidator requestCheckValidator, ReplyMessageService  replyMessageService){
		this.requestCheckValidator=requestCheckValidator;
		this.replyMessageService=replyMessageService;
	}

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ResponseEntity<ReplyMessage> replying(@PathVariable @NonNull String message) {
		//to check if message is in proper format eg : 12-abcdef
		log.info(String.format("incomming request message is:[{}]",message));
		return replyMessageService.response(message);
	}
}