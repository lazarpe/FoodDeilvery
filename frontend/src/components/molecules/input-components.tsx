import AppButton from "../atoms/button";
import Inputfield from "../atoms/inputfield";
import styled from "styled-components";

function InputComponents() {
  return (
    <div>
      <div>
        <Inputfield label="Username" placeholder="Guilierme Hansa" />
      </div>
      <div>
        <Inputfield label="Password" placeholder="as" isPassword={true} />
      </div>
      <div>
        <AppButton label="Register" />
      </div>
    </div>
  );
}

export default InputComponents;
