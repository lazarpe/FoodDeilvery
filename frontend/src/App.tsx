import React from "react";
import logo from "./logo.svg";
import "./App.css";

import { NextUIProvider } from "@nextui-org/react";
import { Button } from "@nextui-org/react";
import { Navbar } from "@nextui-org/react";

import { Card } from "@nextui-org/react";

const Component = () => <Button>Click me</Button>;

function App() {
  return (
    <NextUIProvider>
      <div className="App">
        <header className="App-header">
          <text>Hello</text>
          <Component />
          <Card css={{ mw: "400px" }}>
            <Card.Body>
              <text>A basic card</text>
            </Card.Body>
          </Card>
        </header>
      </div>
    </NextUIProvider>
  );
}

export default App;
