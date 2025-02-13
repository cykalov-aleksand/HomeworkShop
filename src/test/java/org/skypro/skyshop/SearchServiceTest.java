package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.SearchResult;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    StorageService storageService;
    @InjectMocks
    private SearchService searchService;

    @Test
    void searchIfThereAreNoObjectsIn_StorageServis_AnEmpty() {
        Map<UUID, Product> product = new HashMap<>();
        Map<UUID, Searchable> entireCollectionProduct = new HashMap<>(product);
        when(storageService.entireCollection()).thenReturn(entireCollectionProduct);
        searchService = new SearchService(storageService.entireCollection());
        List<SearchResult> productEtalon = List.of();
        List<SearchResult> results = searchService.search("Test");
        assertEquals(productEtalon.toString(), results.toString());
    }

    @Test
    void searchIfThereAreObjectsButThereIsNoSuitableOneIn_StorageService() {
        UUID idProduct = UUID.randomUUID();
        Map<UUID, Product> product = new HashMap<>();
        product.put(idProduct, new SimpleProduct(idProduct, "Рыба", 800));
        Map<UUID, Searchable> entireCollectionProduct = new HashMap<>(product);
        when(storageService.entireCollection()).thenReturn(entireCollectionProduct);
        searchService = new SearchService(storageService.entireCollection());
        List<SearchResult> productEtalon = List.of(new SearchResult(idProduct, "Test", "PRODUCT"));
        List<SearchResult> results = searchService.search("Test");
        assertNotEquals(productEtalon.toString(), results.toString());
    }

    @Test
    void searchWhenThereIsSuitableObjectIn_StorageService() {
        UUID idProduct = UUID.randomUUID();
        Map<UUID, Product> product = new HashMap<>();
        product.put(idProduct, new SimpleProduct(idProduct, "Test", 800));
        Map<UUID, Searchable> entireCollectionProduct = new HashMap<>(product);
        when(storageService.entireCollection()).thenReturn(entireCollectionProduct);
        searchService = new SearchService(storageService.entireCollection());
        List<SearchResult> productEtalon = List.of(new SearchResult(idProduct, "Test", "PRODUCT"));
        List<SearchResult> results = searchService.search("Test");
        assertEquals(productEtalon.toString(), results.toString());
    }
}
