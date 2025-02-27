package cursoSpringBoot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import cursoSpringBoot.domain.Product;

@Service //esto es un bean se servicio
//@Service("listResourceService")
@ConditionalOnProperty(name= "service.properties",havingValue = "list")
public class ProductsServiceimpl implements ProductService {

    // all logic here

    List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1, "Laptop", 799.99, 10),
        new Product(2, "SmartPhone", 499.99, 25),
        new Product(3, "Tablet", 299.99, 15),
        new Product(4, "SmartWatch", 199.99, 30)
    ));

    @Override
    public List<Product> getProducts(){
        return products;
    }

}
