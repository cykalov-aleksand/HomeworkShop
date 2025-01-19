package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StorageService {
    private final Map<UUID, Product> storageProduct;
    private final Map<UUID, Article> storageArticle;

    public StorageService(List<Searchable> test) {
        storageProduct = test.stream().filter(product -> product.getContentType().equals("PRODUCT")).collect(Collectors.toMap(Searchable::getId, product -> (Product) product));
        storageArticle = test.stream().filter(product -> product.getContentType().equals("ARTICLE")).collect(Collectors.toMap(Searchable::getId, product -> (Article) product));
    }

    public Collection<Product> getAllProducts() {

        return storageProduct.values();
    }

    public Collection<Article> getAllArticle() {
        return storageArticle.values();
    }

    public SearchService entireCollection() {
       Set<Searchable> entire = new HashSet<>(storageProduct.values());
        entire.addAll(storageArticle.values());
        return new SearchService(entire);
    }
}