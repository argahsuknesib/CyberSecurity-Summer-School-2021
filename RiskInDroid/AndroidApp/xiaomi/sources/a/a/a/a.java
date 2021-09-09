package a.a.a;

import _m_j.O00o;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import org.json.JSONObject;

public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f2609O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public double O0000OoO;
    public double O0000Ooo;
    public List<String> O0000o;
    public String O0000o0;
    public int O0000o00;
    public int O0000o0O;
    public String O0000o0o;

    public static class O00000Oo {
    }

    public a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public a(Parcel parcel) {
        this.f2609O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readDouble();
        this.O0000Ooo = parcel.readDouble();
        this.O0000o00 = parcel.readInt();
        this.O0000o0 = parcel.readString();
        this.O0000o0O = parcel.readInt();
        this.O0000o0o = parcel.readString();
        this.O0000o = parcel.createStringArrayList();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2609O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeDouble(this.O0000OoO);
        parcel.writeDouble(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
        parcel.writeString(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
        parcel.writeString(this.O0000o0o);
        parcel.writeStringList(this.O0000o);
    }

    public class O000000o implements Parcelable.Creator<a> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new a[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    }

    public final void O000000o(JSONObject jSONObject) {
        jSONObject.put("odmf", this.f2609O000000o);
        jSONObject.put("odi", this.O00000Oo);
        jSONObject.put("odb", this.O00000o0);
        jSONObject.put("odm", this.O00000o);
        jSONObject.put("os", this.O00000oO);
        jSONObject.put("cps", this.O00000oo);
        jSONObject.put("parch", this.O0000O0o);
        jSONObject.put("pcs", this.O0000OOo);
        jSONObject.put("pc_cpu", this.O0000Oo0);
        jSONObject.put("pc_sys", this.O0000Oo);
        jSONObject.put("ram", this.O0000OoO);
        jSONObject.put("ds", this.O0000Ooo);
        jSONObject.put("idr", this.O0000o00);
        jSONObject.put("rsa", this.O0000o0);
        jSONObject.put("esa", this.O0000o0o);
        jSONObject.put("ide", this.O0000o0O);
        List<String> list = this.O0000o;
        jSONObject.put("imei", (list == null || list.isEmpty()) ? "" : O00o.O000000o((String[]) list.toArray(new String[list.size()])));
    }
}
