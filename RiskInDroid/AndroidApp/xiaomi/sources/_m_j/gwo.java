package _m_j;

import _m_j.gwm;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "", "()V", "ErrorState", "FaceStatusDataState", "LoadingState", "ToastState", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$LoadingState;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$ToastState;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$ErrorState;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$FaceStatusDataState;", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class gwo {
    public /* synthetic */ gwo(byte b) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$LoadingState;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "()V", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 extends gwo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O00000o0 f18424O000000o = new O00000o0();

        private O00000o0() {
            super((byte) 0);
        }
    }

    private gwo() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$ToastState;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "msgRes", "", "msgStr", "", "(ILjava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "getMsg", "context", "Landroid/content/Context;", "hashCode", "toString", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends gwo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f18423O000000o;
        public final String O00000Oo;

        public O00000o() {
            this(0, null, 3);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000o)) {
                return false;
            }
            O00000o o00000o = (O00000o) obj;
            return this.f18423O000000o == o00000o.f18423O000000o && ixe.O000000o(this.O00000Oo, o00000o.O00000Oo);
        }

        public final int hashCode() {
            return (Integer.valueOf(this.f18423O000000o).hashCode() * 31) + this.O00000Oo.hashCode();
        }

        public final String toString() {
            return "ToastState(msgRes=" + this.f18423O000000o + ", msgStr=" + this.O00000Oo + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private O00000o(int i, String str) {
            super((byte) 0);
            ixe.O00000o(str, "msgStr");
            this.f18423O000000o = i;
            this.O00000Oo = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ O00000o(int i, String str, int i2) {
            this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$ErrorState;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends gwo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Throwable f18421O000000o;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof O000000o) && ixe.O000000o(this.f18421O000000o, ((O000000o) obj).f18421O000000o);
        }

        public final int hashCode() {
            return this.f18421O000000o.hashCode();
        }

        public final String toString() {
            return "ErrorState(error=" + this.f18421O000000o + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(Throwable th) {
            super((byte) 0);
            ixe.O00000o(th, "error");
            this.f18421O000000o = th;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$FaceStatusDataState;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "data", "", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyApi$FaceStatus;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends gwo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final List<gwm.O000000o> f18422O000000o;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof O00000Oo) && ixe.O000000o(this.f18422O000000o, ((O00000Oo) obj).f18422O000000o);
        }

        public final int hashCode() {
            return this.f18422O000000o.hashCode();
        }

        public final String toString() {
            return "FaceStatusDataState(data=" + this.f18422O000000o + ')';
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List<? extends _m_j.gwm$O000000o>, java.util.List<_m_j.gwm$O000000o>] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O00000Oo(List<? extends gwm.O000000o> r2) {
            super((byte) 0);
            ixe.O00000o(r2, "data");
            this.f18422O000000o = r2;
        }
    }
}
