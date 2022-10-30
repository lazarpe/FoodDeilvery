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

type LoginProps = {
  setIsLoggedIn: (value: boolean) => void;
};

function LoginPage(/*{ setIsLoggedIn }: LoginProps*/) {
  const navigation = useNavigate();

  const [data, setData] = React.useState({
    name: "",
    password: "",
  });

  function requestLogin() {
    login(new AppUser(undefined, data.name, undefined, data.password)).then(
      (response) => {
        if (response.ok) {
          console.log("response is okeeee");
          navigation("/");
        } else {
          console.log("didn't work properly");
        }
      }
    );
    console.log("Request login");
    schema.validate(data).catch((err) => {
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
