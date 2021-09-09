package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public final class iog extends ioh {

    /* renamed from: O000000o  reason: collision with root package name */
    private Activity f1516O000000o;

    public iog(Activity activity) {
        this.f1516O000000o = activity;
    }

    public final Context O000000o() {
        return this.f1516O000000o;
    }

    public final void O000000o(Intent intent) {
        try {
            this.f1516O000000o.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O000000o(Intent intent, int i) {
        try {
            this.f1516O000000o.startActivityForResult(intent, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
