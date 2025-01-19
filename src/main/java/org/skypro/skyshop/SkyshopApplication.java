package org.skypro.skyshop;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@SpringBootApplication
public class SkyshopApplication {
    public static List<Searchable> test() {
        Product[] products = {
                new SimpleProduct(UUID.randomUUID(),"Конфеты", 800),
                new SimpleProduct(UUID.randomUUID(),"Макароны", 80),
                new SimpleProduct(UUID.randomUUID(),"Пельмени", 350),
                new SimpleProduct(UUID.randomUUID(),"Масло", 120),
                new SimpleProduct(UUID.randomUUID(),"Сосиски", 150),
                new SimpleProduct(UUID.randomUUID(),"Кетчуп", 120),
                new SimpleProduct(UUID.randomUUID(),"Майонез", 77),
                new SimpleProduct(UUID.randomUUID(),"Молоко", 80),
                new SimpleProduct(UUID.randomUUID(),"Кефир", 80),
                new SimpleProduct(UUID.randomUUID(),"Сметана", 210),
                new SimpleProduct(UUID.randomUUID(),"Яйца", 100),
                new DiscountedProduct(UUID.randomUUID(),"Мыло", 23, 10),
                new DiscountedProduct(UUID.randomUUID(),"Шампунь ", 888, 10),
                new DiscountedProduct(UUID.randomUUID(),"Стиральный порошок", 780, 15),
                new DiscountedProduct(UUID.randomUUID(),"Пена для бритья", 455, 15),
                new FixPriceProduct(UUID.randomUUID(),"Хлеб ржаной"),
                new FixPriceProduct(UUID.randomUUID(),"Хлеб Бородинский"),
                new FixPriceProduct(UUID.randomUUID(),"Туалетная бумага"),
                new FixPriceProduct(UUID.randomUUID(),"Батон нарезной 2 кат."),
                new FixPriceProduct(UUID.randomUUID(),"Батон нарезной 1 кат."),
                new FixPriceProduct(UUID.randomUUID(),"Батон нарезной 3 кат.")
        };
        Article[] articles = {
                new Article(UUID.randomUUID(),"Шампунь", "Шампунь Ромашка"),
                new Article(UUID.randomUUID(),"Конфеты", "Конфеты Cладкоежка"),
                new Article(UUID.randomUUID(),"Макароны", "Макароны Макфа"),
                new Article(UUID.randomUUID(),"Пельмени", "Пельмени Рузские"),
                new Article(UUID.randomUUID(),"Масло", "Масло Вологодское"),
                new Article(UUID.randomUUID(),"Сосиски", "Сосиски Микояновские"),
                new Article(UUID.randomUUID(),"Кетчуп", "Кетчуп острый"),
                new Article(UUID.randomUUID(),"Кетчуп", "Кетчуп острый"),
                new Article(UUID.randomUUID(),"Кетчуп", "Кетчуп острый"),
                new Article(UUID.randomUUID(),"Кетчуп", "Кетчуп острый"),
                new Article(UUID.randomUUID(),"Майонез", "Майонез Провансаль"),
                new Article(UUID.randomUUID(),"Молоко", "Молоко Рузское"),
                new Article(UUID.randomUUID(),"Сметана", "Сметана домашняя"),
                new Article(UUID.randomUUID(),"Яйца", "Яйца куриные первой категории"),
                new Article(UUID.randomUUID(),"Мыло", "Мыло Palmolive"),
                new Article(UUID.randomUUID(),"Хлеб ржаной", "Хлебобулочное изделие"),
                new Article(UUID.randomUUID(),"Хлеб Бородинский", "Хлебобулочное изделие"),
                new Article(UUID.randomUUID(),"Батон нарезной 4 кат", "Батон нарезной 4 кат"),
                new Article(UUID.randomUUID(),"Батон нарезной 4 кат", "Батон нарезной 4 кат"),
                new Article(UUID.randomUUID(),"Стиральный порошок", "Стиральный порошок Tide"),
                new Article(UUID.randomUUID(),"Пена для бритья", "Пена для бритья Tide")
        };
        List<Searchable> testArray = new ArrayList<>();
        Collections.addAll(testArray, articles);
        Collections.addAll(testArray, products);
        return testArray;
    }

    public static void main(String[] args) {
        SpringApplication.run(SkyshopApplication.class, args);
    }

}
