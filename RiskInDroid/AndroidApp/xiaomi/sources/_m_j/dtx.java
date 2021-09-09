package _m_j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collection;

public final class dtx {
    public static <V> boolean O000000o(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static TextView O000000o(View view) {
        while (!(view instanceof TextView)) {
            if (!(view instanceof ViewGroup)) {
                return null;
            }
            view = ((ViewGroup) view).getChildAt(0);
        }
        return (TextView) view;
    }

    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
