package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class RuntimeEnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> type;

    RuntimeEnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
        this.type = cls;
    }

    private Method getFromValueMethod() {
        Method method = this.fromValueMethod;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.type.getMethod("fromValue", Integer.TYPE);
            this.fromValueMethod = method2;
            return method2;
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public final int encodedSize(E e) {
        return ProtoWriter.varint32Size(e.getValue());
    }

    public final void encode(ProtoWriter protoWriter, E e) throws IOException {
        protoWriter.writeVarint32(e.getValue());
    }

    public final E decode(ProtoReader protoReader) throws IOException {
        int readVarint32 = protoReader.readVarint32();
        try {
            E e = (WireEnum) getFromValueMethod().invoke(null, Integer.valueOf(readVarint32));
            if (e != null) {
                return e;
            }
            throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, this.type);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && ((RuntimeEnumAdapter) obj).type == this.type;
    }

    public final int hashCode() {
        return this.type.hashCode();
    }
}
