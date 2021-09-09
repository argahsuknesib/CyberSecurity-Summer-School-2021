package com.mi.global.shop.model.user;

import com.google.android.exoplayer2.C;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class CouponData extends Message<CouponData, Builder> {
    public static final ProtoAdapter<CouponData> ADAPTER = new ProtoAdapter_CouponData();
    public static final Integer DEFAULT_BEGINTIME = 0;
    public static final Integer DEFAULT_ENDTIME = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String additional;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer beginTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String couponId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String couponName;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String couponNameDesc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer endTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String order_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String stat;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String type_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String usableRange;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String value;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String valueDesc;

    public CouponData(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this(str, str2, num, num2, str3, str4, str5, str6, str7, str8, str9, str10, str11, ByteString.O00000Oo);
    }

    public CouponData(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ByteString byteString) {
        super(ADAPTER, byteString);
        this.couponId = str;
        this.value = str2;
        this.beginTime = num;
        this.endTime = num2;
        this.couponName = str3;
        this.couponNameDesc = str4;
        this.stat = str5;
        this.additional = str6;
        this.type = str7;
        this.type_id = str8;
        this.order_id = str9;
        this.valueDesc = str10;
        this.usableRange = str11;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.couponId = this.couponId;
        builder.value = this.value;
        builder.beginTime = this.beginTime;
        builder.endTime = this.endTime;
        builder.couponName = this.couponName;
        builder.couponNameDesc = this.couponNameDesc;
        builder.stat = this.stat;
        builder.additional = this.additional;
        builder.type = this.type;
        builder.type_id = this.type_id;
        builder.order_id = this.order_id;
        builder.valueDesc = this.valueDesc;
        builder.usableRange = this.usableRange;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponData)) {
            return false;
        }
        CouponData couponData = (CouponData) obj;
        return Internal.equals(unknownFields(), couponData.unknownFields()) && Internal.equals(this.couponId, couponData.couponId) && Internal.equals(this.value, couponData.value) && Internal.equals(this.beginTime, couponData.beginTime) && Internal.equals(this.endTime, couponData.endTime) && Internal.equals(this.couponName, couponData.couponName) && Internal.equals(this.couponNameDesc, couponData.couponNameDesc) && Internal.equals(this.stat, couponData.stat) && Internal.equals(this.additional, couponData.additional) && Internal.equals(this.type, couponData.type) && Internal.equals(this.type_id, couponData.type_id) && Internal.equals(this.order_id, couponData.order_id) && Internal.equals(this.valueDesc, couponData.valueDesc) && Internal.equals(this.usableRange, couponData.usableRange);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.couponId;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.beginTime;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.endTime;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.couponName;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.couponNameDesc;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.stat;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.additional;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.type;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.type_id;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.order_id;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.valueDesc;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.usableRange;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.couponId != null) {
            sb.append(", couponId=");
            sb.append(this.couponId);
        }
        if (this.value != null) {
            sb.append(", value=");
            sb.append(this.value);
        }
        if (this.beginTime != null) {
            sb.append(", beginTime=");
            sb.append(this.beginTime);
        }
        if (this.endTime != null) {
            sb.append(", endTime=");
            sb.append(this.endTime);
        }
        if (this.couponName != null) {
            sb.append(", couponName=");
            sb.append(this.couponName);
        }
        if (this.couponNameDesc != null) {
            sb.append(", couponNameDesc=");
            sb.append(this.couponNameDesc);
        }
        if (this.stat != null) {
            sb.append(", stat=");
            sb.append(this.stat);
        }
        if (this.additional != null) {
            sb.append(", additional=");
            sb.append(this.additional);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.type_id != null) {
            sb.append(", type_id=");
            sb.append(this.type_id);
        }
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        if (this.valueDesc != null) {
            sb.append(", valueDesc=");
            sb.append(this.valueDesc);
        }
        if (this.usableRange != null) {
            sb.append(", usableRange=");
            sb.append(this.usableRange);
        }
        StringBuilder replace = sb.replace(0, 2, "CouponData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CouponData, Builder> {
        public String additional;
        public Integer beginTime;
        public String couponId;
        public String couponName;
        public String couponNameDesc;
        public Integer endTime;
        public String order_id;
        public String stat;
        public String type;
        public String type_id;
        public String usableRange;
        public String value;
        public String valueDesc;

        public final Builder couponId(String str) {
            this.couponId = str;
            return this;
        }

        public final Builder value(String str) {
            this.value = str;
            return this;
        }

        public final Builder beginTime(Integer num) {
            this.beginTime = num;
            return this;
        }

        public final Builder endTime(Integer num) {
            this.endTime = num;
            return this;
        }

        public final Builder couponName(String str) {
            this.couponName = str;
            return this;
        }

        public final Builder couponNameDesc(String str) {
            this.couponNameDesc = str;
            return this;
        }

        public final Builder stat(String str) {
            this.stat = str;
            return this;
        }

        public final Builder additional(String str) {
            this.additional = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder type_id(String str) {
            this.type_id = str;
            return this;
        }

        public final Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public final Builder valueDesc(String str) {
            this.valueDesc = str;
            return this;
        }

        public final Builder usableRange(String str) {
            this.usableRange = str;
            return this;
        }

        public final CouponData build() {
            return new CouponData(this.couponId, this.value, this.beginTime, this.endTime, this.couponName, this.couponNameDesc, this.stat, this.additional, this.type, this.type_id, this.order_id, this.valueDesc, this.usableRange, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CouponData extends ProtoAdapter<CouponData> {
        ProtoAdapter_CouponData() {
            super(FieldEncoding.LENGTH_DELIMITED, CouponData.class);
        }

        public final int encodedSize(CouponData couponData) {
            int i = 0;
            int encodedSizeWithTag = (couponData.couponId != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, couponData.couponId) : 0) + (couponData.value != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, couponData.value) : 0) + (couponData.beginTime != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, couponData.beginTime) : 0) + (couponData.endTime != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, couponData.endTime) : 0) + (couponData.couponName != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, couponData.couponName) : 0) + (couponData.couponNameDesc != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, couponData.couponNameDesc) : 0) + (couponData.stat != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, couponData.stat) : 0) + (couponData.additional != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, couponData.additional) : 0) + (couponData.type != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, couponData.type) : 0) + (couponData.type_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, couponData.type_id) : 0) + (couponData.order_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, couponData.order_id) : 0) + (couponData.valueDesc != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, couponData.valueDesc) : 0);
            if (couponData.usableRange != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(13, couponData.usableRange);
            }
            return encodedSizeWithTag + i + couponData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CouponData couponData) throws IOException {
            if (couponData.couponId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, couponData.couponId);
            }
            if (couponData.value != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, couponData.value);
            }
            if (couponData.beginTime != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, couponData.beginTime);
            }
            if (couponData.endTime != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, couponData.endTime);
            }
            if (couponData.couponName != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, couponData.couponName);
            }
            if (couponData.couponNameDesc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, couponData.couponNameDesc);
            }
            if (couponData.stat != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, couponData.stat);
            }
            if (couponData.additional != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, couponData.additional);
            }
            if (couponData.type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, couponData.type);
            }
            if (couponData.type_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, couponData.type_id);
            }
            if (couponData.order_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, couponData.order_id);
            }
            if (couponData.valueDesc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, couponData.valueDesc);
            }
            if (couponData.usableRange != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, couponData.usableRange);
            }
            protoWriter.writeBytes(couponData.unknownFields());
        }

        public final CouponData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.couponId(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.value(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.beginTime(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 4:
                            builder.endTime(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 5:
                            builder.couponName(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.couponNameDesc(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.stat(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.additional(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.type(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.type_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.order_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.valueDesc(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.usableRange(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final CouponData redact(CouponData couponData) {
            Builder newBuilder = couponData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
