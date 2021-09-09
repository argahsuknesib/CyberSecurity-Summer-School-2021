package com.mi.global.shop.model.app;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class RefreshUserInfoData extends Message<RefreshUserInfoData, Builder> {
    public static final ProtoAdapter<RefreshUserInfoData> ADAPTER = new ProtoAdapter_RefreshUserInfoData();
    public static final Integer DEFAULT_NOT_COMMENT_ITEM_COUNT = 0;
    public static final Integer DEFAULT_NOT_PAY_ORDER_COUNT = 0;
    public static final Integer DEFAULT_NOT_USED_COUPON_COUNT = 0;
    public static final Integer DEFAULT_RETURNS_COUNT = 0;
    public static final Integer DEFAULT_SHIP_COUNT = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer not_comment_item_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer not_pay_order_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer not_used_coupon_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer returns_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer ship_count;

    public RefreshUserInfoData(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this(num, num2, num3, num4, num5, ByteString.O00000Oo);
    }

    public RefreshUserInfoData(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, ByteString byteString) {
        super(ADAPTER, byteString);
        this.not_pay_order_count = num;
        this.not_used_coupon_count = num2;
        this.ship_count = num3;
        this.returns_count = num4;
        this.not_comment_item_count = num5;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.not_pay_order_count = this.not_pay_order_count;
        builder.not_used_coupon_count = this.not_used_coupon_count;
        builder.ship_count = this.ship_count;
        builder.returns_count = this.returns_count;
        builder.not_comment_item_count = this.not_comment_item_count;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefreshUserInfoData)) {
            return false;
        }
        RefreshUserInfoData refreshUserInfoData = (RefreshUserInfoData) obj;
        return Internal.equals(unknownFields(), refreshUserInfoData.unknownFields()) && Internal.equals(this.not_pay_order_count, refreshUserInfoData.not_pay_order_count) && Internal.equals(this.not_used_coupon_count, refreshUserInfoData.not_used_coupon_count) && Internal.equals(this.ship_count, refreshUserInfoData.ship_count) && Internal.equals(this.returns_count, refreshUserInfoData.returns_count) && Internal.equals(this.not_comment_item_count, refreshUserInfoData.not_comment_item_count);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.not_pay_order_count;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.not_used_coupon_count;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ship_count;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.returns_count;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.not_comment_item_count;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.not_pay_order_count != null) {
            sb.append(", not_pay_order_count=");
            sb.append(this.not_pay_order_count);
        }
        if (this.not_used_coupon_count != null) {
            sb.append(", not_used_coupon_count=");
            sb.append(this.not_used_coupon_count);
        }
        if (this.ship_count != null) {
            sb.append(", ship_count=");
            sb.append(this.ship_count);
        }
        if (this.returns_count != null) {
            sb.append(", returns_count=");
            sb.append(this.returns_count);
        }
        if (this.not_comment_item_count != null) {
            sb.append(", not_comment_item_count=");
            sb.append(this.not_comment_item_count);
        }
        StringBuilder replace = sb.replace(0, 2, "RefreshUserInfoData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<RefreshUserInfoData, Builder> {
        public Integer not_comment_item_count;
        public Integer not_pay_order_count;
        public Integer not_used_coupon_count;
        public Integer returns_count;
        public Integer ship_count;

        public final Builder not_pay_order_count(Integer num) {
            this.not_pay_order_count = num;
            return this;
        }

        public final Builder not_used_coupon_count(Integer num) {
            this.not_used_coupon_count = num;
            return this;
        }

        public final Builder ship_count(Integer num) {
            this.ship_count = num;
            return this;
        }

        public final Builder returns_count(Integer num) {
            this.returns_count = num;
            return this;
        }

        public final Builder not_comment_item_count(Integer num) {
            this.not_comment_item_count = num;
            return this;
        }

        public final RefreshUserInfoData build() {
            return new RefreshUserInfoData(this.not_pay_order_count, this.not_used_coupon_count, this.ship_count, this.returns_count, this.not_comment_item_count, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_RefreshUserInfoData extends ProtoAdapter<RefreshUserInfoData> {
        ProtoAdapter_RefreshUserInfoData() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshUserInfoData.class);
        }

        public final int encodedSize(RefreshUserInfoData refreshUserInfoData) {
            int i = 0;
            int encodedSizeWithTag = (refreshUserInfoData.not_pay_order_count != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, refreshUserInfoData.not_pay_order_count) : 0) + (refreshUserInfoData.not_used_coupon_count != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, refreshUserInfoData.not_used_coupon_count) : 0) + (refreshUserInfoData.ship_count != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, refreshUserInfoData.ship_count) : 0) + (refreshUserInfoData.returns_count != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, refreshUserInfoData.returns_count) : 0);
            if (refreshUserInfoData.not_comment_item_count != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(5, refreshUserInfoData.not_comment_item_count);
            }
            return encodedSizeWithTag + i + refreshUserInfoData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, RefreshUserInfoData refreshUserInfoData) throws IOException {
            if (refreshUserInfoData.not_pay_order_count != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, refreshUserInfoData.not_pay_order_count);
            }
            if (refreshUserInfoData.not_used_coupon_count != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, refreshUserInfoData.not_used_coupon_count);
            }
            if (refreshUserInfoData.ship_count != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, refreshUserInfoData.ship_count);
            }
            if (refreshUserInfoData.returns_count != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, refreshUserInfoData.returns_count);
            }
            if (refreshUserInfoData.not_comment_item_count != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, refreshUserInfoData.not_comment_item_count);
            }
            protoWriter.writeBytes(refreshUserInfoData.unknownFields());
        }

        public final RefreshUserInfoData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.not_pay_order_count(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.not_used_coupon_count(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.ship_count(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.returns_count(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.not_comment_item_count(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public final RefreshUserInfoData redact(RefreshUserInfoData refreshUserInfoData) {
            Builder newBuilder = refreshUserInfoData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
