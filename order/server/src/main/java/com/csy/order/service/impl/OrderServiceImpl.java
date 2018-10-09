package com.csy.order.service.impl;

import com.csy.order.dataobject.OrderDetail;
import com.csy.order.dataobject.OrderMaster;
import com.csy.order.exception.OrderException;
import com.csy.order.repository.OrderDetailRepository;
import com.csy.order.repository.OrderMasterRepository;
import com.csy.order.service.OrderService;
import com.csy.order.dto.OrderDTO;
import com.csy.order.enums.OrderStatusEnum;
import com.csy.order.enums.PayStatusEnum;
import com.csy.order.enums.ResultEnum;
import com.csy.order.utils.KeyUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by 廖师兄
 * 2017-12-10 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;



    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(String orderId) {
        //1. 先查询订单
        Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
        if (!orderMasterOptional.isPresent()) {
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        return orderDTO;
    }


}
