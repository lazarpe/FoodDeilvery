import { AppUser } from "../models/user";

export function register(appUser: AppUser) {
  return fetch("http://localhost:8080/api/users/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(appUser),
  });
}

export function login(appUser: AppUser) {
  return fetch("http://localhost:8080/api/users/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(appUser),
  });
}
