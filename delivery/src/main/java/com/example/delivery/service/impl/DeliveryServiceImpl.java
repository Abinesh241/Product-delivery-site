package com.example.delivery.service.impl;

import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.BookorderRequest;
import com.example.delivery.io.ItemRequest;
import com.example.delivery.repository.Deliveryrepository;
import com.example.delivery.repository.impl.DeliveryrepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl {
    @Autowired
    DeliveryrepositoryImpl deliveryrepository;
    public Baseresponse postitem(int id,ItemRequest request){
        return deliveryrepository.postitem(id,request);
    }

    public Baseresponse bookorder(BookorderRequest request){
        return deliveryrepository.bookorder(request);
    }

    public Baseresponse deliverorder(BookorderRequest request){
        return deliveryrepository.deliverorder(request);
    }
}
