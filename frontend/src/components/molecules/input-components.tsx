import Inputfield from "../atoms/inputfield";

function InputComponents() {
  return (
    <div>
      <br></br>
      <div>
        <Inputfield label="Username" placeholder="Guilierme Hansa" />
      </div>
      <br></br>
      <div>
        <Inputfield label="Password" placeholder="as" isPassword={true} />
      </div>
    </div>
  );
}

export default InputComponents;
