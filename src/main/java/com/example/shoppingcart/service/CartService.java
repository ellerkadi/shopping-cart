package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CartService {

    private final ProductRepository productRepository;

    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product " + product.getName() + " has been added.";
    }

    public List<Product> getCartItems() {
        return productRepository.findAll();
    }

    public String deleteProductByName(String enteredName) {
        productRepository.deleteByName(enteredName);
        return "Product deleted. " + getCartItems();
    }

    public double calculateCartTotal() {
        double cartTotal = 0;
        for (Product product : getCartItems()) {
            cartTotal += product.calculatePrice();
        }
        return cartTotal;
    }

    public double calculateTax() {
        double taxRate = 0.22;
        double tax = taxRate * calculateCartTotal();
        return tax;
    }

    public double calculateTaxTotal() {
        double taxRate = 0.22;
        double taxImplement = (taxRate * calculateCartTotal()) + calculateCartTotal();
        return taxImplement;
    }

    public String discountToCart() {
        double discount = 0.10;
        double applyDiscount = (calculateCartTotal() - (discount * calculateCartTotal()));
        return "Discount applied. Discounted total is " + applyDiscount + ".";
    }
}