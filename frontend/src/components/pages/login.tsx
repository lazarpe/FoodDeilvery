import AppButton from "../atoms/button";
import Inputfield from "../atoms/inputfield";
import * as yup from "yup";
import { login } from "../../services/user_service";
import { AppUser } from "../../models/user";
import React from "react";
import { useNavigate } from "react-router-dom";

const schema = yup.object().shape({
  email: yup.string().email().required(),
  password: yup.string().required(),
});

function LoginPage() {
  let navigate = useNavigate();

  const [data, setData] = React.useState({
    email: "",
    password: "",
  });

  function requestLogin() {
    console.log("Request login");
    schema
      .validate(data)
      .then(() => {
        console.log("Input validated");
        login(
          new AppUser(undefined, undefined, data.email, data.password)
        ).then((value) => {
          if (value.ok) {
            navigate("/");
          }
        });
      })
      .catch((err) => {
        console.log("Error", err);
      });
  }

  return (
    <div>
      <br />
      <h1>Login</h1>
      <div>
        <div>
          <Inputfield
            label="Email"
            placeholder="peter@sunny.com"
            value={data.email}
            onChangeText={(value) => setData({ ...data, email: value })}
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
