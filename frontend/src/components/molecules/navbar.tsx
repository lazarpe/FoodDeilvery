import {Navbar, Button, Link, User, Text} from "@nextui-org/react";
import {getUserByName, isLoggedIn, logout} from "../../services/user_service";
import React from "react";

interface NavbarProps {
    value?: string;
};

export default function NavBar({value}: NavbarProps) {
//    const [user, setUser] = React.useState("");
    const [user, setUser] = React.useState({username: "", email: ""});


    if (isLoggedIn()) {
        getUserByName().then((response) => {
            if (response.ok) {
                response.json().then((data) => {
                    //setUser(data.name);
                    setUser({username: data.name, email: data.email});
                });
            }
        });
        return (
            <Navbar isBordered variant="floating">
                <Navbar.Brand>
                    <Text b color="inherit" hideIn="xs">
                        <Link href="/">Foody</Link>
                    </Text>
                </Navbar.Brand>
                <Navbar.Content>
                    <Navbar.Item>
                        <User
                            src="https://images.unsplash.com/photo-1511367461989-f85a21fda167?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2231&q=80"
                            //name={user}
                            name={user.username}
                        >
                            <User.Link>{user.email}</User.Link>
                        </User>
                    </Navbar.Item>
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
