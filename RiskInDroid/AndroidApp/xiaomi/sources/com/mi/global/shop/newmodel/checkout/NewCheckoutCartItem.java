package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewCheckoutCartItem {
    @SerializedName("commodity_id")
    public String commodity_id;
    @SerializedName("getType")
    public String getType;
    @SerializedName("goodsId")
    public String goodsId;
    @SerializedName("goods_dealer")
    public String goods_dealer;
    @SerializedName("image_url")
    public String imageUrl;
    @SerializedName("isInsurance")
    public boolean isInsurance;
    @SerializedName("itemId")
    public String itemId;
    @SerializedName("item_timeout")
    public boolean item_timeout;
    @SerializedName("product_name")
    public String name;
    @SerializedName("num")
    public int num;
    @SerializedName("salePrice_txt")
    public String price;
    @SerializedName("properties")
    public NewCheckoutCartProperty properties;
    @SerializedName("salePrice")
    public String salePrice;
    @SerializedName("showType")
    public String showType;
    @SerializedName("subtotal")
    public String subtotal;
    @SerializedName("subtotal_txt")
    public String total;
    @SerializedName("item_type_name")
    public String type;

    public static NewCheckoutCartItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCheckoutCartItem decode(ProtoReader protoReader) throws IOException {
        NewCheckoutCartItem newCheckoutCartItem = new NewCheckoutCartItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newCheckoutCartItem.itemId = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newCheckoutCartItem.goodsId = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newCheckoutCartItem.getType = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newCheckoutCartItem.num = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 5:
                        newCheckoutCartItem.salePrice = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newCheckoutCartItem.commodity_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newCheckoutCartItem.goods_dealer = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newCheckoutCartItem.subtotal = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newCheckoutCartItem.name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newCheckoutCartItem.imageUrl = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newCheckoutCartItem.showType = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newCheckoutCartItem.item_timeout = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 13:
                        newCheckoutCartItem.type = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 14:
                        newCheckoutCartItem.price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newCheckoutCartItem.total = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 16:
                        newCheckoutCartItem.properties = NewCheckoutCartProperty.decode(protoReader);
                        break;
                    case 17:
                        newCheckoutCartItem.isInsurance = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newCheckoutCartItem;
            }
        }
    }
}
