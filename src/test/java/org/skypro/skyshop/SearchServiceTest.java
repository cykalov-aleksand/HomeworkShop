package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Test
    void searchIfThereAreNoObjectsIn_StorageServis_AnEmpty() {
        String stringStates;
        System.out.println("Поиск в случае отсутствия объектов в StorageService:\n");
        CodeAnalysisSearchServices test = new CodeAnalysisSearchServices("Макароны", null);
        stringStates=test.test();
        System.out.println(stringStates);
       // boolean equals = stringStates.equals("Тестовые значения в StorageService не введены");
        assertEquals("Тестовые значения в StorageService не введены",stringStates);

    }

    @Test
    void searchIfThereAreObjectsButThereIsNoSuitableOneIn_StorageService() {
        String stringStates;
        System.out.println("Поиск в случае, если объекты в StorageService есть, но нет подходящего:\n");
        CodeAnalysisSearchServices test = new CodeAnalysisSearchServices("Мыло", test());
        stringStates=test.test();
        System.out.println(stringStates);
        assertEquals("[]",stringStates);
    }

    @Test
    void searchWhenThereIsSuitableObjectIn_StorageService() {
        String stringStates;
        String stringCheck="Пельмени";
        System.out.println("Поиск, когда есть подходящий объект в StorageService:\n");
        CodeAnalysisSearchServices test = new CodeAnalysisSearchServices(stringCheck, test());
        stringStates=test.test();
        System.out.println( stringStates);
        assertTrue(stringStates.contains(stringCheck));


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
