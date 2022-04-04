package com.example.delivery.controller;

import com.example.delivery.constant.Endpointsconstant;
import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.BookorderRequest;
import com.example.delivery.io.ItemRequest;
import com.example.delivery.service.impl.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
    @Autowired
    DeliveryServiceImpl deliveryservice;
    @PostMapping(Endpointsconstant.postitem.url)
    public Baseresponse postitem(@PathVariable int id, @RequestBody ItemRequest request){
        return deliveryservice.postitem(id,request);
    }
    @PostMapping(Endpointsconstant.bookorder.url)
    public Baseresponse bookorder(@RequestBody BookorderRequest request){
        return deliveryservice.bookorder(request);
    }
    @PostMapping(Endpointsconstant.deliverorder.url)
    public Baseresponse deliverorder(@RequestBody BookorderRequest request){
        return deliveryservice.deliverorder(request);
    }
}
