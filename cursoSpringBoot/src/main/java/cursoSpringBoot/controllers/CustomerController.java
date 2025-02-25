package cursoSpringBoot.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cursoSpringBoot.domain.Customer;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Jeff", "Jaramillo", "123"),
            new Customer(456, "Carlos", "Rodriguez", "567"),
            new Customer(789, "Julieth", "Garay", "909"),
            new Customer(780, "Sebastian", "Orozco", "secret")));

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customers);
        // return customers;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username) {// el signo de ? indica que puede retornar
                                                                        // cualquier tipo de dato
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
                // return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: " + username);
    }

    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customer) {
        customers.add(customer);
        URI location =ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{username}")
        .buildAndExpand(customer.getUsername())
        .toUri();

        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping
    public ResponseEntity<?> putClientes(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity.ok("Cliente modificado satisfactoriamente: "+customer.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con id: "+customer.getId());
    }
}
