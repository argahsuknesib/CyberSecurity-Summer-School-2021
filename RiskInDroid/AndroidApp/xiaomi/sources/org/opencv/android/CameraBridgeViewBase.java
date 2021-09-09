package org.opencv.android;

import _m_j.jlm;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.xiaomi.smarthome.R;
import java.util.List;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;

public abstract class CameraBridgeViewBase extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15452O000000o = 0;
    private Bitmap O00000Oo;
    private boolean O00000o;
    private O00000o0 O00000o0;
    private final Object O00000oO = new Object();
    protected int O0000Ooo;
    protected int O0000o = 1;
    protected int O0000o0;
    protected int O0000o00;
    protected int O0000o0O;
    protected float O0000o0o = 0.0f;
    protected boolean O0000oO;
    protected int O0000oO0 = -1;
    protected jlm O0000oOO = null;

    public interface O000000o {
        Mat O000000o();

        Mat O00000Oo();
    }

    public interface O00000Oo {
        Mat O000000o();
    }

    public interface O00000o0 {
        Mat O000000o(O000000o o000000o);

        void O000000o();

        void O000000o(int i, int i2);
    }

    public interface O0000O0o {
        int O000000o(Object obj);

        int O00000Oo(Object obj);
    }

    /* access modifiers changed from: protected */
    public abstract void O00000Oo();

    /* access modifiers changed from: protected */
    public abstract boolean O00000Oo(int i, int i2);

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public CameraBridgeViewBase(Context context, int i) {
        super(context);
        this.O0000oO0 = i;
        getHolder().addCallback(this);
        this.O0000o0O = -1;
        this.O0000o0 = -1;
    }

    public CameraBridgeViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int attributeCount = attributeSet.getAttributeCount();
        Log.d("CameraBridge", "Attr count: " + Integer.valueOf(attributeCount));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.camera_id, R.attr.show_fps});
        if (obtainStyledAttributes.getBoolean(1, false) && this.O0000oOO == null) {
            this.O0000oOO = new jlm();
            this.O0000oOO.O000000o(this.O0000Ooo, this.O0000o00);
        }
        this.O0000oO0 = obtainStyledAttributes.getInt(0, -1);
        getHolder().addCallback(this);
        this.O0000o0O = -1;
        this.O0000o0 = -1;
        obtainStyledAttributes.recycle();
    }

    public void setCameraIndex(int i) {
        this.O0000oO0 = i;
    }

    public class O00000o implements O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        int f15454O000000o = 1;
        private O00000Oo O00000o0;

        public final void O000000o() {
        }

        public final void O000000o(int i, int i2) {
        }

        public O00000o(O00000Oo o00000Oo) {
            this.O00000o0 = o00000Oo;
        }

        public final Mat O000000o(O000000o o000000o) {
            int i = this.f15454O000000o;
            if (i == 1) {
                O00000Oo o00000Oo = this.O00000o0;
                o000000o.O000000o();
                return o00000Oo.O000000o();
            } else if (i != 2) {
                Log.e("CameraBridge", "Invalid frame format! Only RGBA and Gray Scale are supported!");
                return null;
            } else {
                O00000Oo o00000Oo2 = this.O00000o0;
                o000000o.O00000Oo();
                return o00000Oo2.O000000o();
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.d("CameraBridge", "call surfaceChanged event");
        synchronized (this.O00000oO) {
            if (!this.O00000o) {
                this.O00000o = true;
                O000000o();
            } else {
                this.O00000o = false;
                O000000o();
                this.O00000o = true;
                O000000o();
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.O00000oO) {
            this.O00000o = false;
            O000000o();
        }
    }

    public final void O00000o0() {
        synchronized (this.O00000oO) {
            this.O0000oO = true;
            O000000o();
        }
    }

    public final void O00000o() {
        synchronized (this.O00000oO) {
            this.O0000oO = false;
            O000000o();
        }
    }

    public void setCvCameraViewListener(O00000o0 o00000o0) {
        this.O00000o0 = o00000o0;
    }

    public void setCvCameraViewListener(O00000Oo o00000Oo) {
        O00000o o00000o = new O00000o(o00000Oo);
        o00000o.f15454O000000o = this.O0000o;
        this.O00000o0 = o00000o;
    }

    private void O000000o() {
        Log.d("CameraBridge", "call checkCurrentState");
        int i = (!this.O0000oO || !this.O00000o || getVisibility() != 0) ? 0 : 1;
        int i2 = this.f15452O000000o;
        if (i != i2) {
            O00000Oo(i2);
            this.f15452O000000o = i;
            O000000o(this.f15452O000000o);
        }
    }

    private void O000000o(int i) {
        Log.d("CameraBridge", "call processEnterState: ".concat(String.valueOf(i)));
        if (i == 0) {
            O00000o0 o00000o0 = this.O00000o0;
            if (o00000o0 != null) {
                o00000o0.O000000o();
            }
        } else if (i == 1) {
            O00000oo();
            O00000o0 o00000o02 = this.O00000o0;
            if (o00000o02 != null) {
                o00000o02.O000000o(this.O0000Ooo, this.O0000o00);
            }
        }
    }

    private void O00000Oo(int i) {
        Log.d("CameraBridge", "call processExitState: ".concat(String.valueOf(i)));
        if (i == 1) {
            O0000O0o();
        }
    }

    private void O00000oo() {
        Log.d("CameraBridge", "call onEnterStartedState");
        if (!O00000Oo(getWidth(), getHeight())) {
            AlertDialog create = new AlertDialog.Builder(getContext()).create();
            create.setCancelable(false);
            create.setMessage("It seems that you device does not support camera (or it is locked). Application will be closed.");
            create.setButton(-3, "OK", new DialogInterface.OnClickListener() {
                /* class org.opencv.android.CameraBridgeViewBase.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    ((Activity) CameraBridgeViewBase.this.getContext()).finish();
                }
            });
            create.show();
        }
    }

    private void O0000O0o() {
        O00000Oo();
        Bitmap bitmap = this.O00000Oo;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(O000000o o000000o) {
        Mat mat;
        boolean z;
        Canvas lockCanvas;
        O00000o0 o00000o0 = this.O00000o0;
        if (o00000o0 != null) {
            mat = o00000o0.O000000o(o000000o);
        } else {
            mat = o000000o.O000000o();
        }
        if (mat != null) {
            try {
                Utils.O000000o(mat, this.O00000Oo);
            } catch (Exception e) {
                Log.e("CameraBridge", "Mat type: ".concat(String.valueOf(mat)));
                Log.e("CameraBridge", "Bitmap type: " + this.O00000Oo.getWidth() + "*" + this.O00000Oo.getHeight());
                StringBuilder sb = new StringBuilder("Utils.matToBitmap() throws an exception: ");
                sb.append(e.getMessage());
                Log.e("CameraBridge", sb.toString());
                z = false;
            }
        }
        z = true;
        if (z && this.O00000Oo != null && (lockCanvas = getHolder().lockCanvas()) != null) {
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            if (this.O0000o0o != 0.0f) {
                Bitmap bitmap = this.O00000Oo;
                lockCanvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), this.O00000Oo.getHeight()), new Rect((int) ((((float) lockCanvas.getWidth()) - (this.O0000o0o * ((float) this.O00000Oo.getWidth()))) / 2.0f), (int) ((((float) lockCanvas.getHeight()) - (this.O0000o0o * ((float) this.O00000Oo.getHeight()))) / 2.0f), (int) (((((float) lockCanvas.getWidth()) - (this.O0000o0o * ((float) this.O00000Oo.getWidth()))) / 2.0f) + (this.O0000o0o * ((float) this.O00000Oo.getWidth()))), (int) (((((float) lockCanvas.getHeight()) - (this.O0000o0o * ((float) this.O00000Oo.getHeight()))) / 2.0f) + (this.O0000o0o * ((float) this.O00000Oo.getHeight())))), (Paint) null);
            } else {
                Bitmap bitmap2 = this.O00000Oo;
                lockCanvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), this.O00000Oo.getHeight()), new Rect((lockCanvas.getWidth() - this.O00000Oo.getWidth()) / 2, (lockCanvas.getHeight() - this.O00000Oo.getHeight()) / 2, ((lockCanvas.getWidth() - this.O00000Oo.getWidth()) / 2) + this.O00000Oo.getWidth(), ((lockCanvas.getHeight() - this.O00000Oo.getHeight()) / 2) + this.O00000Oo.getHeight()), (Paint) null);
            }
            jlm jlm = this.O0000oOO;
            if (jlm != null) {
                if (!jlm.O0000O0o) {
                    jlm.O00000Oo = 0;
                    jlm.O00000o0 = Core.getTickFrequency();
                    jlm.O00000o = Core.getTickCount();
                    jlm.O00000oO = "";
                    jlm.O00000oo = new Paint();
                    jlm.O00000oo.setColor(-16776961);
                    jlm.O00000oo.setTextSize(20.0f);
                    jlm.O0000O0o = true;
                } else {
                    jlm.O00000Oo++;
                    if (jlm.O00000Oo % 20 == 0) {
                        long tickCount = Core.getTickCount();
                        double d = (double) (tickCount - jlm.O00000o);
                        Double.isNaN(d);
                        double d2 = (jlm.O00000o0 * 20.0d) / d;
                        jlm.O00000o = tickCount;
                        if (jlm.O0000OOo == 0 || jlm.O0000Oo0 == 0) {
                            jlm.O00000oO = jlm.f1924O000000o.format(d2) + " FPS";
                        } else {
                            jlm.O00000oO = jlm.f1924O000000o.format(d2) + " FPS@" + Integer.valueOf(jlm.O0000OOo) + "x" + Integer.valueOf(jlm.O0000Oo0);
                        }
                        Log.i("FpsMeter", jlm.O00000oO);
                    }
                }
                jlm jlm2 = this.O0000oOO;
                Log.d("FpsMeter", jlm2.O00000oO);
                lockCanvas.drawText(jlm2.O00000oO, 20.0f, 30.0f, jlm2.O00000oo);
            }
            getHolder().unlockCanvasAndPost(lockCanvas);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000oO() {
        this.O00000Oo = Bitmap.createBitmap(this.O0000Ooo, this.O0000o00, Bitmap.Config.ARGB_8888);
    }

    /* access modifiers changed from: protected */
    public final Size O000000o(List<?> list, O0000O0o o0000O0o, int i, int i2) {
        int i3 = this.O0000o0O;
        if (i3 != -1 && i3 < i) {
            i = i3;
        }
        int i4 = this.O0000o0;
        if (i4 != -1 && i4 < i2) {
            i2 = i4;
        }
        int i5 = 0;
        int i6 = 0;
        for (Object next : list) {
            int O000000o2 = o0000O0o.O000000o(next);
            int O00000Oo2 = o0000O0o.O00000Oo(next);
            if (O000000o2 <= i && O00000Oo2 <= i2 && O000000o2 >= i5 && O00000Oo2 >= i6) {
                i6 = O00000Oo2;
                i5 = O000000o2;
            }
        }
        return new Size((double) i5, (double) i6);
    }
}
