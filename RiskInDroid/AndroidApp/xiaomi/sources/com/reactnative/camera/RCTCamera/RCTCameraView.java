package com.reactnative.camera.RCTCamera;

import _m_j.csz;
import _m_j.cta;
import android.content.Context;
import android.hardware.Camera;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;

public class RCTCameraView extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f5476O000000o;
    cta O00000Oo = null;
    private int O00000o = -1;
    private final OrientationEventListener O00000o0;
    private int O00000oO = 1;
    private int O00000oo = 0;
    private String O0000O0o = "high";
    private int O0000OOo = -1;
    private int O0000Oo = 0;
    private int O0000Oo0 = -1;
    private boolean O0000OoO = false;

    public RCTCameraView(Context context) {
        super(context);
        this.f5476O000000o = context;
        csz.O000000o(O00000Oo(context));
        this.O00000o0 = new OrientationEventListener(context) {
            /* class com.reactnative.camera.RCTCamera.RCTCameraView.AnonymousClass1 */

            public final void onOrientationChanged(int i) {
                RCTCameraView rCTCameraView = RCTCameraView.this;
                if (rCTCameraView.O000000o(rCTCameraView.f5476O000000o)) {
                    RCTCameraView.this.O000000o();
                }
            }
        };
        if (this.O00000o0.canDetectOrientation()) {
            this.O00000o0.enable();
        } else {
            this.O00000o0.disable();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        O000000o(i, i2, i3, i4);
    }

    public void onViewAdded(View view) {
        cta cta = this.O00000Oo;
        if (cta != view) {
            removeView(cta);
            addView(this.O00000Oo, 0);
        }
    }

    public void setAspect(int i) {
        this.O00000oO = i;
        O000000o();
    }

    public void setCameraType(int i) {
        cta cta = this.O00000Oo;
        if (cta != null) {
            if (cta.f14330O000000o != i) {
                new Thread(new Runnable(i) {
                    /* class _m_j.cta.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f14331O000000o;

                    {
                        this.f14331O000000o = r2;
                    }

                    public final void run() {
                        cta.this.O00000o0();
                        cta cta = cta.this;
                        cta.f14330O000000o = this.f14331O000000o;
                        cta.O00000Oo();
                    }
                }).start();
            }
            csz.O000000o().O00000oo(i);
            return;
        }
        this.O00000Oo = new cta(this.f5476O000000o, i);
        int i2 = this.O0000Oo0;
        if (-1 != i2) {
            this.O00000Oo.O00000Oo(i2);
        }
        int i3 = this.O0000OOo;
        if (-1 != i3) {
            this.O00000Oo.O000000o(i3);
        }
        int i4 = this.O0000Oo;
        if (i4 != 0) {
            this.O00000Oo.O00000o0(i4);
        }
        cta cta2 = this.O00000Oo;
        cta2.O00000o0 = this.O0000OoO;
        addView(cta2);
    }

    public void setCaptureMode(int i) {
        this.O00000oo = i;
        cta cta = this.O00000Oo;
        if (cta != null) {
            Camera camera = csz.O000000o().O00000Oo.get(Integer.valueOf(cta.f14330O000000o));
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                parameters.setRecordingHint(z);
                camera.setParameters(parameters);
            }
            cta.O00000Oo = i;
        }
    }

    public void setCaptureQuality(String str) {
        this.O0000O0o = str;
        cta cta = this.O00000Oo;
        if (cta != null) {
            csz.O000000o().O000000o(cta.f14330O000000o, str);
        }
    }

    public void setTorchMode(int i) {
        this.O0000OOo = i;
        cta cta = this.O00000Oo;
        if (cta != null) {
            cta.O000000o(i);
        }
    }

    public void setFlashMode(int i) {
        this.O0000Oo0 = i;
        cta cta = this.O00000Oo;
        if (cta != null) {
            cta.O00000Oo(i);
        }
    }

    public void setZoom(int i) {
        this.O0000Oo = i;
        cta cta = this.O00000Oo;
        if (cta != null) {
            cta.O00000o0(i);
        }
    }

    public void setOrientation(int i) {
        csz O000000o2 = csz.O000000o();
        if (O000000o2.O00000oO != i) {
            O000000o2.O00000oO = i;
            O000000o2.O00000oo(1);
            O000000o2.O00000oo(2);
        }
        if (this.O00000Oo != null) {
            O000000o();
        }
    }

    public void setBarcodeScannerEnabled(boolean z) {
        csz.O000000o().O00000o0 = z;
    }

    public void setBarCodeTypes(List<String> list) {
        csz.O000000o().O00000o = list;
    }

    public void setClearWindowBackground(boolean z) {
        this.O0000OoO = z;
        cta cta = this.O00000Oo;
        if (cta != null) {
            cta.O00000o0 = z;
        }
    }

    public final boolean O000000o(Context context) {
        int O00000Oo2 = O00000Oo(context);
        if (this.O00000o == O00000Oo2) {
            return false;
        }
        this.O00000o = O00000Oo2;
        csz O000000o2 = csz.O000000o();
        O000000o2.O00000oo = this.O00000o;
        O000000o2.O00000oo(1);
        O000000o2.O00000oo(2);
        return true;
    }

    private static int O00000Oo(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    public final void O000000o() {
        O000000o(getLeft(), getTop(), getRight(), getBottom());
    }

    private void O000000o(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        double d;
        double d2;
        double d3;
        cta cta = this.O00000Oo;
        if (cta != null) {
            float f = (float) (i3 - i);
            float f2 = (float) (i4 - i2);
            int i7 = this.O00000oO;
            if (i7 == 0) {
                d2 = cta.O000000o();
                double d4 = (double) f2;
                Double.isNaN(d4);
                d = d4 * d2;
                d3 = (double) f;
                if (d < d3) {
                    Double.isNaN(d3);
                    i5 = (int) (d3 / d2);
                    i6 = (int) f;
                    int i8 = (int) ((f - ((float) i6)) / 2.0f);
                    int i9 = (int) ((f2 - ((float) i5)) / 2.0f);
                    csz.O000000o().O000000o(this.O00000Oo.f14330O000000o, (int) f, (int) f2);
                    this.O00000Oo.layout(i8, i9, i6 + i8, i5 + i9);
                    postInvalidate(getLeft(), getTop(), getRight(), getBottom());
                }
                i6 = (int) d;
            } else if (i7 != 1) {
                i6 = (int) f;
            } else {
                d2 = cta.O000000o();
                double d5 = (double) f2;
                Double.isNaN(d5);
                d = d5 * d2;
                d3 = (double) f;
                if (d > d3) {
                    Double.isNaN(d3);
                    i5 = (int) (d3 / d2);
                    i6 = (int) f;
                    int i82 = (int) ((f - ((float) i6)) / 2.0f);
                    int i92 = (int) ((f2 - ((float) i5)) / 2.0f);
                    csz.O000000o().O000000o(this.O00000Oo.f14330O000000o, (int) f, (int) f2);
                    this.O00000Oo.layout(i82, i92, i6 + i82, i5 + i92);
                    postInvalidate(getLeft(), getTop(), getRight(), getBottom());
                }
                i6 = (int) d;
            }
            i5 = (int) f2;
            int i822 = (int) ((f - ((float) i6)) / 2.0f);
            int i922 = (int) ((f2 - ((float) i5)) / 2.0f);
            csz.O000000o().O000000o(this.O00000Oo.f14330O000000o, (int) f, (int) f2);
            this.O00000Oo.layout(i822, i922, i6 + i822, i5 + i922);
            postInvalidate(getLeft(), getTop(), getRight(), getBottom());
        }
    }
}
