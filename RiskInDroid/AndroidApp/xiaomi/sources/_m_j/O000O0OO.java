package _m_j;

import O000000o.O000000o.O000000o.O00000oO.p;
import O000000o.O000000o.O000000o.O00000oO.q;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.hannto.circledialog.params.ButtonParams;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.DialogParams;
import com.hannto.circledialog.params.ProgressParams;
import com.hannto.circledialog.params.TitleParams;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class O000O0OO extends p {

    /* renamed from: O000000o  reason: collision with root package name */
    public ProgressParams f5255O000000o;
    public ProgressBar O00000Oo;
    public Handler O00000o0;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d0  */
    public O000O0OO(Context context, CircleParams circleParams) {
        super(context);
        ProgressParams progressParams;
        int i;
        ProgressParams progressParams2;
        int[] iArr;
        int[] iArr2;
        ProgressParams progressParams3;
        O000000o o000000o;
        O000000o o000000o2;
        setOrientation(1);
        DialogParams dialogParams = circleParams.O00000Oo;
        TitleParams titleParams = circleParams.O00000o0;
        ButtonParams buttonParams = circleParams.O00000oO;
        ButtonParams buttonParams2 = circleParams.O00000oo;
        this.f5255O000000o = circleParams.O0000OOo;
        int i2 = this.f5255O000000o.O0000OoO;
        int i3 = i2 == 0 ? -1 : i2;
        if (titleParams != null && buttonParams == null && buttonParams2 == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i4 = dialogParams.O0000OoO;
                o000000o2 = new O000000o(i3, 0, 0, i4, i4);
            } else {
                int i5 = dialogParams.O0000OoO;
                o000000o = new O000000o(i3, 0, 0, i5, i5);
                setBackgroundDrawable(o000000o);
                progressParams = this.f5255O000000o;
                int i6 = progressParams.O00000oo;
                Field field = null;
                if (progressParams.O00000o0 == 0) {
                }
                progressParams2.O0000O0o = i;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f5255O000000o.O0000O0o);
                iArr = this.f5255O000000o.O00000o;
                if (iArr != null) {
                }
                addView(this.O00000Oo, layoutParams);
                q qVar = new q(getContext());
                qVar.setTextSize((float) this.f5255O000000o.O0000o00);
                qVar.setTextColor(this.f5255O000000o.O0000Ooo);
                iArr2 = this.f5255O000000o.O00000oO;
                if (iArr2 != null) {
                }
                addView(qVar);
                progressParams3 = this.f5255O000000o;
                if (progressParams3.O00000o0 == 0) {
                }
            }
        } else if (titleParams != null || (buttonParams == null && buttonParams2 == null)) {
            if (titleParams != null || buttonParams != null || buttonParams2 != null) {
                setBackgroundColor(i3);
                progressParams = this.f5255O000000o;
                int i62 = progressParams.O00000oo;
                Field field2 = null;
                if (progressParams.O00000o0 == 0) {
                    if (i62 != 0) {
                        this.O00000Oo = new ProgressBar(getContext());
                        ProgressBar progressBar = this.O00000Oo;
                        Boolean bool = new Boolean(false);
                        Class<?> cls = progressBar.getClass();
                        while (true) {
                            if (cls == Object.class) {
                                break;
                            }
                            try {
                                field2 = cls.getDeclaredField("mOnlyIndeterminate");
                                break;
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                                cls = cls.getSuperclass();
                            }
                        }
                        if (field2 != null) {
                            if (!Modifier.isPublic(field2.getModifiers()) || !Modifier.isPublic(field2.getDeclaringClass().getModifiers())) {
                                field2.setAccessible(true);
                            }
                            try {
                                field2.set(progressBar, bool);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            }
                            this.O00000Oo.setIndeterminate(false);
                            if (Build.VERSION.SDK_INT >= 21) {
                                this.O00000Oo.setProgressDrawableTiled(context.getDrawable(i62));
                            } else {
                                this.O00000Oo.setProgressDrawable(context.getResources().getDrawable(i62));
                            }
                        } else {
                            throw new IllegalArgumentException("Could not find field [" + "mOnlyIndeterminate" + "] on target [" + progressBar + "]");
                        }
                    } else {
                        this.O00000Oo = new ProgressBar(getContext(), null, 16842872);
                    }
                    progressParams2 = this.f5255O000000o;
                    i = 10;
                } else {
                    if (i62 != 0) {
                        this.O00000Oo = new ProgressBar(getContext());
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.O00000Oo.setIndeterminateDrawableTiled(context.getDrawable(i62));
                        } else {
                            this.O00000Oo.setIndeterminateDrawable(context.getResources().getDrawable(i62));
                        }
                    } else {
                        this.O00000Oo = new ProgressBar(getContext(), null, 16842871);
                    }
                    progressParams2 = this.f5255O000000o;
                    i = 80;
                }
                progressParams2.O0000O0o = i;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.f5255O000000o.O0000O0o);
                iArr = this.f5255O000000o.O00000o;
                if (iArr != null) {
                    layoutParams2.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
                }
                addView(this.O00000Oo, layoutParams2);
                q qVar2 = new q(getContext());
                qVar2.setTextSize((float) this.f5255O000000o.O0000o00);
                qVar2.setTextColor(this.f5255O000000o.O0000Ooo);
                iArr2 = this.f5255O000000o.O00000oO;
                if (iArr2 != null) {
                    qVar2.a(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
                }
                addView(qVar2);
                progressParams3 = this.f5255O000000o;
                if (progressParams3.O00000o0 == 0) {
                    this.O00000o0 = new O000O00o(this, qVar2);
                    return;
                } else {
                    qVar2.setText(progressParams3.O0000Oo);
                    return;
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                o000000o2 = new O000000o(i3, dialogParams.O0000OoO);
            } else {
                o000000o = new O000000o(i3, dialogParams.O0000OoO);
                setBackgroundDrawable(o000000o);
                progressParams = this.f5255O000000o;
                int i622 = progressParams.O00000oo;
                Field field22 = null;
                if (progressParams.O00000o0 == 0) {
                }
                progressParams2.O0000O0o = i;
                LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, this.f5255O000000o.O0000O0o);
                iArr = this.f5255O000000o.O00000o;
                if (iArr != null) {
                }
                addView(this.O00000Oo, layoutParams22);
                q qVar22 = new q(getContext());
                qVar22.setTextSize((float) this.f5255O000000o.O0000o00);
                qVar22.setTextColor(this.f5255O000000o.O0000Ooo);
                iArr2 = this.f5255O000000o.O00000oO;
                if (iArr2 != null) {
                }
                addView(qVar22);
                progressParams3 = this.f5255O000000o;
                if (progressParams3.O00000o0 == 0) {
                }
            }
        } else if (Build.VERSION.SDK_INT >= 16) {
            int i7 = dialogParams.O0000OoO;
            o000000o2 = new O000000o(i3, i7, i7, 0, 0);
        } else {
            int i8 = dialogParams.O0000OoO;
            o000000o = new O000000o(i3, i8, i8, 0, 0);
            setBackgroundDrawable(o000000o);
            progressParams = this.f5255O000000o;
            int i6222 = progressParams.O00000oo;
            Field field222 = null;
            if (progressParams.O00000o0 == 0) {
            }
            progressParams2.O0000O0o = i;
            LinearLayout.LayoutParams layoutParams222 = new LinearLayout.LayoutParams(-1, this.f5255O000000o.O0000O0o);
            iArr = this.f5255O000000o.O00000o;
            if (iArr != null) {
            }
            addView(this.O00000Oo, layoutParams222);
            q qVar222 = new q(getContext());
            qVar222.setTextSize((float) this.f5255O000000o.O0000o00);
            qVar222.setTextColor(this.f5255O000000o.O0000Ooo);
            iArr2 = this.f5255O000000o.O00000oO;
            if (iArr2 != null) {
            }
            addView(qVar222);
            progressParams3 = this.f5255O000000o;
            if (progressParams3.O00000o0 == 0) {
            }
        }
        setBackground(o000000o2);
        progressParams = this.f5255O000000o;
        int i62222 = progressParams.O00000oo;
        Field field2222 = null;
        if (progressParams.O00000o0 == 0) {
        }
        progressParams2.O0000O0o = i;
        LinearLayout.LayoutParams layoutParams2222 = new LinearLayout.LayoutParams(-1, this.f5255O000000o.O0000O0o);
        iArr = this.f5255O000000o.O00000o;
        if (iArr != null) {
        }
        addView(this.O00000Oo, layoutParams2222);
        q qVar2222 = new q(getContext());
        qVar2222.setTextSize((float) this.f5255O000000o.O0000o00);
        qVar2222.setTextColor(this.f5255O000000o.O0000Ooo);
        iArr2 = this.f5255O000000o.O00000oO;
        if (iArr2 != null) {
        }
        addView(qVar2222);
        progressParams3 = this.f5255O000000o;
        if (progressParams3.O00000o0 == 0) {
        }
    }
}
