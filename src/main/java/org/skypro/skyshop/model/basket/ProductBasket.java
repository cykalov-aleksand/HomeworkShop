package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@SessionScope
@Component
public class ProductBasket {
    private final Map<UUID, Integer> productBasket = new HashMap<>();

    public void addProductBasket(UUID id) {
        productBasket.computeIfAbsent(id, k -> 0);
        productBasket.put(id, productBasket.get(id) + 1);
    }

    public Map<UUID, Integer> getProductBasket() {
        return Collections.unmodifiableMap(productBasket);
    }
}
