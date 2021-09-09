package com.mi.global.shop.model.common;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class Netbank extends Message<Netbank, Builder> {
    public static final ProtoAdapter<Netbank> ADAPTER = new ProtoAdapter_Netbank();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String all_json;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> recommend;

    public Netbank(List<String> list, String str) {
        this(list, str, ByteString.O00000Oo);
    }

    public Netbank(List<String> list, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.recommend = Internal.immutableCopyOf("recommend", list);
        this.all_json = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.recommend = Internal.copyOf("recommend", this.recommend);
        builder.all_json = this.all_json;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Netbank)) {
            return false;
        }
        Netbank netbank = (Netbank) obj;
        return Internal.equals(unknownFields(), netbank.unknownFields()) && Internal.equals(this.recommend, netbank.recommend) && Internal.equals(this.all_json, netbank.all_json);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        List<String> list = this.recommend;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.all_json;
        int hashCode3 = hashCode2 + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.recommend != null) {
            sb.append(", recommend=");
            sb.append(this.recommend);
        }
        if (this.all_json != null) {
            sb.append(", all_json=");
            sb.append(this.all_json);
        }
        StringBuilder replace = sb.replace(0, 2, "Netbank{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Netbank, Builder> {
        public String all_json;
        public List<String> recommend = Internal.newMutableList();

        public final Builder recommend(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.recommend = list;
            return this;
        }

        public final Builder all_json(String str) {
            this.all_json = str;
            return this;
        }

        public final Netbank build() {
            return new Netbank(this.recommend, this.all_json, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Netbank extends ProtoAdapter<Netbank> {
        ProtoAdapter_Netbank() {
            super(FieldEncoding.LENGTH_DELIMITED, Netbank.class);
        }

        public final int encodedSize(Netbank netbank) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, netbank.recommend) + (netbank.all_json != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, netbank.all_json) : 0) + netbank.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Netbank netbank) throws IOException {
            if (netbank.recommend != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 1, netbank.recommend);
            }
            if (netbank.all_json != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, netbank.all_json);
            }
            protoWriter.writeBytes(netbank.unknownFields());
        }

        public final Netbank decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.recommend.add(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.all_json(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final Netbank redact(Netbank netbank) {
            Builder newBuilder = netbank.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
