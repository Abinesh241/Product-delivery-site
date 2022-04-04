package com.example.delivery.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemRequest {
    private String name;
    private String receivername;
    private String itemname;
    private String from;
    private String to;
    private String pincode;
}
