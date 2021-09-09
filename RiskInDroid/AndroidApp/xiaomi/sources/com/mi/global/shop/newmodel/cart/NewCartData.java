package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewCartData {
    @SerializedName("ActDiscountMin")
    public String ActDiscountMin;
    @SerializedName("CartActivityDiscountMoney")
    public String CartActivityDiscountMoney;
    @SerializedName("CartOrderMoney")
    public String CartOrderMoney;
    @SerializedName("CartPostFreeBalance")
    public float CartPostFreeBalance;
    @SerializedName("CartProductMoney")
    public String CartProductMoney;
    @SerializedName("activityDiscountMoney")
    public String activityDiscountMoney;
    @SerializedName("activityDiscountMoney_txt")
    public String activityDiscountMoney_txt;
    @SerializedName("activitys")
    public NewCartActivity activitys;
    @SerializedName("appConfig")
    public NewCartAppConfig appConfig;
    @SerializedName("bargains")
    public ArrayList<NewCartBargainItem> bargains = new ArrayList<>();
    @SerializedName("gatherorder_info")
    public NewCartGatherOrderInfo gatherorder_info;
    @SerializedName("items")
    public ArrayList<NewCartItem> items = new ArrayList<>();
    @SerializedName("orderMoney")
    public String orderMoney;
    @SerializedName("orderMoney_txt")
    public String orderMoney_txt;
    @SerializedName("pagemsg")
    public NewPageMessage pagemsg;
    @SerializedName("postFree")
    public boolean postFree;
    @SerializedName("postFreeBalance")
    public float postFreeBalance;
    @SerializedName("postFreeBalance_txt")
    public String postFreeBalance_txt;
    @SerializedName("productMoney")
    public String productMoney;
    @SerializedName("productMoney_txt")
    public String productMoney_txt;
    @SerializedName("total")
    public int total;
    @SerializedName("totalWithoutGift")
    public int totalWithoutGift;
    @SerializedName("totalprice")
    public String totalprice;

    public static NewCartData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartData decode(ProtoReader protoReader) throws IOException {
        NewCartData newCartData = new NewCartData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 2:
                        newCartData.items.add(NewCartItem.decode(protoReader));
                        break;
                    case 3:
                        newCartData.postFree = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 4:
                    case 5:
                    case 7:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    case 11:
                    case 13:
                    case 17:
                    case 21:
                    case 22:
                    case 25:
                    case 26:
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                    case 6:
                        newCartData.productMoney = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newCartData.activityDiscountMoney = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newCartData.orderMoney = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newCartData.ActDiscountMin = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 14:
                        newCartData.total = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newCartData.totalWithoutGift = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 16:
                        newCartData.totalprice = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 18:
                        newCartData.activitys = NewCartActivity.decode(protoReader);
                        break;
                    case 19:
                        newCartData.appConfig = NewCartAppConfig.decode(protoReader);
                        break;
                    case 20:
                        newCartData.bargains.add(NewCartBargainItem.decode(protoReader));
                        break;
                    case 23:
                        newCartData.postFreeBalance = ProtoAdapter.FLOAT.decode(protoReader).floatValue();
                        break;
                    case 24:
                        newCartData.gatherorder_info = NewCartGatherOrderInfo.decode(protoReader);
                        break;
                    case 27:
                        newCartData.productMoney_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 28:
                        newCartData.orderMoney_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 29:
                        newCartData.activityDiscountMoney_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 30:
                        newCartData.postFreeBalance_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 31:
                        newCartData.pagemsg = NewPageMessage.decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newCartData;
            }
        }
    }
}
