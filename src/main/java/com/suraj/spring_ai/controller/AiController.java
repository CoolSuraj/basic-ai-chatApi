package com.suraj.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    //AiConfig is added for the bean implmentation
    @Autowired
    private ChatClient chatClient;

    @GetMapping("/prompt")
    public  String prompt(@RequestParam String message){
        ChatClient.CallResponseSpec explainAboutPune = chatClient.prompt()
                .user(message)
                .call();
        String content = explainAboutPune.content();
        return content;
    }


}
