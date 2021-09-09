package com.xiaomi.passport.ui.internal;

import _m_j.ixe;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000eB#\b\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "phone", "", "sid", "(Ljava/lang/String;Ljava/lang/String;)V", "activateInfo", "Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;", "(Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;Ljava/lang/String;)V", "(Ljava/lang/String;Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;Ljava/lang/String;)V", "getActivateInfo", "()Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;", "getPhone", "()Ljava/lang/String;", "getSid", "describeContents", "", "getPhoneOrMarkPhone", "writeToParcel", "", "flags", "CREATOR", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class PhoneWrapper implements Parcelable {
    public static final O000000o CREATOR = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f6255O000000o;
    public final ActivatorPhoneInfo O00000Oo;
    public final String O00000o0;

    public final int describeContents() {
        return 0;
    }

    private PhoneWrapper(String str, ActivatorPhoneInfo activatorPhoneInfo, String str2) {
        this.f6255O000000o = str;
        this.O00000Oo = activatorPhoneInfo;
        this.O00000o0 = str2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.os.Bundle, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX WARNING: Illegal instructions before constructor call */
    @SuppressLint({"ParcelClassLoader"})
    public PhoneWrapper(Parcel parcel) {
        this(r2);
        ixe.O00000o0(parcel, "parcel");
        Bundle readBundle = parcel.readBundle();
        ixe.O000000o((Object) readBundle, "parcel.readBundle()");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX WARNING: Illegal instructions before constructor call */
    private PhoneWrapper(Bundle bundle) {
        this(bundle.getString("phone"), (ActivatorPhoneInfo) bundle.getParcelable("activateInfo"), r4);
        ixe.O00000o0(bundle, "bundle");
        String string = bundle.getString("sid");
        ixe.O000000o((Object) string, "bundle.getString(\"sid\")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PhoneWrapper(String str, String str2) {
        this(str, null, str2);
        ixe.O00000o0(str, "phone");
        ixe.O00000o0(str2, "sid");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PhoneWrapper(ActivatorPhoneInfo activatorPhoneInfo, String str) {
        this(null, activatorPhoneInfo, str);
        ixe.O00000o0(activatorPhoneInfo, "activateInfo");
        ixe.O00000o0(str, "sid");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ixe.O00000o0(parcel, "parcel");
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.f6255O000000o);
        bundle.putParcelable("activateInfo", this.O00000Oo);
        bundle.putString("sid", this.O00000o0);
        parcel.writeBundle(bundle);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhoneWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o implements Parcelable.Creator<PhoneWrapper> {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ixe.O00000o0(parcel, "parcel");
            return new PhoneWrapper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PhoneWrapper[i];
        }
    }
}
