package com.example.delivery.io;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Baseresponse {
    private String code;
    private String status;
    private String statusmessage;
    private Object data;
}
