package com.squareup.wire;

import _m_j.jax;
import _m_j.jay;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import okio.ByteString;

public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize = 0;
    protected transient int hashCode = 0;
    private final transient ByteString unknownFields;

    public abstract Builder<M, B> newBuilder();

    protected Message(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        if (protoAdapter == null) {
            throw new NullPointerException("adapter == null");
        } else if (byteString != null) {
            this.adapter = protoAdapter;
            this.unknownFields = byteString;
        } else {
            throw new NullPointerException("unknownFields == null");
        }
    }

    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        if (byteString != null) {
            return byteString;
        }
        return ByteString.O00000Oo;
    }

    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    /* access modifiers changed from: protected */
    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(jay jay) throws IOException {
        this.adapter.encode(jay, this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream outputStream) throws IOException {
        this.adapter.encode(outputStream, this);
    }

    public static abstract class Builder<T extends Message<T, B>, B extends Builder<T, B>> {
        jax unknownFieldsBuffer;
        ProtoWriter unknownFieldsWriter;

        public abstract T build();

        public Builder<T, B> addUnknownFields(ByteString byteString) {
            if (byteString.O0000OOo() > 0) {
                if (this.unknownFieldsWriter == null) {
                    this.unknownFieldsBuffer = new jax();
                    this.unknownFieldsWriter = new ProtoWriter(this.unknownFieldsBuffer);
                }
                try {
                    this.unknownFieldsWriter.writeBytes(byteString);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public Builder<T, B> addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
            if (this.unknownFieldsWriter == null) {
                this.unknownFieldsBuffer = new jax();
                this.unknownFieldsWriter = new ProtoWriter(this.unknownFieldsBuffer);
            }
            try {
                fieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public Builder<T, B> clearUnknownFields() {
            this.unknownFieldsWriter = null;
            this.unknownFieldsBuffer = null;
            return this;
        }

        public ByteString buildUnknownFields() {
            jax jax = this.unknownFieldsBuffer;
            return jax != null ? jax.clone().O0000o0o() : ByteString.O00000Oo;
        }
    }
}
