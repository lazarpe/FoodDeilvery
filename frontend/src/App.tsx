import "./App.css";
import { NextUIProvider } from "@nextui-org/react";
import InputComponents from "./components/molecules/input-components";
import NavBar from "./components/molecules/navbar";

function App() {
  return (
    <div className="App">
      <NextUIProvider>
        <NavBar />
      </NextUIProvider>
    </div>
  );
}

export default App;
