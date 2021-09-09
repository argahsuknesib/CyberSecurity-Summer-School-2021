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

public final class Result extends Message<Result, Builder> {
    public static final ProtoAdapter<Result> ADAPTER = new ProtoAdapter_Result();
    public static final Boolean DEFAULT_REFRESH = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean refresh;
    @WireField(adapter = "com.mi.global.shop.model.cod.Support#ADAPTER", tag = 3)
    public final Support support;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    public Result(String str, Boolean bool, Support support2) {
        this(str, bool, support2, ByteString.O00000Oo);
    }

    public Result(String str, Boolean bool, Support support2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.url = str;
        this.refresh = bool;
        this.support = support2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.refresh = this.refresh;
        builder.support = this.support;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return Internal.equals(unknownFields(), result.unknownFields()) && Internal.equals(this.url, result.url) && Internal.equals(this.refresh, result.refresh) && Internal.equals(this.support, result.support);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.url;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.refresh;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Support support2 = this.support;
        if (support2 != null) {
            i2 = support2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        if (this.refresh != null) {
            sb.append(", refresh=");
            sb.append(this.refresh);
        }
        if (this.support != null) {
            sb.append(", support=");
            sb.append(this.support);
        }
        StringBuilder replace = sb.replace(0, 2, "Result{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Result, Builder> {
        public Boolean refresh;
        public Support support;
        public String url;

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder refresh(Boolean bool) {
            this.refresh = bool;
            return this;
        }

        public final Builder support(Support support2) {
            this.support = support2;
            return this;
        }

        public final Result build() {
            return new Result(this.url, this.refresh, this.support, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Result extends ProtoAdapter<Result> {
        ProtoAdapter_Result() {
            super(FieldEncoding.LENGTH_DELIMITED, Result.class);
        }

        public final int encodedSize(Result result) {
            int i = 0;
            int encodedSizeWithTag = (result.url != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, result.url) : 0) + (result.refresh != null ? ProtoAdapter.BOOL.encodedSizeWithTag(2, result.refresh) : 0);
            if (result.support != null) {
                i = Support.ADAPTER.encodedSizeWithTag(3, result.support);
            }
            return encodedSizeWithTag + i + result.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Result result) throws IOException {
            if (result.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, result.url);
            }
            if (result.refresh != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, result.refresh);
            }
            if (result.support != null) {
                Support.ADAPTER.encodeWithTag(protoWriter, 3, result.support);
            }
            protoWriter.writeBytes(result.unknownFields());
        }

        public final Result decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.refresh(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.support(Support.ADAPTER.decode(protoReader));
                }
            }
        }

        public final Result redact(Result result) {
            Builder newBuilder = result.newBuilder();
            if (newBuilder.support != null) {
                newBuilder.support = Support.ADAPTER.redact(newBuilder.support);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
