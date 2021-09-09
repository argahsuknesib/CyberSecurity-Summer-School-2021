package _m_j;

import android.text.Layout;
import android.text.Spannable;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class hww {

    /* renamed from: O000000o  reason: collision with root package name */
    WeakReference<hwv> f931O000000o;

    public final hwv O000000o(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(y + textView.getScrollY());
        float f = (float) scrollX;
        try {
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
            if (f < layout.getLineLeft(lineForVertical) || f > layout.getLineRight(lineForVertical)) {
                offsetForHorizontal = -1;
            }
            hwv[] hwvArr = (hwv[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, hwv.class);
            if (hwvArr.length > 0) {
                return hwvArr[0];
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            Log.d(toString(), "getPressedSpan", e);
            return null;
        }
    }
}
