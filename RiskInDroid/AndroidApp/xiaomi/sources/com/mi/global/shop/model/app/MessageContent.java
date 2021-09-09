package com.mi.global.shop.model.app;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class MessageContent extends Message<MessageContent, Builder> {
    public static final ProtoAdapter<MessageContent> ADAPTER = new ProtoAdapter_MessageContent();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String content;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String url;

    public MessageContent(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.O00000Oo);
    }

    public MessageContent(String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.type = str;
        this.content = str2;
        this.url = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.content = this.content;
        builder.url = this.url;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessageContent)) {
            return false;
        }
        MessageContent messageContent = (MessageContent) obj;
        return Internal.equals(unknownFields(), messageContent.unknownFields()) && Internal.equals(this.type, messageContent.type) && Internal.equals(this.content, messageContent.content) && Internal.equals(this.url, messageContent.url);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.type;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.content;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.url;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.content != null) {
            sb.append(", content=");
            sb.append(this.content);
        }
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        StringBuilder replace = sb.replace(0, 2, "MessageContent{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<MessageContent, Builder> {
        public String content;
        public String type;
        public String url;

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder content(String str) {
            this.content = str;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final MessageContent build() {
            return new MessageContent(this.type, this.content, this.url, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_MessageContent extends ProtoAdapter<MessageContent> {
        ProtoAdapter_MessageContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageContent.class);
        }

        public final int encodedSize(MessageContent messageContent) {
            int i = 0;
            int encodedSizeWithTag = (messageContent.type != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, messageContent.type) : 0) + (messageContent.content != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, messageContent.content) : 0);
            if (messageContent.url != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, messageContent.url);
            }
            return encodedSizeWithTag + i + messageContent.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, MessageContent messageContent) throws IOException {
            if (messageContent.type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, messageContent.type);
            }
            if (messageContent.content != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, messageContent.content);
            }
            if (messageContent.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, messageContent.url);
            }
            protoWriter.writeBytes(messageContent.unknownFields());
        }

        public final MessageContent decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.type(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.content(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.url(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final MessageContent redact(MessageContent messageContent) {
            Builder newBuilder = messageContent.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
