package com.csy.order.controller;

import com.csy.order.dto.OrderDTO;
import com.csy.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageConreoller {

    @Autowired
    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void sendMessage(){
//        streamClient.output().send(MessageBuilder.withPayload("now"+new Date()).build());
//    }

    /**
     * 发送OrderDTO对象
     */
    @GetMapping("/sendMessage2")
    public void sendMessage2(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("12345");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
