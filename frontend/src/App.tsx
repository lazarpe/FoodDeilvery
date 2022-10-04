import "./App.css";
import { NextUIProvider } from "@nextui-org/react";
import InputComponents from "./components/molecules/input-components";
import NavBar from "./components/molecules/navbar";
import LoginPage from "./components/pages/login";

function App() {
  return (
    <div className="App">
      <NextUIProvider>
        <NavBar />
        <LoginPage />
      </NextUIProvider>
    </div>
  );
}

export default App;
