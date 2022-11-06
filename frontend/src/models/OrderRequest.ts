import {ShippingAddress} from "./ShippingAddress";
import {Customer} from "./Customer";
import {CartItem} from "./CartItem";
import {ShoppingCart} from "./ShoppingCart";

export class OrderRequest {
    cart: ShoppingCart;
    cartItems: CartItem[];

    constructor(
        cart: ShoppingCart,
        cartItems: CartItem[]
    ) {
        this.cart = cart;
        this.cartItems = cartItems;
    }
}
