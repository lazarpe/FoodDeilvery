package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.models.*;
import com.petrovic.fooddeliveryapi.services.OrderRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/order_request")
public class OrderRequestController {

    private final OrderRequestService orderRequestService;

    @PostMapping("/order")
    public ResponseEntity<ShoppingCart> orderRequest(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok().body(orderRequestService.createOrderRequest(orderRequest));
    }

    @GetMapping("/test")
    public ResponseEntity<OrderRequest> test() {
        OrderRequest orderRequest = new OrderRequest();
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setId("1");
        shoppingCart.setTotal_price(100.0f);
        shoppingCart.setOrder_date(new java.sql.Date(System.currentTimeMillis()));

        Customer customer = new Customer();
        customer.setId("1");
        customer.setFirstName("John");
        customer.setLastName("Doe");

        AppUser appUser = new AppUser();
        appUser.setId("1");
        appUser.setName("John");
        appUser.setEmail("la@ma.ch");
        appUser.setPassword("123456");
        appUser.setRoles(List.of(new Role[]{new Role(1L, "ROLE_USER")}));

        customer.setAppUser(appUser);

        shoppingCart.setCustomer(customer);

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setId("1");
        shippingAddress.setAddress("123 Main St");
        shippingAddress.setCity("New York");
        shippingAddress.setZipcode("12345");
        shippingAddress.setCountry("USA");

        shoppingCart.setShippingAddress(shippingAddress);
        orderRequest.setCart(shoppingCart);

        // mir mached jz nur eine und tünnds nachher zumene arr umwandle
        CartItem cartItem = new CartItem();
        cartItem.setId("1");
        cartItem.setQuantity(1);
        cartItem.setPrice(100.0f);

        Product product = new Product();
        product.setId("1");
        product.setName("Pizza");
        product.setDescription("Pizza description");
        product.setImageUrl("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
        product.setPrice(100.0f);
        product.setAvailable(true);

        cartItem.setProduct(product);

        orderRequest.setCartItems(new CartItem[]{cartItem});

        return ResponseEntity.ok().body(orderRequest);
    }
}
