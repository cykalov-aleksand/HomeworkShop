package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

import static org.skypro.skyshop.service.StorageService.*;


@RestController
public class Shopcontroller {

    private final StorageService storageService;

    public Shopcontroller(StorageService storageService) {
        this.storageService=new StorageService(test());
    }
    private static List<Searchable> test() {
        Product[] products = {
                new SimpleProduct("Конфеты", 800, UUID.randomUUID()),
                new SimpleProduct("Макароны", 80, UUID.randomUUID()),
                new SimpleProduct("Пельмени", 350, UUID.randomUUID()),
                new SimpleProduct("Масло", 120, UUID.randomUUID()),
                new SimpleProduct("Сосиски", 150, UUID.randomUUID()),
                new SimpleProduct("Кетчуп", 120, UUID.randomUUID()),
                new SimpleProduct("Майонез", 77, UUID.randomUUID()),
                new SimpleProduct("Молоко", 80, UUID.randomUUID()),
                new SimpleProduct("Кефир", 80, UUID.randomUUID()),
                new SimpleProduct("Сметана", 210, UUID.randomUUID()),
                new SimpleProduct("Яйца", 100, UUID.randomUUID()),
                new DiscountedProduct("Мыло", 23, 10, UUID.randomUUID()),
                new DiscountedProduct("Шампунь ", 888, 10, UUID.randomUUID()),
                new DiscountedProduct("Стиральный порошок", 780, 15, UUID.randomUUID()),
                new DiscountedProduct("Пена для бритья", 455, 15, UUID.randomUUID()),
                new FixPriceProduct("Хлеб ржаной", UUID.randomUUID()),
                new FixPriceProduct("Хлеб Бородинский", UUID.randomUUID()),
                new FixPriceProduct("Туалетная бумага", UUID.randomUUID()),
                new FixPriceProduct("Батон нарезной 1 кат.", UUID.randomUUID()),
                new FixPriceProduct("Батон нарезной 2 кат.", UUID.randomUUID()),
                new FixPriceProduct("Батон нарезной 3 кат.", UUID.randomUUID()),
        };
        Article[] articles = {
                new Article("Шампунь", "Шампунь Ромашка", UUID.randomUUID()),
                new Article("Конфеты", "Конфеты Cладкоежка", UUID.randomUUID()),
                new Article("Макароны", "Макароны Макфа", UUID.randomUUID()),
                new Article("Пельмени", "Пельмени Рузские", UUID.randomUUID()),
                new Article("Масло", "Масло Вологодское", UUID.randomUUID()),
                new Article("Сосиски", "Сосиски Микояновские", UUID.randomUUID()),
                new Article("Кетчуп", "Кетчуп острый", UUID.randomUUID()),
                new Article("Кетчуп", "Кетчуп острый", UUID.randomUUID()),
                new Article("Кетчуп", "Кетчуп острый", UUID.randomUUID()),
                new Article("Кетчуп", "Кетчуп острый", UUID.randomUUID()),
                new Article("Майонез", "Майонез Провансаль", UUID.randomUUID()),
                new Article("Молоко", "Молоко Рузское", UUID.randomUUID()),
                new Article("Кефир", "Рузский", UUID.randomUUID()),
                new Article("Сметана", "Сметана домашняя", UUID.randomUUID()),
                new Article("Яйца", "Яйца куриные первой категории", UUID.randomUUID()),
                new Article("Мыло", "Мыло Palmolive", UUID.randomUUID()),
                new Article("Хлеб ржаной", "Хлебобулочное изделие", UUID.randomUUID()),
                new Article("Хлеб Бородинский", "Хлебобулочное изделие", UUID.randomUUID()),
                new Article("Батон нарезной 4 кат", "Батон нарезной 4 кат", UUID.randomUUID()),
                new Article("Батон нарезной 4 кат", "Батон нарезной 4 кат", UUID.randomUUID()),
                new Article("Стиральный порошок", "Стиральный порошок Tide", UUID.randomUUID()),
                new Article("Пена для бритья", "Пена для бритья Tide", UUID.randomUUID())
        };
        List<Searchable> testArray = new ArrayList<>();
        Collections.addAll(testArray, products);
        Collections.addAll(testArray, articles);
        return testArray;
    }
    @GetMapping("/products")
    public Collection<Product> getAllProducts(){
       // System.err.println(test());
       return storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticle(){
        return storageService.getAllArticle();
    }
}
