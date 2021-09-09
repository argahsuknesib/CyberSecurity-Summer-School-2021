package _m_j;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002R/\u0010\u0003\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "bindTagInfos", "Landroidx/lifecycle/MutableLiveData;", "", "Lkotlin/Pair;", "", "Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel$TagBindInfo;", "getBindTagInfos", "()Landroidx/lifecycle/MutableLiveData;", "editMode", "", "getEditMode", "TagBindInfo", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ddw extends fm {

    /* renamed from: O000000o  reason: collision with root package name */
    public final fg<Boolean> f14527O000000o = new fg<>();
    public final fg<List<Pair<String, List<O000000o>>>> O00000Oo = new fg<>();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel$TagBindInfo;", "", "tag_id", "", "tag_name", "dev_id", "isHidMode", "", "isDevRemoved", "dev_name", "room_name", "dev_model", "tag_model", "isTagOnline", "isDevOnline", "homeId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getDev_id", "()Ljava/lang/String;", "getDev_model", "getDev_name", "getHomeId", "()Z", "getRoom_name", "getTag_id", "getTag_model", "getTag_name", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f14528O000000o;
        public final String O00000Oo;
        public final boolean O00000o;
        public final String O00000o0;
        public final boolean O00000oO;
        public final String O00000oo;
        public final String O0000O0o;
        public final String O0000OOo;
        public final boolean O0000Oo;
        public final String O0000Oo0;
        public final boolean O0000OoO;
        public final String O0000Ooo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            return ixe.O000000o(this.f14528O000000o, o000000o.f14528O000000o) && ixe.O000000o(this.O00000Oo, o000000o.O00000Oo) && ixe.O000000o(this.O00000o0, o000000o.O00000o0) && this.O00000o == o000000o.O00000o && this.O00000oO == o000000o.O00000oO && ixe.O000000o(this.O00000oo, o000000o.O00000oo) && ixe.O000000o(this.O0000O0o, o000000o.O0000O0o) && ixe.O000000o(this.O0000OOo, o000000o.O0000OOo) && ixe.O000000o(this.O0000Oo0, o000000o.O0000Oo0) && this.O0000Oo == o000000o.O0000Oo && this.O0000OoO == o000000o.O0000OoO && ixe.O000000o(this.O0000Ooo, o000000o.O0000Ooo);
        }

        public final int hashCode() {
            int hashCode = ((((this.f14528O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode()) * 31;
            boolean z = this.O00000o;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            boolean z2 = this.O00000oO;
            if (z2) {
                z2 = true;
            }
            int i2 = (i + (z2 ? 1 : 0)) * 31;
            String str = this.O00000oo;
            int i3 = 0;
            int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.O0000O0o;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.O0000OOo;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            int hashCode4 = (((hashCode3 + i3) * 31) + this.O0000Oo0.hashCode()) * 31;
            boolean z3 = this.O0000Oo;
            if (z3) {
                z3 = true;
            }
            int i4 = (hashCode4 + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.O0000OoO;
            if (z4) {
                z4 = true;
            }
            return ((i4 + (z4 ? 1 : 0)) * 31) + this.O0000Ooo.hashCode();
        }

        public final String toString() {
            return "TagBindInfo(tag_id=" + this.f14528O000000o + ", tag_name=" + this.O00000Oo + ", dev_id=" + this.O00000o0 + ", isHidMode=" + this.O00000o + ", isDevRemoved=" + this.O00000oO + ", dev_name=" + ((Object) this.O00000oo) + ", room_name=" + ((Object) this.O0000O0o) + ", dev_model=" + ((Object) this.O0000OOo) + ", tag_model=" + this.O0000Oo0 + ", isTagOnline=" + this.O0000Oo + ", isDevOnline=" + this.O0000OoO + ", homeId=" + this.O0000Ooo + ')';
        }

        public O000000o(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7, boolean z3, boolean z4, String str8) {
            ixe.O00000o(str, "tag_id");
            ixe.O00000o(str2, "tag_name");
            ixe.O00000o(str3, "dev_id");
            ixe.O00000o(str7, "tag_model");
            ixe.O00000o(str8, "homeId");
            this.f14528O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
            this.O00000o = z;
            this.O00000oO = z2;
            this.O00000oo = str4;
            this.O0000O0o = str5;
            this.O0000OOo = str6;
            this.O0000Oo0 = str7;
            this.O0000Oo = z3;
            this.O0000OoO = z4;
            this.O0000Ooo = str8;
        }
    }
}
