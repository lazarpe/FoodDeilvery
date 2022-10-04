import AppButton from "../atoms/button";
import Inputfield from "../atoms/inputfield";
import styled from "styled-components";

function InputComponents() {
  return (
    <div>
      <div>
        <Inputfield label="Username" placeholder="Peter Sunny" />
      </div>
      <div>
        <Inputfield
          label="Password"
          placeholder="*********"
          isPassword={true}
        />
      </div>
      <div>
        <AppButton label="Register" />
      </div>
    </div>
  );
}

export default InputComponents;
