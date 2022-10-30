import { isLoggedIn } from "../../services/user_service";

function LandingScreen() {
  if (isLoggedIn()) {
    return (
      <div>
        <br />
        <h1>Logged in</h1>
      </div>
    );
  } else {
    return (
      <div>
        <br />
        <h1>Welcome</h1>
      </div>
    );
  }
}

export default LandingScreen;
