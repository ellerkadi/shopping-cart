package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // http://localhost:8089/api/cart/addProduct
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        return cartService.addProduct(product);
    }

    @GetMapping("/getCartItems")
    public List<Product> getCartItems() {
        return cartService.getCartItems();
    }

    @DeleteMapping("/deleteProductByName/{name}")
    public String deleteProductByName(@PathVariable("name") String enteredName) {
        return cartService.deleteProductByName(enteredName);
    }

    @GetMapping("/calculateCartTotal")
    public double calculateCartTotal() {
        return cartService.calculateCartTotal();
    }

    @GetMapping("/calculateTax")
    public double calculateTax() {
        return cartService.calculateTax();
    }

    @GetMapping("/calculateTaxTotal")
    public double calculateTaxTotal() {
        return cartService.calculateTaxTotal();
    }

    @GetMapping("/discountToCart")
    public String discountToCart() {
        return cartService.discountToCart();
    }
}
