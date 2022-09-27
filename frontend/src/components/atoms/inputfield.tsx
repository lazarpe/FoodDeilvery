import { Input } from "@nextui-org/react";
import styled from "styled-components";

interface InputfieldProps {
  label: string;
  placeholder: string;
  isPassword?: boolean;
}

function Inputfield({ label, placeholder, isPassword }: InputfieldProps) {
  if (isPassword) {
    return (
      <View>
        <label>{label}</label>
        <Input.Password placeholder={placeholder} style={InputfieldStyle} />
      </View>
    );
  }
  return (
    <View>
      <label>{label}</label>
      <Input placeholder={placeholder} style={InputfieldStyle} />
    </View>
  );
}

const InputfieldStyle = {
  width: "100%",
};

const View = styled.div`
  display: flex;
  padding-top: 30px;
  flex-direction: column;
  width: 40%;
  position: relative;
  left: 30%;
`;

export default Inputfield;
