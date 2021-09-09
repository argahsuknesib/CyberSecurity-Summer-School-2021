package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.mi.global.shop.newmodel.user.address.NewRegionItem;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewCheckoutData {
    @SerializedName("address_list")
    public String addressList;
    @SerializedName("cart_info")
    public NewCheckoutCartInfo cartInfo;
    @SerializedName("checkoutInfo")
    public NewCheckoutInfo checkoutInfo;
    @SerializedName("coupon_list")
    public String couponList;
    @SerializedName("couponsCount")
    public int couponsCount;
    @SerializedName("currency")
    public String currency;
    @SerializedName("exchange_coupon_count")
    public int exchange_coupon_count;
    @SerializedName("exchange_coupon_list")
    public String exchange_coupon_list;
    @SerializedName("exchange_deny_reason")
    public String exchange_deny_reason;
    @SerializedName("gstin")
    public boolean gstin;
    @SerializedName("needGoBack")
    public boolean needGoBack;
    @SerializedName("needVcode")
    public boolean needVcode;
    @SerializedName("pagemsg")
    public NewPageMessage pagemsg;
    @SerializedName("region")
    public ArrayList<NewRegionItem> region = new ArrayList<>();
    @SerializedName("shipment_expense")
    public String shipmentExpense;
    @SerializedName("shipment_expense_txt")
    public String shipmentExpenseTxt;
    @SerializedName("totalpay_txt")
    public String totalPayTxt;
    @SerializedName("totalpay")
    public String totalpay;
    @SerializedName("userInfoUrl")
    public String userInfoUrl;

    public static NewCheckoutData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCheckoutData decode(ProtoReader protoReader) throws IOException {
        NewCheckoutData newCheckoutData = new NewCheckoutData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newCheckoutData.checkoutInfo = NewCheckoutInfo.decode(protoReader);
                        break;
                    case 2:
                        newCheckoutData.totalpay = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newCheckoutData.totalPayTxt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newCheckoutData.shipmentExpense = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newCheckoutData.shipmentExpenseTxt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newCheckoutData.couponList = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newCheckoutData.couponsCount = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newCheckoutData.userInfoUrl = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newCheckoutData.region.add(NewRegionItem.decode(protoReader));
                        break;
                    case 10:
                        newCheckoutData.currency = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newCheckoutData.needVcode = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newCheckoutData.addressList = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 13:
                        newCheckoutData.needGoBack = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 14:
                        newCheckoutData.cartInfo = NewCheckoutCartInfo.decode(protoReader);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newCheckoutData.pagemsg = NewPageMessage.decode(protoReader);
                        break;
                    case 16:
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                    case 17:
                        newCheckoutData.gstin = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 18:
                        newCheckoutData.exchange_coupon_list = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 19:
                        newCheckoutData.exchange_deny_reason = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 20:
                        newCheckoutData.exchange_coupon_count = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newCheckoutData;
            }
        }
    }
}
