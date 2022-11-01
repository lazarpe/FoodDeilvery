import {ShippingAddress} from "./ShippingAddress";
import {Customer} from "./Customer";

export class Cart {
    customer: Customer;
    shippingAddress: ShippingAddress;

    constructor(
        customer: Customer,
        shippingAddress: ShippingAddress
    ) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
    }
}
