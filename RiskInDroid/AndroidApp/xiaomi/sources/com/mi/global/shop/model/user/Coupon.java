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

public final class Coupon extends Message<Coupon, Builder> {
    public static final ProtoAdapter<Coupon> ADAPTER = new ProtoAdapter_Coupon();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.user.Coupons#ADAPTER", tag = 5)
    public final Coupons data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public Coupon(Integer num, String str, Coupons coupons) {
        this(num, str, coupons, ByteString.O00000Oo);
    }

    public Coupon(Integer num, String str, Coupons coupons, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = coupons;
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
        if (!(obj instanceof Coupon)) {
            return false;
        }
        Coupon coupon = (Coupon) obj;
        return Internal.equals(unknownFields(), coupon.unknownFields()) && Internal.equals(this.errno, coupon.errno) && Internal.equals(this.errmsg, coupon.errmsg) && Internal.equals(this.data, coupon.data);
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
        Coupons coupons = this.data;
        if (coupons != null) {
            i2 = coupons.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "Coupon{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Coupon, Builder> {
        public Coupons data;
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

        public final Builder data(Coupons coupons) {
            this.data = coupons;
            return this;
        }

        public final Coupon build() {
            return new Coupon(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Coupon extends ProtoAdapter<Coupon> {
        ProtoAdapter_Coupon() {
            super(FieldEncoding.LENGTH_DELIMITED, Coupon.class);
        }

        public final int encodedSize(Coupon coupon) {
            int i = 0;
            int encodedSizeWithTag = (coupon.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, coupon.errno) : 0) + (coupon.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, coupon.errmsg) : 0);
            if (coupon.data != null) {
                i = Coupons.ADAPTER.encodedSizeWithTag(5, coupon.data);
            }
            return encodedSizeWithTag + i + coupon.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Coupon coupon) throws IOException {
            if (coupon.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, coupon.errno);
            }
            if (coupon.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, coupon.errmsg);
            }
            if (coupon.data != null) {
                Coupons.ADAPTER.encodeWithTag(protoWriter, 5, coupon.data);
            }
            protoWriter.writeBytes(coupon.unknownFields());
        }

        public final Coupon decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(Coupons.ADAPTER.decode(protoReader));
                }
            }
        }

        public final Coupon redact(Coupon coupon) {
            Builder newBuilder = coupon.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = Coupons.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
