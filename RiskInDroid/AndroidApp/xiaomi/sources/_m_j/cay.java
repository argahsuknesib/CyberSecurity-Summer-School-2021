package _m_j;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

public final class cay {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Typeface f13577O000000o;
    public static Typeface O00000Oo;

    public static void O000000o(TextView textView, Context context) {
        try {
            if (f13577O000000o == null) {
                f13577O000000o = Typeface.createFromAsset(context.getAssets(), "font/Lato-Regular.ttf");
            }
            if (O00000Oo == null) {
                O00000Oo = Typeface.createFromAsset(context.getAssets(), "font/Lato-Bold.ttf");
            }
            Typeface typeface = textView.getTypeface();
            if (typeface == null) {
                textView.setTypeface(f13577O000000o);
            } else if (typeface.getStyle() == 1) {
                textView.setTypeface(O00000Oo);
            } else {
                textView.setTypeface(f13577O000000o);
            }
        } catch (Exception e) {
            String name = context.getClass().getName();
            Log.e(name, "Unable to load typeface: " + e.getMessage());
        }
    }
}
