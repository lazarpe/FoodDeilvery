export class ShippingAddress {
    address: string;
    city: string;
    zipCode: string;
    country: string;

    constructor(
        address: string,
        city: string,
        zipCode: string,
        country: string
    ) {
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
}