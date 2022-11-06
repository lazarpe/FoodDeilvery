export class ShippingAddress {
    id: number;
    address: string;
    city: string;
    zipCode: string;
    country: string;

    constructor(
        id: number,
        address: string,
        city: string,
        zipCode: string,
        country: string
    ) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
}