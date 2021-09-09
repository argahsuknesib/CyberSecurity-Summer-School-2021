package com.otaliastudios.cameraview;

import _m_j.cpk;
import _m_j.cpl;
import _m_j.cpm;
import _m_j.cpn;
import _m_j.cpo;
import _m_j.cpp;
import _m_j.cpq;
import _m_j.cpr;
import _m_j.cps;
import _m_j.cpt;
import _m_j.cpu;
import _m_j.cpw;
import _m_j.cpy;
import _m_j.cpz;
import _m_j.cqa;
import _m_j.cqb;
import _m_j.cqc;
import _m_j.cqe;
import _m_j.cqf;
import _m_j.ez;
import _m_j.fa;
import _m_j.fi;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.xiaomi.smarthome.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CameraView extends FrameLayout implements ez {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f5372O000000o = "CameraView";
    private static final cpo O00000Oo = cpo.O000000o(CameraView.class.getSimpleName());
    public boolean O00000o;
    public int O00000o0;
    public boolean O00000oO;
    public HashMap<Gesture, GestureAction> O00000oo = new HashMap<>(4);
    O00000Oo O0000O0o;
    public cpq O0000OOo;
    public cpm O0000Oo;
    public cpy O0000Oo0;
    MediaActionSound O0000OoO;
    List<cpn> O0000Ooo = new CopyOnWriteArrayList();
    ScrollGestureLayout O0000o;
    GridLinesLayout O0000o0;
    public List<cpw> O0000o00 = new CopyOnWriteArrayList();
    PinchGestureLayout O0000o0O;
    TapGestureLayout O0000o0o;
    public cqf O0000oO;
    public Handler O0000oO0;
    public cqf O0000oOO;
    private Lifecycle O0000oOo;

    public interface O00000Oo extends cpy.O000000o {
        void O000000o();

        void O000000o(float f, float[] fArr, PointF[] pointFArr);

        void O000000o(float f, PointF[] pointFArr);

        void O000000o(cpp cpp);

        void O000000o(cpu cpu);

        void O000000o(CameraException cameraException);

        void O000000o(Gesture gesture, PointF pointF);

        void O000000o(Gesture gesture, boolean z, PointF pointF);

        void O000000o(File file);

        void O000000o(byte[] bArr, boolean z);

        void O00000Oo();
    }

    private static String O000000o(int i) {
        if (i == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i == 0) {
            return "UNSPECIFIED";
        }
        if (i != 1073741824) {
            return null;
        }
        return "EXACTLY";
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public CameraView(Context context) {
        super(context, null);
        O000000o(context, (AttributeSet) null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        cqa cqa;
        Context context2 = context;
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843038, R.attr.aspectRatio, R.attr.autoFocus, R.attr.cameraAudio, R.attr.cameraCropOutput, R.attr.cameraFacing, R.attr.cameraFlash, R.attr.cameraGestureLongTap, R.attr.cameraGesturePinch, R.attr.cameraGestureScrollHorizontal, R.attr.cameraGestureScrollVertical, R.attr.cameraGestureTap, R.attr.cameraGrid, R.attr.cameraHdr, R.attr.cameraJpegQuality, R.attr.cameraPictureSizeAspectRatio, R.attr.cameraPictureSizeBiggest, R.attr.cameraPictureSizeMaxArea, R.attr.cameraPictureSizeMaxHeight, R.attr.cameraPictureSizeMaxWidth, R.attr.cameraPictureSizeMinArea, R.attr.cameraPictureSizeMinHeight, R.attr.cameraPictureSizeMinWidth, R.attr.cameraPictureSizeSmallest, R.attr.cameraPlaySounds, R.attr.cameraSessionType, R.attr.cameraVideoCodec, R.attr.cameraVideoMaxDuration, R.attr.cameraVideoMaxSize, R.attr.cameraVideoQuality, R.attr.cameraWhiteBalance, R.attr.facing, R.attr.flash}, 0, 0);
        int integer = obtainStyledAttributes.getInteger(14, 100);
        boolean z = obtainStyledAttributes.getBoolean(4, false);
        boolean z2 = obtainStyledAttributes.getBoolean(24, true);
        Facing fromValue = Facing.fromValue(obtainStyledAttributes.getInteger(5, Facing.DEFAULT.value()));
        Flash fromValue2 = Flash.fromValue(obtainStyledAttributes.getInteger(6, Flash.DEFAULT.value()));
        Grid fromValue3 = Grid.fromValue(obtainStyledAttributes.getInteger(12, Grid.DEFAULT.value()));
        WhiteBalance fromValue4 = WhiteBalance.fromValue(obtainStyledAttributes.getInteger(30, WhiteBalance.DEFAULT.value()));
        VideoQuality fromValue5 = VideoQuality.fromValue(obtainStyledAttributes.getInteger(29, VideoQuality.DEFAULT.value()));
        SessionType fromValue6 = SessionType.fromValue(obtainStyledAttributes.getInteger(25, SessionType.DEFAULT.value()));
        Hdr fromValue7 = Hdr.fromValue(obtainStyledAttributes.getInteger(13, Hdr.DEFAULT.value()));
        Audio fromValue8 = Audio.fromValue(obtainStyledAttributes.getInteger(3, Audio.DEFAULT.value()));
        VideoCodec fromValue9 = VideoCodec.fromValue(obtainStyledAttributes.getInteger(26, VideoCodec.DEFAULT.value()));
        Audio audio = fromValue8;
        long j = (long) obtainStyledAttributes.getFloat(28, 0.0f);
        int integer2 = obtainStyledAttributes.getInteger(27, 0);
        ArrayList arrayList = new ArrayList(3);
        if (obtainStyledAttributes.hasValue(22)) {
            i = integer2;
            i2 = 0;
            arrayList.add(cqb.O00000Oo(obtainStyledAttributes.getInteger(22, 0)));
        } else {
            i = integer2;
            i2 = 0;
        }
        if (obtainStyledAttributes.hasValue(19)) {
            arrayList.add(cqb.O000000o(obtainStyledAttributes.getInteger(19, i2)));
        }
        if (obtainStyledAttributes.hasValue(21)) {
            arrayList.add(cqb.O00000o(obtainStyledAttributes.getInteger(21, i2)));
        }
        if (obtainStyledAttributes.hasValue(18)) {
            arrayList.add(cqb.O00000o0(obtainStyledAttributes.getInteger(18, i2)));
        }
        if (obtainStyledAttributes.hasValue(20)) {
            arrayList.add(cqb.O00000oo(obtainStyledAttributes.getInteger(20, i2)));
        }
        if (obtainStyledAttributes.hasValue(17)) {
            arrayList.add(cqb.O00000oO(obtainStyledAttributes.getInteger(17, i2)));
        }
        if (obtainStyledAttributes.hasValue(15)) {
            arrayList.add(cqb.O000000o(cpk.O000000o(obtainStyledAttributes.getString(15))));
        }
        if (obtainStyledAttributes.getBoolean(23, false)) {
            arrayList.add(new cqa() {
                /* class _m_j.cqb.AnonymousClass7 */

                public final List<cpz> O000000o(List<cpz> list) {
                    Collections.sort(list);
                    return list;
                }
            });
        }
        if (obtainStyledAttributes.getBoolean(16, false)) {
            arrayList.add(new cqa() {
                /* class _m_j.cqb.AnonymousClass6 */

                public final List<cpz> O000000o(List<cpz> list) {
                    Collections.sort(list);
                    Collections.reverse(list);
                    return list;
                }
            });
        }
        if (!arrayList.isEmpty()) {
            cqa = cqb.O000000o((cqa[]) arrayList.toArray(new cqa[0]));
        } else {
            cqa = new cqa() {
                /* class _m_j.cqb.AnonymousClass6 */

                public final List<cpz> O000000o(List<cpz> list) {
                    Collections.sort(list);
                    Collections.reverse(list);
                    return list;
                }
            };
        }
        GestureAction fromValue10 = GestureAction.fromValue(obtainStyledAttributes.getInteger(11, GestureAction.DEFAULT_TAP.value()));
        GestureAction fromValue11 = GestureAction.fromValue(obtainStyledAttributes.getInteger(7, GestureAction.DEFAULT_LONG_TAP.value()));
        GestureAction fromValue12 = GestureAction.fromValue(obtainStyledAttributes.getInteger(8, GestureAction.DEFAULT_PINCH.value()));
        GestureAction fromValue13 = GestureAction.fromValue(obtainStyledAttributes.getInteger(9, GestureAction.DEFAULT_SCROLL_HORIZONTAL.value()));
        GestureAction fromValue14 = GestureAction.fromValue(obtainStyledAttributes.getInteger(10, GestureAction.DEFAULT_SCROLL_VERTICAL.value()));
        obtainStyledAttributes.recycle();
        this.O0000O0o = new O000000o();
        this.O0000Oo = O000000o(this.O0000O0o);
        this.O0000oO0 = new Handler(Looper.getMainLooper());
        this.O0000oO = cqf.O000000o("CameraViewWorker");
        this.O0000oOO = cqf.O000000o("FrameProcessorsWorker");
        this.O0000o0 = new GridLinesLayout(context2);
        this.O0000o0O = new PinchGestureLayout(context2);
        this.O0000o0o = new TapGestureLayout(context2);
        this.O0000o = new ScrollGestureLayout(context2);
        addView(this.O0000o0);
        addView(this.O0000o0O);
        addView(this.O0000o0o);
        addView(this.O0000o);
        setCropOutput(z);
        setJpegQuality(integer);
        setPlaySounds(z2);
        setFacing(fromValue);
        setFlash(fromValue2);
        setSessionType(fromValue6);
        setVideoQuality(fromValue5);
        setWhiteBalance(fromValue4);
        setGrid(fromValue3);
        setHdr(fromValue7);
        setAudio(audio);
        setPictureSize(cqa);
        setVideoCodec(fromValue9);
        setVideoMaxSize(j);
        setVideoMaxDuration(i);
        O000000o(Gesture.TAP, fromValue10);
        O000000o(Gesture.LONG_TAP, fromValue11);
        O000000o(Gesture.PINCH, fromValue12);
        O000000o(Gesture.SCROLL_HORIZONTAL, fromValue13);
        O000000o(Gesture.SCROLL_VERTICAL, fromValue14);
        if (!isInEditMode()) {
            this.O0000Oo0 = new cpy(context2, this.O0000O0o);
        }
    }

    private static cpm O000000o(O00000Oo o00000Oo) {
        return new cpl(o00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.O0000OOo == null) {
            Context context = getContext();
            O00000Oo.O000000o(2, "preview:", "isHardwareAccelerated:", Boolean.valueOf(isHardwareAccelerated()));
            this.O0000OOo = isHardwareAccelerated() ? new cqe(context, this) : new cqc(context, this);
            this.O0000Oo.O000000o(this.O0000OOo);
        }
        if (!isInEditMode()) {
            this.O0000Oo0.O000000o(getContext());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            cpy cpy = this.O0000Oo0;
            cpy.f14220O000000o.disable();
            cpy.O00000o = -1;
            cpy.O00000o0 = -1;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        cpz previewSize = getPreviewSize();
        if (previewSize == null) {
            O00000Oo.O000000o(2, "onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean O000O0oO = this.O0000Oo.O000O0oO();
        if (O000O0oO) {
            i3 = previewSize.O00000Oo;
        } else {
            i3 = previewSize.f14222O000000o;
        }
        float f = (float) i3;
        if (O000O0oO) {
            i4 = previewSize.f14222O000000o;
        } else {
            i4 = previewSize.O00000Oo;
        }
        float f2 = (float) i4;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.O0000OOo.O00000oo()) {
            if (mode == 1073741824) {
                mode = Integer.MIN_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = Integer.MIN_VALUE;
            }
        } else {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = 1073741824;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = 1073741824;
            }
        }
        cpo cpo = O00000Oo;
        cpo.O000000o("onMeasure:", "requested dimensions are", "(" + size + "[" + O000000o(mode) + "]x" + size2 + "[" + O000000o(mode2) + "])");
        cpo cpo2 = O00000Oo;
        StringBuilder sb = new StringBuilder("(");
        sb.append(f);
        sb.append("x");
        sb.append(f2);
        sb.append(")");
        cpo2.O000000o("onMeasure:", "previewSize is", sb.toString());
        if (mode == 1073741824 && mode2 == 1073741824) {
            cpo cpo3 = O00000Oo;
            cpo3.O00000Oo("onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", "(" + size + "x" + size2 + ")");
            super.onMeasure(i, i2);
        } else if (mode == 0 && mode2 == 0) {
            cpo cpo4 = O00000Oo;
            cpo4.O000000o("onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + f + "x" + f2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f, 1073741824), View.MeasureSpec.makeMeasureSpec((int) f2, 1073741824));
        } else {
            float f3 = f2 / f;
            if (mode == 0 || mode2 == 0) {
                if (mode == 0) {
                    size = (int) (((float) size2) / f3);
                } else {
                    size2 = (int) (((float) size) * f3);
                }
                cpo cpo5 = O00000Oo;
                cpo5.O000000o("onMeasure:", "one dimension was free, we adapted it to fit the aspect ratio.", "(" + size + "x" + size2 + ")");
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else if (mode == 1073741824 || mode2 == 1073741824) {
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min((int) (((float) size2) / f3), size);
                } else {
                    size2 = Math.min((int) (((float) size) * f3), size2);
                }
                cpo cpo6 = O00000Oo;
                cpo6.O000000o("onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", "(" + size + "x" + size2 + ")");
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else {
                float f4 = (float) size2;
                float f5 = (float) size;
                if (f4 / f5 >= f3) {
                    size2 = (int) (f5 * f3);
                } else {
                    size = (int) (f4 / f3);
                }
                cpo cpo7 = O00000Oo;
                cpo7.O000000o("onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", "(" + size + "x" + size2 + ")");
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }
        }
    }

    private boolean O000000o(Gesture gesture, GestureAction gestureAction) {
        GestureAction gestureAction2 = GestureAction.NONE;
        boolean z = false;
        if (gesture.isAssignableTo(gestureAction)) {
            this.O00000oo.put(gesture, gestureAction);
            int i = AnonymousClass1.f5373O000000o[gesture.ordinal()];
            if (i == 1) {
                PinchGestureLayout pinchGestureLayout = this.O0000o0O;
                if (this.O00000oo.get(Gesture.PINCH) != gestureAction2) {
                    z = true;
                }
                pinchGestureLayout.O000000o(z);
            } else if (i == 2 || i == 3) {
                TapGestureLayout tapGestureLayout = this.O0000o0o;
                if (!(this.O00000oo.get(Gesture.TAP) == gestureAction2 && this.O00000oo.get(Gesture.LONG_TAP) == gestureAction2)) {
                    z = true;
                }
                tapGestureLayout.O000000o(z);
            } else if (i == 4 || i == 5) {
                ScrollGestureLayout scrollGestureLayout = this.O0000o;
                if (!(this.O00000oo.get(Gesture.SCROLL_HORIZONTAL) == gestureAction2 && this.O00000oo.get(Gesture.SCROLL_VERTICAL) == gestureAction2)) {
                    z = true;
                }
                scrollGestureLayout.O000000o(z);
            }
            return true;
        }
        O000000o(gesture, gestureAction2);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!O000000o()) {
            return true;
        }
        cpp O0000oO02 = this.O0000Oo.O0000oO0();
        if (this.O0000o0O.onTouchEvent(motionEvent)) {
            O00000Oo.O000000o(1, "onTouchEvent", "pinch!");
            O000000o(this.O0000o0O, O0000oO02);
        } else if (this.O0000o.onTouchEvent(motionEvent)) {
            O00000Oo.O000000o(1, "onTouchEvent", "scroll!");
            O000000o(this.O0000o, O0000oO02);
        } else if (this.O0000o0o.onTouchEvent(motionEvent)) {
            O00000Oo.O000000o(1, "onTouchEvent", "tap!");
            O000000o(this.O0000o0o, O0000oO02);
        }
        return true;
    }

    private void O000000o(GestureLayout gestureLayout, cpp cpp) {
        Gesture O000000o2 = gestureLayout.O000000o();
        PointF[] O00000Oo2 = gestureLayout.O00000Oo();
        int i = AnonymousClass1.O00000Oo[this.O00000oo.get(O000000o2).ordinal()];
        if (i == 1) {
            this.O0000Oo.O0000OOo();
        } else if (i == 2 || i == 3) {
            this.O0000Oo.O000000o(O000000o2, O00000Oo2[0]);
        } else if (i == 4) {
            float O00oOoOo = this.O0000Oo.O00oOoOo();
            float O000000o3 = gestureLayout.O000000o(O00oOoOo, 0.0f, 1.0f);
            if (O000000o3 != O00oOoOo) {
                this.O0000Oo.O000000o(O000000o3, O00000Oo2, true);
            }
        } else if (i == 5) {
            float O000O0o0 = this.O0000Oo.O000O0o0();
            float f = cpp.O00000oO;
            float f2 = cpp.O00000oo;
            float O000000o4 = gestureLayout.O000000o(O000O0o0, f, f2);
            if (O000000o4 != O000O0o0) {
                this.O0000Oo.O000000o(O000000o4, new float[]{f, f2}, O00000Oo2, true);
            }
        }
    }

    public final boolean O000000o() {
        return this.O0000Oo.O0000o0o() >= 2;
    }

    private boolean O00000Oo() {
        return this.O0000Oo.O0000o0o() == 0;
    }

    public void setLifecycleOwner(fa faVar) {
        Lifecycle lifecycle = this.O0000oOo;
        if (lifecycle != null) {
            lifecycle.O00000Oo(this);
        }
        this.O0000oOo = faVar.getLifecycle();
        this.O0000oOo.O000000o(this);
    }

    @fi(O000000o = Lifecycle.Event.ON_RESUME)
    public void start() {
        if (isEnabled() && O000000o(getSessionType(), getAudio())) {
            this.O0000Oo0.O000000o(getContext());
            this.O0000Oo.O000OO00 = this.O0000Oo0.O00000o;
            this.O0000Oo.O0000Ooo();
        }
    }

    @SuppressLint({"NewApi"})
    private boolean O000000o(SessionType sessionType, Audio audio) {
        O00000Oo(sessionType, audio);
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z = sessionType == SessionType.VIDEO && audio == Audio.ON;
        boolean z2 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z3 = z && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z2 && !z3) {
            return true;
        }
        O000000o(z2, z3);
        return false;
    }

    private void O00000Oo(SessionType sessionType, Audio audio) {
        if (sessionType == SessionType.VIDEO && audio == Audio.ON) {
            try {
                String[] strArr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (!strArr[i].equals("android.permission.RECORD_AUDIO")) {
                        i++;
                    } else {
                        return;
                    }
                }
                O00000Oo.O000000o(3, "Permission error:", "When the session type is set to video,", "the RECORD_AUDIO permission should be added to the app manifest file.");
                throw new IllegalStateException(cpo.f14212O000000o);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_PAUSE)
    public void stop() {
        this.O0000Oo.O0000o00();
    }

    public void set(cps cps) {
        if (cps instanceof Audio) {
            setAudio((Audio) cps);
        } else if (cps instanceof Facing) {
            setFacing((Facing) cps);
        } else if (cps instanceof Flash) {
            setFlash((Flash) cps);
        } else if (cps instanceof Grid) {
            setGrid((Grid) cps);
        } else if (cps instanceof Hdr) {
            setHdr((Hdr) cps);
        } else if (cps instanceof SessionType) {
            setSessionType((SessionType) cps);
        } else if (cps instanceof VideoQuality) {
            setVideoQuality((VideoQuality) cps);
        } else if (cps instanceof WhiteBalance) {
            setWhiteBalance((WhiteBalance) cps);
        } else if (cps instanceof VideoCodec) {
            setVideoCodec((VideoCodec) cps);
        }
    }

    public cpp getCameraOptions() {
        return this.O0000Oo.O0000oO0();
    }

    public cpt getExtraProperties() {
        return this.O0000Oo.O0000o();
    }

    public void setExposureCorrection(float f) {
        cpp cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float f2 = cameraOptions.O00000oO;
            float f3 = cameraOptions.O00000oo;
            if (f < f2) {
                f = f2;
            }
            if (f > f3) {
                f = f3;
            }
            this.O0000Oo.O000000o(f, null, null, false);
        }
    }

    public float getExposureCorrection() {
        return this.O0000Oo.O000O0o0();
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.O0000Oo.O000000o(f, null, false);
    }

    public float getZoom() {
        return this.O0000Oo.O00oOoOo();
    }

    public void setGrid(Grid grid) {
        GridLinesLayout gridLinesLayout = this.O0000o0;
        gridLinesLayout.f5389O000000o = grid;
        gridLinesLayout.postInvalidate();
    }

    public Grid getGrid() {
        return this.O0000o0.f5389O000000o;
    }

    public void setHdr(Hdr hdr) {
        this.O0000Oo.O000000o(hdr);
    }

    public Hdr getHdr() {
        return this.O0000Oo.O00oOooo();
    }

    public void setLocation(Location location) {
        this.O0000Oo.O000000o(location);
    }

    public Location getLocation() {
        return this.O0000Oo.O000O00o();
    }

    public void setWhiteBalance(WhiteBalance whiteBalance) {
        this.O0000Oo.O000000o(whiteBalance);
    }

    public WhiteBalance getWhiteBalance() {
        return this.O0000Oo.O0000oOo();
    }

    public void setFacing(Facing facing) {
        this.O0000Oo.O000000o(facing);
    }

    public Facing getFacing() {
        return this.O0000Oo.O0000oO();
    }

    public void setFlash(Flash flash) {
        this.O0000Oo.O000000o(flash);
    }

    public Flash getFlash() {
        return this.O0000Oo.O0000oOO();
    }

    public void setAudio(Audio audio) {
        if (audio == getAudio() || O00000Oo()) {
            this.O0000Oo.O000000o(audio);
        } else if (O000000o(getSessionType(), audio)) {
            this.O0000Oo.O000000o(audio);
        } else {
            stop();
        }
    }

    public Audio getAudio() {
        return this.O0000Oo.O000O0OO();
    }

    public void setSessionType(SessionType sessionType) {
        if (sessionType == getSessionType() || O00000Oo()) {
            this.O0000Oo.O000000o(sessionType);
        } else if (O000000o(sessionType, getAudio())) {
            this.O0000Oo.O000000o(sessionType);
        } else {
            stop();
        }
    }

    public SessionType getSessionType() {
        return this.O0000Oo.O00oOooO();
    }

    public void setPictureSize(cqa cqa) {
        this.O0000Oo.O000000o(cqa);
    }

    public void setVideoQuality(VideoQuality videoQuality) {
        this.O0000Oo.O000000o(videoQuality);
    }

    public VideoQuality getVideoQuality() {
        return this.O0000Oo.O0000oo0();
    }

    public void setJpegQuality(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException("JPEG quality should be > 0 and <= 100");
        }
        this.O00000o0 = i;
    }

    public int getJpegQuality() {
        return this.O00000o0;
    }

    public void setCropOutput(boolean z) {
        this.O00000o = z;
    }

    public boolean getCropOutput() {
        return this.O00000o;
    }

    @Deprecated
    public void setCameraListener(cpn cpn) {
        this.O0000Ooo.clear();
        O000000o(cpn);
    }

    public final void O000000o(cpn cpn) {
        if (cpn != null) {
            this.O0000Ooo.add(cpn);
        }
    }

    public cpz getPreviewSize() {
        cpm cpm = this.O0000Oo;
        if (cpm != null) {
            return cpm.O000O0o();
        }
        return null;
    }

    public cpz getPictureSize() {
        cpm cpm = this.O0000Oo;
        if (cpm != null) {
            return cpm.O000O0Oo();
        }
        return null;
    }

    public cpz getSnapshotSize() {
        return getPreviewSize();
    }

    @TargetApi(23)
    private void O000000o(boolean z, boolean z2) {
        Activity activity = null;
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add("android.permission.CAMERA");
        }
        if (z2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (activity != null) {
            activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 16);
        }
    }

    public void setPlaySounds(boolean z) {
        this.O00000oO = z && Build.VERSION.SDK_INT >= 16;
        this.O0000Oo.O00000Oo(z);
    }

    public boolean getPlaySounds() {
        return this.O00000oO;
    }

    public void setVideoCodec(VideoCodec videoCodec) {
        this.O0000Oo.O000000o(videoCodec);
    }

    public VideoCodec getVideoCodec() {
        return this.O0000Oo.O0000oo();
    }

    public void setVideoMaxSize(long j) {
        this.O0000Oo.O000000o(j);
    }

    public long getVideoMaxSize() {
        return this.O0000Oo.O0000ooO();
    }

    public void setVideoMaxDuration(int i) {
        this.O0000Oo.O000000o(i);
    }

    public int getVideoMaxDuration() {
        return this.O0000Oo.O0000ooo();
    }

    class O000000o implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public cpo f5374O000000o = cpo.O000000o(O00000Oo.class.getSimpleName());

        O000000o() {
        }

        public final void O000000o(final cpp cpp) {
            this.f5374O000000o.O000000o(1, "dispatchOnCameraOpened", cpp);
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass1 */

                public final void run() {
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O000000o() {
            this.f5374O000000o.O000000o(1, "dispatchOnCameraClosed");
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass7 */

                public final void run() {
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O00000Oo() {
            this.f5374O000000o.O000000o(1, "onCameraPreviewSizeChanged");
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass8 */

                public final void run() {
                    CameraView.this.requestLayout();
                }
            });
        }

        public final void O000000o(final byte[] bArr, final boolean z) {
            this.f5374O000000o.O000000o(1, "processImage");
            CameraView.this.O0000oO.O000000o(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass9 */

                public final void run() {
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    byte[] bArr = bArr;
                    if (CameraView.this.O00000o && CameraView.this.O0000OOo.O00000oO) {
                        cpk O000000o2 = cpk.O000000o(z ? CameraView.this.getWidth() : CameraView.this.getHeight(), z ? CameraView.this.getHeight() : CameraView.this.getWidth());
                        O000000o.this.f5374O000000o.O000000o(1, "processImage", "is consistent?", Boolean.valueOf(z));
                        O000000o.this.f5374O000000o.O000000o(1, "processImage", "viewWidth?", Integer.valueOf(CameraView.this.getWidth()), "viewHeight?", Integer.valueOf(CameraView.this.getHeight()));
                        byte[] bArr2 = bArr;
                        int i5 = CameraView.this.O00000o0;
                        Bitmap O000000o3 = cpr.O000000o(bArr2);
                        int width = O000000o3.getWidth();
                        int height = O000000o3.getHeight();
                        if (cpk.O000000o(width, height).O000000o() > O000000o2.O000000o()) {
                            i4 = (int) (((float) height) * O000000o2.O000000o());
                            i3 = (width - i4) / 2;
                            i = height;
                            i2 = 0;
                        } else {
                            int O000000o4 = (int) (((float) width) / O000000o2.O000000o());
                            i2 = (height - O000000o4) / 2;
                            i = O000000o4;
                            i4 = width;
                            i3 = 0;
                        }
                        Rect rect = new Rect(i3, i2, i4 + i3, i + i2);
                        Bitmap createBitmap = Bitmap.createBitmap(O000000o3, rect.left, rect.top, rect.width(), rect.height());
                        O000000o3.recycle();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream);
                        createBitmap.recycle();
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    O000000o.this.O000000o(bArr);
                }
            });
        }

        public final void O000000o(final byte[] bArr) {
            this.f5374O000000o.O000000o(1, "dispatchOnPictureTaken");
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass10 */

                public final void run() {
                    for (cpn O000000o2 : CameraView.this.O0000Ooo) {
                        O000000o2.O000000o(bArr);
                    }
                }
            });
        }

        public final void O000000o(final File file) {
            this.f5374O000000o.O000000o(1, "dispatchOnVideoTaken", file);
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass11 */

                public final void run() {
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O000000o(final Gesture gesture, final PointF pointF) {
            this.f5374O000000o.O000000o(1, "dispatchOnFocusStart", gesture, pointF);
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass12 */

                public final void run() {
                    if (gesture != null && CameraView.this.O00000oo.get(gesture) == GestureAction.FOCUS_WITH_MARKER) {
                        TapGestureLayout tapGestureLayout = CameraView.this.O0000o0o;
                        PointF pointF = pointF;
                        tapGestureLayout.removeCallbacks(tapGestureLayout.O0000O0o);
                        tapGestureLayout.O00000oO.clearAnimation();
                        tapGestureLayout.O00000oo.clearAnimation();
                        tapGestureLayout.O00000oO.setTranslationX((float) ((int) (pointF.x - ((float) (tapGestureLayout.O00000oO.getWidth() / 2)))));
                        tapGestureLayout.O00000oO.setTranslationY((float) ((int) (pointF.y - ((float) (tapGestureLayout.O00000oO.getWidth() / 2)))));
                        tapGestureLayout.O00000oO.setScaleX(1.36f);
                        tapGestureLayout.O00000oO.setScaleY(1.36f);
                        tapGestureLayout.O00000oO.setAlpha(1.0f);
                        tapGestureLayout.O00000oo.setScaleX(0.0f);
                        tapGestureLayout.O00000oo.setScaleY(0.0f);
                        tapGestureLayout.O00000oo.setAlpha(1.0f);
                        TapGestureLayout.O000000o(tapGestureLayout.O00000oO, 1.0f, 1.0f, 300, 0, null);
                        TapGestureLayout.O000000o(tapGestureLayout.O00000oo, 1.0f, 1.0f, 300, 0, new AnimatorListenerAdapter() {
                            /* class com.otaliastudios.cameraview.TapGestureLayout.AnonymousClass3 */

                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                TapGestureLayout tapGestureLayout = TapGestureLayout.this;
                                tapGestureLayout.postDelayed(tapGestureLayout.O0000O0o, 2000);
                            }
                        });
                    }
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O000000o(final Gesture gesture, final boolean z, final PointF pointF) {
            this.f5374O000000o.O000000o(1, "dispatchOnFocusEnd", gesture, Boolean.valueOf(z), pointF);
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass13 */

                public final void run() {
                    if (z && CameraView.this.O00000oO) {
                        CameraView cameraView = CameraView.this;
                        if (cameraView.O00000oO) {
                            if (cameraView.O0000OoO == null) {
                                cameraView.O0000OoO = new MediaActionSound();
                            }
                            cameraView.O0000OoO.play(1);
                        }
                    }
                    if (gesture != null && CameraView.this.O00000oo.get(gesture) == GestureAction.FOCUS_WITH_MARKER) {
                        CameraView.this.O0000o0o.O00000Oo(z);
                    }
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O000000o(int i) {
            this.f5374O000000o.O000000o(1, "onDeviceOrientationChanged", Integer.valueOf(i));
            CameraView.this.O0000Oo.O000OO0o = i;
            final int i2 = (i + CameraView.this.O0000Oo0.O00000o) % 360;
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass2 */

                public final void run() {
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O000000o(final float f, final PointF[] pointFArr) {
            this.f5374O000000o.O000000o(1, "dispatchOnZoomChanged", Float.valueOf(f));
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass3 */

                public final void run() {
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O000000o(final float f, final float[] fArr, final PointF[] pointFArr) {
            this.f5374O000000o.O000000o(1, "dispatchOnExposureCorrectionChanged", Float.valueOf(f));
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass4 */

                public final void run() {
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }

        public final void O000000o(final cpu cpu) {
            if (CameraView.this.O0000o00.isEmpty()) {
                cpu.O000000o();
                return;
            }
            this.f5374O000000o.O000000o(0, "dispatchFrame:", Long.valueOf(cpu.O00000o0), "processors:", Integer.valueOf(CameraView.this.O0000o00.size()));
            CameraView.this.O0000oOO.O000000o(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass5 */

                public final void run() {
                    for (cpw O000000o2 : CameraView.this.O0000o00) {
                        O000000o2.O000000o(cpu);
                    }
                    cpu.O000000o();
                }
            });
        }

        public final void O000000o(final CameraException cameraException) {
            this.f5374O000000o.O000000o(1, "dispatchError", cameraException);
            CameraView.this.O0000oO0.post(new Runnable() {
                /* class com.otaliastudios.cameraview.CameraView.O000000o.AnonymousClass6 */

                public final void run() {
                    Iterator<cpn> it = CameraView.this.O0000Ooo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    @Deprecated
    public cpz getCaptureSize() {
        return getPictureSize();
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5373O000000o = new int[Gesture.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[GestureAction.values().length];
        static final /* synthetic */ int[] O00000o = new int[Flash.values().length];
        static final /* synthetic */ int[] O00000o0 = new int[Facing.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00bf */
        static {
            try {
                O00000o[Flash.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000o[Flash.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000o[Flash.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000o[Flash.TORCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            O00000o0[Facing.BACK.ordinal()] = 1;
            O00000o0[Facing.FRONT.ordinal()] = 2;
            O00000Oo[GestureAction.CAPTURE.ordinal()] = 1;
            O00000Oo[GestureAction.FOCUS.ordinal()] = 2;
            O00000Oo[GestureAction.FOCUS_WITH_MARKER.ordinal()] = 3;
            try {
                O00000Oo[GestureAction.ZOOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                O00000Oo[GestureAction.EXPOSURE_CORRECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            f5373O000000o[Gesture.PINCH.ordinal()] = 1;
            f5373O000000o[Gesture.TAP.ordinal()] = 2;
            f5373O000000o[Gesture.LONG_TAP.ordinal()] = 3;
            f5373O000000o[Gesture.SCROLL_HORIZONTAL.ordinal()] = 4;
            try {
                f5373O000000o[Gesture.SCROLL_VERTICAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getCameraId() {
        return this.O0000Oo.O0000oo0;
    }

    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        this.O0000Ooo.clear();
        this.O0000o00.clear();
        this.O0000Oo.O0000Oo();
    }
}
