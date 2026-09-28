package com.tekpyramid.TEK_UserService.service;

import com.tekpyramid.TEK_UserService.dto.RequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    RequestDto createUser(RequestDto requestDto);

    Page<RequestDto> getAll(String email, Pageable pageable);

    RequestDto getById(Integer id);
}
