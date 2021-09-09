package com.mi.global.shop.model.address;

import com.mi.global.shop.model.common.AddressData;
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
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.AddressData#ADAPTER", tag = 3)
    public final AddressData addinfo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String errors;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String result;

    public ResultData(String str, String str2, AddressData addressData) {
        this(str, str2, addressData, ByteString.O00000Oo);
    }

    public ResultData(String str, String str2, AddressData addressData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errors = str;
        this.result = str2;
        this.addinfo = addressData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errors = this.errors;
        builder.result = this.result;
        builder.addinfo = this.addinfo;
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
        return Internal.equals(unknownFields(), resultData.unknownFields()) && Internal.equals(this.errors, resultData.errors) && Internal.equals(this.result, resultData.result) && Internal.equals(this.addinfo, resultData.addinfo);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.errors;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.result;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        AddressData addressData = this.addinfo;
        if (addressData != null) {
            i2 = addressData.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.errors != null) {
            sb.append(", errors=");
            sb.append(this.errors);
        }
        if (this.result != null) {
            sb.append(", result=");
            sb.append(this.result);
        }
        if (this.addinfo != null) {
            sb.append(", addinfo=");
            sb.append(this.addinfo);
        }
        StringBuilder replace = sb.replace(0, 2, "ResultData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ResultData, Builder> {
        public AddressData addinfo;
        public String errors;
        public String result;

        public final Builder errors(String str) {
            this.errors = str;
            return this;
        }

        public final Builder result(String str) {
            this.result = str;
            return this;
        }

        public final Builder addinfo(AddressData addressData) {
            this.addinfo = addressData;
            return this;
        }

        public final ResultData build() {
            return new ResultData(this.errors, this.result, this.addinfo, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ResultData extends ProtoAdapter<ResultData> {
        ProtoAdapter_ResultData() {
            super(FieldEncoding.LENGTH_DELIMITED, ResultData.class);
        }

        public final int encodedSize(ResultData resultData) {
            int i = 0;
            int encodedSizeWithTag = (resultData.errors != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, resultData.errors) : 0) + (resultData.result != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, resultData.result) : 0);
            if (resultData.addinfo != null) {
                i = AddressData.ADAPTER.encodedSizeWithTag(3, resultData.addinfo);
            }
            return encodedSizeWithTag + i + resultData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ResultData resultData) throws IOException {
            if (resultData.errors != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, resultData.errors);
            }
            if (resultData.result != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, resultData.result);
            }
            if (resultData.addinfo != null) {
                AddressData.ADAPTER.encodeWithTag(protoWriter, 3, resultData.addinfo);
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
                    builder.errors(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.result(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.addinfo(AddressData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final ResultData redact(ResultData resultData) {
            Builder newBuilder = resultData.newBuilder();
            if (newBuilder.addinfo != null) {
                newBuilder.addinfo = AddressData.ADAPTER.redact(newBuilder.addinfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
