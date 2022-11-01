package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.OrderRequest;
import com.petrovic.fooddeliveryapi.models.ShoppingCart;
import com.petrovic.fooddeliveryapi.repositories.CartItemRepository;
import com.petrovic.fooddeliveryapi.repositories.CustomerRepository;
import com.petrovic.fooddeliveryapi.repositories.ShippingAddressRepository;
import com.petrovic.fooddeliveryapi.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@Transactional
public class OrderRequestServiceImpl implements OrderRequestService {

    private final ShippingAddressService shippingAddressService;
    private final ShippingAddressRepository shippingAddressRepository;
    private final CustomerRepository customerRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public OrderRequestServiceImpl(ShippingAddressService shippingAddressService, ShippingAddressRepository shippingAddressRepository, CustomerRepository customerRepository, ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository) {
        this.shippingAddressService = shippingAddressService;
        this.shippingAddressRepository = shippingAddressRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public ShoppingCart createOrderRequest(OrderRequest orderRequest) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShippingAddress(shippingAddressRepository.save(orderRequest.getCart().getShippingAddress()));
        shoppingCart.setCustomer(customerRepository.save(orderRequest.getCart().getCustomer()));
        shoppingCart = shoppingCartRepository.save(shoppingCart);

        ShoppingCart finalShoppingCart = shoppingCart;
        Arrays.stream(orderRequest.getCartItem()).forEach(cartItem -> {
            cartItem.setShoppingCart(finalShoppingCart);
            cartItemRepository.save(cartItem);
        });
        return shoppingCartRepository.findById(shoppingCart.getId()).orElse(null);
    }
}
