package com.tekpyramid.TEK_OrderService.entity;

import com.tekpyramid.TEK_OrderService.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private OrderStatus status;

}
