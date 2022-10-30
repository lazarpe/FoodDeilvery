import * as yup from "yup";
import Inputfield from "../atoms/inputfield";
import AppButton from "../atoms/button";
import React from "react";
import { register } from "../../services/user_service";
import { AppUser } from "../../models/user";
import { useNavigate } from "react-router";

const schema = yup.object().shape({
  name: yup.string().required(),
  email: yup.string().email().required(),
  password: yup.string().required(),
});

function RegisterPage() {
  const navigation = useNavigate();

  const [data, setData] = React.useState({
    name: "",
    email: "",
    password: "",
  });

  function requestRegistration() {
    console.log("Request registration");
    schema.validate(data).catch((err) => {
      console.log("Error", err);
    });
    register(new AppUser(undefined, data.name, data.email, data.password)).then(
      (response) => {
        if (response.ok) {
          console.log("Registration successful");
          response.json().then((data) => {
            console.log(data.access_token);
            localStorage.setItem("access_token", data.access_token);
          });
          navigation("/");
        } else {
          console.log("didn't work proper");
        }
      }
    );
  }

  return (
    <div>
      <br />
      <h1>Registration</h1>
      <div>
        <div>
          <Inputfield
            value={data.name}
            label="Username"
            placeholder="peter"
            onChangeText={(value) => setData({ ...data, name: value })}
          />
        </div>
        <div>
          <Inputfield
            value={data.email}
            label="Email"
            placeholder="peter@school.com"
            onChangeText={(value) => setData({ ...data, email: value })}
          />
        </div>
        <div>
          <Inputfield
            value={data.password}
            label="Password"
            placeholder="*********"
            isPassword={true}
            onChangeText={(value) => setData({ ...data, password: value })}
          />
        </div>
        <div>
          <AppButton
            label="Register"
            onClick={() => {
              requestRegistration();
            }}
          />
        </div>
      </div>
    </div>
  );
}

export default RegisterPage;
