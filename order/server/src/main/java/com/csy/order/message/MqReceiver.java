package com.csy.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

    //1.@RabbitListener(queues = "myQueue")  需要先新建myQueue
    //2.@RabbitListener(queuesToDeclare = @Queue("myQueue")) 自动创建队列
    //3.@RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"),exchange = @Exchange("myExchange")))
    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"),exchange = @Exchange("myExchange")))
    public void getQueue(String msg){
        log.info("mqReceiver:{}",msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("fashionOrder"),exchange = @Exchange("myExchange"),key = "fashion"))
    public void getFashionOrder(String msg){
        log.info("mqReceiver:{}",msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("foodOrder"),exchange = @Exchange("myExchange"),key = "food"))
    public void getFoodOrder(String msg){
        log.info("mqReceiver:{}",msg);
    }
}
