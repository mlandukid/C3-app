package com.codewithloyiso.C3app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithloyiso.C3app.Dto.MessageDto;

@RestController
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/user-all")
    @SendTo("/topic/message")
    public MessageDto send(@Payload MessageDto message) {
        return message;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDto messageDto) {
        template.convertAndSend("/topic/message", messageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}