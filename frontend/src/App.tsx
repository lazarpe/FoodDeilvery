import "./App.css";
import { NextUIProvider } from "@nextui-org/react";
import InputComponents from "./components/molecules/input-components";
import NavBar from "./components/molecules/navbar";
import LoginPage from "./components/pages/login";
import RegisterPage from "./components/pages/register";
import LandingScreen from "./components/pages/landing-screen";

import {
  BrowserRouter,
  Routes, //replaces "Switch" used till v5
  Route,
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NextUIProvider>
          <NavBar />
          <Routes>
            <Route path="/" element={<LandingScreen />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
          </Routes>
        </NextUIProvider>
      </BrowserRouter>
    </div>
  );
}

export default App;
