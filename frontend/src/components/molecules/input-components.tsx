import Inputfield from "../atoms/inputfield";

function InputComponents() {
  return (
    <div>
      <div>
        <Inputfield label="Username" placeholder="Guilierme Hansa" />
      </div>
      <div>
        <Inputfield label="Password" placeholder="as" isPassword={true} />
      </div>
    </div>
  );
}

export default InputComponents;
