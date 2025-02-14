package org.skypro.skyshop;

import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;

import java.util.*;

import static java.util.Optional.ofNullable;

public class CodeAnalysisSearchServices {
    String nameProduct;
    Map<UUID, Searchable>  listProduct;

    public CodeAnalysisSearchServices(String nameProduct, Map<UUID, Searchable> listProduct) {
        this.nameProduct = nameProduct;
        this.listProduct = listProduct;
    }

    String test() {
        Optional<Map<UUID, Searchable>> safeNull = ofNullable(listProduct);
        Optional<String> optional;
        optional = safeNull.map(product -> new SearchService(listProduct).search(nameProduct)
                .toString()).orElse("Тестовые значения в StorageService не введены").describeConstable();
        String outputString = "";
        if (optional.isPresent()) {
            outputString = optional.get();
        }
        return outputString;
    }
}

