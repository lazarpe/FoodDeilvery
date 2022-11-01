import {Popover, Card, Grid, Row, Text, Button} from "@nextui-org/react";
import {isLoggedIn} from "../../services/user_service";
import {addProductToLocalStorage, getAllProducts} from "../../services/product_service";
import React, {useEffect} from "react";
import {Product} from "../../models/product";

export default function ProductCard() {
    const [list, setList] = React.useState<Product[]>([]);
    const [productList, setProductList] = React.useState<Product[]>([]);

    useEffect(() => {
        getAllProducts().then((response) => {
                if (response.ok) {
                    response.json().then((data) => {
                        setList(data);
                    });
                }
            }
        );
    }, []);


    return (
        <Grid.Container gap={2} justify="flex-start">
            {list.map((item, index) => (
                <Grid xs={6} sm={3} key={index}>
                    <div>
                    </div>
                    <Popover>
                        <Popover.Trigger>
                            <Card>
                                <Card.Body css={{p: 0}}>
                                    <Card.Image
                                        src={item.imageUrl}
                                        objectFit="cover"
                                        width="100%"
                                        height={140}
                                        alt={item.name}
                                    />
                                </Card.Body>
                                <Card.Footer css={{justifyItems: "flex-start"}}>
                                    <Row wrap="wrap" justify="space-between" align="center">
                                        <Text b>{item.name}</Text>
                                        <Text css={{color: "$accents7", fontWeight: "$semibold", fontSize: "$sm"}}>
                                            ${item.price}
                                        </Text>
                                    </Row>
                                </Card.Footer>
                            </Card>
                        </Popover.Trigger>
                        <Popover.Content>
                            <Grid.Container
                                css={{borderRadius: "14px", padding: "0.75rem", maxWidth: "330px"}}
                            >
                                <Row justify="center" align="center">
                                    <Text b>Confirm</Text>
                                </Row>
                                <Row>
                                    <Text css={{color: "$accents7", fontSize: "$sm"}}>
                                        {item.description}
                                    </Text>
                                </Row>
                                <Grid.Container justify="space-between" alignContent="center">
                                    <Grid>
                                        <Button size="sm" light>
                                            Cancel
                                        </Button>
                                    </Grid>
                                    <Grid>
                                        <Button size="sm" shadow color="success"
                                                onClick={() => addProductToLocalStorage(new Product(
                                                    item.available,
                                                    item.description,
                                                    item.imageUrl,
                                                    item.name,
                                                    item.price))}
                                        >
                                            Add to cart
                                        </Button>
                                    </Grid>
                                </Grid.Container>
                            </Grid.Container>
                        </Popover.Content>
                    </Popover>
                </Grid>

            ))}
        </Grid.Container>
    );
}
