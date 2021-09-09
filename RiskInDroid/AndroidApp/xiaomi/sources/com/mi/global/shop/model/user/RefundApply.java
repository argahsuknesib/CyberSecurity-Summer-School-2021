package com.mi.global.shop.model.user;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class RefundApply extends Message<RefundApply, Builder> {
    public static final ProtoAdapter<RefundApply> ADAPTER = new ProtoAdapter_RefundApply();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.user.RefundApplyData#ADAPTER", tag = 5)
    public final RefundApplyData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public RefundApply(Integer num, String str, RefundApplyData refundApplyData) {
        this(num, str, refundApplyData, ByteString.O00000Oo);
    }

    public RefundApply(Integer num, String str, RefundApplyData refundApplyData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = refundApplyData;
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
        if (!(obj instanceof RefundApply)) {
            return false;
        }
        RefundApply refundApply = (RefundApply) obj;
        return Internal.equals(unknownFields(), refundApply.unknownFields()) && Internal.equals(this.errno, refundApply.errno) && Internal.equals(this.errmsg, refundApply.errmsg) && Internal.equals(this.data, refundApply.data);
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
        RefundApplyData refundApplyData = this.data;
        if (refundApplyData != null) {
            i2 = refundApplyData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "RefundApply{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<RefundApply, Builder> {
        public RefundApplyData data;
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

        public final Builder data(RefundApplyData refundApplyData) {
            this.data = refundApplyData;
            return this;
        }

        public final RefundApply build() {
            return new RefundApply(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_RefundApply extends ProtoAdapter<RefundApply> {
        ProtoAdapter_RefundApply() {
            super(FieldEncoding.LENGTH_DELIMITED, RefundApply.class);
        }

        public final int encodedSize(RefundApply refundApply) {
            int i = 0;
            int encodedSizeWithTag = (refundApply.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, refundApply.errno) : 0) + (refundApply.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, refundApply.errmsg) : 0);
            if (refundApply.data != null) {
                i = RefundApplyData.ADAPTER.encodedSizeWithTag(5, refundApply.data);
            }
            return encodedSizeWithTag + i + refundApply.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, RefundApply refundApply) throws IOException {
            if (refundApply.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, refundApply.errno);
            }
            if (refundApply.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, refundApply.errmsg);
            }
            if (refundApply.data != null) {
                RefundApplyData.ADAPTER.encodeWithTag(protoWriter, 5, refundApply.data);
            }
            protoWriter.writeBytes(refundApply.unknownFields());
        }

        public final RefundApply decode(ProtoReader protoReader) throws IOException {
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
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(RefundApplyData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final RefundApply redact(RefundApply refundApply) {
            Builder newBuilder = refundApply.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = RefundApplyData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
