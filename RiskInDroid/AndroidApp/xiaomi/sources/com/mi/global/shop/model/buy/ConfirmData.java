package com.mi.global.shop.model.buy;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.mi.global.shop.model.basestruct.PageMessage;
import com.mi.global.shop.model.common.PayInfo;
import com.mi.global.shop.model.user.OrderInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class ConfirmData extends Message<ConfirmData, Builder> {
    public static final ProtoAdapter<ConfirmData> ADAPTER = new ProtoAdapter_ConfirmData();
    public static final Integer DEFAULT_CAN_COD = 0;
    public static final Integer DEFAULT_CAN_ONLINEPAY = 0;
    public static final Integer DEFAULT_COD_RESTRICT = 0;
    public static final Boolean DEFAULT_ISFIRSTLOAD = Boolean.FALSE;
    public static final Boolean DEFAULT_JUMPPAY = Boolean.FALSE;
    public static final Integer DEFAULT_ONLINEPAY_RESTRICT = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean IsFirstLoad;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String bankList;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer can_cod;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer can_onlinepay;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String cod_message;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer cod_restrict;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String codstatus;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String errInfo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean jumpPay;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String mention;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final String mention_ext;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String onlinepayCouponInfo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 14)
    public final Integer onlinepay_restrict;
    @WireField(adapter = "com.mi.global.shop.model.user.OrderInfo#ADAPTER", tag = 1)
    public final OrderInfo orderInfo;
    @WireField(adapter = "com.mi.global.shop.model.basestruct.PageMessage#ADAPTER", tag = 17)
    public final PageMessage pagemsg;
    @WireField(adapter = "com.mi.global.shop.model.common.PayInfo#ADAPTER", tag = 7)
    public final PayInfo payinfo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 4)
    public final List<String> slowCallBackArr;

    public ConfirmData(OrderInfo orderInfo2, Boolean bool, String str, List<String> list, Integer num, Integer num2, PayInfo payInfo, String str2, Boolean bool2, String str3, String str4, String str5, Integer num3, Integer num4, String str6, String str7, PageMessage pageMessage) {
        this(orderInfo2, bool, str, list, num, num2, payInfo, str2, bool2, str3, str4, str5, num3, num4, str6, str7, pageMessage, ByteString.O00000Oo);
    }

    public ConfirmData(OrderInfo orderInfo2, Boolean bool, String str, List<String> list, Integer num, Integer num2, PayInfo payInfo, String str2, Boolean bool2, String str3, String str4, String str5, Integer num3, Integer num4, String str6, String str7, PageMessage pageMessage, ByteString byteString) {
        super(ADAPTER, byteString);
        this.orderInfo = orderInfo2;
        this.IsFirstLoad = bool;
        this.bankList = str;
        this.slowCallBackArr = Internal.immutableCopyOf("slowCallBackArr", list);
        this.can_cod = num;
        this.can_onlinepay = num2;
        this.payinfo = payInfo;
        this.codstatus = str2;
        this.jumpPay = bool2;
        this.mention = str3;
        this.errInfo = str4;
        this.onlinepayCouponInfo = str5;
        this.cod_restrict = num3;
        this.onlinepay_restrict = num4;
        this.mention_ext = str6;
        this.cod_message = str7;
        this.pagemsg = pageMessage;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.orderInfo = this.orderInfo;
        builder.IsFirstLoad = this.IsFirstLoad;
        builder.bankList = this.bankList;
        builder.slowCallBackArr = Internal.copyOf("slowCallBackArr", this.slowCallBackArr);
        builder.can_cod = this.can_cod;
        builder.can_onlinepay = this.can_onlinepay;
        builder.payinfo = this.payinfo;
        builder.codstatus = this.codstatus;
        builder.jumpPay = this.jumpPay;
        builder.mention = this.mention;
        builder.errInfo = this.errInfo;
        builder.onlinepayCouponInfo = this.onlinepayCouponInfo;
        builder.cod_restrict = this.cod_restrict;
        builder.onlinepay_restrict = this.onlinepay_restrict;
        builder.mention_ext = this.mention_ext;
        builder.cod_message = this.cod_message;
        builder.pagemsg = this.pagemsg;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfirmData)) {
            return false;
        }
        ConfirmData confirmData = (ConfirmData) obj;
        return Internal.equals(unknownFields(), confirmData.unknownFields()) && Internal.equals(this.orderInfo, confirmData.orderInfo) && Internal.equals(this.IsFirstLoad, confirmData.IsFirstLoad) && Internal.equals(this.bankList, confirmData.bankList) && Internal.equals(this.slowCallBackArr, confirmData.slowCallBackArr) && Internal.equals(this.can_cod, confirmData.can_cod) && Internal.equals(this.can_onlinepay, confirmData.can_onlinepay) && Internal.equals(this.payinfo, confirmData.payinfo) && Internal.equals(this.codstatus, confirmData.codstatus) && Internal.equals(this.jumpPay, confirmData.jumpPay) && Internal.equals(this.mention, confirmData.mention) && Internal.equals(this.errInfo, confirmData.errInfo) && Internal.equals(this.onlinepayCouponInfo, confirmData.onlinepayCouponInfo) && Internal.equals(this.cod_restrict, confirmData.cod_restrict) && Internal.equals(this.onlinepay_restrict, confirmData.onlinepay_restrict) && Internal.equals(this.mention_ext, confirmData.mention_ext) && Internal.equals(this.cod_message, confirmData.cod_message) && Internal.equals(this.pagemsg, confirmData.pagemsg);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        OrderInfo orderInfo2 = this.orderInfo;
        int i2 = 0;
        int hashCode2 = (hashCode + (orderInfo2 != null ? orderInfo2.hashCode() : 0)) * 37;
        Boolean bool = this.IsFirstLoad;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.bankList;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        List<String> list = this.slowCallBackArr;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.can_cod;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.can_onlinepay;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        PayInfo payInfo = this.payinfo;
        int hashCode8 = (hashCode7 + (payInfo != null ? payInfo.hashCode() : 0)) * 37;
        String str2 = this.codstatus;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool2 = this.jumpPay;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str3 = this.mention;
        int hashCode11 = (hashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.errInfo;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.onlinepayCouponInfo;
        int hashCode13 = (hashCode12 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num3 = this.cod_restrict;
        int hashCode14 = (hashCode13 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.onlinepay_restrict;
        int hashCode15 = (hashCode14 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str6 = this.mention_ext;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.cod_message;
        int hashCode17 = (hashCode16 + (str7 != null ? str7.hashCode() : 0)) * 37;
        PageMessage pageMessage = this.pagemsg;
        if (pageMessage != null) {
            i2 = pageMessage.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.orderInfo != null) {
            sb.append(", orderInfo=");
            sb.append(this.orderInfo);
        }
        if (this.IsFirstLoad != null) {
            sb.append(", IsFirstLoad=");
            sb.append(this.IsFirstLoad);
        }
        if (this.bankList != null) {
            sb.append(", bankList=");
            sb.append(this.bankList);
        }
        if (this.slowCallBackArr != null) {
            sb.append(", slowCallBackArr=");
            sb.append(this.slowCallBackArr);
        }
        if (this.can_cod != null) {
            sb.append(", can_cod=");
            sb.append(this.can_cod);
        }
        if (this.can_onlinepay != null) {
            sb.append(", can_onlinepay=");
            sb.append(this.can_onlinepay);
        }
        if (this.payinfo != null) {
            sb.append(", payinfo=");
            sb.append(this.payinfo);
        }
        if (this.codstatus != null) {
            sb.append(", codstatus=");
            sb.append(this.codstatus);
        }
        if (this.jumpPay != null) {
            sb.append(", jumpPay=");
            sb.append(this.jumpPay);
        }
        if (this.mention != null) {
            sb.append(", mention=");
            sb.append(this.mention);
        }
        if (this.errInfo != null) {
            sb.append(", errInfo=");
            sb.append(this.errInfo);
        }
        if (this.onlinepayCouponInfo != null) {
            sb.append(", onlinepayCouponInfo=");
            sb.append(this.onlinepayCouponInfo);
        }
        if (this.cod_restrict != null) {
            sb.append(", cod_restrict=");
            sb.append(this.cod_restrict);
        }
        if (this.onlinepay_restrict != null) {
            sb.append(", onlinepay_restrict=");
            sb.append(this.onlinepay_restrict);
        }
        if (this.mention_ext != null) {
            sb.append(", mention_ext=");
            sb.append(this.mention_ext);
        }
        if (this.cod_message != null) {
            sb.append(", cod_message=");
            sb.append(this.cod_message);
        }
        if (this.pagemsg != null) {
            sb.append(", pagemsg=");
            sb.append(this.pagemsg);
        }
        StringBuilder replace = sb.replace(0, 2, "ConfirmData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ConfirmData, Builder> {
        public Boolean IsFirstLoad;
        public String bankList;
        public Integer can_cod;
        public Integer can_onlinepay;
        public String cod_message;
        public Integer cod_restrict;
        public String codstatus;
        public String errInfo;
        public Boolean jumpPay;
        public String mention;
        public String mention_ext;
        public String onlinepayCouponInfo;
        public Integer onlinepay_restrict;
        public OrderInfo orderInfo;
        public PageMessage pagemsg;
        public PayInfo payinfo;
        public List<String> slowCallBackArr = Internal.newMutableList();

        public final Builder orderInfo(OrderInfo orderInfo2) {
            this.orderInfo = orderInfo2;
            return this;
        }

        public final Builder IsFirstLoad(Boolean bool) {
            this.IsFirstLoad = bool;
            return this;
        }

        public final Builder bankList(String str) {
            this.bankList = str;
            return this;
        }

        public final Builder slowCallBackArr(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.slowCallBackArr = list;
            return this;
        }

        public final Builder can_cod(Integer num) {
            this.can_cod = num;
            return this;
        }

        public final Builder can_onlinepay(Integer num) {
            this.can_onlinepay = num;
            return this;
        }

        public final Builder payinfo(PayInfo payInfo) {
            this.payinfo = payInfo;
            return this;
        }

        public final Builder codstatus(String str) {
            this.codstatus = str;
            return this;
        }

        public final Builder jumpPay(Boolean bool) {
            this.jumpPay = bool;
            return this;
        }

        public final Builder mention(String str) {
            this.mention = str;
            return this;
        }

        public final Builder errInfo(String str) {
            this.errInfo = str;
            return this;
        }

        public final Builder onlinepayCouponInfo(String str) {
            this.onlinepayCouponInfo = str;
            return this;
        }

        public final Builder cod_restrict(Integer num) {
            this.cod_restrict = num;
            return this;
        }

        public final Builder onlinepay_restrict(Integer num) {
            this.onlinepay_restrict = num;
            return this;
        }

        public final Builder mention_ext(String str) {
            this.mention_ext = str;
            return this;
        }

        public final Builder cod_message(String str) {
            this.cod_message = str;
            return this;
        }

        public final Builder pagemsg(PageMessage pageMessage) {
            this.pagemsg = pageMessage;
            return this;
        }

        public final ConfirmData build() {
            return new ConfirmData(this.orderInfo, this.IsFirstLoad, this.bankList, this.slowCallBackArr, this.can_cod, this.can_onlinepay, this.payinfo, this.codstatus, this.jumpPay, this.mention, this.errInfo, this.onlinepayCouponInfo, this.cod_restrict, this.onlinepay_restrict, this.mention_ext, this.cod_message, this.pagemsg, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ConfirmData extends ProtoAdapter<ConfirmData> {
        ProtoAdapter_ConfirmData() {
            super(FieldEncoding.LENGTH_DELIMITED, ConfirmData.class);
        }

        public final int encodedSize(ConfirmData confirmData) {
            int i = 0;
            int encodedSizeWithTag = (confirmData.orderInfo != null ? OrderInfo.ADAPTER.encodedSizeWithTag(1, confirmData.orderInfo) : 0) + (confirmData.IsFirstLoad != null ? ProtoAdapter.BOOL.encodedSizeWithTag(2, confirmData.IsFirstLoad) : 0) + (confirmData.bankList != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, confirmData.bankList) : 0) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(4, confirmData.slowCallBackArr) + (confirmData.can_cod != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, confirmData.can_cod) : 0) + (confirmData.can_onlinepay != null ? ProtoAdapter.INT32.encodedSizeWithTag(6, confirmData.can_onlinepay) : 0) + (confirmData.payinfo != null ? PayInfo.ADAPTER.encodedSizeWithTag(7, confirmData.payinfo) : 0) + (confirmData.codstatus != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, confirmData.codstatus) : 0) + (confirmData.jumpPay != null ? ProtoAdapter.BOOL.encodedSizeWithTag(9, confirmData.jumpPay) : 0) + (confirmData.mention != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, confirmData.mention) : 0) + (confirmData.errInfo != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, confirmData.errInfo) : 0) + (confirmData.onlinepayCouponInfo != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, confirmData.onlinepayCouponInfo) : 0) + (confirmData.cod_restrict != null ? ProtoAdapter.INT32.encodedSizeWithTag(13, confirmData.cod_restrict) : 0) + (confirmData.onlinepay_restrict != null ? ProtoAdapter.INT32.encodedSizeWithTag(14, confirmData.onlinepay_restrict) : 0) + (confirmData.mention_ext != null ? ProtoAdapter.STRING.encodedSizeWithTag(15, confirmData.mention_ext) : 0) + (confirmData.cod_message != null ? ProtoAdapter.STRING.encodedSizeWithTag(16, confirmData.cod_message) : 0);
            if (confirmData.pagemsg != null) {
                i = PageMessage.ADAPTER.encodedSizeWithTag(17, confirmData.pagemsg);
            }
            return encodedSizeWithTag + i + confirmData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ConfirmData confirmData) throws IOException {
            if (confirmData.orderInfo != null) {
                OrderInfo.ADAPTER.encodeWithTag(protoWriter, 1, confirmData.orderInfo);
            }
            if (confirmData.IsFirstLoad != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, confirmData.IsFirstLoad);
            }
            if (confirmData.bankList != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, confirmData.bankList);
            }
            if (confirmData.slowCallBackArr != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 4, confirmData.slowCallBackArr);
            }
            if (confirmData.can_cod != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, confirmData.can_cod);
            }
            if (confirmData.can_onlinepay != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, confirmData.can_onlinepay);
            }
            if (confirmData.payinfo != null) {
                PayInfo.ADAPTER.encodeWithTag(protoWriter, 7, confirmData.payinfo);
            }
            if (confirmData.codstatus != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, confirmData.codstatus);
            }
            if (confirmData.jumpPay != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 9, confirmData.jumpPay);
            }
            if (confirmData.mention != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, confirmData.mention);
            }
            if (confirmData.errInfo != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, confirmData.errInfo);
            }
            if (confirmData.onlinepayCouponInfo != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, confirmData.onlinepayCouponInfo);
            }
            if (confirmData.cod_restrict != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 13, confirmData.cod_restrict);
            }
            if (confirmData.onlinepay_restrict != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 14, confirmData.onlinepay_restrict);
            }
            if (confirmData.mention_ext != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, confirmData.mention_ext);
            }
            if (confirmData.cod_message != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, confirmData.cod_message);
            }
            if (confirmData.pagemsg != null) {
                PageMessage.ADAPTER.encodeWithTag(protoWriter, 17, confirmData.pagemsg);
            }
            protoWriter.writeBytes(confirmData.unknownFields());
        }

        public final ConfirmData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.orderInfo(OrderInfo.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.IsFirstLoad(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 3:
                            builder.bankList(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.slowCallBackArr.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.can_cod(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 6:
                            builder.can_onlinepay(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 7:
                            builder.payinfo(PayInfo.ADAPTER.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.codstatus(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.jumpPay(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 10:
                            builder.mention(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.errInfo(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.onlinepayCouponInfo(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.cod_restrict(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 14:
                            builder.onlinepay_restrict(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.mention_ext(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            builder.cod_message(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            builder.pagemsg(PageMessage.ADAPTER.decode(protoReader));
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

        public final ConfirmData redact(ConfirmData confirmData) {
            Builder newBuilder = confirmData.newBuilder();
            if (newBuilder.orderInfo != null) {
                newBuilder.orderInfo = OrderInfo.ADAPTER.redact(newBuilder.orderInfo);
            }
            if (newBuilder.payinfo != null) {
                newBuilder.payinfo = PayInfo.ADAPTER.redact(newBuilder.payinfo);
            }
            if (newBuilder.pagemsg != null) {
                newBuilder.pagemsg = PageMessage.ADAPTER.redact(newBuilder.pagemsg);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
