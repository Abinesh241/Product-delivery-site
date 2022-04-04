package com.example.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deliverytbl")
public class DeliveryEntity {
    @Id
    @GeneratedValue
    private int orderid;
    private String name;
    private String receivername;
    private String itemname;
    private String fromss;
    private String too;
    private String pincode;
    private String orderstatus;
    private String messagestatus;
    private String receiverphoneno;
    private String phoneno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private UserEntity userEntity;
}
