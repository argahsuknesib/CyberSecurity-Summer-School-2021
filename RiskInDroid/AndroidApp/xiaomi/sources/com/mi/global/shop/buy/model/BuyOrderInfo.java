package com.mi.global.shop.buy.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BuyOrderInfo implements Parcelable {
    public static final Parcelable.Creator<BuyOrderInfo> CREATOR = new Parcelable.Creator<BuyOrderInfo>() {
        /* class com.mi.global.shop.buy.model.BuyOrderInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BuyOrderInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BuyOrderInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4863O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public String O0000OoO;
    public ArrayList<BuyOrderItem> O0000Ooo;

    public int describeContents() {
        return 0;
    }

    public BuyOrderInfo() {
    }

    public BuyOrderInfo(JSONObject jSONObject) throws JSONException {
        this.O0000Ooo = new ArrayList<>();
        if (jSONObject != null) {
            JSONArray jSONArray = (JSONArray) jSONObject.get("orderItems");
            this.f4863O000000o = jSONObject.get("order_id").toString();
            this.O00000o0 = jSONObject.get("consignee").toString();
            if (jSONObject.has("zipcode")) {
                this.O0000Oo0 = jSONObject.get("zipcode").toString();
            }
            String[] split = Html.fromHtml(jSONObject.get("address").toString()).toString().split("\\[\\-addr\\-\\]");
            if (split.length >= 3) {
                this.O00000o = split[1] + " " + split[2] + " " + split[0] + " / " + this.O0000Oo0;
            } else if (split.length == 2) {
                this.O00000o = split[1] + " " + split[0] + " / " + this.O0000Oo0;
            } else {
                this.O00000o = split[0] + " / " + this.O0000Oo0;
            }
            this.O00000Oo = jSONObject.get("tel").toString();
            this.O0000O0o = jSONObject.get("goods_amount").toString();
            this.O00000oO = jSONObject.get("reduce_price").toString();
            this.O00000oo = jSONObject.get("shipment_expense").toString();
            this.O0000Oo = jSONObject.get("remaining_time").toString();
            JSONObject optJSONObject = jSONObject.optJSONObject("exchange_coupon");
            if (optJSONObject != null) {
                this.O0000OoO = optJSONObject.getString("amount");
            }
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    BuyOrderItem buyOrderItem = new BuyOrderItem();
                    buyOrderItem.O00000Oo = jSONObject2.get("product_count").toString();
                    buyOrderItem.f4864O000000o = jSONObject2.get("product_name").toString();
                    buyOrderItem.O00000oO = jSONObject2.get("product_id").toString();
                    buyOrderItem.O0000O0o = jSONObject2.get("goods_id").toString();
                    buyOrderItem.O00000o = jSONObject2.get("price").toString();
                    buyOrderItem.O00000o0 = jSONObject2.get("subtotal").toString();
                    buyOrderItem.O00000oo = jSONObject2.get("product_count").toString();
                    this.O0000Ooo.add(buyOrderItem);
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4863O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeList(this.O0000Ooo);
    }

    protected BuyOrderInfo(Parcel parcel) {
        this.f4863O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = new ArrayList<>();
        parcel.readList(this.O0000Ooo, BuyOrderItem.class.getClassLoader());
    }
}
