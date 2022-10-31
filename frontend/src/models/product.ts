export class AppUser {
    id: string | undefined;
    name: string;
    email: string | undefined;
    password: string;

    constructor(
        id: string | undefined,
        name: string,
        email: string | undefined,
        password: string
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
