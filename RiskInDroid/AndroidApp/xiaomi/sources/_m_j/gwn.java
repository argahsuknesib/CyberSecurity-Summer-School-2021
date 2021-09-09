package _m_j;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent;", "", "()V", "LoadFaceStatusEvent", "ToggleFaceSwitchEvent", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent$LoadFaceStatusEvent;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent$ToggleFaceSwitchEvent;", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class gwn {
    public /* synthetic */ gwn(byte b) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent$LoadFaceStatusEvent;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent;", "()V", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends gwn {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f18419O000000o = new O000000o();

        private O000000o() {
            super((byte) 0);
        }
    }

    private gwn() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent$ToggleFaceSwitchEvent;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent;", "did", "", "exceptStatus", "", "(Ljava/lang/String;Z)V", "getDid", "()Ljava/lang/String;", "getExceptStatus", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends gwn {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f18420O000000o;
        final boolean O00000Oo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            return ixe.O000000o(this.f18420O000000o, o00000Oo.f18420O000000o) && this.O00000Oo == o00000Oo.O00000Oo;
        }

        public final int hashCode() {
            int hashCode = this.f18420O000000o.hashCode() * 31;
            boolean z = this.O00000Oo;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public final String toString() {
            return "ToggleFaceSwitchEvent(did=" + this.f18420O000000o + ", exceptStatus=" + this.O00000Oo + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(String str, boolean z) {
            super((byte) 0);
            ixe.O00000o(str, "did");
            this.f18420O000000o = str;
            this.O00000Oo = z;
        }
    }
}
