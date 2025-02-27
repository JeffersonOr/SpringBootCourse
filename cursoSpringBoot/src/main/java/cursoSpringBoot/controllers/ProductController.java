package cursoSpringBoot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursoSpringBoot.domain.Product;
import cursoSpringBoot.service.ProductsServiceimpl;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductsServiceimpl productsServiceimpl = new ProductsServiceimpl();

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productsServiceimpl.geProducts();
        return ResponseEntity.ok(products);
    }

}
