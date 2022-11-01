import {getCurrentUser, getUserByName, isLoggedIn} from "../../services/user_service";
import {getAllProducts} from "../../services/product_service";
import React from "react";
import ProductCard from "../atoms/product";

function LandingScreen() {
    const [products, setProducts] = React.useState([]);
    const [user, setUser] = React.useState({username: "", email: ""});

    if (isLoggedIn()) {
        /*getAllProducts().then((response) => {
            if (response.ok) {
                // here is the problem with the request being sent endlessly.
                // I think it's because of the state change
                response.json().then((data) => {
                    console.log("asdf", data);
                });
            }
        });*/

        getUserByName().then((response) => {
            if (response.ok) {
                response.json().then((data) => {

                    //setUser({username: data.name, email: data.email});
                });
            }
        });
        return (
            <div>
                <br/>
                <h1>Product overview</h1>
                <p>{user.username}, listen to your stomach :D</p>
                <ProductCard></ProductCard>
            </div>
        );
    } else {
        document.location.reload();
        return <></>;
    }
}

export default LandingScreen;
