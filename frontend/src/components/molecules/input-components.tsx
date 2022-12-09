import AppButton from "../atoms/button";
import Inputfield from "../atoms/inputfield";

interface InputComponentsProps {
    buttonLabel: string;
}

function InputComponents({buttonLabel}: InputComponentsProps) {
    return (
        <div>
            <div>
                <Inputfield label="Username" placeholder="peter_sunny"/>
            </div>
            <div>
                <Inputfield
                    label="Password"
                    placeholder="*********"
                    isPassword={true}
                />
            </div>
            <div>
                <AppButton label={buttonLabel}/>
            </div>
        </div>
    );
}

export default InputComponents;
