package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.ImageView;

public class c extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    final String f5853a = "TouchView";
    public boolean b = false;
    private Matrix c = new Matrix();
    private Matrix d = new Matrix();
    private int e = 0;
    private float f = 1.0f;
    private float g = 1.0f;
    private Bitmap h;
    /* access modifiers changed from: private */
    public boolean i = false;
    private float j;
    private float k;
    private PointF l = new PointF();
    private PointF m = new PointF();
    private float n = 1.0f;
    private float o = 0.0f;
    private Rect p = new Rect();

    private void a() {
    }

    public c(Context context) {
        super(context);
        getDrawingRect(this.p);
        a();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.h != null) {
            float[] fArr = new float[9];
            this.c.getValues(fArr);
            float f2 = fArr[2];
            float f3 = fArr[5];
            float f4 = fArr[0];
            float width = ((float) this.h.getWidth()) * f4;
            float height = ((float) this.h.getHeight()) * f4;
            float f5 = ((float) this.p.left) - f2;
            if (f5 <= 1.0f) {
                f5 = 1.0f;
            }
            float f6 = (f2 + width) - ((float) this.p.right);
            if (f6 <= 1.0f) {
                f6 = 1.0f;
            }
            float width2 = ((((float) this.p.width()) * f5) / (f6 + f5)) + ((float) this.p.left);
            float f7 = ((float) this.p.top) - f3;
            float f8 = (f3 + height) - ((float) this.p.bottom);
            if (f7 <= 1.0f) {
                f7 = 1.0f;
            }
            if (f8 <= 1.0f) {
                f8 = 1.0f;
            }
            pointF.set(width2, ((((float) this.p.height()) * f7) / (f8 + f7)) + ((float) this.p.top));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r0 != 6) goto L_0x00ae;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = this.e;
                    if (i2 == 1) {
                        this.c.set(this.d);
                        this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                    } else if (i2 == 2) {
                        Matrix matrix = this.c;
                        matrix.set(matrix);
                        float a2 = a(motionEvent);
                        if (a2 > 10.0f) {
                            this.c.set(this.d);
                            float f2 = a2 / this.n;
                            this.c.postScale(f2, f2, this.m.x, this.m.y);
                        }
                    }
                    setImageMatrix(this.c);
                } else if (action == 5) {
                    this.n = a(motionEvent);
                    if (this.n > 10.0f) {
                        this.d.set(this.c);
                        a(this.m);
                        this.e = 2;
                    }
                }
            }
            b();
            this.e = 0;
        } else {
            this.c.set(getImageMatrix());
            this.d.set(this.c);
            this.l.set(motionEvent.getX(), motionEvent.getY());
            this.e = 1;
        }
        this.b = true;
        return true;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.animation.Animation] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public void b() {
        /*
            r17 = this;
            r0 = r17
            android.graphics.Bitmap r1 = r0.h
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            android.graphics.Rect r1 = r0.p
            int r1 = r1.width()
            float r1 = (float) r1
            android.graphics.Rect r2 = r0.p
            int r2 = r2.height()
            float r2 = (float) r2
            r3 = 9
            float[] r3 = new float[r3]
            android.graphics.Matrix r4 = r0.c
            r4.getValues(r3)
            r4 = 2
            r5 = r3[r4]
            r6 = 5
            r7 = r3[r6]
            r8 = 0
            r9 = r3[r8]
            r10 = 0
            float r11 = r0.f
            r12 = 1
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x0068
            float r11 = r11 / r9
            r0.o = r11
            android.graphics.Matrix r1 = r0.c
            float r2 = r0.o
            android.graphics.PointF r3 = r0.m
            float r3 = r3.x
            android.graphics.PointF r4 = r0.m
            float r4 = r4.y
            r1.postScale(r2, r2, r3, r4)
            android.graphics.Matrix r1 = r0.c
            r0.setImageMatrix(r1)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            float r2 = r0.o
            r3 = 1065353216(0x3f800000, float:1.0)
            float r4 = r3 / r2
            r5 = 1065353216(0x3f800000, float:1.0)
            float r6 = r3 / r2
            r7 = 1065353216(0x3f800000, float:1.0)
            android.graphics.PointF r2 = r0.m
            float r8 = r2.x
            android.graphics.PointF r2 = r0.m
            float r9 = r2.y
            r2 = r1
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x0109
        L_0x0068:
            float r11 = r0.g
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0096
            float r11 = r11 / r9
            r0.o = r11
            android.graphics.Matrix r1 = r0.c
            float r2 = r0.o
            android.graphics.PointF r3 = r0.m
            float r3 = r3.x
            android.graphics.PointF r4 = r0.m
            float r4 = r4.y
            r1.postScale(r2, r2, r3, r4)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r6 = 1065353216(0x3f800000, float:1.0)
            float r9 = r0.o
            r8 = 1065353216(0x3f800000, float:1.0)
            android.graphics.PointF r2 = r0.m
            float r10 = r2.x
            android.graphics.PointF r2 = r0.m
            float r11 = r2.y
            r5 = r1
            r7 = r9
            r5.<init>(r6, r7, r8, r9, r10, r11)
            goto L_0x0109
        L_0x0096:
            android.graphics.Bitmap r11 = r0.h
            int r11 = r11.getWidth()
            float r11 = (float) r11
            float r11 = r11 * r9
            android.graphics.Bitmap r13 = r0.h
            int r13 = r13.getHeight()
            float r13 = (float) r13
            float r13 = r13 * r9
            android.graphics.Rect r9 = r0.p
            int r9 = r9.left
            float r9 = (float) r9
            float r9 = r9 - r5
            android.graphics.Rect r14 = r0.p
            int r14 = r14.top
            float r14 = (float) r14
            float r14 = r14 - r7
            r15 = 0
            int r16 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r16 >= 0) goto L_0x00bf
            android.graphics.Rect r5 = r0.p
            int r5 = r5.left
            float r5 = (float) r5
            r8 = 1
        L_0x00bf:
            int r16 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r16 >= 0) goto L_0x00c9
            android.graphics.Rect r7 = r0.p
            int r7 = r7.top
            float r7 = (float) r7
            r8 = 1
        L_0x00c9:
            float r9 = r11 - r9
            float r14 = r13 - r14
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 >= 0) goto L_0x00da
            float r11 = r11 - r1
            android.graphics.Rect r1 = r0.p
            int r1 = r1.left
            float r1 = (float) r1
            float r5 = r1 - r11
            r8 = 1
        L_0x00da:
            int r1 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00e7
            float r13 = r13 - r2
            android.graphics.Rect r1 = r0.p
            int r1 = r1.top
            float r1 = (float) r1
            float r7 = r1 - r13
            r8 = 1
        L_0x00e7:
            if (r8 == 0) goto L_0x0103
            r1 = r3[r4]
            float r1 = r1 - r5
            r2 = r3[r6]
            float r2 = r2 - r7
            r3[r4] = r5
            r3[r6] = r7
            android.graphics.Matrix r4 = r0.c
            r4.setValues(r3)
            android.graphics.Matrix r3 = r0.c
            r0.setImageMatrix(r3)
            android.view.animation.TranslateAnimation r10 = new android.view.animation.TranslateAnimation
            r10.<init>(r1, r15, r2, r15)
            goto L_0x0108
        L_0x0103:
            android.graphics.Matrix r1 = r0.c
            r0.setImageMatrix(r1)
        L_0x0108:
            r1 = r10
        L_0x0109:
            if (r1 == 0) goto L_0x0122
            r0.i = r12
            r2 = 300(0x12c, double:1.48E-321)
            r1.setDuration(r2)
            r0.startAnimation(r1)
            java.lang.Thread r1 = new java.lang.Thread
            com.tencent.connect.avatar.c$1 r2 = new com.tencent.connect.avatar.c$1
            r2.<init>()
            r1.<init>(r2)
            r1.start()
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.b():void");
    }

    private void c() {
        if (this.h != null) {
            float[] fArr = new float[9];
            this.c.getValues(fArr);
            float max = Math.max(((float) this.p.width()) / ((float) this.h.getWidth()), ((float) this.p.height()) / ((float) this.h.getHeight()));
            this.j = ((float) this.p.left) - (((((float) this.h.getWidth()) * max) - ((float) this.p.width())) / 2.0f);
            this.k = ((float) this.p.top) - (((((float) this.h.getHeight()) * max) - ((float) this.p.height())) / 2.0f);
            fArr[2] = this.j;
            fArr[5] = this.k;
            fArr[4] = max;
            fArr[0] = max;
            this.c.setValues(fArr);
            this.f = Math.min(2048.0f / ((float) this.h.getWidth()), 2048.0f / ((float) this.h.getHeight()));
            this.g = max;
            float f2 = this.f;
            float f3 = this.g;
            if (f2 < f3) {
                this.f = f3;
            }
            setImageMatrix(this.c);
        }
    }
}
