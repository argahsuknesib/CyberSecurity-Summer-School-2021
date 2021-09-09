package _m_j;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class oOOO0oOO {
    public Bundle O000000o() {
        return null;
    }

    public static oOOO0oOO O000000o(Activity activity, View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new O000000o(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
        }
        return new oOOO0oOO();
    }

    static class O000000o extends oOOO0oOO {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ActivityOptions f2321O000000o;

        O000000o(ActivityOptions activityOptions) {
            this.f2321O000000o = activityOptions;
        }

        public final Bundle O000000o() {
            return this.f2321O000000o.toBundle();
        }
    }

    protected oOOO0oOO() {
    }
}
