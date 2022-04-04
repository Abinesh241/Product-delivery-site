package com.example.delivery.controller;

import com.example.delivery.constant.Endpointsconstant;
import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.LoginRequest;
import com.example.delivery.io.OtpRequest;
import com.example.delivery.io.SignupRequest;
import com.example.delivery.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userservice;
@PostMapping(value=Endpointsconstant.usersignup.url)
    public Baseresponse usersignup(@RequestBody SignupRequest request){
    return  userservice.usersignup(request);
}
@PostMapping(value =Endpointsconstant.login.url )
    public Baseresponse login(@RequestBody LoginRequest loginRequest){
    return userservice.login(loginRequest);
}
@PostMapping(value = Endpointsconstant.verifyotp.url)
    public Baseresponse verifyotp(@RequestBody OtpRequest otpRequest){
    return userservice.verifyotp(otpRequest);
}
@PutMapping(value = Endpointsconstant.editprofile.url)
    public Baseresponse editprofile (@PathVariable int id, @RequestBody SignupRequest request){
    return  userservice.editprofile( id,request);
}
}
