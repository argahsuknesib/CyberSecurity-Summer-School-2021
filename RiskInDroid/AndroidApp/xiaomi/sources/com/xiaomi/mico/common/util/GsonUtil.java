package com.xiaomi.mico.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class GsonUtil {
    private static final TypeAdapter<Boolean> INT_AS_BOOLEAN_TYPE_ADAPTER = new AbstractReadOnlyJsonTypeAdapter<Boolean>() {
        /* class com.xiaomi.mico.common.util.GsonUtil.AnonymousClass1 */

        public final Boolean read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            int i = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
            boolean z = true;
            if (i == 1) {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            if (i == 2) {
                jsonReader.nextNull();
                return null;
            } else if (i == 3) {
                if (jsonReader.nextInt() == 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else if (i == 4) {
                String nextString = jsonReader.nextString();
                if (ContainerUtil.isEmpty(nextString) || "0".equals(nextString)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else {
                throw new IllegalStateException("Expected BOOLEAN or NUMBER but was ".concat(String.valueOf(peek)));
            }
        }
    };
    private static final Gson INT_AS_BOOL_PARSER = new GsonBuilder().registerTypeAdapter(Boolean.TYPE, INT_AS_BOOLEAN_TYPE_ADAPTER).create();

    static class GsonHolder {
        public static final Gson EXPOSE_INSTANCE = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        public static final Gson INSTANCE = new Gson();

        private GsonHolder() {
        }
    }

    public static Gson getGsonInstance() {
        return GsonHolder.INSTANCE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
     arg types: [java.lang.String, java.lang.Class<T>]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T */
    public static <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return getGsonInstance().fromJson(str, (Class) cls);
    }

    public static String toJson(Object obj) {
        return getGsonInstance().toJson(obj);
    }

    public static Gson getExposeInstance() {
        return GsonHolder.EXPOSE_INSTANCE;
    }

    /* renamed from: com.xiaomi.mico.common.util.GsonUtil$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 1;
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 2;
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 3;
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static Gson getIntAsBoolGson() {
        return INT_AS_BOOL_PARSER;
    }

    static abstract class AbstractReadOnlyJsonTypeAdapter<T> extends TypeAdapter<T> {
        public void write(JsonWriter jsonWriter, T t) throws IOException {
        }

        private AbstractReadOnlyJsonTypeAdapter() {
        }
    }
}
