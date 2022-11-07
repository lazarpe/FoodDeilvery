export function saveCartItem() {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        redirect: 'follow'
    };
    // @ts-ignore
    return fetch(AppSettings.API_ENDPOINT + "cart-items/save", requestOptions);
}



