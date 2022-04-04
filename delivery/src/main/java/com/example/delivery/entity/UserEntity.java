package com.example.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usertbl")
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
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
    private String otp;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<DeliveryEntity> deliveryEntity;


}
