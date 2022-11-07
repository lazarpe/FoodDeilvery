import "./App.css";
import {NextUIProvider} from "@nextui-org/react";
import NavBar from "./components/molecules/navbar";
import LoginPage from "./components/pages/login";
import RegisterPage from "./components/pages/register";
import LandingScreen from "./components/pages/landing-screen";
import CartItemsScreen from "./components/pages/cart-items-screen";

import {HashRouter, Route, Routes,} from "react-router-dom";
import CustomerScreen from "./components/pages/customer-screen";

function App() {

    console.log(JSON.stringify(new Date()));

    return (
        <div className="App">
            <HashRouter basename={"/"}>
                <NextUIProvider>
                    <NavBar/>
                    <Routes>
                        <Route path="/" element={<LandingScreen/>}/>
                        <Route path="/login" element={<LoginPage/>}/>
                        <Route path="/register" element={<RegisterPage/>}/>
                        <Route path="/cart" element={<CartItemsScreen/>}/>
                        <Route path="/customer" element={<CustomerScreen/>}/>
                    </Routes>
                </NextUIProvider>
            </HashRouter>
        </div>
    );
}

export default App;
