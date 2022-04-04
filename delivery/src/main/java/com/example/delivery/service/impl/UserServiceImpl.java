package com.example.delivery.service.impl;

import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.LoginRequest;
import com.example.delivery.io.OtpRequest;
import com.example.delivery.io.SignupRequest;
import com.example.delivery.repository.impl.UserrepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

@Service
public class UserServiceImpl {
    @Autowired
    UserrepositoryImpl userrepository;
    public Baseresponse usersignup(SignupRequest request) {

        return userrepository.usersignup(request);
    }
    public Baseresponse login(LoginRequest loginRequest){

        return userrepository.login(loginRequest);
    }
    public Baseresponse verifyotp(OtpRequest otpRequest){

        return userrepository.verifyotp(otpRequest);
    }
    public Baseresponse editprofile(int id,SignupRequest request){

        return userrepository.editprofile(id,request);
    }

}
