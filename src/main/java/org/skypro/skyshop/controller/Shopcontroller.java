package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class Shopcontroller {

    private final StorageService storageService;

    public Shopcontroller(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticle() {
        return storageService.getAllArticle();
    }

    @GetMapping("/search")
    public String search(@RequestParam("pattern") String pattern) {
        Optional<StorageService> safeNull = Optional.ofNullable(null);
        Optional<String> optional;
        optional = safeNull.map(productArtycle -> new SearchService(productArtycle.entireCollection()).search(pattern)
                .toString()).orElse("Тестовые значения в StorageService не введены").describeConstable();
        String outputString = "";
        if (optional.isPresent()) {
            outputString = optional.get();
        }
        return outputString;
    }
}


