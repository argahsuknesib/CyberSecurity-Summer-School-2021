package _m_j;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;

final class inz implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1511O000000o;

    inz(Context context) {
        this.f1511O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        SipManager newInstance;
        if (!SipManager.isApiSupported(this.f1511O000000o) || (newInstance = SipManager.newInstance(this.f1511O000000o)) == null) {
            return true;
        }
        SipProfile.Builder builder = new SipProfile.Builder("Permission", "127.0.0.1");
        builder.setPassword("password");
        SipProfile build = builder.build();
        newInstance.open(build);
        newInstance.close(build.getUriString());
        return true;
    }
}
