package com.xiaomi.smarthome.newui.widget.topnavi;

import _m_j.fnn;
import _m_j.gfz;
import _m_j.ggb;
import _m_j.gge;
import _m_j.ggh;
import _m_j.gsy;
import _m_j.hfz;
import _m_j.iuo;
import _m_j.ixe;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000e\u001a\u00020\tHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "name", "", "id", "isCategory", "", "wallpaper", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "Classify", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PageBean implements Parcelable {
    public static final O000000o CREATOR = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f10340O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final boolean O00000o0;

    public static final PageBean O000000o() {
        return O000000o.O000000o();
    }

    public static final PageBean O00000Oo() {
        return O000000o.O00000o0();
    }

    public static final PageBean O00000o0() {
        return O000000o.O00000o();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageBean)) {
            return false;
        }
        PageBean pageBean = (PageBean) obj;
        return ixe.O000000o(this.f10340O000000o, pageBean.f10340O000000o) && ixe.O000000o(this.O00000Oo, pageBean.O00000Oo) && this.O00000o0 == pageBean.O00000o0 && ixe.O000000o(this.O00000o, pageBean.O00000o);
    }

    public final int hashCode() {
        int hashCode = ((this.f10340O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31;
        boolean z = this.O00000o0;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.O00000o;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "PageBean(name=" + this.f10340O000000o + ", id=" + this.O00000Oo + ", isCategory=" + this.O00000o0 + ", wallpaper=" + ((Object) this.O00000o) + ')';
    }

    private PageBean(String str, String str2, boolean z, String str3) {
        ixe.O00000o(str, "name");
        ixe.O00000o(str2, "id");
        this.f10340O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = z;
        this.O00000o = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageBean(String str, String str2, boolean z, String str3, int i) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean$Classify;", "", "title", "", "pages", "", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "(Ljava/lang/String;Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f10341O000000o;
        public final List<PageBean> O00000Oo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            return ixe.O000000o(this.f10341O000000o, o00000Oo.f10341O000000o) && ixe.O000000o(this.O00000Oo, o00000Oo.O00000Oo);
        }

        public final int hashCode() {
            return (this.f10341O000000o.hashCode() * 31) + this.O00000Oo.hashCode();
        }

        public final String toString() {
            return "Classify(title=" + this.f10341O000000o + ", pages=" + this.O00000Oo + ')';
        }

        public O00000Oo(String str, List<PageBean> list) {
            ixe.O00000o(str, "title");
            ixe.O00000o(list, "pages");
            this.f10341O000000o = str;
            this.O00000Oo = list;
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u001d\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J0\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\u00192\u0006\u0010)\u001a\u00020*H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u000b¨\u0006+"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "()V", "ALL_TYPE", "", "CATEGORY_TYPE", "TAG", "allDefault", "getAllDefault$annotations", "getAllDefault", "()Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "commonDefault", "getCommonDefault$annotations", "getCommonDefault", "defaultRoom", "getDefaultRoom$annotations", "getDefaultRoom", "uncommonDefault", "getUncommonDefault$annotations", "getUncommonDefault", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getCurrentHomeAllRooms", "", "context", "Landroid/content/Context;", "newArray", "", "size", "", "(I)[Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "wrapperCategory", "", "res", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean$Classify;", "wrapperRooms", "rooms", "Lcom/xiaomi/smarthome/homeroom/model/Room;", "isShowCategory", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements Parcelable.Creator<PageBean> {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ixe.O00000o(parcel, "parcel");
            return new PageBean(parcel);
        }

        static void O000000o(ArrayList<O00000Oo> arrayList) {
            DeviceTagInterface<Device> O00000Oo = fnn.O000000o().O00000Oo();
            ixe.O00000Oo(O00000Oo, "getInstance().deviceTagManager");
            Map<String, List<String>> O0000Oo = O00000Oo.O0000Oo(ggb.O00000Oo().O0000OOo());
            if (O0000Oo.isEmpty()) {
                gsy.O00000Oo("PageBean", "wrapperCategory: is not ready");
            } else {
                gsy.O00000Oo("PageBean", "wrapperCategory: is ready");
            }
            Set<Map.Entry<String, List<String>>> entrySet = O0000Oo.entrySet();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry next : entrySet) {
                String str = (String) next.getKey();
                List list = (List) next.getValue();
                DeviceTagInterface.Category O00000o = O00000Oo.O00000o(str);
                if (O00000o != null && !TextUtils.isEmpty(O00000o.id) && !TextUtils.isEmpty(O00000o.name) && list != null && list.size() > 0) {
                    String str2 = O00000o.id;
                    ixe.O00000Oo(str2, "category.id");
                    arrayList2.add(new PageBean(str, str2, true, null, 8));
                }
            }
            if (arrayList2.size() > 0) {
                arrayList.add(new O00000Oo("category_type", arrayList2));
            }
        }

        public static List<PageBean> O000000o(Context context) {
            String str;
            String str2;
            String str3;
            String str4;
            Context context2 = context;
            ixe.O00000o(context2, "context");
            ggh O000000o2 = ggh.O000000o();
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo0 == null || (str = O0000Oo0.getBackground()) == null) {
                str = "";
            }
            int indexOf = O000000o2.f17740O000000o.indexOf(str);
            if (indexOf == 0) {
                str2 = str + "_favorites";
            } else if (indexOf > 0) {
                str2 = str + "_default";
            } else {
                str2 = "style_1_favorites";
            }
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo02 == null || (str3 = O0000Oo02.getIcon()) == null) {
                str3 = "";
            }
            CharSequence charSequence = str3;
            if (charSequence.length() == 0) {
                charSequence = "style_1_favorites";
            }
            String string = context2.getString(R.string.tag_common);
            ixe.O00000Oo(string, "context.getString(R.string.tag_common)");
            List<PageBean> O00000Oo = iuo.O00000Oo(new PageBean(string, "mijia.roomid.common", false, (String) charSequence, 4));
            List<Room> O00000o = ggb.O00000Oo().O00000o();
            ixe.O00000Oo(O00000o, "rooms");
            Iterable<Room> iterable = O00000o;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (Room room : iterable) {
                String name = room.getName();
                ixe.O00000Oo(name, "it.name");
                String id = room.getId();
                ixe.O00000Oo(id, "it.id");
                String background = room.getBackground();
                if (background == null) {
                    background = "";
                }
                if (TextUtils.isEmpty(background)) {
                    str4 = "style_1_favorites";
                } else {
                    str4 = room.getBackground();
                }
                arrayList.add(new PageBean(name, id, false, str4, 4));
            }
            O00000Oo.addAll((List) arrayList);
            String string2 = context2.getString(R.string.tag_unassign);
            ixe.O00000Oo(string2, "context.getString(R.string.tag_unassign)");
            PageBean pageBean = new PageBean(string2, "mijia.roomid.default", false, str2, 4);
            if (!gfz.f17670O000000o.O000000o(pageBean).isEmpty()) {
                O00000Oo.add(pageBean);
            }
            String string3 = context2.getString(R.string.nearby_device);
            ixe.O00000Oo(string3, "context.getString(R.string.nearby_device)");
            PageBean pageBean2 = new PageBean(string3, "mijia.roomid.nearby", false, str2, 4);
            if (!gfz.f17670O000000o.O000000o(pageBean2).isEmpty()) {
                O00000Oo.add(pageBean2);
            }
            String string4 = context2.getString(R.string.tag_share);
            ixe.O00000Oo(string4, "context.getString(R.string.tag_share)");
            PageBean pageBean3 = new PageBean(string4, "mijia.roomid.share", false, str2, 4);
            if (!gfz.f17670O000000o.O000000o(pageBean3).isEmpty()) {
                O00000Oo.add(pageBean3);
            }
            return O00000Oo;
        }

        public static PageBean O000000o() {
            String string = CommonApplication.getAppContext().getString(R.string.tag_common);
            ixe.O00000Oo(string, "getAppContext().getString(R.string.tag_common)");
            hfz hfz = hfz.f18889O000000o;
            return new PageBean(string, "mijia.roomid.common", false, hfz.O00000oO(), 4);
        }

        public static PageBean O00000Oo() {
            String string = CommonApplication.getAppContext().getString(R.string.tag_common);
            ixe.O00000Oo(string, "getAppContext().getString(R.string.tag_common)");
            return new PageBean(string, "mijia.roomid.uncommon", false, null, 12);
        }

        public static PageBean O00000o0() {
            String string = CommonApplication.getAppContext().getString(R.string.tag_mine);
            ixe.O00000Oo(string, "getAppContext().getString(R.string.tag_mine)");
            return new PageBean(string, "mijia.roomid.all", false, null, 12);
        }

        public static PageBean O00000o() {
            String string = CommonApplication.getAppContext().getString(R.string.default_room);
            ixe.O00000Oo(string, "getAppContext().getString(R.string.default_room)");
            return new PageBean(string, "mijia.roomid.default", false, null, 12);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PageBean[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PageBean(Parcel parcel) {
        this(String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), parcel.readByte() != 0, null, 8);
        ixe.O00000o(parcel, "parcel");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ixe.O00000o(parcel, "dest");
        parcel.writeString(this.f10340O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
    }

    public static final List<O00000Oo> O000000o(Context context, List<? extends Room> list) {
        Context context2 = context;
        ixe.O00000o(context2, "context");
        String string = context2.getString(R.string.tag_mine);
        ixe.O00000Oo(string, "context.getString(R.string.tag_mine)");
        PageBean pageBean = new PageBean(string, "mijia.roomid.all", false, null, 12);
        String string2 = context2.getString(R.string.tag_share);
        ixe.O00000Oo(string2, "context.getString(R.string.tag_share)");
        PageBean pageBean2 = new PageBean(string2, "mijia.roomid.share", false, null, 12);
        String string3 = context2.getString(R.string.nearby_device);
        ixe.O00000Oo(string3, "context.getString(R.string.nearby_device)");
        PageBean pageBean3 = new PageBean(string3, "mijia.roomid.nearby", false, null, 12);
        String string4 = context2.getString(R.string.device_add_to_commonuse);
        ixe.O00000Oo(string4, "context.getString(R.string.device_add_to_commonuse)");
        PageBean pageBean4 = new PageBean(string4, "mijia.roomid.common", false, null, 12);
        String string5 = context2.getString(R.string.device_add_to_uncommonuse);
        ixe.O00000Oo(string5, "context.getString(R.string.device_add_to_uncommonuse)");
        PageBean pageBean5 = new PageBean(string5, "mijia.roomid.uncommon", false, null, 12);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(pageBean);
            arrayList2.add(pageBean4);
            arrayList2.add(pageBean5);
            gge.O000000o();
            if (gge.O00000oO().size() > 0) {
                arrayList2.add(pageBean2);
            }
            List<Device> list2 = gge.O000000o().f17734O000000o;
            if (list2 != null && list2.size() > 0) {
                arrayList2.add(pageBean3);
            }
            arrayList.add(new O00000Oo("all_type", arrayList2));
            O000000o.O000000o(arrayList);
        }
        return arrayList;
    }
}
