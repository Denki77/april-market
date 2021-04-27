package ru.geekbrains.aprilmarket.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.aprilmarket.dto.CartDto;
import ru.geekbrains.aprilmarket.entities.Cart;
import ru.geekbrains.aprilmarket.services.CartService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {
    private CartService cartService;

    @GetMapping("/{id}")
    public CartDto findById(@PathVariable Long id) {
        return cartService.findCartDtoById(id).orElseThrow(() -> new RuntimeException("Not found!!!"));
    }

    @PutMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

}
