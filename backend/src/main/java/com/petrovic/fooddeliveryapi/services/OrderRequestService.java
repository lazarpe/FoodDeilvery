package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.OrderRequest;
import com.petrovic.fooddeliveryapi.models.ShoppingCart;
import org.springframework.stereotype.Service;

public interface OrderRequestService {
    public ShoppingCart createOrderRequest(OrderRequest orderRequest);
}
