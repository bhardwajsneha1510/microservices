package com.tekpyramid.TEK_UserService.service.impl;

import com.tekpyramid.TEK_UserService.dto.RequestDto;
import com.tekpyramid.TEK_UserService.entity.User;
import com.tekpyramid.TEK_UserService.repository.UserRepository;
import com.tekpyramid.TEK_UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public RequestDto createUser(RequestDto requestDto) {
        userRepository.save(User.builder().email(requestDto.getEmail()).name(requestDto.getName()).build());
        return requestDto;
    }

    @Override
    public Page<RequestDto> getAll(String email, Pageable pageable) {
        Page<User> users;
        if(email==null || email.isEmpty()){
            users= userRepository.findAll(pageable);
        }else{
            users= userRepository.findByEmailContainingIgnoreCase(email,pageable);
        }
        return users.map(user->RequestDto.builder().email(user.getEmail()).name(user.getName()).build()) ;
    }

    @Override
    public RequestDto getById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return RequestDto.builder().email(user.getEmail()).name(user.getName()).build();
    }
}
