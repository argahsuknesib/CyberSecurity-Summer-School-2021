package a.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i extends g {
    public static final Parcelable.Creator<i> CREATOR = new O000000o();
    public List<b> O0000oO;
    public String O0000oOO;

    public i(Parcel parcel) {
        super(parcel);
        this.O0000oO = parcel.createTypedArrayList(b.CREATOR);
        this.O0000oOO = parcel.readString();
    }

    public i(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.O0000oO);
        parcel.writeString(this.O0000oOO);
    }

    public static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new O000000o();

        /* renamed from: O000000o  reason: collision with root package name */
        public String f2615O000000o;
        public String O00000Oo;

        public b() {
        }

        public b(Parcel parcel) {
            this.f2615O000000o = parcel.readString();
            this.O00000Oo = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return this.O00000Oo;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2615O000000o);
            parcel.writeString(this.O00000Oo);
        }

        public class O000000o implements Parcelable.Creator<b> {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new b[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new b(parcel);
            }
        }
    }

    public class O000000o implements Parcelable.Creator<i> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new i[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new i(parcel);
        }
    }

    public void O000000o(String str) {
        super.O000000o(str);
        try {
            this.O0000oO = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            this.O0000oOO = jSONObject.getString("qid");
            JSONArray jSONArray = jSONObject.getJSONArray("vr");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String[] split = jSONArray.getString(i).split("\\|");
                if (split.length == 2) {
                    b bVar = new b();
                    bVar.f2615O000000o = split[0];
                    bVar.O00000Oo = split[1];
                    this.O0000oO.add(bVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
