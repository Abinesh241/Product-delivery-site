package com.example.delivery.service;

import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.LoginRequest;
import com.example.delivery.io.OtpRequest;
import com.example.delivery.io.SignupRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
  public Baseresponse usersignup(SignupRequest request);

  public Baseresponse login(LoginRequest loginRequest);

  public Baseresponse verifyotp(OtpRequest otpRequest);

  public Baseresponse editprofile(int id,SignupRequest request);
}
