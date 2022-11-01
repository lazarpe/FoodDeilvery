package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.models.OrderRequest;
import com.petrovic.fooddeliveryapi.models.ShoppingCart;
import com.petrovic.fooddeliveryapi.services.OrderRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/order_request")
public class OrderRequestController {

    private final OrderRequestService orderRequestService;

    @PostMapping("/order")
    public ResponseEntity<ShoppingCart> orderRequest(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok().body(orderRequestService.createOrderRequest(orderRequest));
    }
}
