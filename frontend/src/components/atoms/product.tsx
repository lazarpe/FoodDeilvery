import {Card, Grid, Row, Text} from "@nextui-org/react";
import {isLoggedIn} from "../../services/user_service";
import {getAllProducts} from "../../services/product_service";
import React, {useEffect} from "react";
import {Product} from "../../models/product";

export default function ProductCard() {
    // let list: Product[] = [];

    const [list, setList] = React.useState<Product[]>([]);

    // if (isLoggedIn()) {
    useEffect(() => {
            getAllProducts().then((response) => {
                    if (response.ok) {
                        response.json().then((data) => {
                            setList(data);
                            for (let i = 0; i < data.length; i++) {
                                console.log("DATAAAA: ", i, data[i]);

                                //setProducts(data[i]);
                                /* setProducts({
                                     "available": data[i].available,
                                     "description": data[i].description,
                                     "imageUrl": data[i].imageUrl,
                                     "name": data[i].name,
                                     "price": data[i].price
                                 });*/
                                 //list.push(products);
                            }
                        });
                    }
                //setProducts();
                //console.log("asdf", data);
            }
        );
    }, []);

        /*
        for (let i = 0; i < products.length; i++) {
            list.push({
                title: products[i],
                img: products[i].image,
                price: products[i].price,
            });
        }*/
        return (
            <Grid.Container gap={2} justify="flex-start">
                {list.map((item, index) => (
                    <Grid xs={6} sm={3} key={index}>
                        <Card isPressable>
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
                       {/*         <Row>
                                    <Text css={{color: "$accents7", fontSize: "$sm"}}>
                                        {item.description}
                                    </Text>
                                </Row>*/}
                            </Card.Footer>
                        </Card>
                    </Grid>
                ))}
            </Grid.Container>
        );
    // } else {
    //     return (
    //         <div>
    //             <br/>
    //             <h1>No products available</h1>
    //         </div>
    //     );
    // }
}
