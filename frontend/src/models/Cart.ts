import {ShippingAddress} from "./ShippingAddress";
import {Customer} from "./Customer";

export class Cart {
    id: number;
    customer: Customer;
    shippingAddress: ShippingAddress;

    constructor(
        id: number,
        customer: Customer,
        shippingAddress: ShippingAddress
    ) {
        this.id = id;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
    }
}
