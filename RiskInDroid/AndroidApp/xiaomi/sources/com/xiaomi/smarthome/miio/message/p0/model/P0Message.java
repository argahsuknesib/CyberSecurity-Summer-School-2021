package com.xiaomi.smarthome.miio.message.p0.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import org.json.JSONObject;

public class P0Message implements Parcelable {
    public static final Parcelable.Creator<P0Message> CREATOR = new Parcelable.Creator<P0Message>() {
        /* class com.xiaomi.smarthome.miio.message.p0.model.P0Message.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new P0Message[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new P0Message(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9728O000000o;
    public String O00000Oo;
    private String O00000o;
    public MessageRecord O00000o0;
    private String O00000oO;
    private long O00000oo;

    public int describeContents() {
        return 0;
    }

    public static P0Message O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        P0Message p0Message = new P0Message();
        try {
            p0Message.f9728O000000o = jSONObject.optString("did");
            p0Message.O00000o = jSONObject.optString("homeId");
            p0Message.O00000oO = jSONObject.optString("roomId");
            p0Message.O00000Oo = jSONObject.optString("title");
            p0Message.O00000oo = jSONObject.optLong("timestamp");
            if (!jSONObject.isNull("message")) {
                p0Message.O00000o0 = new MessageRecord();
                MessageRecord.parse(jSONObject.optJSONObject("message"), p0Message.O00000o0);
            }
            return p0Message;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final long O000000o() {
        return this.O00000oo * 1000;
    }

    public P0Message() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9728O000000o);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000Oo);
        parcel.writeLong(this.O00000oo);
        parcel.writeParcelable(this.O00000o0, i);
    }

    protected P0Message(Parcel parcel) {
        this.f9728O000000o = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000oo = parcel.readLong();
        this.O00000o0 = (MessageRecord) parcel.readParcelable(MessageRecord.class.getClassLoader());
    }
}
