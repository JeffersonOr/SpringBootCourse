package cursoSpringBoot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cursoSpringBoot.domain.Product;

public class ProductsServiceimpl {

    // all logic here

    List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1, "Laptop", 799.99, 10),
        new Product(2, "SmartPhone", 499.99, 25),
        new Product(3, "Tablet", 299.99, 15),
        new Product(4, "SmartWatch", 199.99, 30)
    ));

    public List<Product> geProducts(){
        return products;
    }
}
