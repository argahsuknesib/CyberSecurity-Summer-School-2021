package _m_j;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

public final class byr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Typeface f13413O000000o;
    public static Typeface O00000Oo;
    public static Typeface O00000o0;

    public static void O000000o(TextView textView, Context context) {
        try {
            if (f13413O000000o == null) {
                f13413O000000o = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Regular.ttf");
            }
            if (O00000Oo == null) {
                O00000Oo = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Bold.ttf");
            }
            if (O00000o0 == null) {
                O00000o0 = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Italic.ttf");
            }
            Typeface typeface = textView.getTypeface();
            if (typeface == null) {
                textView.setTypeface(f13413O000000o);
            }
            if (typeface != null && typeface.getStyle() == 2) {
                textView.setTypeface(O00000o0);
            } else if (typeface.getStyle() == 1) {
                textView.setTypeface(O00000Oo);
            } else {
                textView.setTypeface(f13413O000000o);
            }
        } catch (Exception e) {
            String name = context.getClass().getName();
            Log.e(name, "Unable to load typeface: " + e.getMessage());
        }
    }
}
