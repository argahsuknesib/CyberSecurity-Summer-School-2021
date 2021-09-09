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

public final class SetDefaultBody extends Message<SetDefaultBody, Builder> {
    public static final ProtoAdapter<SetDefaultBody> ADAPTER = new ProtoAdapter_SetDefaultBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.address.SetDefaultData#ADAPTER", tag = 3)
    public final SetDefaultData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public SetDefaultBody(Integer num, String str, SetDefaultData setDefaultData) {
        this(num, str, setDefaultData, ByteString.O00000Oo);
    }

    public SetDefaultBody(Integer num, String str, SetDefaultData setDefaultData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = setDefaultData;
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
        if (!(obj instanceof SetDefaultBody)) {
            return false;
        }
        SetDefaultBody setDefaultBody = (SetDefaultBody) obj;
        return Internal.equals(unknownFields(), setDefaultBody.unknownFields()) && Internal.equals(this.errno, setDefaultBody.errno) && Internal.equals(this.errmsg, setDefaultBody.errmsg) && Internal.equals(this.data, setDefaultBody.data);
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
        SetDefaultData setDefaultData = this.data;
        if (setDefaultData != null) {
            i2 = setDefaultData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "SetDefaultBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SetDefaultBody, Builder> {
        public SetDefaultData data;
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

        public final Builder data(SetDefaultData setDefaultData) {
            this.data = setDefaultData;
            return this;
        }

        public final SetDefaultBody build() {
            return new SetDefaultBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_SetDefaultBody extends ProtoAdapter<SetDefaultBody> {
        ProtoAdapter_SetDefaultBody() {
            super(FieldEncoding.LENGTH_DELIMITED, SetDefaultBody.class);
        }

        public final int encodedSize(SetDefaultBody setDefaultBody) {
            int i = 0;
            int encodedSizeWithTag = (setDefaultBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, setDefaultBody.errno) : 0) + (setDefaultBody.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, setDefaultBody.errmsg) : 0);
            if (setDefaultBody.data != null) {
                i = SetDefaultData.ADAPTER.encodedSizeWithTag(3, setDefaultBody.data);
            }
            return encodedSizeWithTag + i + setDefaultBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, SetDefaultBody setDefaultBody) throws IOException {
            if (setDefaultBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, setDefaultBody.errno);
            }
            if (setDefaultBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, setDefaultBody.errmsg);
            }
            if (setDefaultBody.data != null) {
                SetDefaultData.ADAPTER.encodeWithTag(protoWriter, 3, setDefaultBody.data);
            }
            protoWriter.writeBytes(setDefaultBody.unknownFields());
        }

        public final SetDefaultBody decode(ProtoReader protoReader) throws IOException {
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
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(SetDefaultData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final SetDefaultBody redact(SetDefaultBody setDefaultBody) {
            Builder newBuilder = setDefaultBody.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = SetDefaultData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
