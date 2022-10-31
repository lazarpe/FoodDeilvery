import { AppUser } from "../models/user";
import jwtDecode from "jwt-decode";

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
  var urlencoded = new URLSearchParams();
  urlencoded.append("name", appUser.name);
  urlencoded.append("password", appUser.password);

  return fetch("http://localhost:8080/api/users/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded", //"Content-Type": "application/json",
    },
    body: urlencoded,
  });
}

export function logout() {
  localStorage.removeItem("access_token");
}

// get user by name
export function getUserByName() {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));

    const requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
    };
    const token = jwtDecode(localStorage.getItem("access_token") || "{}");
    // @ts-ignore
    return fetch("http://localhost:8080/api/users/name/" + token.sub, requestOptions);
}

// get the current user from local storage
export function getCurrentUser() {
    return JSON.parse(localStorage.getItem("access_token")!);
}

export function isLoggedIn() {
  return localStorage.getItem("access_token") != null;
}
