import AppButton from "../atoms/button";
import Inputfield from "../atoms/inputfield";
import * as yup from "yup";
import { login } from "../../services/user_service";
import { AppUser } from "../../models/user";
import React from "react";
import { useNavigate } from "react-router";

const schema = yup.object().shape({
  name: yup.string().required(),
  password: yup.string().required(),
});

function LoginPage() {
  const navigation = useNavigate();

  const [data, setData] = React.useState({
    name: "",
    password: "",
  });

  function requestLogin() {
    console.log("Requested login");
    schema.validate(data).catch((err) => {
      console.log("Error", err);
    });
    login(new AppUser(undefined, data.name, undefined, data.password)).then(
      (response) => {
        if (response.ok) {
          console.log("Login successful");
          response.json().then((data) => {
            console.log(data.access_token);
            localStorage.setItem("access_token", data.access_token);
          });
          navigation("/");
        } else {
          console.log("Login failed");
        }
      }
    );
  }

  return (
    <div>
      <br />
      <h1>Login</h1>
      <div>
        <div>
          <Inputfield
            label="Username"
            placeholder="petersunny"
            value={data.name}
            onChangeText={(value) => setData({ ...data, name: value })}
          />
        </div>
        <div>
          <Inputfield
            label="Password"
            placeholder="*********"
            isPassword={true}
            value={data.password}
            onChangeText={(value) => setData({ ...data, password: value })}
          />
        </div>
        <div>
          <AppButton
            label="Login"
            onClick={() => {
              requestLogin();
            }}
          />
        </div>
      </div>
    </div>
  );
}

export default LoginPage;
