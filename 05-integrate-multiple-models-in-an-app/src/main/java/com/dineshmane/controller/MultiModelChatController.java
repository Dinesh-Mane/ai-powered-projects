package com.dineshmane.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MultiModelChatController {

    private final ChatClient openAiChatCleint;
    private final ChatClient ollamaChatCleint;

    public MultiModelChatController(@Qualifier("openAiChatClient") ChatClient openAiChatCleint, @Qualifier("ollamaChatClient") ChatClient ollamaChatCleint) {
        this.openAiChatCleint = openAiChatCleint;
        this.ollamaChatCleint = ollamaChatCleint;
    }

    @GetMapping("/openai/chat")
    public String ChatWithOpenAiChatModel(@RequestParam("message") String msg){
        return openAiChatCleint.prompt(msg).call().content();
    }

    // invoking llama3.2 model which I've deployed locally using ollama
    @GetMapping("/ollama/chat")
    public String ChatWitLocalLlmModel(@RequestParam("message") String msg){
        return ollamaChatCleint.prompt(msg).call().content();
    }

}
