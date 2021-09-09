package com.mi.global.shop.model.buy;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.mi.global.shop.model.common.AddressData;
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

public final class CheckoutInfoData extends Message<CheckoutInfoData, Builder> {
    public static final ProtoAdapter<CheckoutInfoData> ADAPTER = new ProtoAdapter_CheckoutInfoData();
    public static final Integer DEFAULT_TOTAL = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String activityDiscountMoney;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String activityDiscountMoney_txt;
    @WireField(adapter = "com.mi.global.shop.model.common.AddressData#ADAPTER", tag = 1)
    public final AddressData address;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String amount;
    @WireField(adapter = "com.mi.global.shop.model.buy.DelivertimeData#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<DelivertimeData> delivertime;
    @WireField(adapter = "com.mi.global.shop.model.buy.InvoiceData#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<InvoiceData> invoice;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String invoice_title;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String need_pay_amount;
    @WireField(adapter = "com.mi.global.shop.model.buy.PaylistData#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<PaylistData> paylist;
    @WireField(adapter = "com.mi.global.shop.model.buy.PaymentData#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<PaymentData> payment;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String productMoney;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final String productMoney_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String shipment;
    @WireField(adapter = "com.mi.global.shop.model.buy.ShipmentlistData#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<ShipmentlistData> shipmentlist;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer total;

    public CheckoutInfoData(AddressData addressData, List<PaymentData> list, List<PaylistData> list2, List<ShipmentlistData> list3, List<DelivertimeData> list4, List<InvoiceData> list5, String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8) {
        this(addressData, list, list2, list3, list4, list5, str, str2, str3, num, str4, str5, str6, str7, str8, ByteString.O00000Oo);
    }

    public CheckoutInfoData(AddressData addressData, List<PaymentData> list, List<PaylistData> list2, List<ShipmentlistData> list3, List<DelivertimeData> list4, List<InvoiceData> list5, String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, ByteString byteString) {
        super(ADAPTER, byteString);
        this.address = addressData;
        this.payment = Internal.immutableCopyOf("payment", list);
        this.paylist = Internal.immutableCopyOf("paylist", list2);
        this.shipmentlist = Internal.immutableCopyOf("shipmentlist", list3);
        this.delivertime = Internal.immutableCopyOf("delivertime", list4);
        this.invoice = Internal.immutableCopyOf("invoice", list5);
        this.invoice_title = str;
        this.productMoney = str2;
        this.activityDiscountMoney = str3;
        this.total = num;
        this.amount = str4;
        this.shipment = str5;
        this.need_pay_amount = str6;
        this.activityDiscountMoney_txt = str7;
        this.productMoney_txt = str8;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.address = this.address;
        builder.payment = Internal.copyOf("payment", this.payment);
        builder.paylist = Internal.copyOf("paylist", this.paylist);
        builder.shipmentlist = Internal.copyOf("shipmentlist", this.shipmentlist);
        builder.delivertime = Internal.copyOf("delivertime", this.delivertime);
        builder.invoice = Internal.copyOf("invoice", this.invoice);
        builder.invoice_title = this.invoice_title;
        builder.productMoney = this.productMoney;
        builder.activityDiscountMoney = this.activityDiscountMoney;
        builder.total = this.total;
        builder.amount = this.amount;
        builder.shipment = this.shipment;
        builder.need_pay_amount = this.need_pay_amount;
        builder.activityDiscountMoney_txt = this.activityDiscountMoney_txt;
        builder.productMoney_txt = this.productMoney_txt;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutInfoData)) {
            return false;
        }
        CheckoutInfoData checkoutInfoData = (CheckoutInfoData) obj;
        return Internal.equals(unknownFields(), checkoutInfoData.unknownFields()) && Internal.equals(this.address, checkoutInfoData.address) && Internal.equals(this.payment, checkoutInfoData.payment) && Internal.equals(this.paylist, checkoutInfoData.paylist) && Internal.equals(this.shipmentlist, checkoutInfoData.shipmentlist) && Internal.equals(this.delivertime, checkoutInfoData.delivertime) && Internal.equals(this.invoice, checkoutInfoData.invoice) && Internal.equals(this.invoice_title, checkoutInfoData.invoice_title) && Internal.equals(this.productMoney, checkoutInfoData.productMoney) && Internal.equals(this.activityDiscountMoney, checkoutInfoData.activityDiscountMoney) && Internal.equals(this.total, checkoutInfoData.total) && Internal.equals(this.amount, checkoutInfoData.amount) && Internal.equals(this.shipment, checkoutInfoData.shipment) && Internal.equals(this.need_pay_amount, checkoutInfoData.need_pay_amount) && Internal.equals(this.activityDiscountMoney_txt, checkoutInfoData.activityDiscountMoney_txt) && Internal.equals(this.productMoney_txt, checkoutInfoData.productMoney_txt);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        AddressData addressData = this.address;
        int i2 = 0;
        int hashCode2 = (hashCode + (addressData != null ? addressData.hashCode() : 0)) * 37;
        List<PaymentData> list = this.payment;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<PaylistData> list2 = this.paylist;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<ShipmentlistData> list3 = this.shipmentlist;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<DelivertimeData> list4 = this.delivertime;
        int hashCode6 = (hashCode5 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<InvoiceData> list5 = this.invoice;
        if (list5 != null) {
            i3 = list5.hashCode();
        }
        int i4 = (hashCode6 + i3) * 37;
        String str = this.invoice_title;
        int hashCode7 = (i4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.productMoney;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.activityDiscountMoney;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.total;
        int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.amount;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.shipment;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.need_pay_amount;
        int hashCode13 = (hashCode12 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.activityDiscountMoney_txt;
        int hashCode14 = (hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.productMoney_txt;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i5 = hashCode14 + i2;
        this.hashCode = i5;
        return i5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.address != null) {
            sb.append(", address=");
            sb.append(this.address);
        }
        if (this.payment != null) {
            sb.append(", payment=");
            sb.append(this.payment);
        }
        if (this.paylist != null) {
            sb.append(", paylist=");
            sb.append(this.paylist);
        }
        if (this.shipmentlist != null) {
            sb.append(", shipmentlist=");
            sb.append(this.shipmentlist);
        }
        if (this.delivertime != null) {
            sb.append(", delivertime=");
            sb.append(this.delivertime);
        }
        if (this.invoice != null) {
            sb.append(", invoice=");
            sb.append(this.invoice);
        }
        if (this.invoice_title != null) {
            sb.append(", invoice_title=");
            sb.append(this.invoice_title);
        }
        if (this.productMoney != null) {
            sb.append(", productMoney=");
            sb.append(this.productMoney);
        }
        if (this.activityDiscountMoney != null) {
            sb.append(", activityDiscountMoney=");
            sb.append(this.activityDiscountMoney);
        }
        if (this.total != null) {
            sb.append(", total=");
            sb.append(this.total);
        }
        if (this.amount != null) {
            sb.append(", amount=");
            sb.append(this.amount);
        }
        if (this.shipment != null) {
            sb.append(", shipment=");
            sb.append(this.shipment);
        }
        if (this.need_pay_amount != null) {
            sb.append(", need_pay_amount=");
            sb.append(this.need_pay_amount);
        }
        if (this.activityDiscountMoney_txt != null) {
            sb.append(", activityDiscountMoney_txt=");
            sb.append(this.activityDiscountMoney_txt);
        }
        if (this.productMoney_txt != null) {
            sb.append(", productMoney_txt=");
            sb.append(this.productMoney_txt);
        }
        StringBuilder replace = sb.replace(0, 2, "CheckoutInfoData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CheckoutInfoData, Builder> {
        public String activityDiscountMoney;
        public String activityDiscountMoney_txt;
        public AddressData address;
        public String amount;
        public List<DelivertimeData> delivertime = Internal.newMutableList();
        public List<InvoiceData> invoice = Internal.newMutableList();
        public String invoice_title;
        public String need_pay_amount;
        public List<PaylistData> paylist = Internal.newMutableList();
        public List<PaymentData> payment = Internal.newMutableList();
        public String productMoney;
        public String productMoney_txt;
        public String shipment;
        public List<ShipmentlistData> shipmentlist = Internal.newMutableList();
        public Integer total;

        public final Builder address(AddressData addressData) {
            this.address = addressData;
            return this;
        }

        public final Builder payment(List<PaymentData> list) {
            Internal.checkElementsNotNull(list);
            this.payment = list;
            return this;
        }

        public final Builder paylist(List<PaylistData> list) {
            Internal.checkElementsNotNull(list);
            this.paylist = list;
            return this;
        }

        public final Builder shipmentlist(List<ShipmentlistData> list) {
            Internal.checkElementsNotNull(list);
            this.shipmentlist = list;
            return this;
        }

        public final Builder delivertime(List<DelivertimeData> list) {
            Internal.checkElementsNotNull(list);
            this.delivertime = list;
            return this;
        }

        public final Builder invoice(List<InvoiceData> list) {
            Internal.checkElementsNotNull(list);
            this.invoice = list;
            return this;
        }

        public final Builder invoice_title(String str) {
            this.invoice_title = str;
            return this;
        }

        public final Builder productMoney(String str) {
            this.productMoney = str;
            return this;
        }

        public final Builder activityDiscountMoney(String str) {
            this.activityDiscountMoney = str;
            return this;
        }

        public final Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public final Builder amount(String str) {
            this.amount = str;
            return this;
        }

        public final Builder shipment(String str) {
            this.shipment = str;
            return this;
        }

        public final Builder need_pay_amount(String str) {
            this.need_pay_amount = str;
            return this;
        }

        public final Builder activityDiscountMoney_txt(String str) {
            this.activityDiscountMoney_txt = str;
            return this;
        }

        public final Builder productMoney_txt(String str) {
            this.productMoney_txt = str;
            return this;
        }

        public final CheckoutInfoData build() {
            return new CheckoutInfoData(this.address, this.payment, this.paylist, this.shipmentlist, this.delivertime, this.invoice, this.invoice_title, this.productMoney, this.activityDiscountMoney, this.total, this.amount, this.shipment, this.need_pay_amount, this.activityDiscountMoney_txt, this.productMoney_txt, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CheckoutInfoData extends ProtoAdapter<CheckoutInfoData> {
        ProtoAdapter_CheckoutInfoData() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckoutInfoData.class);
        }

        public final int encodedSize(CheckoutInfoData checkoutInfoData) {
            int i = 0;
            int encodedSizeWithTag = (checkoutInfoData.address != null ? AddressData.ADAPTER.encodedSizeWithTag(1, checkoutInfoData.address) : 0) + PaymentData.ADAPTER.asRepeated().encodedSizeWithTag(2, checkoutInfoData.payment) + PaylistData.ADAPTER.asRepeated().encodedSizeWithTag(3, checkoutInfoData.paylist) + ShipmentlistData.ADAPTER.asRepeated().encodedSizeWithTag(4, checkoutInfoData.shipmentlist) + DelivertimeData.ADAPTER.asRepeated().encodedSizeWithTag(5, checkoutInfoData.delivertime) + InvoiceData.ADAPTER.asRepeated().encodedSizeWithTag(6, checkoutInfoData.invoice) + (checkoutInfoData.invoice_title != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, checkoutInfoData.invoice_title) : 0) + (checkoutInfoData.productMoney != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, checkoutInfoData.productMoney) : 0) + (checkoutInfoData.activityDiscountMoney != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, checkoutInfoData.activityDiscountMoney) : 0) + (checkoutInfoData.total != null ? ProtoAdapter.INT32.encodedSizeWithTag(10, checkoutInfoData.total) : 0) + (checkoutInfoData.amount != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, checkoutInfoData.amount) : 0) + (checkoutInfoData.shipment != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, checkoutInfoData.shipment) : 0) + (checkoutInfoData.need_pay_amount != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, checkoutInfoData.need_pay_amount) : 0) + (checkoutInfoData.activityDiscountMoney_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, checkoutInfoData.activityDiscountMoney_txt) : 0);
            if (checkoutInfoData.productMoney_txt != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(15, checkoutInfoData.productMoney_txt);
            }
            return encodedSizeWithTag + i + checkoutInfoData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CheckoutInfoData checkoutInfoData) throws IOException {
            if (checkoutInfoData.address != null) {
                AddressData.ADAPTER.encodeWithTag(protoWriter, 1, checkoutInfoData.address);
            }
            if (checkoutInfoData.payment != null) {
                PaymentData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, checkoutInfoData.payment);
            }
            if (checkoutInfoData.paylist != null) {
                PaylistData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, checkoutInfoData.paylist);
            }
            if (checkoutInfoData.shipmentlist != null) {
                ShipmentlistData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, checkoutInfoData.shipmentlist);
            }
            if (checkoutInfoData.delivertime != null) {
                DelivertimeData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, checkoutInfoData.delivertime);
            }
            if (checkoutInfoData.invoice != null) {
                InvoiceData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, checkoutInfoData.invoice);
            }
            if (checkoutInfoData.invoice_title != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, checkoutInfoData.invoice_title);
            }
            if (checkoutInfoData.productMoney != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, checkoutInfoData.productMoney);
            }
            if (checkoutInfoData.activityDiscountMoney != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, checkoutInfoData.activityDiscountMoney);
            }
            if (checkoutInfoData.total != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 10, checkoutInfoData.total);
            }
            if (checkoutInfoData.amount != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, checkoutInfoData.amount);
            }
            if (checkoutInfoData.shipment != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, checkoutInfoData.shipment);
            }
            if (checkoutInfoData.need_pay_amount != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, checkoutInfoData.need_pay_amount);
            }
            if (checkoutInfoData.activityDiscountMoney_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, checkoutInfoData.activityDiscountMoney_txt);
            }
            if (checkoutInfoData.productMoney_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, checkoutInfoData.productMoney_txt);
            }
            protoWriter.writeBytes(checkoutInfoData.unknownFields());
        }

        public final CheckoutInfoData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.address(AddressData.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.payment.add(PaymentData.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.paylist.add(PaylistData.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.shipmentlist.add(ShipmentlistData.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.delivertime.add(DelivertimeData.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            builder.invoice.add(InvoiceData.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            builder.invoice_title(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.productMoney(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.activityDiscountMoney(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.total(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 11:
                            builder.amount(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.shipment(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.need_pay_amount(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            builder.activityDiscountMoney_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.productMoney_txt(ProtoAdapter.STRING.decode(protoReader));
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

        public final CheckoutInfoData redact(CheckoutInfoData checkoutInfoData) {
            Builder newBuilder = checkoutInfoData.newBuilder();
            if (newBuilder.address != null) {
                newBuilder.address = AddressData.ADAPTER.redact(newBuilder.address);
            }
            Internal.redactElements(newBuilder.payment, PaymentData.ADAPTER);
            Internal.redactElements(newBuilder.paylist, PaylistData.ADAPTER);
            Internal.redactElements(newBuilder.shipmentlist, ShipmentlistData.ADAPTER);
            Internal.redactElements(newBuilder.delivertime, DelivertimeData.ADAPTER);
            Internal.redactElements(newBuilder.invoice, InvoiceData.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
