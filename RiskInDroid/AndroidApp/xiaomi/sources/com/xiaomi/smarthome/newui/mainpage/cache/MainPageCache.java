package com.xiaomi.smarthome.newui.mainpage.cache;

import _m_j.ixe;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.newui.adapter.MainCameraCardModel;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004By\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\b¢\u0006\u0002\u0010\u0013J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bHÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\bHÆ\u0003J\t\u0010 \u001a\u00020\u000eHÆ\u0003J\t\u0010!\u001a\u00020\u0010HÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\bHÆ\u0003J\u0001\u0010#\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\bHÆ\u0001J\b\u0010$\u001a\u00020\u000eH\u0016J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020\u0010HÖ\u0001J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000eH\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCache;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "commonDeviceModels", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "Lkotlin/collections/ArrayList;", "indicatorPages", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "commonScenes", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "cameraCount", "", "wallpaper", "", "freqCameras", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;ILjava/lang/String;Ljava/util/ArrayList;)V", "getCameraCount", "()I", "getCommonDeviceModels", "()Ljava/util/ArrayList;", "getCommonScenes", "getFreqCameras", "getIndicatorPages", "getWallpaper", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MainPageCache implements Parcelable {
    public static final O000000o CREATOR = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<MainPageDeviceModel> f10249O000000o;
    public final ArrayList<PageBean> O00000Oo;
    public final int O00000o;
    public final ArrayList<CommonUsedScene> O00000o0;
    public final String O00000oO;
    public final ArrayList<MainCameraCardModel> O00000oo;

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MainPageCache)) {
            return false;
        }
        MainPageCache mainPageCache = (MainPageCache) obj;
        return ixe.O000000o(this.f10249O000000o, mainPageCache.f10249O000000o) && ixe.O000000o(this.O00000Oo, mainPageCache.O00000Oo) && ixe.O000000o(this.O00000o0, mainPageCache.O00000o0) && this.O00000o == mainPageCache.O00000o && ixe.O000000o(this.O00000oO, mainPageCache.O00000oO) && ixe.O000000o(this.O00000oo, mainPageCache.O00000oo);
    }

    public final int hashCode() {
        return (((((((((this.f10249O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode()) * 31) + Integer.valueOf(this.O00000o).hashCode()) * 31) + this.O00000oO.hashCode()) * 31) + this.O00000oo.hashCode();
    }

    public final String toString() {
        return "MainPageCache(commonDeviceModels=" + this.f10249O000000o + ", indicatorPages=" + this.O00000Oo + ", commonScenes=" + this.O00000o0 + ", cameraCount=" + this.O00000o + ", wallpaper=" + this.O00000oO + ", freqCameras=" + this.O00000oo + ')';
    }

    public MainPageCache(ArrayList<MainPageDeviceModel> arrayList, ArrayList<PageBean> arrayList2, ArrayList<CommonUsedScene> arrayList3, int i, String str, ArrayList<MainCameraCardModel> arrayList4) {
        ixe.O00000o(arrayList, "commonDeviceModels");
        ixe.O00000o(arrayList2, "indicatorPages");
        ixe.O00000o(arrayList3, "commonScenes");
        ixe.O00000o(str, "wallpaper");
        ixe.O00000o(arrayList4, "freqCameras");
        this.f10249O000000o = arrayList;
        this.O00000Oo = arrayList2;
        this.O00000o0 = arrayList3;
        this.O00000o = i;
        this.O00000oO = str;
        this.O00000oo = arrayList4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MainPageCache(Parcel parcel) {
        this(r2, r3, r4, r5, r6, r9 == null ? new ArrayList() : r9);
        ixe.O00000o(parcel, "parcel");
        ArrayList createTypedArrayList = parcel.createTypedArrayList(MainPageDeviceModel.CREATOR);
        ArrayList arrayList = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
        ArrayList createTypedArrayList2 = parcel.createTypedArrayList(PageBean.CREATOR);
        ArrayList arrayList2 = createTypedArrayList2 == null ? new ArrayList() : createTypedArrayList2;
        ArrayList createTypedArrayList3 = parcel.createTypedArrayList(CommonUsedScene.CREATOR);
        ArrayList arrayList3 = createTypedArrayList3 == null ? new ArrayList() : createTypedArrayList3;
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        ArrayList createTypedArrayList4 = parcel.createTypedArrayList(MainCameraCardModel.CREATOR);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ixe.O00000o(parcel, "parcel");
        parcel.writeTypedList(this.f10249O000000o);
        parcel.writeTypedList(this.O00000Oo);
        parcel.writeTypedList(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeTypedList(this.O00000oo);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCache$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCache;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCache;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements Parcelable.Creator<MainPageCache> {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ixe.O00000o(parcel, "parcel");
            return new MainPageCache(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MainPageCache[i];
        }
    }
}
