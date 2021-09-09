package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<M> messageClass;

    public MessageSerializedForm(byte[] bArr, Class<M> cls) {
        this.bytes = bArr;
        this.messageClass = cls;
    }

    /* access modifiers changed from: package-private */
    public final Object readResolve() throws ObjectStreamException {
        try {
            return ProtoAdapter.get(this.messageClass).decode(this.bytes);
        } catch (IOException e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
