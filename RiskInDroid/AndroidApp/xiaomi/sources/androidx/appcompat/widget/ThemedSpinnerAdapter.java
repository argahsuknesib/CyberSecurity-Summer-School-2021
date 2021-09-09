package androidx.appcompat.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Context f2750O000000o;
        private final LayoutInflater O00000Oo;

        public Helper(Context context) {
            this.f2750O000000o = context;
            this.O00000Oo = LayoutInflater.from(context);
        }
    }
}
