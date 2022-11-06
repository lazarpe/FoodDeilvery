import {Customer} from "./Customer";
import {ShippingAddress} from "./ShippingAddress";
import {CartItem} from "./CartItem";

export class ShoppingCart {
    id: number;
    total_price: number;
    order_date: Date;
    customer: Customer;
    shippingAddress: ShippingAddress;
    cartItems: CartItem[] = [];

    constructor(
        id: number,
        total_price: number,
        order_date: Date,
        customer: Customer,
        shippingAddress: ShippingAddress,
        cartItems: CartItem[]
    ) {
        this.id = id;
        this.total_price = total_price;
        this.order_date = order_date;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.cartItems = cartItems;
    }
}