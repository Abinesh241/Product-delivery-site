package com.example.delivery.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SignupRequest {
    private String firstname;
    private String lastname;
    private String address;
    private String pincode;
    private String gender;
    private String email;
    private String aadharnumber;
    private String usertype;
    private String username;
    private String password;
}
