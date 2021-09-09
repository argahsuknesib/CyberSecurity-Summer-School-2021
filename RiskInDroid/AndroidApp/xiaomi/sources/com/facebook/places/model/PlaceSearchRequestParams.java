package com.facebook.places.model;

import java.util.HashSet;
import java.util.Set;

public final class PlaceSearchRequestParams {
    private final Set<String> categories;
    private final int distance;
    private final Set<String> fields;
    private final int limit;
    private final String searchText;

    private PlaceSearchRequestParams(Builder builder) {
        this.categories = new HashSet();
        this.fields = new HashSet();
        this.distance = builder.distance;
        this.limit = builder.limit;
        this.searchText = builder.searchText;
        this.categories.addAll(builder.categories);
        this.fields.addAll(builder.fields);
    }

    public final int getDistance() {
        return this.distance;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getSearchText() {
        return this.searchText;
    }

    public final Set<String> getCategories() {
        return this.categories;
    }

    public final Set<String> getFields() {
        return this.fields;
    }

    public static class Builder {
        public final Set<String> categories = new HashSet();
        public int distance;
        public final Set<String> fields = new HashSet();
        public int limit;
        public String searchText;

        public Builder setDistance(int i) {
            this.distance = i;
            return this;
        }

        public Builder setLimit(int i) {
            this.limit = i;
            return this;
        }

        public Builder setSearchText(String str) {
            this.searchText = str;
            return this;
        }

        public Builder addCategory(String str) {
            this.categories.add(str);
            return this;
        }

        public Builder addField(String str) {
            this.fields.add(str);
            return this;
        }

        public PlaceSearchRequestParams build() {
            return new PlaceSearchRequestParams(this);
        }
    }
}
