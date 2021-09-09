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

public final class CheckZipcodeBody extends Message<CheckZipcodeBody, Builder> {
    public static final ProtoAdapter<CheckZipcodeBody> ADAPTER = new ProtoAdapter_CheckZipcodeBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.address.CheckZipcodeData#ADAPTER", tag = 3)
    public final CheckZipcodeData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public CheckZipcodeBody(Integer num, String str, CheckZipcodeData checkZipcodeData) {
        this(num, str, checkZipcodeData, ByteString.O00000Oo);
    }

    public CheckZipcodeBody(Integer num, String str, CheckZipcodeData checkZipcodeData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = checkZipcodeData;
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
        if (!(obj instanceof CheckZipcodeBody)) {
            return false;
        }
        CheckZipcodeBody checkZipcodeBody = (CheckZipcodeBody) obj;
        return Internal.equals(unknownFields(), checkZipcodeBody.unknownFields()) && Internal.equals(this.errno, checkZipcodeBody.errno) && Internal.equals(this.errmsg, checkZipcodeBody.errmsg) && Internal.equals(this.data, checkZipcodeBody.data);
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
        CheckZipcodeData checkZipcodeData = this.data;
        if (checkZipcodeData != null) {
            i2 = checkZipcodeData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "CheckZipcodeBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CheckZipcodeBody, Builder> {
        public CheckZipcodeData data;
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

        public final Builder data(CheckZipcodeData checkZipcodeData) {
            this.data = checkZipcodeData;
            return this;
        }

        public final CheckZipcodeBody build() {
            return new CheckZipcodeBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CheckZipcodeBody extends ProtoAdapter<CheckZipcodeBody> {
        ProtoAdapter_CheckZipcodeBody() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckZipcodeBody.class);
        }

        public final int encodedSize(CheckZipcodeBody checkZipcodeBody) {
            int i = 0;
            int encodedSizeWithTag = (checkZipcodeBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, checkZipcodeBody.errno) : 0) + (checkZipcodeBody.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, checkZipcodeBody.errmsg) : 0);
            if (checkZipcodeBody.data != null) {
                i = CheckZipcodeData.ADAPTER.encodedSizeWithTag(3, checkZipcodeBody.data);
            }
            return encodedSizeWithTag + i + checkZipcodeBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CheckZipcodeBody checkZipcodeBody) throws IOException {
            if (checkZipcodeBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, checkZipcodeBody.errno);
            }
            if (checkZipcodeBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, checkZipcodeBody.errmsg);
            }
            if (checkZipcodeBody.data != null) {
                CheckZipcodeData.ADAPTER.encodeWithTag(protoWriter, 3, checkZipcodeBody.data);
            }
            protoWriter.writeBytes(checkZipcodeBody.unknownFields());
        }

        public final CheckZipcodeBody decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(CheckZipcodeData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final CheckZipcodeBody redact(CheckZipcodeBody checkZipcodeBody) {
            Builder newBuilder = checkZipcodeBody.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = CheckZipcodeData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
