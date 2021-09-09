package com.mi.global.shop.model.cod;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class ResultData extends Message<ResultData, Builder> {
    public static final ProtoAdapter<ResultData> ADAPTER = new ProtoAdapter_ResultData();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.cod.Result#ADAPTER", tag = 3)
    public final Result data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public ResultData(Integer num, String str, Result result) {
        this(num, str, result, ByteString.O00000Oo);
    }

    public ResultData(Integer num, String str, Result result, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = result;
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
        if (!(obj instanceof ResultData)) {
            return false;
        }
        ResultData resultData = (ResultData) obj;
        return Internal.equals(unknownFields(), resultData.unknownFields()) && Internal.equals(this.errno, resultData.errno) && Internal.equals(this.errmsg, resultData.errmsg) && Internal.equals(this.data, resultData.data);
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
        Result result = this.data;
        if (result != null) {
            i2 = result.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "ResultData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ResultData, Builder> {
        public Result data;
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

        public final Builder data(Result result) {
            this.data = result;
            return this;
        }

        public final ResultData build() {
            return new ResultData(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ResultData extends ProtoAdapter<ResultData> {
        ProtoAdapter_ResultData() {
            super(FieldEncoding.LENGTH_DELIMITED, ResultData.class);
        }

        public final int encodedSize(ResultData resultData) {
            int i = 0;
            int encodedSizeWithTag = (resultData.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, resultData.errno) : 0) + (resultData.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, resultData.errmsg) : 0);
            if (resultData.data != null) {
                i = Result.ADAPTER.encodedSizeWithTag(3, resultData.data);
            }
            return encodedSizeWithTag + i + resultData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ResultData resultData) throws IOException {
            if (resultData.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, resultData.errno);
            }
            if (resultData.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, resultData.errmsg);
            }
            if (resultData.data != null) {
                Result.ADAPTER.encodeWithTag(protoWriter, 3, resultData.data);
            }
            protoWriter.writeBytes(resultData.unknownFields());
        }

        public final ResultData decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(Result.ADAPTER.decode(protoReader));
                }
            }
        }

        public final ResultData redact(ResultData resultData) {
            Builder newBuilder = resultData.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = Result.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
