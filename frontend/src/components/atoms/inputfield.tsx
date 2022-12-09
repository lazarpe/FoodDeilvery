import {Input} from "@nextui-org/react";
import styled from "styled-components";

interface InputfieldProps {
    value?: string;
    label: string;
    placeholder: string;
    isPassword?: boolean;
    onChangeText?: (text: string) => void;
}

function Inputfield({
                        value,
                        label,
                        placeholder,
                        isPassword,
                        onChangeText = () => {
                        },
                    }: InputfieldProps) {
    if (isPassword) {
        return (
            <View>
                <label>{label}</label>
                <Input.Password
                    value={value}
                    placeholder={placeholder}
                    style={InputfieldStyle}
                    onChange={(e) => onChangeText(e.target.value)}
                />
            </View>
        );
    }
    return (
        <View>
            <label>{label}</label>
            <Input
                value={value}
                placeholder={placeholder}
                style={InputfieldStyle}
                onChange={(e) => onChangeText(e.target.value)}
            />
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
