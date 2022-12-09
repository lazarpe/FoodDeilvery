export class Product {
    id: number;
    available: boolean;
    description: string;
    imageUrl: string;
    name: string;
    price: number;

    constructor(
        id: number,
        available: boolean,
        description: string,
        imageUrl: string,
        name: string,
        price: number
    ) {
        this.id = id;
        this.available = available;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
    }
}
