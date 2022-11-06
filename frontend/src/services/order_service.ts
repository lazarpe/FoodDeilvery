import {OrderRequest} from "../models/OrderRequest";
import {ShoppingCart} from "../models/ShoppingCart";
import {CartItem} from "../models/CartItem";
import {Customer} from "../models/Customer";
import {ShippingAddress} from "../models/ShippingAddress";

export function saveOrder(orderRequest: OrderRequest) {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));
    myHeaders.append("Content-Type", "application/json");
    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(orderRequest),
        redirect: 'follow'
    };
    // @ts-ignore
    return fetch("http://localhost:8080/api/order_request/order", requestOptions);
}



