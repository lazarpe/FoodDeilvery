import {Product} from "../models/product";
import {AppSettings} from "../app.settings";

export function getAllProducts() {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));

    const requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };
    // @ts-ignore
    return fetch(AppSettings.API_ENDPOINT + "products/", requestOptions);
}

export function getProductByName(name: string) {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));

    const requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };
    // @ts-ignore
    return fetch(AppSettings.API_ENDPOINT + "products/name/" + name, requestOptions);
}

export function addProductToLocalStorage(product: Product) {
    let products: Product[] = [];
    if (localStorage.getItem("product_list") != null) {
        products = JSON.parse(localStorage.getItem("product_list")!);
    }
    products.push(product);
    localStorage.setItem("product_list", JSON.stringify(products));
}

export function getProductsFromLocalStorage() {
    return JSON.parse(localStorage.getItem("product_list")!);
}

export function deleteProductFromLocalStorage(product: Product) {
    let products: Product[] = [];
    if (localStorage.getItem("product_list") != null) {
        products = JSON.parse(localStorage.getItem("product_list")!);
    }
    products = products.filter(p => p.name !== product.name);
    localStorage.setItem("product_list", JSON.stringify(products));
}
