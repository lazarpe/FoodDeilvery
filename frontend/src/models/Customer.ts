import {AppUser} from "./user";

export class Customer {
    id: number;
    firstName: string;
    lastName: string;
    appUser: AppUser;

    constructor(
        id: number,
        firstName: string,
        lastName: string,
        appUser: AppUser
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.appUser = appUser;
    }
}