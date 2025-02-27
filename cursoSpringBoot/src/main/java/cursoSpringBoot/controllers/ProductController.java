package cursoSpringBoot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursoSpringBoot.domain.Product;
import cursoSpringBoot.service.ProductService;
import cursoSpringBoot.service.ProductsServiceimpl;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productsService = new ProductsServiceimpl();

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

}
