package com.tekpyramid.TEK_OrderService.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private String message;
    private Object data;
    private Boolean error;
}
