package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private String titleAtribute;
    private String textAtribute;
    private final UUID id;

    public Article(String titleAtribute, String textAtribute,UUID id) {
        this.titleAtribute = titleAtribute.trim();
        this.textAtribute = textAtribute;
        this.id=id;
    }

    public String sortingElement() {
        return titleAtribute;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return (String.format("%27s\n%35s", titleAtribute, textAtribute));
    }

    @JsonIgnore
    @Override
    public String getSearchTemp() {
        return (String.format("%27s\n%35s", titleAtribute, textAtribute));
    }
    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return Objects.equals(titleAtribute, article.titleAtribute);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleAtribute);
    }
}

