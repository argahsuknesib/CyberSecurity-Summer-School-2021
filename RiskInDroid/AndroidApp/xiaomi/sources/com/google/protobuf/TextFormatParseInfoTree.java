package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> map, Map<Descriptors.FieldDescriptor, List<Builder>> map2) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
        }
        this.locationsFromField = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next2 : map2.entrySet()) {
            ArrayList arrayList = new ArrayList();
            for (Builder build : (List) next2.getValue()) {
                arrayList.add(build.build());
            }
            hashMap2.put(next2.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.subtreesFromField = Collections.unmodifiableMap(hashMap2);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseLocation> list = this.locationsFromField.get(fieldDescriptor);
        return list == null ? Collections.emptyList() : list;
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        return (TextFormatParseLocation) getFromList(getLocations(fieldDescriptor), i, fieldDescriptor);
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseInfoTree> list = this.subtreesFromField.get(fieldDescriptor);
        return list == null ? Collections.emptyList() : list;
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        return (TextFormatParseInfoTree) getFromList(getNestedTrees(fieldDescriptor), i, fieldDescriptor);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static <T> T getFromList(List<T> list, int i, Descriptors.FieldDescriptor fieldDescriptor) {
        String str;
        if (i < list.size() && i >= 0) {
            return list.get(i);
        }
        Object[] objArr = new Object[2];
        if (fieldDescriptor == null) {
            str = "<null>";
        } else {
            str = fieldDescriptor.getName();
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", objArr));
    }

    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        private Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }

        public Builder setLocation(Descriptors.FieldDescriptor fieldDescriptor, TextFormatParseLocation textFormatParseLocation) {
            List list = this.locationsFromField.get(fieldDescriptor);
            if (list == null) {
                list = new ArrayList();
                this.locationsFromField.put(fieldDescriptor, list);
            }
            list.add(textFormatParseLocation);
            return this;
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor fieldDescriptor) {
            List list = this.subtreeBuildersFromField.get(fieldDescriptor);
            if (list == null) {
                list = new ArrayList();
                this.subtreeBuildersFromField.put(fieldDescriptor, list);
            }
            Builder builder = new Builder();
            list.add(builder);
            return builder;
        }

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField);
        }
    }
}
