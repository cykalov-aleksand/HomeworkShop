package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceTest {

    @Test
    void searchIfThereAreNoObjectsIn_StorageServis_AnEmpty() {
        System.out.println("Поиск в случае отсутствия объектов в StorageService.\n");
        assertThrows(NullPointerException.class, () -> new SearchService(null).search("Мыло"));

    }

    @Test
    void searchIfThereAreObjectsButThereIsNoSuitableOneIn_StorageService() {
        System.out.println("Поиск в случае, если объекты в StorageService есть, но нет подходящего.\n");
        assertEquals("[]", new SearchService(test()).search("Мыло").toString());
    }

    @Test
    void searchWhenThereIsSuitableObjectIn_StorageService() {
        String stringCheck = "Пельмени";
        System.out.println("Поиск, когда есть подходящий объект в StorageService.\n");
        assertTrue(new SearchService(test()).search("Пельмени").toString().contains(stringCheck));
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
