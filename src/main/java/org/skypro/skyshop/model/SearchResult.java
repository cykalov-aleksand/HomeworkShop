package org.skypro.skyshop.model;

import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class SearchResult {
    private final UUID id;
    private final String nameProduct;
    private final String contentType;

    public SearchResult(UUID id, String nameProduct, String contentType) {
        this.nameProduct = nameProduct;
        this.id = id;
        this.contentType = contentType;
    }

    static public SearchResult fromSearchable(Searchable object) {
        UUID id = object.getId();
        String nameProduct = object.getSearchTemp();
        String contentType = object.getContentType();
        return new SearchResult(id, nameProduct, contentType);
    }


    @Override
    public String toString() {
        return String.format("%6s%20s%15s%25s%15s%15s%2s","id=",id.toString()," nameProduct=",nameProduct,"contentType='",contentType,"\n");
    }
}
