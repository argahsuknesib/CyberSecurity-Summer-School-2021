package _m_j;

import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.Queue;

public final class gab implements fzr<Bitmap> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Queue<Bitmap> f17457O000000o = new LinkedList();

    public final synchronized int O000000o() {
        if (this.f17457O000000o == null) {
            return 0;
        }
        return this.f17457O000000o.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public synchronized Bitmap O00000Oo() {
        if (this.f17457O000000o != null) {
            if (this.f17457O000000o.size() > 0) {
                return this.f17457O000000o.poll();
            }
        }
        return null;
    }

    public final synchronized void O00000o0() {
        if (this.f17457O000000o != null) {
            this.f17457O000000o.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public synchronized void O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public final synchronized void O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            this.f17457O000000o.add(bitmap);
        }
    }
}
