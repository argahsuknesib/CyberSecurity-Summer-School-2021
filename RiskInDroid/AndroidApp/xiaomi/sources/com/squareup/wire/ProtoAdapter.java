package com.squareup.wire;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jbg;
import com.squareup.wire.Message;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = new ProtoAdapter<Boolean>(FieldEncoding.VARINT, Boolean.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass1 */

        public final int encodedSize(Boolean bool) {
            return 1;
        }

        public final void encode(ProtoWriter protoWriter, Boolean bool) throws IOException {
            protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
        }

        public final Boolean decode(ProtoReader protoReader) throws IOException {
            int readVarint32 = protoReader.readVarint32();
            if (readVarint32 == 0) {
                return Boolean.FALSE;
            }
            if (readVarint32 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(readVarint32)));
        }
    };
    public static final ProtoAdapter<ByteString> BYTES = new ProtoAdapter<ByteString>(FieldEncoding.LENGTH_DELIMITED, ByteString.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass13 */

        public final int encodedSize(ByteString byteString) {
            return byteString.O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ByteString byteString) throws IOException {
            protoWriter.writeBytes(byteString);
        }

        public final ByteString decode(ProtoReader protoReader) throws IOException {
            return protoReader.readBytes();
        }
    };
    public static final ProtoAdapter<Double> DOUBLE = new ProtoAdapter<Double>(FieldEncoding.FIXED64, Double.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass11 */

        public final int encodedSize(Double d) {
            return 8;
        }

        public final void encode(ProtoWriter protoWriter, Double d) throws IOException {
            protoWriter.writeFixed64(Double.doubleToLongBits(d.doubleValue()));
        }

        public final Double decode(ProtoReader protoReader) throws IOException {
            return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
        }
    };
    public static final ProtoAdapter<Integer> FIXED32;
    public static final ProtoAdapter<Long> FIXED64;
    public static final ProtoAdapter<Float> FLOAT = new ProtoAdapter<Float>(FieldEncoding.FIXED32, Float.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass10 */

        public final int encodedSize(Float f) {
            return 4;
        }

        public final void encode(ProtoWriter protoWriter, Float f) throws IOException {
            protoWriter.writeFixed32(Float.floatToIntBits(f.floatValue()));
        }

        public final Float decode(ProtoReader protoReader) throws IOException {
            return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
        }
    };
    public static final ProtoAdapter<Integer> INT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass2 */

        public final int encodedSize(Integer num) {
            return ProtoWriter.int32Size(num.intValue());
        }

        public final void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeSignedVarint32(num.intValue());
        }

        public final Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final ProtoAdapter<Long> INT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass6 */

        public final int encodedSize(Long l) {
            return ProtoWriter.varint64Size(l.longValue());
        }

        public final void encode(ProtoWriter protoWriter, Long l) throws IOException {
            protoWriter.writeVarint64(l.longValue());
        }

        public final Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readVarint64());
        }
    };
    public static final ProtoAdapter<Integer> SFIXED32;
    public static final ProtoAdapter<Long> SFIXED64;
    public static final ProtoAdapter<Integer> SINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass4 */

        public final int encodedSize(Integer num) {
            return ProtoWriter.varint32Size(ProtoWriter.encodeZigZag32(num.intValue()));
        }

        public final void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeVarint32(ProtoWriter.encodeZigZag32(num.intValue()));
        }

        public final Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(ProtoWriter.decodeZigZag32(protoReader.readVarint32()));
        }
    };
    public static final ProtoAdapter<Long> SINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass8 */

        public final int encodedSize(Long l) {
            return ProtoWriter.varint64Size(ProtoWriter.encodeZigZag64(l.longValue()));
        }

        public final void encode(ProtoWriter protoWriter, Long l) throws IOException {
            protoWriter.writeVarint64(ProtoWriter.encodeZigZag64(l.longValue()));
        }

        public final Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(ProtoWriter.decodeZigZag64(protoReader.readVarint64()));
        }
    };
    public static final ProtoAdapter<String> STRING = new ProtoAdapter<String>(FieldEncoding.LENGTH_DELIMITED, String.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass12 */

        public final int encodedSize(String str) {
            return ProtoWriter.utf8Length(str);
        }

        public final void encode(ProtoWriter protoWriter, String str) throws IOException {
            protoWriter.writeString(str);
        }

        public final String decode(ProtoReader protoReader) throws IOException {
            return protoReader.readString();
        }
    };
    public static final ProtoAdapter<Integer> UINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass3 */

        public final int encodedSize(Integer num) {
            return ProtoWriter.varint32Size(num.intValue());
        }

        public final void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeVarint32(num.intValue());
        }

        public final Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final ProtoAdapter<Long> UINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) {
        /* class com.squareup.wire.ProtoAdapter.AnonymousClass7 */

        public final int encodedSize(Long l) {
            return ProtoWriter.varint64Size(l.longValue());
        }

        public final void encode(ProtoWriter protoWriter, Long l) throws IOException {
            protoWriter.writeVarint64(l.longValue());
        }

        public final Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readVarint64());
        }
    };
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    public abstract E decode(ProtoReader protoReader) throws IOException;

    public abstract void encode(ProtoWriter protoWriter, Object obj) throws IOException;

    public abstract int encodedSize(Object obj);

    public E redact(Object obj) {
        return null;
    }

    public ProtoAdapter(FieldEncoding fieldEncoding2, Class<?> cls) {
        this.fieldEncoding = fieldEncoding2;
        this.javaType = cls;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return RuntimeMessageAdapter.create(cls);
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return new RuntimeEnumAdapter<>(cls);
    }

    public static <M extends Message> ProtoAdapter<M> get(M m) {
        return get(m.getClass());
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e);
        }
    }

    static ProtoAdapter<?> get(String str) {
        try {
            int indexOf = str.indexOf(35);
            String substring = str.substring(0, indexOf);
            return (ProtoAdapter) Class.forName(substring).getField(str.substring(indexOf + 1)).get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("failed to access ".concat(String.valueOf(str)), e);
        }
    }

    public int encodedSizeWithTag(int i, E e) {
        int encodedSize = encodedSize(e);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.varint32Size(encodedSize);
        }
        return encodedSize + ProtoWriter.tagSize(i);
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, E e) throws IOException {
        protoWriter.writeTag(i, this.fieldEncoding);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(encodedSize(e));
        }
        encode(protoWriter, e);
    }

    public final void encode(jay jay, Object obj) throws IOException {
        Preconditions.checkNotNull(obj, "value == null");
        Preconditions.checkNotNull(jay, "sink == null");
        encode(new ProtoWriter(jay), obj);
    }

    public final byte[] encode(E e) {
        Preconditions.checkNotNull(e, "value == null");
        jax jax = new jax();
        try {
            encode(jax, e);
            return jax.O0000oOO();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void encode(OutputStream outputStream, Object obj) throws IOException {
        Preconditions.checkNotNull(obj, "value == null");
        Preconditions.checkNotNull(outputStream, "stream == null");
        jay O000000o2 = jbg.O000000o(jbg.O000000o(outputStream));
        encode(O000000o2, obj);
        O000000o2.O00000o0();
    }

    public final E decode(byte[] bArr) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes == null");
        return decode(new jax().O00000o0(bArr));
    }

    public final E decode(ByteString byteString) throws IOException {
        Preconditions.checkNotNull(byteString, "bytes == null");
        return decode(new jax().O00000o0(byteString));
    }

    public final E decode(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream, "stream == null");
        return decode(jbg.O000000o(jbg.O000000o(inputStream)));
    }

    public final E decode(jaz jaz) throws IOException {
        Preconditions.checkNotNull(jaz, "source == null");
        return decode(new ProtoReader(jaz));
    }

    public String toString(E e) {
        return e.toString();
    }

    static {
        AnonymousClass5 r0 = new ProtoAdapter<Integer>(FieldEncoding.FIXED32, Integer.class) {
            /* class com.squareup.wire.ProtoAdapter.AnonymousClass5 */

            public final int encodedSize(Integer num) {
                return 4;
            }

            public final void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeFixed32(num.intValue());
            }

            public final Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(protoReader.readFixed32());
            }
        };
        FIXED32 = r0;
        SFIXED32 = r0;
        AnonymousClass9 r02 = new ProtoAdapter<Long>(FieldEncoding.FIXED64, Long.class) {
            /* class com.squareup.wire.ProtoAdapter.AnonymousClass9 */

            public final int encodedSize(Long l) {
                return 8;
            }

            public final void encode(ProtoWriter protoWriter, Long l) throws IOException {
                protoWriter.writeFixed64(l.longValue());
            }

            public final Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(protoReader.readFixed64());
            }
        };
        FIXED64 = r02;
        SFIXED64 = r02;
    }

    /* access modifiers changed from: package-private */
    public ProtoAdapter<?> withLabel(WireField.Label label) {
        if (!label.isRepeated()) {
            return this;
        }
        if (label.isPacked()) {
            return asPacked();
        }
        return asRepeated();
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createPacked = createPacked();
        this.packedAdapter = createPacked;
        return createPacked;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createRepeated = createRepeated();
        this.repeatedAdapter = createRepeated;
        return createRepeated;
    }

    private ProtoAdapter<List<E>> createPacked() {
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) {
            return new ProtoAdapter<List<E>>(FieldEncoding.LENGTH_DELIMITED, List.class) {
                /* class com.squareup.wire.ProtoAdapter.AnonymousClass14 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.squareup.wire.ProtoAdapter.encodeWithTag(com.squareup.wire.ProtoWriter, int, java.lang.Object):void
                 arg types: [com.squareup.wire.ProtoWriter, int, java.util.List<E>]
                 candidates:
                  com.squareup.wire.ProtoAdapter.14.encodeWithTag(com.squareup.wire.ProtoWriter, int, java.util.List):void
                  com.squareup.wire.ProtoAdapter.encodeWithTag(com.squareup.wire.ProtoWriter, int, java.lang.Object):void */
                public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) throws IOException {
                    if (!list.isEmpty()) {
                        ProtoAdapter.super.encodeWithTag(protoWriter, i, (Object) list);
                    }
                }

                public int encodedSize(List<E> list) {
                    int size = list.size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        i += ProtoAdapter.this.encodedSize(list.get(i2));
                    }
                    return i;
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.squareup.wire.ProtoAdapter.encodedSizeWithTag(int, java.lang.Object):int
                 arg types: [int, java.util.List<E>]
                 candidates:
                  com.squareup.wire.ProtoAdapter.14.encodedSizeWithTag(int, java.util.List):int
                  com.squareup.wire.ProtoAdapter.encodedSizeWithTag(int, java.lang.Object):int */
                public int encodedSizeWithTag(int i, List<E> list) {
                    if (list.isEmpty()) {
                        return 0;
                    }
                    return ProtoAdapter.super.encodedSizeWithTag(i, (Object) list);
                }

                public void encode(ProtoWriter protoWriter, List<E> list) throws IOException {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ProtoAdapter.this.encode(protoWriter, list.get(i));
                    }
                }

                public List<E> decode(ProtoReader protoReader) throws IOException {
                    return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
                }

                public List<E> redact(List<E> list) {
                    return Collections.emptyList();
                }
            };
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        return new ProtoAdapter<List<E>>(this.fieldEncoding, List.class) {
            /* class com.squareup.wire.ProtoAdapter.AnonymousClass15 */

            public int encodedSize(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            public int encodedSizeWithTag(int i, List<E> list) {
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += ProtoAdapter.this.encodedSizeWithTag(i, list.get(i3));
                }
                return i2;
            }

            public void encode(ProtoWriter protoWriter, List<E> list) throws IOException {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) throws IOException {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ProtoAdapter.this.encodeWithTag(protoWriter, i, list.get(i2));
                }
            }

            public List<E> decode(ProtoReader protoReader) throws IOException {
                return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
            }

            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        EnumConstantNotFoundException(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.value = i;
        }
    }
}
