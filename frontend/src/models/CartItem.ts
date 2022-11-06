import {Product} from "./product";
import {ShoppingCart} from "./ShoppingCart";

export class CartItem {
    id: number;
    quantity: number;
    price: number;
    product: Product;
    shoppingCart: ShoppingCart | undefined;

    constructor(
        id: number,
        quantity: number,
        price: number,
        product: Product,
        shoppingCart: ShoppingCart | undefined
    ) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.shoppingCart = shoppingCart;
    }
}