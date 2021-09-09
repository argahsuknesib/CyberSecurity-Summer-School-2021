package _m_j;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.NotificationCompat;
import android.widget.TextView;

public final class dun {

    /* renamed from: O000000o  reason: collision with root package name */
    static Typeface f14952O000000o;

    public static void O000000o(Context context, TextView textView) {
        if (textView != null && context != null) {
            try {
                if (f14952O000000o == null) {
                    f14952O000000o = Typeface.createFromAsset(context.getAssets(), "Fonts/Avenir.ttf");
                }
                textView.setTypeface(f14952O000000o);
                textView.setPaintFlags(textView.getPaintFlags() | NotificationCompat.FLAG_HIGH_PRIORITY | 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
