import {isLoggedIn} from "../../services/user_service";
import React from "react";
import ProductCard from "../atoms/product";

function LandingScreen() {
    const [products, setProducts] = React.useState([]);
    const [user, setUser] = React.useState({username: "", email: ""});

    if (isLoggedIn()) {
        return (
            <div>
                <br/>
                <h1>Product overview</h1>
                <p>{localStorage.getItem("username")}, listen to your stomach :D</p>
                <ProductCard></ProductCard>
            </div>
        );
    } else {
        return <></>;
    }
}

export default LandingScreen;
