export function saveCartItem() {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        redirect: 'follow'
    };
    // @ts-ignore
    return fetch("http://localhost:8082/api/cart-items/save", requestOptions);
}



