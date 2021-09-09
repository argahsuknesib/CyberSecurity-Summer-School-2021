package _m_j;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

public final class hnk {

    /* renamed from: O000000o  reason: collision with root package name */
    public View f19094O000000o;
    int O00000Oo;
    public O000000o O00000o0;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public hnk(Activity activity) {
        this.f19094O000000o = activity.getWindow().getDecorView();
        this.f19094O000000o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class _m_j.hnk.AnonymousClass1 */

            public final void onGlobalLayout() {
                Rect rect = new Rect();
                hnk.this.f19094O000000o.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                System.out.println(String.valueOf(height));
                if (hnk.this.O00000Oo == 0) {
                    hnk.this.O00000Oo = height;
                } else if (hnk.this.O00000Oo != height) {
                    if (hnk.this.O00000Oo - height > 200) {
                        if (hnk.this.O00000o0 != null) {
                            hnk.this.O00000o0.O000000o();
                        }
                        hnk.this.O00000Oo = height;
                    } else if (height - hnk.this.O00000Oo > 200) {
                        if (hnk.this.O00000o0 != null) {
                            hnk.this.O00000o0.O00000Oo();
                        }
                        hnk.this.O00000Oo = height;
                    }
                }
            }
        });
    }
}
