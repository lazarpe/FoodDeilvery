import {bool} from "yup";

export class Product {
    available: boolean;
    description: string;
    imageUrl: string;
    name: string;
    price: number;

    constructor(
        available: boolean,
        description: string,
        imageUrl: string,
        name: string,
        price: number
    ) {
        this.available = available;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
    }
}
