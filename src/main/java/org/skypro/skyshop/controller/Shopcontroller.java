package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


import static org.skypro.skyshop.SkyshopApplication.test;


@RestController
public class Shopcontroller {

    private final StorageService storageService;

    public Shopcontroller(StorageService storageService) {
        this.storageService = new StorageService(test());
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
        return storageService.entireCollection().search(pattern).toString();
    }
}
