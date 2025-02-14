package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


public class SearchServiceTest {

    @Test
    void searchIfThereAreNoObjectsIn_StorageServis_AnEmpty() {
        System.out.println("Поиск в случае отсутствия объектов в StorageService:\n");
        CodeAnalysisSearchServices test = new CodeAnalysisSearchServices("Макароны", null);
        System.out.println(test.test());
    }

    @Test
    void searchIfThereAreObjectsButThereIsNoSuitableOneIn_StorageService() {
        System.out.println("Поиск в случае, если объекты в StorageService есть, но нет подходящего:\n");
        CodeAnalysisSearchServices test = new CodeAnalysisSearchServices("Мыло", test());
        System.out.println(test.test());
    }

    @Test
    void searchWhenThereIsSuitableObjectIn_StorageService() {
        System.out.println("Поиск, когда есть подходящий объект в StorageService:\n");
        CodeAnalysisSearchServices test = new CodeAnalysisSearchServices("Пельмени", test());
        System.out.println(test.test());
    }

    private Map<UUID, Searchable> test() {
        Product[] products = {
                new SimpleProduct(UUID.randomUUID(), "Конфеты", 800),
                new SimpleProduct(UUID.randomUUID(), "Макароны", 80),
                new SimpleProduct(UUID.randomUUID(), "Пельмени", 250),

        };
        Article[] articles = {
                new Article(UUID.randomUUID(), "Конфеты", "Конфеты Cладкоежка"),
                new Article(UUID.randomUUID(), "Макароны", "Макароны Макфа"),
        };
        Map<UUID, Searchable> testArray;
        testArray = stream(articles).collect(Collectors.toMap(Searchable::getId, product -> product));
        testArray.putAll(stream(products).collect(Collectors.toMap(Searchable::getId, product -> product)));
        return testArray;
    }
}
