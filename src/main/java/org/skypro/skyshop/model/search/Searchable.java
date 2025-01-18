package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.SearchResult;

import java.util.UUID;

public interface Searchable {
    String getSearchTemp();
    String getContentType();
    String sortingElement();
   // SearchResult fromSearchable(Searchable object);
    UUID getId();
    default String getStringRepresentation() {
        return String.format("%5s%30s%10s%30s", "Имя ", getSearchTemp(), " — тип - ", getContentType());
    }
}