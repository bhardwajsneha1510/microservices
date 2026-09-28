package com.tekpyramid.TEK_OrderService.service;

import com.tekpyramid.TEK_OrderService.dto.OrderRequestDto;
import com.tekpyramid.TEK_OrderService.dto.OrderResponseDto;
import com.tekpyramid.TEK_OrderService.dto.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto requestDto);

    Page<OrderResponseDto> getOrdersByUserId(Integer userId,Integer orderId, Pageable pageable);
}