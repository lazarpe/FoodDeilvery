export function getAllProducts() {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));

    const requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };
    // @ts-ignore
    return fetch("http://localhost:8080/api/products/", requestOptions);
}