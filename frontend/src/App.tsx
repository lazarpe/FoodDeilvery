import "./App.css";
import { NextUIProvider } from "@nextui-org/react";
import InputComponents from "./components/molecules/input-components";

function App() {
  return (
    <div className="App">
      <NextUIProvider>
        <InputComponents />
      </NextUIProvider>
    </div>
  );
}

export default App;
