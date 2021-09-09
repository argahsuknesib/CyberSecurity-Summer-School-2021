package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class MapEntryLite<K, V> {
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
            this.keyType = fieldType;
            this.defaultKey = k;
            this.valueType = fieldType2;
            this.defaultValue = v;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        this.metadata = new Metadata<>(fieldType, k, fieldType2, v);
        this.key = k;
        this.value = v;
    }

    private MapEntryLite(Metadata<K, V> metadata2, K k, V v) {
        this.metadata = metadata2;
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new MapEntryLite<>(fieldType, k, fieldType2, v);
    }

    static <K, V> void writeTo(CodedOutputStream codedOutputStream, Metadata<K, V> metadata2, K k, V v) throws IOException {
        FieldSet.writeElement(codedOutputStream, metadata2.keyType, 1, k);
        FieldSet.writeElement(codedOutputStream, metadata2.valueType, 2, v);
    }

    static <K, V> int computeSerializedSize(Metadata<K, V> metadata2, K k, V v) {
        return FieldSet.computeElementSize(metadata2.keyType, 1, k) + FieldSet.computeElementSize(metadata2.valueType, 2, v);
    }

    /* renamed from: com.google.protobuf.MapEntryLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static <T> T parseField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()];
        if (i == 1) {
            MessageLite.Builder builder = ((MessageLite) t).toBuilder();
            codedInputStream.readMessage(builder, extensionRegistryLite);
            return builder.buildPartial();
        } else if (i == 2) {
            return Integer.valueOf(codedInputStream.readEnum());
        } else {
            if (i != 3) {
                return FieldSet.readPrimitiveField(codedInputStream, fieldType, true);
            }
            throw new RuntimeException("Groups are not allowed in maps.");
        }
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i, K k, V v) throws IOException {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeUInt32NoTag(computeSerializedSize(this.metadata, k, v));
        writeTo(codedOutputStream, this.metadata, k, v);
    }

    public int computeMessageSize(int i, K k, V v) {
        return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, k, v));
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseEntry(byteString.newCodedInput(), this.metadata, extensionRegistryLite);
    }

    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream codedInputStream, Metadata<K, V> metadata2, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        K k = metadata2.defaultKey;
        V v = metadata2.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.makeTag(1, metadata2.keyType.getWireType())) {
                k = parseField(codedInputStream, extensionRegistryLite, metadata2.keyType, k);
            } else if (readTag == WireFormat.makeTag(2, metadata2.valueType.getWireType())) {
                v = parseField(codedInputStream, extensionRegistryLite, metadata2.valueType, v);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        K k = this.metadata.defaultKey;
        V v = this.metadata.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) {
                k = parseField(codedInputStream, extensionRegistryLite, this.metadata.keyType, k);
            } else if (readTag == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) {
                v = parseField(codedInputStream, extensionRegistryLite, this.metadata.valueType, v);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(pushLimit);
        mapFieldLite.put(k, v);
    }

    /* access modifiers changed from: package-private */
    public Metadata<K, V> getMetadata() {
        return this.metadata;
    }
}
