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

public final class SubmitBody extends Message<SubmitBody, Builder> {
    public static final ProtoAdapter<SubmitBody> ADAPTER = new ProtoAdapter_SubmitBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.buy.SubmitData#ADAPTER", tag = 3)
    public final SubmitData Data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String Errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer Errno;

    public SubmitBody(Integer num, String str, SubmitData submitData) {
        this(num, str, submitData, ByteString.O00000Oo);
    }

    public SubmitBody(Integer num, String str, SubmitData submitData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.Errno = num;
        this.Errmsg = str;
        this.Data = submitData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.Errno = this.Errno;
        builder.Errmsg = this.Errmsg;
        builder.Data = this.Data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitBody)) {
            return false;
        }
        SubmitBody submitBody = (SubmitBody) obj;
        return Internal.equals(unknownFields(), submitBody.unknownFields()) && Internal.equals(this.Errno, submitBody.Errno) && Internal.equals(this.Errmsg, submitBody.Errmsg) && Internal.equals(this.Data, submitBody.Data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.Errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.Errmsg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        SubmitData submitData = this.Data;
        if (submitData != null) {
            i2 = submitData.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.Errno != null) {
            sb.append(", Errno=");
            sb.append(this.Errno);
        }
        if (this.Errmsg != null) {
            sb.append(", Errmsg=");
            sb.append(this.Errmsg);
        }
        if (this.Data != null) {
            sb.append(", Data=");
            sb.append(this.Data);
        }
        StringBuilder replace = sb.replace(0, 2, "SubmitBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SubmitBody, Builder> {
        public SubmitData Data;
        public String Errmsg;
        public Integer Errno;

        public final Builder Errno(Integer num) {
            this.Errno = num;
            return this;
        }

        public final Builder Errmsg(String str) {
            this.Errmsg = str;
            return this;
        }

        public final Builder Data(SubmitData submitData) {
            this.Data = submitData;
            return this;
        }

        public final SubmitBody build() {
            return new SubmitBody(this.Errno, this.Errmsg, this.Data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_SubmitBody extends ProtoAdapter<SubmitBody> {
        ProtoAdapter_SubmitBody() {
            super(FieldEncoding.LENGTH_DELIMITED, SubmitBody.class);
        }

        public final int encodedSize(SubmitBody submitBody) {
            int i = 0;
            int encodedSizeWithTag = (submitBody.Errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, submitBody.Errno) : 0) + (submitBody.Errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, submitBody.Errmsg) : 0);
            if (submitBody.Data != null) {
                i = SubmitData.ADAPTER.encodedSizeWithTag(3, submitBody.Data);
            }
            return encodedSizeWithTag + i + submitBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, SubmitBody submitBody) throws IOException {
            if (submitBody.Errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, submitBody.Errno);
            }
            if (submitBody.Errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, submitBody.Errmsg);
            }
            if (submitBody.Data != null) {
                SubmitData.ADAPTER.encodeWithTag(protoWriter, 3, submitBody.Data);
            }
            protoWriter.writeBytes(submitBody.unknownFields());
        }

        public final SubmitBody decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.Errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.Errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.Data(SubmitData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final SubmitBody redact(SubmitBody submitBody) {
            Builder newBuilder = submitBody.newBuilder();
            if (newBuilder.Data != null) {
                newBuilder.Data = SubmitData.ADAPTER.redact(newBuilder.Data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
