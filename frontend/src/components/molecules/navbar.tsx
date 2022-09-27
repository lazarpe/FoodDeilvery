import { Navbar, Button, Link, Text } from "@nextui-org/react";

export default function NavBar() {
  return (
    <Navbar isBordered variant="floating">
      <Navbar.Brand>
        <Text b color="inherit" hideIn="xs">
          Foody
        </Text>
      </Navbar.Brand>
      <Navbar.Content>
        <Navbar.Link color="inherit" href="#">
          Login
        </Navbar.Link>
        <Navbar.Item>
          <Button auto flat as={Link} href="#">
            Sign Up
          </Button>
        </Navbar.Item>
      </Navbar.Content>
    </Navbar>
  );
}
