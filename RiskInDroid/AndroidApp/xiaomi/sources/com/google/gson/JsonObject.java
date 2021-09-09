package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>();

    public final JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry next : this.members.entrySet()) {
            jsonObject.add((String) next.getKey(), ((JsonElement) next.getValue()).deepCopy());
        }
        return jsonObject;
    }

    public final void add(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.members.put(str, jsonElement);
    }

    public final JsonElement remove(String str) {
        return this.members.remove(str);
    }

    public final void addProperty(String str, String str2) {
        add(str, createJsonElement(str2));
    }

    public final void addProperty(String str, Number number) {
        add(str, createJsonElement(number));
    }

    public final void addProperty(String str, Boolean bool) {
        add(str, createJsonElement(bool));
    }

    public final void addProperty(String str, Character ch) {
        add(str, createJsonElement(ch));
    }

    private JsonElement createJsonElement(Object obj) {
        return obj == null ? JsonNull.INSTANCE : new JsonPrimitive(obj);
    }

    public final Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public final Set<String> keySet() {
        return this.members.keySet();
    }

    public final int size() {
        return this.members.size();
    }

    public final boolean has(String str) {
        return this.members.containsKey(str);
    }

    public final JsonElement get(String str) {
        return this.members.get(str);
    }

    public final JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.members.get(str);
    }

    public final JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.members.get(str);
    }

    public final JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members);
        }
        return true;
    }

    public final int hashCode() {
        return this.members.hashCode();
    }
}
