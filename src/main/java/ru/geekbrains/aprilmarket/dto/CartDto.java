package ru.geekbrains.aprilmarket.dto;

import lombok.Data;
import ru.geekbrains.aprilmarket.entities.Cart;
import ru.geekbrains.aprilmarket.entities.CartItem;

import java.util.List;

@Data
public class CartDto {
    private Long cartId;
    private Integer totalItems;
    private Integer totalPrice;
    private Long ownerId;
    private List<CartItem> cartItems;

    public CartDto(Cart cart) {
        this.cartId = cart.getId();
        this.totalItems = cart.getTotalItems();
        this.totalPrice = cart.getTotalPrice();
        this.ownerId = cart.getOwner().getId();
        this.cartItems = cart.getCartItems();
    }
}
