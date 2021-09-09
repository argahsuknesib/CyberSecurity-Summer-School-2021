package com.mi.global.shop.model.user;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class GetIndex extends Message<GetIndex, Builder> {
    public static final ProtoAdapter<GetIndex> ADAPTER = new ProtoAdapter_GetIndex();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.user.MessageContent#ADAPTER", tag = 5)
    public final MessageContent data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public GetIndex(Integer num, String str, MessageContent messageContent) {
        this(num, str, messageContent, ByteString.O00000Oo);
    }

    public GetIndex(Integer num, String str, MessageContent messageContent, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = messageContent;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errno = this.errno;
        builder.errmsg = this.errmsg;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetIndex)) {
            return false;
        }
        GetIndex getIndex = (GetIndex) obj;
        return Internal.equals(unknownFields(), getIndex.unknownFields()) && Internal.equals(this.errno, getIndex.errno) && Internal.equals(this.errmsg, getIndex.errmsg) && Internal.equals(this.data, getIndex.data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.errmsg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        MessageContent messageContent = this.data;
        if (messageContent != null) {
            i2 = messageContent.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.errno != null) {
            sb.append(", errno=");
            sb.append(this.errno);
        }
        if (this.errmsg != null) {
            sb.append(", errmsg=");
            sb.append(this.errmsg);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "GetIndex{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<GetIndex, Builder> {
        public MessageContent data;
        public String errmsg;
        public Integer errno;

        public final Builder errno(Integer num) {
            this.errno = num;
            return this;
        }

        public final Builder errmsg(String str) {
            this.errmsg = str;
            return this;
        }

        public final Builder data(MessageContent messageContent) {
            this.data = messageContent;
            return this;
        }

        public final GetIndex build() {
            return new GetIndex(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_GetIndex extends ProtoAdapter<GetIndex> {
        ProtoAdapter_GetIndex() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIndex.class);
        }

        public final int encodedSize(GetIndex getIndex) {
            int i = 0;
            int encodedSizeWithTag = (getIndex.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, getIndex.errno) : 0) + (getIndex.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, getIndex.errmsg) : 0);
            if (getIndex.data != null) {
                i = MessageContent.ADAPTER.encodedSizeWithTag(5, getIndex.data);
            }
            return encodedSizeWithTag + i + getIndex.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, GetIndex getIndex) throws IOException {
            if (getIndex.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, getIndex.errno);
            }
            if (getIndex.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, getIndex.errmsg);
            }
            if (getIndex.data != null) {
                MessageContent.ADAPTER.encodeWithTag(protoWriter, 5, getIndex.data);
            }
            protoWriter.writeBytes(getIndex.unknownFields());
        }

        public final GetIndex decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(MessageContent.ADAPTER.decode(protoReader));
                }
            }
        }

        public final GetIndex redact(GetIndex getIndex) {
            Builder newBuilder = getIndex.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = MessageContent.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
