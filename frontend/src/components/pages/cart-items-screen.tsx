import React, {useEffect} from "react";
import {addProductToLocalStorage, getProductByName, getProductsFromLocalStorage} from "../../services/product_service";
import {Product} from "../../models/product";
import {Button, Card, Grid, Popover, Row, Text} from "@nextui-org/react";
import CustomerScreen from "./custommer-screen";
import AppButton from "../atoms/button";

export default function CartItemsScreen() {
    let product_list: Product[] = getProductsFromLocalStorage();

    return (
        <>
            <div>
                <br/>
                <h1>Cart overview</h1>
                <p>Here you can see all the items you have added to your cart</p>
                <Grid.Container gap={2} justify="flex-start">
                    {product_list.map((item, index) => (
                        <Grid xs={6} sm={3} key={index}>
                            <Card>
                                <Card.Body css={{p: 0}}>
                                    <Card.Image
                                        src={item.imageUrl}
                                        objectFit="cover"
                                        width="100%"
                                        height={140}
                                        alt={item.name}/>
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
                        </Grid>

                    ))}
                </Grid.Container>
            </div>
            <div>
                <AppButton
                    label="Next"
                    onClick={() => {
                        window.location.href = "/#customer";
                    }}
                />
            </div>
        </>
    );
}
