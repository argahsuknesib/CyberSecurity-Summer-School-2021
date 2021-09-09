package retrofit2;

import _m_j.jdn;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

abstract class ParameterHandler<T> {
    /* access modifiers changed from: package-private */
    public abstract void apply(RequestBuilder requestBuilder, T t) throws IOException;

    ParameterHandler() {
    }

    /* access modifiers changed from: package-private */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            /* class retrofit2.ParameterHandler.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T apply : iterable) {
                        ParameterHandler.this.apply(requestBuilder, apply);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            /* class retrofit2.ParameterHandler.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
                    }
                }
            }
        };
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        RelativeUrl() {
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, Object obj) {
            requestBuilder.setRelativeUrl(obj);
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        Header(String str, Converter<T, String> converter) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addHeader(this.name, this.valueConverter.convert(t));
            }
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Path(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t), this.encoded);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.name + "\" value must not be null.");
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Query(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addQueryParam(this.name, this.valueConverter.convert(t), this.encoded);
            }
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Converter<T, String> valueConverter;

        QueryMap(Converter<T, String> converter, boolean z) {
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addQueryParam(str, this.valueConverter.convert(value), this.encoded);
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, String> valueConverter;

        HeaderMap(Converter<T, String> converter) {
            this.valueConverter = converter;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(str, this.valueConverter.convert(value));
                        } else {
                            throw new IllegalArgumentException("Header map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Field(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addFormField(this.name, this.valueConverter.convert(t), this.encoded);
            }
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Converter<T, String> valueConverter;

        FieldMap(Converter<T, String> converter, boolean z) {
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addFormField(str, this.valueConverter.convert(value), this.encoded);
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Headers headers;

        Part(Headers headers2, Converter<T, RequestBody> converter2) {
            this.headers = headers2;
            this.converter = converter2;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.addPart(this.headers, this.converter.convert(t));
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + ((Object) t) + " to RequestBody", e);
                }
            }
        }
    }

    static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, MultipartBody.Part part) throws IOException {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        PartMap(Converter<T, RequestBody> converter, String str) {
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + str + jdn.f1779O000000o, "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;

        Body(Converter<T, RequestBody> converter2) {
            this.converter = converter2;
        }

        /* access modifiers changed from: package-private */
        public final void apply(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.setBody(this.converter.convert(t));
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + ((Object) t) + " to RequestBody", e);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }
}
