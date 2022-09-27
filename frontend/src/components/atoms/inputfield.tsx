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
        <Input.Password placeholder={placeholder} />
      </View>
    );
  }
  return (
    <View>
      <label>{label}</label>
      <Input placeholder={placeholder} />
    </View>
  );
}

const View = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

export default Inputfield;
