package com.mi.global.shop.model.address;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class SetDefaultData extends Message<SetDefaultData, Builder> {
    public static final ProtoAdapter<SetDefaultData> ADAPTER = new ProtoAdapter_SetDefaultData();
    public static final Boolean DEFAULT_DATA = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean data;

    public SetDefaultData(Boolean bool) {
        this(bool, ByteString.O00000Oo);
    }

    public SetDefaultData(Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.data = bool;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetDefaultData)) {
            return false;
        }
        SetDefaultData setDefaultData = (SetDefaultData) obj;
        return Internal.equals(unknownFields(), setDefaultData.unknownFields()) && Internal.equals(this.data, setDefaultData.data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.data;
        int hashCode2 = hashCode + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "SetDefaultData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SetDefaultData, Builder> {
        public Boolean data;

        public final Builder data(Boolean bool) {
            this.data = bool;
            return this;
        }

        public final SetDefaultData build() {
            return new SetDefaultData(this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_SetDefaultData extends ProtoAdapter<SetDefaultData> {
        ProtoAdapter_SetDefaultData() {
            super(FieldEncoding.LENGTH_DELIMITED, SetDefaultData.class);
        }

        public final int encodedSize(SetDefaultData setDefaultData) {
            return (setDefaultData.data != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, setDefaultData.data) : 0) + setDefaultData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, SetDefaultData setDefaultData) throws IOException {
            if (setDefaultData.data != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, setDefaultData.data);
            }
            protoWriter.writeBytes(setDefaultData.unknownFields());
        }

        public final SetDefaultData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public final SetDefaultData redact(SetDefaultData setDefaultData) {
            Builder newBuilder = setDefaultData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
