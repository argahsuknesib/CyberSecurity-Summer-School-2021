package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;

public class cqc extends cpq<View, SurfaceHolder> {
    public static final cpo O0000Oo = cpo.O000000o(cqc.class.getSimpleName());
    private SurfaceView O0000OoO;

    /* access modifiers changed from: protected */
    public final void O000000o(float f, float f2) {
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000oo() {
        return false;
    }

    public cqc(Context context, ViewGroup viewGroup) {
        super(context, viewGroup, null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final View O000000o(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        this.O0000OoO = (SurfaceView) inflate.findViewById(R.id.surface_view);
        SurfaceHolder holder = this.O0000OoO.getHolder();
        holder.setType(3);
        holder.addCallback(new SurfaceHolder.Callback() {
            /* class _m_j.cqc.AnonymousClass1 */
            private boolean O00000Oo = true;

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                cqc.O0000Oo.O000000o(1, "callback:", "surfaceCreated");
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                cqc.O0000Oo.O000000o(1, "callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "firstTime:", Boolean.valueOf(this.O00000Oo));
                if (this.O00000Oo) {
                    cqc.this.O00000Oo(i2, i3);
                    this.O00000Oo = false;
                    return;
                }
                cqc.this.O00000o0(i2, i3);
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cqc.O0000Oo.O000000o(1, "callback:", "surfaceDestroyed");
                cqc.this.O00000o();
                this.O00000Oo = true;
            }
        });
        return inflate.findViewById(R.id.surface_view_root);
    }

    /* access modifiers changed from: package-private */
    public final Class<SurfaceHolder> O000000o() {
        return SurfaceHolder.class;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object O00000Oo() {
        return this.O0000OoO.getHolder();
    }
}
