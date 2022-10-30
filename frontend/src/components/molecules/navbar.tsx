import { Navbar, Button, Link, Text } from "@nextui-org/react";
import { isLoggedIn, logout } from "../../services/user_service";

export default function NavBar() {
  if (isLoggedIn()) {
    return (
      <Navbar isBordered variant="floating">
        <Navbar.Brand>
          <Text b color="inherit" hideIn="xs">
            <Link href="/">Foody</Link>
          </Text>
        </Navbar.Brand>
        <Navbar.Content>
          <Navbar.Item>
            <Button
              auto
              flat
              as={Link}
              href="/login"
              onClick={() => {
                logout();
              }}
            >
              Log out
            </Button>
          </Navbar.Item>
        </Navbar.Content>
      </Navbar>
    );
  } else {
    return (
      <Navbar isBordered variant="floating">
        <Navbar.Brand>
          <Text b color="inherit" hideIn="xs">
            <Link href="/">Foody</Link>
          </Text>
        </Navbar.Brand>
        <Navbar.Content>
          <Navbar.Link color="inherit" href="/login">
            Login
          </Navbar.Link>
          <Navbar.Item>
            <Button auto flat as={Link} href="/register">
              Registration
            </Button>
          </Navbar.Item>
        </Navbar.Content>
      </Navbar>
    );
  }
}
