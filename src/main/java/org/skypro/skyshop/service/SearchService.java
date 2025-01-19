package org.skypro.skyshop.service;

import org.skypro.skyshop.model.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {
    private final Set<Searchable> searchService;

    public SearchService(Set<Searchable> storageService) {
        this.searchService = storageService;
    }

    public List<SearchResult> search(String query) {
        List<Searchable> collect = searchService.stream().filter(Objects::nonNull).filter(o -> o.sortingElement().equalsIgnoreCase(query.trim()))
                .toList();
        List<SearchResult> variant = new ArrayList<>();
        for (Searchable variable : collect) {
            variant.add(SearchResult.fromSearchable(variable));
        }
        return variant;
    }
}

