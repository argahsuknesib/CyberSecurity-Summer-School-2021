package com.mi.global.shop.model.basestruct;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class PageMessage extends Message<PageMessage, Builder> {
    public static final ProtoAdapter<PageMessage> ADAPTER = new ProtoAdapter_PageMessage();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String icon;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String pagemsg;

    public PageMessage(String str, String str2) {
        this(str, str2, ByteString.O00000Oo);
    }

    public PageMessage(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.pagemsg = str;
        this.icon = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.pagemsg = this.pagemsg;
        builder.icon = this.icon;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PageMessage)) {
            return false;
        }
        PageMessage pageMessage = (PageMessage) obj;
        return Internal.equals(unknownFields(), pageMessage.unknownFields()) && Internal.equals(this.pagemsg, pageMessage.pagemsg) && Internal.equals(this.icon, pageMessage.icon);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.pagemsg;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.icon;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.pagemsg != null) {
            sb.append(", pagemsg=");
            sb.append(this.pagemsg);
        }
        if (this.icon != null) {
            sb.append(", icon=");
            sb.append(this.icon);
        }
        StringBuilder replace = sb.replace(0, 2, "PageMessage{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PageMessage, Builder> {
        public String icon;
        public String pagemsg;

        public final Builder pagemsg(String str) {
            this.pagemsg = str;
            return this;
        }

        public final Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public final PageMessage build() {
            return new PageMessage(this.pagemsg, this.icon, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PageMessage extends ProtoAdapter<PageMessage> {
        ProtoAdapter_PageMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, PageMessage.class);
        }

        public final int encodedSize(PageMessage pageMessage) {
            int i = 0;
            int encodedSizeWithTag = pageMessage.pagemsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, pageMessage.pagemsg) : 0;
            if (pageMessage.icon != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, pageMessage.icon);
            }
            return encodedSizeWithTag + i + pageMessage.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PageMessage pageMessage) throws IOException {
            if (pageMessage.pagemsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, pageMessage.pagemsg);
            }
            if (pageMessage.icon != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, pageMessage.icon);
            }
            protoWriter.writeBytes(pageMessage.unknownFields());
        }

        public final PageMessage decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.pagemsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.icon(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final PageMessage redact(PageMessage pageMessage) {
            Builder newBuilder = pageMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
