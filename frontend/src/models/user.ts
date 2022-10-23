export class AppUser {
  id: string | undefined;
  name: string | undefined;
  email: string;
  password: string;

  constructor(
    id: string | undefined,
    name: string | undefined,
    email: string,
    password: string
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
