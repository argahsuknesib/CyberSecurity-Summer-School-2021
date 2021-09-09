package _m_j;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.mainpage.cache.MainPageCache;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class gpt<P extends Parcelable> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f18130O000000o = "ParcelStoreHelper";
    private String O00000Oo = null;
    private Class<P> O00000o;
    private String O00000o0;

    public final void O000000o(String str) {
        new File(O00000Oo(str)).delete();
    }

    public static byte[] O000000o(List<MainPageCache> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Parcel obtain = Parcel.obtain();
        obtain.writeInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            Parcelable parcelable = list.get(i);
            if (parcelable != null) {
                obtain.writeParcelable(parcelable, 0);
            }
        }
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public final List<P> O000000o(Parcel parcel) {
        if (parcel == null) {
            gsy.O00000Oo(LogType.GENERAL, "ParcelStoreHelper", "parseParcel parcel is null");
            return new ArrayList();
        }
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            Parcelable readParcelable = parcel.readParcelable(this.O00000o.getClassLoader());
            if (readParcelable != null) {
                arrayList.add(readParcelable);
            }
        }
        LogType logType = LogType.GENERAL;
        gsy.O00000Oo(logType, "ParcelStoreHelper", "parseParcel " + arrayList.size());
        return arrayList;
    }

    public gpt(String str, String str2, Class<P> cls) {
        this.O00000Oo = str2;
        this.O00000o0 = str;
        this.O00000o = cls;
    }

    public final String O00000Oo(String str) {
        return CommonApplication.getAppContext().getFilesDir() + File.separator + this.O00000o0 + File.separator + this.O00000Oo + gpp.O000000o(str);
    }
}
