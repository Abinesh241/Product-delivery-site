package com.example.delivery.repository.impl;

import com.example.delivery.constant.MessageCodes;
import com.example.delivery.entity.UserEntity;
import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.LoginRequest;
import com.example.delivery.io.OtpRequest;
import com.example.delivery.io.SignupRequest;
import com.example.delivery.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserrepositoryImpl {
    @Autowired
    Userrepository userrepository;
    String Status = "";
    String Code = "";
    String Statusmessage = "";
    Object data = null;
    public Baseresponse usersignup(SignupRequest request){
        try {
            String randomnumber = randomnumber();
            String mail = request.getEmail();
            mail(mail, randomnumber);

            UserEntity userentity = new UserEntity();
            userentity.setFirstname(request.getFirstname());
            userentity.setLastname(request.getLastname());
            userentity.setAddress(request.getAddress());
            userentity.setPincode(request.getPincode());
            userentity.setGender(request.getGender());
            userentity.setEmail(request.getEmail());
            userentity.setAadharnumber(request.getAadharnumber());
            userentity.setUsertype(request.getUsertype());
            userentity.setUsername(request.getUsername());
            userentity.setPassword(request.getPassword());
            userentity.setOtp(randomnumber);
            userrepository.save(userentity);
            Code= MessageCodes.SUCCESS;
            Status=MessageCodes.SUCCESS_MSG;
            Statusmessage=MessageCodes.signupstatusmessage;
            data=request;
        }catch (Exception e){
            Code= MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.Errorsignupstatusmessage;
            data=null;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }
    public String randomnumber() {
        Random random = new Random();
        String otp = String.format("%o4d", random.nextInt(1000));
        return otp;
    }
    @Autowired
    private JavaMailSender mailSender;
    public void mail(String to, String text) {
        SimpleMailMessage mailmessage = new SimpleMailMessage();
        mailmessage.setFrom("abineshkavin2002@gmail.com");
        mailmessage.setTo(to);
        mailmessage.setText(text);
        mailSender.send(mailmessage);
    }

public Baseresponse login(LoginRequest loginRequest) {
    try {
        UserEntity s = userrepository.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (s != null) {
            Code = MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage = MessageCodes.UserLogin_StatusMessage;
            data = s;
        } else {
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.UserLoginFailure_StatusMessage;
            data = null;
        }
    } catch (Exception e) {
        Code = MessageCodes.ERROR;
        Status = MessageCodes.ERROR_MSG;
        Statusmessage = MessageCodes.loginexception_StatusMessage;
        data = null;
    }
     return Baseresponse.builder()
            .code(Code)
            .status(Status)
            .statusmessage(Statusmessage)
            .data(data)
            .build();
}

public Baseresponse verifyotp(OtpRequest otpRequest){
        try{
            UserEntity s=userrepository.verifyotp(otpRequest.getOtp());
            if(s!=null){
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.otp_StatusMessage;
                data = s;
            }else{
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage = MessageCodes.otpFailure_StatusMessage;
                data = null;
            }
        }catch (Exception e){
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.otpexception_StatusMessage;
            data = null;
        }
    return Baseresponse.builder()
            .code(Code)
            .status(Status)
            .statusmessage(Statusmessage)
            .data(data)
            .build();
    }

    public Baseresponse editprofile(int id,SignupRequest request){
        try{
            UserEntity userentity=new UserEntity();
            UserEntity s=userrepository.editprofile(id);
            s.setFirstname(request.getFirstname());
            s.setLastname(request.getLastname());
            s.setAddress(request.getAddress());
            s.setPincode(request.getPincode());
            s.setGender(request.getGender());
            s.setEmail(request.getEmail());
            s.setAadharnumber(request.getAadharnumber());
            s.setUsertype(request.getUsertype());
            s.setUsername(request.getUsername());
            s.setPassword(request.getPassword());
            userrepository.save(s);
            Code=MessageCodes.SUCCESS;
            Status=MessageCodes.SUCCESS_MSG;
            Statusmessage=MessageCodes.editprofile_StatusMessage;
            data=s;
        }catch (Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.editprofileError_StatusMessage;
            data=null;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }


}
