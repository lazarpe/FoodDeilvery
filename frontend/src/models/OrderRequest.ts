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
