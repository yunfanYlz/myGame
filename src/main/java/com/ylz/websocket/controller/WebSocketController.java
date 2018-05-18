package com.ylz.websocket.controller;

import com.ylz.websocket.clientConfig.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

/**
 * 发送消息
 * @return
 */
/*    @ResponseBody
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessage() {
        messagingTemplate.convertAndSend("/queue/notify", "test");
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @ResponseBody
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendMessage(String msg) {
        List<MessageInfo> messages = getMessage();
        messagingTemplate.convertAndSend("/user/topic/messageList", messages);
        messagingTemplate.convertAndSend("/user/topic/message", msg);
    }

    private List<MessageInfo> getMessage(){
        List<MessageInfo> list = new ArrayList<>();
        list.add(new MessageInfo("Message-Text1"));
        list.add(new MessageInfo("Message-Text2"));
        list.add(new MessageInfo("Message-Text3"));
        list.add(new MessageInfo("Message-Text4"));
        return list;
    }
}
