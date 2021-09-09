package _m_j;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class hwx extends LinkMovementMethod {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hwx f932O000000o;
    private static hww O00000Oo = new hww();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r4 != null) goto L_0x0036;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d0  */
    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        boolean z;
        hww hww = O00000Oo;
        if (motionEvent.getAction() == 0) {
            hwv O000000o2 = hww.O000000o(textView, spannable, motionEvent);
            if (O000000o2 != null) {
                O000000o2.O000000o(true);
                Selection.setSelection(spannable, spannable.getSpanStart(O000000o2), spannable.getSpanEnd(O000000o2));
                hww.f931O000000o = new WeakReference<>(O000000o2);
            }
            if (textView instanceof hwu) {
                ((hwu) textView).setTouchSpanHit(O000000o2 != null);
            }
        } else {
            if (motionEvent.getAction() == 2) {
                hwv O000000o3 = hww.O000000o(textView, spannable, motionEvent);
                hwv hwv = hww.f931O000000o != null ? hww.f931O000000o.get() : null;
                if (!(hwv == null || hwv == O000000o3)) {
                    hwv.O000000o(false);
                    hww.f931O000000o = null;
                    Selection.removeSelection(spannable);
                    hwv = null;
                }
                if (textView instanceof hwu) {
                    ((hwu) textView).setTouchSpanHit(hwv != null);
                }
            } else if (motionEvent.getAction() == 1) {
                hwv hwv2 = hww.f931O000000o != null ? hww.f931O000000o.get() : null;
                if (hwv2 != null) {
                    hwv2.O000000o(false);
                    if (motionEvent.getAction() == 1) {
                        hwv2.onClick(textView);
                    }
                    z = true;
                } else {
                    z = false;
                }
                hww.f931O000000o = null;
                Selection.removeSelection(spannable);
                if (textView instanceof hwu) {
                    ((hwu) textView).setTouchSpanHit(z);
                }
                return !z || Touch.onTouchEvent(textView, spannable, motionEvent);
            } else {
                hwv hwv3 = hww.f931O000000o != null ? hww.f931O000000o.get() : null;
                if (hwv3 != null) {
                    hwv3.O000000o(false);
                }
                if (textView instanceof hwu) {
                    ((hwu) textView).setTouchSpanHit(false);
                }
                hww.f931O000000o = null;
                Selection.removeSelection(spannable);
            }
            z = false;
            if (!z) {
            }
        }
        z = true;
        if (!z) {
        }
    }

    public static MovementMethod O000000o() {
        if (f932O000000o == null) {
            f932O000000o = new hwx();
        }
        return f932O000000o;
    }
}
