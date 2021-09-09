package com.xiaomi.smarthome.framework.permission;

import _m_j.fwq;
import _m_j.ixe;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÆ\u0003J<\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bJ\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u001bH\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006'"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "group", "", "", "name", "desc", "isOptional", "", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDesc", "()Ljava/lang/String;", "getGroup", "()[Ljava/lang/String;", "[Ljava/lang/String;", "()Z", "getName", "component1", "component2", "component3", "component4", "copy", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "describeContents", "", "equals", "other", "", "hashCode", "isGranted", "isVirtualPermission", "toString", "writeToParcel", "", "flags", "CREATOR", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PermissionBean implements Parcelable {
    public static final O000000o CREATOR = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public final String[] f8043O000000o;
    public final String O00000Oo;
    final boolean O00000o;
    public final String O00000o0;

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PermissionBean(group=" + Arrays.toString(this.f8043O000000o) + ", name=" + this.O00000Oo + ", desc=" + this.O00000o0 + ", isOptional=" + this.O00000o + ')';
    }

    private PermissionBean(String[] strArr, String str, String str2, boolean z) {
        ixe.O00000o(strArr, "group");
        ixe.O00000o(str, "name");
        ixe.O00000o(str2, "desc");
        this.f8043O000000o = strArr;
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = z;
    }

    public /* synthetic */ PermissionBean(String[] strArr, String str, String str2) {
        this(strArr, str, str2, true);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public PermissionBean(Parcel parcel) {
        this(r0, r1, r2, parcel.readByte() != 0);
        ixe.O00000o(parcel, "parcel");
        String[] createStringArray = parcel.createStringArray();
        ixe.O000000o(createStringArray);
        String readString = parcel.readString();
        ixe.O000000o((Object) readString);
        String readString2 = parcel.readString();
        ixe.O000000o((Object) readString2);
    }

    public final boolean O000000o() {
        return this.f8043O000000o.length == 0;
    }

    public final boolean O00000Oo() {
        String str;
        if (O000000o()) {
            return true;
        }
        String[] strArr = this.f8043O000000o;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = strArr[i];
            if (!fwq.O000000o(str)) {
                break;
            }
            i++;
        }
        if (str == null) {
            return true;
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ixe.O00000o(parcel, "parcel");
        parcel.writeStringArray(this.f8043O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeByte(this.O00000o ? (byte) 1 : 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!ixe.O000000o(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            PermissionBean permissionBean = (PermissionBean) obj;
            return Arrays.equals(this.f8043O000000o, permissionBean.f8043O000000o) && ixe.O000000o(this.O00000Oo, permissionBean.O00000Oo) && ixe.O000000o(this.O00000o0, permissionBean.O00000o0) && this.O00000o == permissionBean.O00000o;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.framework.permission.PermissionBean");
    }

    public final int hashCode() {
        return (((((Arrays.hashCode(this.f8043O000000o) * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode()) * 31) + Boolean.valueOf(this.O00000o).hashCode();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/framework/permission/PermissionBean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/xiaomi/smarthome/framework/permission/PermissionBean;", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements Parcelable.Creator<PermissionBean> {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ixe.O00000o(parcel, "parcel");
            return new PermissionBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PermissionBean[i];
        }
    }
}
