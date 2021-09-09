package com.mi.global.shop.model.buy;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class BankListItem extends Message<BankListItem, Builder> {
    public static final ProtoAdapter<BankListItem> ADAPTER = new ProtoAdapter_BankListItem();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String desc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    public BankListItem(String str, String str2) {
        this(str, str2, ByteString.O00000Oo);
    }

    public BankListItem(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.desc = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.desc = this.desc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankListItem)) {
            return false;
        }
        BankListItem bankListItem = (BankListItem) obj;
        return Internal.equals(unknownFields(), bankListItem.unknownFields()) && Internal.equals(this.name, bankListItem.name) && Internal.equals(this.desc, bankListItem.desc);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.desc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.desc != null) {
            sb.append(", desc=");
            sb.append(this.desc);
        }
        StringBuilder replace = sb.replace(0, 2, "BankListItem{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BankListItem, Builder> {
        public String desc;
        public String name;

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public final BankListItem build() {
            return new BankListItem(this.name, this.desc, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_BankListItem extends ProtoAdapter<BankListItem> {
        ProtoAdapter_BankListItem() {
            super(FieldEncoding.LENGTH_DELIMITED, BankListItem.class);
        }

        public final int encodedSize(BankListItem bankListItem) {
            int i = 0;
            int encodedSizeWithTag = bankListItem.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, bankListItem.name) : 0;
            if (bankListItem.desc != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, bankListItem.desc);
            }
            return encodedSizeWithTag + i + bankListItem.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, BankListItem bankListItem) throws IOException {
            if (bankListItem.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, bankListItem.name);
            }
            if (bankListItem.desc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, bankListItem.desc);
            }
            protoWriter.writeBytes(bankListItem.unknownFields());
        }

        public final BankListItem decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.desc(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final BankListItem redact(BankListItem bankListItem) {
            Builder newBuilder = bankListItem.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
