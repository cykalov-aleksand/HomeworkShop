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

   public StorageService(List<Searchable>test) {
     storageProduct = test.stream().filter(p->p.getContentType().equals("PRODUCT")).collect(Collectors.toMap(Searchable::getId, o-> (Product) o));
      storageArticle = test.stream().filter(p->p.getContentType().equals("ARTICLE")).collect(Collectors.toMap(Searchable::getId, o->(Article)o));
 }
    public Collection<Product> getAllProducts() {

        return storageProduct.values();
    }

    public Collection<Article> getAllArticle() {
        return storageArticle.values();
    }
    public Collection<Searchable> entireCollection(){
        List entire=new ArrayList();
        Collections.addAll(entire, storageProduct);
        Collections.addAll(entire,storageArticle);
        return entire;
    }
   }