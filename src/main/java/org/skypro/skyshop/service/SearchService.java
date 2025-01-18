package org.skypro.skyshop.service;

import org.springframework.stereotype.Service;

//@Service
public class SearchService {
    private final SearchService storageService;

    public SearchService(SearchService storageService) {
        this.storageService = storageService;
    }
}
