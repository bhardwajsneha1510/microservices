package com.tekpyramid.TEK_UserService.controller;

import com.tekpyramid.TEK_UserService.dto.RequestDto;
import com.tekpyramid.TEK_UserService.dto.ResponseDto;
import com.tekpyramid.TEK_UserService.entity.User;
import com.tekpyramid.TEK_UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseDto createUser(@RequestBody RequestDto requestDto) {
        return ResponseDto.builder().error(false).message("User created successfully").data(userService.createUser(requestDto)).build();
    }

    @GetMapping
    public ResponseDto getAll(@RequestParam(required = false,name="email") String email, @PageableDefault(page = 0,size=10,sort="id",direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseDto.builder().error(false).message("Data fetched successfully").data(userService.getAll(email,pageable)).build();
    }

    @GetMapping("/{id}")
    public  ResponseDto getById(@PathVariable Integer id) {
        return ResponseDto.builder().error(false).message("users data is fetched using id").data(userService.getById(id)).build();
    }
}
