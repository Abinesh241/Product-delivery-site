package com.example.delivery.service;

import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.BookorderRequest;
import com.example.delivery.io.ItemRequest;
import org.springframework.stereotype.Component;

@Component
public interface DeliveryService {
    public Baseresponse postitem(int id,ItemRequest request);

    public Baseresponse bookorder(BookorderRequest request);

    public Baseresponse deliverorder(BookorderRequest request);
}
