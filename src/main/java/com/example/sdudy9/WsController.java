package com.example.sdudy9;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyReponse say(WiselyMessage message) throws Exception
    {
        //等待3秒返回消息内容
        Thread.sleep(3000);
        return new WiselyReponse("欢迎使用webScoket："+message.getName());
    }
    @RequestMapping(value = "/test")
    public String tset(){
        return "main";
    }
}