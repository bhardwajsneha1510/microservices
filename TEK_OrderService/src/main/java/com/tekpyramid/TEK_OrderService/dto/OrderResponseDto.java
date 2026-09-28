package com.tekpyramid.TEK_OrderService.dto;

import com.tekpyramid.TEK_OrderService.entity.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Integer id;
    private Integer userId;
    private Integer amount;
    private OrderStatus status;
}
