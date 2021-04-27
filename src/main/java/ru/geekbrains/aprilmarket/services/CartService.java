package ru.geekbrains.aprilmarket.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.aprilmarket.dto.CartDto;
import ru.geekbrains.aprilmarket.dto.ProductDto;
import ru.geekbrains.aprilmarket.entities.Cart;
import ru.geekbrains.aprilmarket.entities.Product;
import ru.geekbrains.aprilmarket.repositories.CartRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {
    private UserService userService;
    private CartRepository cartRepository;


    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart findByOwnerId(Long id) {
        Optional<Cart> returnCart = Optional.of(cartRepository.
                findByOwnerId(id).orElse(new Cart()));

        return returnCart.get();
    }


    public Optional<CartDto> findCartDtoById(Long id) {
        return cartRepository.findById(id).map(CartDto::new);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}
