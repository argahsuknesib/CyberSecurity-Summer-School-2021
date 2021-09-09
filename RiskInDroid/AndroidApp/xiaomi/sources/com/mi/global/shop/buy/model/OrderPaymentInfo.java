package com.mi.global.shop.buy.model;

import _m_j.ccr;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderPaymentInfo implements Parcelable {
    public static final Parcelable.Creator<OrderPaymentInfo> CREATOR = new Parcelable.Creator<OrderPaymentInfo>() {
        /* class com.mi.global.shop.buy.model.OrderPaymentInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OrderPaymentInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OrderPaymentInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4866O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public ArrayList<OrderItem> O0000Oo;
    public String O0000Oo0;
    public String O0000OoO;
    public boolean O0000Ooo = true;
    public String O0000o0 = null;
    public boolean O0000o00 = true;
    public int O0000o0O = 0;
    public int O0000o0o = 0;

    public int describeContents() {
        return 0;
    }

    public OrderPaymentInfo(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("orderInfo")) {
            try {
                O000000o(jSONObject.getJSONObject("orderInfo"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jSONObject != null && jSONObject.has("support")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("support");
                try {
                    if (jSONObject2.has("can_cod")) {
                        if (jSONObject2.getString("can_cod").equals("0")) {
                            this.O0000Ooo = false;
                        }
                    }
                    if (jSONObject2.has("can_onlinepay") && jSONObject2.getString("can_onlinepay").equals("0")) {
                        this.O0000o00 = false;
                    }
                    if (jSONObject2.has("codstatus")) {
                        this.O0000o0 = jSONObject2.getString("codstatus");
                        if (this.O0000o0.equals("needverify")) {
                            this.O0000o0O = 1;
                        } else if (this.O0000o0.equals("noverify")) {
                            this.O0000o0O = 0;
                        } else if (this.O0000o0.equals("notsupport")) {
                            this.O0000o0O = 3;
                        }
                    }
                    if (!this.O0000Ooo) {
                        this.O0000o0O = 3;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009e  */
    private void O000000o(JSONObject jSONObject) {
        JSONArray jSONArray;
        this.O0000Oo = new ArrayList<>();
        if (jSONObject != null) {
            try {
                jSONArray = (JSONArray) jSONObject.get("orderItems");
                try {
                    this.f4866O000000o = jSONObject.get("order_id").toString();
                    this.O00000o = jSONObject.get("consignee").toString();
                    this.O00000oO = jSONObject.get("address").toString().replace("[-addr-]", ",");
                    this.O00000Oo = jSONObject.get("tel").toString();
                    this.O00000o0 = this.O00000Oo;
                    this.O0000OOo = jSONObject.get("goods_amount").toString();
                    this.O00000oo = jSONObject.get("reduce_price").toString();
                    this.O0000O0o = jSONObject.get("shipment_expense").toString();
                    this.O0000OoO = jSONObject.get("remaining_time").toString();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                jSONArray = null;
                ccr.O00000Oo("orderPaymentInfo", "OrderInfo Parse Exception:" + e.toString());
                if (jSONArray == null) {
                }
            }
            if (jSONArray == null) {
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        OrderItem orderItem = new OrderItem();
                        orderItem.O00000Oo = jSONObject2.get("product_count").toString();
                        ccr.O00000Oo("orderPaymentInfo", "product_count is: " + orderItem.O00000Oo);
                        orderItem.f4865O000000o = jSONObject2.get("product_name").toString();
                        ccr.O00000Oo("orderPaymentInfo", "product_name is: " + orderItem.f4865O000000o);
                        orderItem.O00000o0 = jSONObject2.get("subtotal").toString();
                        ccr.O00000Oo("orderPaymentInfo", "subtotal is: " + orderItem.O00000o0);
                        this.O0000Oo.add(orderItem);
                        i++;
                    } catch (Exception e3) {
                        ccr.O00000Oo("orderPaymentInfo", "OrderInfo Parse Exception:" + e3.toString());
                        return;
                    }
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4866O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeList(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeByte(this.O0000Ooo ? (byte) 1 : 0);
        parcel.writeByte(this.O0000o00 ? (byte) 1 : 0);
        parcel.writeString(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
        parcel.writeInt(this.O0000o0o);
    }

    protected OrderPaymentInfo(Parcel parcel) {
        boolean z = true;
        this.f4866O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = new ArrayList<>();
        parcel.readList(this.O0000Oo, OrderItem.class.getClassLoader());
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readByte() != 0;
        this.O0000o00 = parcel.readByte() == 0 ? false : z;
        this.O0000o0 = parcel.readString();
        this.O0000o0O = parcel.readInt();
        this.O0000o0o = parcel.readInt();
    }
}
