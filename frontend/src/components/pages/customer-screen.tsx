import React from "react";
import {getProductsFromLocalStorage} from "../../services/product_service";
import {Product} from "../../models/product";
import Inputfield from "../atoms/inputfield";
import AppButton from "../atoms/button";
import {Customer} from "../../models/Customer";
import {ShippingAddress} from "../../models/ShippingAddress";
import {CartItem} from "../../models/CartItem";
import {ShoppingCart} from "../../models/ShoppingCart";
import {OrderRequest} from "../../models/OrderRequest";
import {getUserByName} from "../../services/user_service";
import {saveOrder} from "../../services/order_service";

export default function CustomerScreen() {

    const [data, setData] = React.useState({
        firstName: "",
        lastName: "",
        address: "",
        city: "",
        zipCode: "",
        country: "",
    });

    function orderProducts() {
        getUserByName().then((response) => {
            if (response.ok) {
                response.json().then((userData) => {
                    console.log(userData);
                    let customer = new Customer(0, data.firstName, data.lastName, userData);
                    let shippingAddress = new ShippingAddress(0, data.address, data.city, data.zipCode, data.country);

                    let products = getProductsFromLocalStorage();
                    let cartItems = products.map((product: Product) => new CartItem(
                        0, 1, product.price, product, undefined
                    ));

                    // Group the same products and increase the quantity
                    let groupedCartItems = cartItems.reduce((acc: CartItem[], item: CartItem) => {
                        let existingItem = acc.find((i: CartItem) => i.product.id === item.product.id);
                        if (existingItem) {
                            existingItem.quantity++;
                        } else {
                            acc.push(item);
                        }
                        return acc;
                    }, []);

                    // get total price of items
                    let totalPrice = groupedCartItems.reduce((acc: number, item: CartItem) => {
                        return acc + item.price * item.quantity;
                    }, 0);

                    let shoppingCard = new ShoppingCart(
                        0, totalPrice, new Date(), customer, shippingAddress, []);

                    let orderRequest = new OrderRequest(shoppingCard, groupedCartItems);
                    saveOrder(orderRequest).then((response) => {
                        if (response.ok) {
                            response.json().then((data) => {
                                console.log(data);
                                alert("Order placed successfully");
                            });
                        }
                    });
                });
            }
        });
    }

    return (
        <div>
            <br/>
            <h2>Customer</h2>
            <div>
                <Inputfield
                    label="First name"
                    placeholder="Peter"
                    value={data.firstName}
                    onChangeText={(value) => setData({...data, firstName: value})}
                />
            </div>
            <div>
                <Inputfield
                    label="Last name"
                    placeholder="Sunny"
                    value={data.lastName}
                    onChangeText={(value) => setData({...data, lastName: value})}
                />
            </div>
            <div>
                <br></br>
                <br></br>
                <br></br>
                <hr/>
                <div>
                    <Inputfield
                        label="Address"
                        placeholder="Hauptstrasse 1"
                        value={data.address}
                        onChangeText={(value) => setData({...data, address: value})}
                    />
                </div>
                <div>
                    <Inputfield
                        label="City"
                        placeholder="Zurich"
                        value={data.city}
                        onChangeText={(value) => setData({...data, city: value})}
                    />
                </div>
                <div>
                    <Inputfield
                        label="Zip code"
                        placeholder="8000"
                        value={data.zipCode}
                        onChangeText={(value) => setData({...data, zipCode: value})}
                    />
                </div>
                <div>
                    <Inputfield
                        label="Country"
                        placeholder="Switzerland"
                        value={data.country}
                        onChangeText={(value) => setData({...data, country: value})}
                    />
                </div>
                <br/>
                <AppButton
                    label="Order"
                    onClick={orderProducts}
                    /*onClick={() => {
                        orderProducts();
                    }}*/
                />
            </div>
        </div>
    );
}
