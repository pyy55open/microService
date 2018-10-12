package com.csy.order.message;

import com.csy.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamRecevier {

    @StreamListener(value = StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object processIn(Object message){
        log.info("StreamRecevier {}",message);
        return message;
    }

    @StreamListener(StreamClient.OUTPUT)
    public void processOut(Object message){
        log.info("StreamRecevier {}",message);
    }

    @StreamListener(StreamClient.OUTPUT)
    public void processOut2(OrderDTO message){
        log.info("StreamRecevier {}",message);
    }
}
