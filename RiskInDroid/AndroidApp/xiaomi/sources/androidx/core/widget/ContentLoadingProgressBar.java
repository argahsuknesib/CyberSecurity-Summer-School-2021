package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: O000000o  reason: collision with root package name */
    long f2843O000000o;
    boolean O00000Oo;
    boolean O00000o;
    boolean O00000o0;
    private final Runnable O00000oO;
    private final Runnable O00000oo;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2843O000000o = -1;
        this.O00000Oo = false;
        this.O00000o0 = false;
        this.O00000o = false;
        this.O00000oO = new Runnable() {
            /* class androidx.core.widget.ContentLoadingProgressBar.AnonymousClass1 */

            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.O00000Oo = false;
                contentLoadingProgressBar.f2843O000000o = -1;
                contentLoadingProgressBar.setVisibility(8);
            }
        };
        this.O00000oo = new Runnable() {
            /* class androidx.core.widget.ContentLoadingProgressBar.AnonymousClass2 */

            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.O00000o0 = false;
                if (!contentLoadingProgressBar.O00000o) {
                    ContentLoadingProgressBar.this.f2843O000000o = System.currentTimeMillis();
                    ContentLoadingProgressBar.this.setVisibility(0);
                }
            }
        };
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O000000o();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O000000o();
    }

    private void O000000o() {
        removeCallbacks(this.O00000oO);
        removeCallbacks(this.O00000oo);
    }
}
