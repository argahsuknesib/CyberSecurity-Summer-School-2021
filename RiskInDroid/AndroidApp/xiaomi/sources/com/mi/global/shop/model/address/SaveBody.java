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

public final class SaveBody extends Message<SaveBody, Builder> {
    public static final ProtoAdapter<SaveBody> ADAPTER = new ProtoAdapter_SaveBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.address.ResultData#ADAPTER", tag = 3)
    public final ResultData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public SaveBody(Integer num, String str, ResultData resultData) {
        this(num, str, resultData, ByteString.O00000Oo);
    }

    public SaveBody(Integer num, String str, ResultData resultData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = resultData;
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
        if (!(obj instanceof SaveBody)) {
            return false;
        }
        SaveBody saveBody = (SaveBody) obj;
        return Internal.equals(unknownFields(), saveBody.unknownFields()) && Internal.equals(this.errno, saveBody.errno) && Internal.equals(this.errmsg, saveBody.errmsg) && Internal.equals(this.data, saveBody.data);
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
        ResultData resultData = this.data;
        if (resultData != null) {
            i2 = resultData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "SaveBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SaveBody, Builder> {
        public ResultData data;
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

        public final Builder data(ResultData resultData) {
            this.data = resultData;
            return this;
        }

        public final SaveBody build() {
            return new SaveBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_SaveBody extends ProtoAdapter<SaveBody> {
        ProtoAdapter_SaveBody() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveBody.class);
        }

        public final int encodedSize(SaveBody saveBody) {
            int i = 0;
            int encodedSizeWithTag = (saveBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, saveBody.errno) : 0) + (saveBody.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, saveBody.errmsg) : 0);
            if (saveBody.data != null) {
                i = ResultData.ADAPTER.encodedSizeWithTag(3, saveBody.data);
            }
            return encodedSizeWithTag + i + saveBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, SaveBody saveBody) throws IOException {
            if (saveBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, saveBody.errno);
            }
            if (saveBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, saveBody.errmsg);
            }
            if (saveBody.data != null) {
                ResultData.ADAPTER.encodeWithTag(protoWriter, 3, saveBody.data);
            }
            protoWriter.writeBytes(saveBody.unknownFields());
        }

        public final SaveBody decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(ResultData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final SaveBody redact(SaveBody saveBody) {
            Builder newBuilder = saveBody.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = ResultData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
