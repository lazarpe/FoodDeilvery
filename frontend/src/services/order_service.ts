import {OrderRequest} from "../models/OrderRequest";
import {AppSettings} from "../app.settings";

export function saveOrder(orderRequest: OrderRequest) {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer " + localStorage.getItem("access_token"));
    myHeaders.append("Content-Type", "application/json");
    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(orderRequest),
        redirect: 'follow'
    };
    // @ts-ignore
    return fetch(AppSettings.API_ENDPOINT + "order_request/order", requestOptions);
}



