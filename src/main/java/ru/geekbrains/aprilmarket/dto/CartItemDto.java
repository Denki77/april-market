package ru.geekbrains.aprilmarket.dto;

import lombok.Data;
import ru.geekbrains.aprilmarket.entities.CartItem;

@Data
public class CartItemDto {
    private Long productId;
    private Integer pricePerProduct;
    private Integer price;
    private Integer quantity;

    public CartItemDto(CartItem cartItem) {
        this.productId = cartItem.getProduct().getId();
        this.pricePerProduct = cartItem.getPricePerProduct();
        this.quantity = cartItem.getQuantity();
        this.price = cartItem.getPrice();
    }
}
