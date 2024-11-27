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

    // http://localhost:8089/api/cart/getCartItems
    @GetMapping("/getCartItems")
    public List<Product> getCartItems() {
        return cartService.getCartItems();
    }

    // http://localhost:8089/api/cart/deleteProductByName/table
    @DeleteMapping("/deleteProductByName/{name}")
    public String deleteProductByName(@PathVariable("name") String enteredName) {
        return cartService.deleteProductByName(enteredName);
    }

    // http://localhost:8089/api/cart/calculateCartTotal
    @GetMapping("/calculateCartTotal")
    public double calculateCartTotal() {
        return cartService.calculateCartTotal();
    }

    // http://localhost:8089/api/cart/calculateTax
    @GetMapping("/calculateTax")
    public double calculateTax() {
        return cartService.calculateTax();
    }

    // http://localhost:8089/api/cart/calculateTaxTotal
    @GetMapping("/calculateTaxTotal")
    public double calculateTaxTotal() {
        return cartService.calculateTaxTotal();
    }

    // http://localhost:8089/api/cart/discountToCart
    @GetMapping("/discountToCart")
    public String discountToCart() {
        return cartService.discountToCart();
    }
}
