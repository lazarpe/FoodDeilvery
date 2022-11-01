import React, {useEffect} from "react";
import {addProductToLocalStorage, getProductByName, getProductsFromLocalStorage} from "../../services/product_service";
import {Product} from "../../models/product";
import {Button, Card, Grid, Popover, Row, Text} from "@nextui-org/react";
import Inputfield from "../atoms/inputfield";
import AppButton from "../atoms/button";

export default function CustomerScreen() {
    const [data, setData] = React.useState({
        firstName: "",
        lastName: "",
        address: "",
        city: "",
        zipCode: "",
        country: "",
    });
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
                <hr />
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
                    onClick={() => {}}
                />
            </div>
        </div>
    );
}
