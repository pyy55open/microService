package com.csy.order.message;

import com.csy.order.utils.JsonUtil;
import com.csy.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@Transactional
public class ProductInfoReceiver {

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        ProductInfoOutput productInfo = (ProductInfoOutput) JsonUtil.fromJson(message,ProductInfoOutput.class);
        log.info("从队列 【{}】 中接收到消息{}","product",productInfo);
    }
}
