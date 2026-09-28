package com.tekpyramid.TEK_UserService.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

    private String email;

    private String name;

}
