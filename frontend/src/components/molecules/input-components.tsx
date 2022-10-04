import AppButton from "../atoms/button";
import Inputfield from "../atoms/inputfield";
import styled from "styled-components";

interface InputComponentsProps {
  buttonLabel: string;
}

function InputComponents({ buttonLabel }: InputComponentsProps) {
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
        <AppButton label={buttonLabel} />
      </div>
    </div>
  );
}

export default InputComponents;
