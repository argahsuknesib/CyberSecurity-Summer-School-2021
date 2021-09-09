package _m_j;

import O000000o.O000000o.O000000o.O00000oO.h;
import O000000o.O000000o.O000000o.O00000oO.j;
import O000000o.O000000o.O000000o.O00000oO.p;
import O000000o.O000000o.O000000o.O00000oO.t;
import O000000o.O000000o.O000000o.O00000oO.u;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.hannto.circledialog.params.CircleParams;

public abstract class O000Oo0 extends dz {
    public boolean O00000o = true;
    public int O00000o0 = 17;
    public boolean O00000oO = true;
    public float O00000oo = 0.9f;
    public int[] O0000O0o;
    public int O0000OOo;
    public int O0000Oo = 0;
    public boolean O0000Oo0 = true;
    public int O0000OoO = 60;
    public float O0000Ooo = 1.0f;
    public int O0000o0;
    public int O0000o00;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
        if (bundle != null) {
            this.O00000o0 = bundle.getInt("circle:baseGravity");
            this.O00000o = bundle.getBoolean("circle:baseTouchOut");
            this.O00000oO = bundle.getBoolean("circle:baseCanceledBack");
            this.O00000oo = bundle.getFloat("circle:baseWidth");
            this.O0000O0o = bundle.getIntArray("circle:basePadding");
            this.O0000OOo = bundle.getInt("circle:baseAnimStyle");
            this.O0000Oo0 = bundle.getBoolean("circle:baseDimEnabled");
            this.O0000Oo = bundle.getInt("circle:baseBackgroundColor");
            this.O0000OoO = bundle.getInt("circle:baseRadius");
            this.O0000Ooo = bundle.getFloat("circle:baseAlpha");
            this.O0000o00 = bundle.getInt("circle:baseX");
            this.O0000o0 = bundle.getInt("circle:baseY");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0159  */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        O0000o0 o0000o0;
        O0000o0 o0000o02;
        getContext();
        O000OOo o000OOo = (O000OOo) this;
        o000OOo.O00000Oo = new O000o00(o000OOo.getContext(), o000OOo.f6617O000000o);
        o000OOo.f6617O000000o.f4340O000000o = o000OOo;
        O000o00 o000o00 = o000OOo.O00000Oo;
        O000O0o o000O0o = o000o00.O00000o0;
        if (o000O0o.O00000o0 == null) {
            o000O0o.O00000o0 = new p(o000O0o.f5256O000000o);
            o000O0o.O00000o0.setOrientation(1);
        }
        if (o000o00.O00000Oo.O00000o0 != null) {
            O000O0o o000O0o2 = o000o00.O00000o0;
            if (o000O0o2.O00000o == null) {
                o000O0o2.O00000o = new u(o000O0o2.f5256O000000o, o000O0o2.O00000Oo);
                o000O0o2.O00000o0.addView(o000O0o2.O00000o);
            }
        }
        if (o000o00.O00000Oo.O0000Oo != 0) {
            O000O0o o000O0o3 = o000o00.O00000o0;
            if (o000O0o3.O0000OoO == null) {
                o000O0o3.O0000OoO = LayoutInflater.from(o000O0o3.f5256O000000o).inflate(o000O0o3.O00000Oo.O0000Oo, (ViewGroup) o000O0o3.O00000o0, false);
                o000O0o3.O00000o0.addView(o000O0o3.O0000OoO);
            }
            View view = o000O0o3.O0000OoO;
            o000o00.O000000o();
            O0000Oo o0000Oo = o000o00.O00000Oo.O0000OoO;
            if (o0000Oo != null) {
                o0000Oo.O000000o(view);
            }
        }
        CircleParams circleParams = o000o00.O00000Oo;
        if (circleParams.O00000o != null) {
            O000O0o o000O0o4 = o000o00.O00000o0;
            if (o000O0o4.O00000oO == null) {
                o000O0o4.O00000oO = new h(o000O0o4.f5256O000000o, o000O0o4.O00000Oo);
                o000O0o4.O00000o0.addView(o000O0o4.O00000oO);
            }
        } else {
            if (circleParams.O0000O0o != null) {
                if (circleParams.O00000o0 != null) {
                    O000O0o o000O0o5 = o000o00.O00000o0;
                    j jVar = new j(o000O0o5.f5256O000000o);
                    jVar.O000000o();
                    o000O0o5.O00000o0.addView(jVar);
                }
                O000O0o o000O0o6 = o000o00.O00000o0;
                if (o000O0o6.O00000oo == null) {
                    o000O0o6.O00000oo = new O00oOooO(o000O0o6.f5256O000000o, o000O0o6.O00000Oo);
                    o000O0o6.O00000o0.addView(o000O0o6.O00000oo);
                }
                CircleParams circleParams2 = o000o00.O00000Oo;
                if (!(circleParams2.O00000oo == null && circleParams2.O00000oO == null)) {
                    o000o00.O00000o0.O000000o();
                }
            } else if (circleParams.O0000OOo != null) {
                O000O0o o000O0o7 = o000o00.O00000o0;
                if (o000O0o7.O0000O0o == null) {
                    o000O0o7.O0000O0o = new O000O0OO(o000O0o7.f5256O000000o, o000O0o7.O00000Oo);
                    o000O0o7.O00000o0.addView(o000O0o7.O0000O0o);
                }
            } else if (circleParams.O0000Oo0 != null) {
                O000O0o o000O0o8 = o000o00.O00000o0;
                if (o000O0o8.O0000OOo == null) {
                    o000O0o8.O0000OOo = new O0000o0(o000O0o8.f5256O000000o, o000O0o8.O00000Oo);
                    o000O0o8.O00000o0.addView(o000O0o8.O0000OOo);
                }
                o000o00.O000000o();
                O000O0o o000O0o9 = o000o00.O00000o0;
                t tVar = o000O0o9.O0000Oo;
                if (!(tVar == null || (o0000o02 = o000O0o9.O0000OOo) == null)) {
                    tVar.a(o0000o02.f5253O000000o);
                }
                O000OOOo o000OOOo = o000O0o9.O0000Oo0;
                if (!(o000OOOo == null || (o0000o0 = o000O0o9.O0000OOo) == null)) {
                    o000OOOo.O00000o.setOnClickListener(new O000OO(o000OOOo, o0000o0.f5253O000000o));
                }
            }
            LinearLayout linearLayout = o000o00.O00000o0.O00000o0;
            if (Build.VERSION.SDK_INT < 16) {
                linearLayout.setBackground(new O000000o(this.O0000Oo, this.O0000OoO));
            } else {
                linearLayout.setBackgroundDrawable(new O000000o(this.O0000Oo, this.O0000OoO));
            }
            linearLayout.setAlpha(this.O0000Ooo);
            return linearLayout;
        }
        o000o00.O000000o();
        LinearLayout linearLayout2 = o000o00.O00000o0.O00000o0;
        if (Build.VERSION.SDK_INT < 16) {
        }
        linearLayout2.setAlpha(this.O0000Ooo);
        return linearLayout2;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("circle:baseGravity", this.O00000o0);
        bundle.putBoolean("circle:baseTouchOut", this.O00000o);
        bundle.putBoolean("circle:baseCanceledBack", this.O00000oO);
        bundle.putFloat("circle:baseWidth", this.O00000oo);
        int[] iArr = this.O0000O0o;
        if (iArr != null) {
            bundle.putIntArray("circle:basePadding", iArr);
        }
        bundle.putInt("circle:baseAnimStyle", this.O0000OOo);
        bundle.putBoolean("circle:baseDimEnabled", this.O0000Oo0);
        bundle.putInt("circle:baseBackgroundColor", this.O0000Oo);
        bundle.putInt("circle:baseRadius", this.O0000OoO);
        bundle.putFloat("circle:baseAlpha", this.O0000Ooo);
        bundle.putInt("circle:baseX", this.O0000o00);
        bundle.putInt("circle:baseY", this.O0000o0);
    }

    public void onStart() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(this.O00000o);
            dialog.setCancelable(this.O00000oO);
            Window window = dialog.getWindow();
            window.setBackgroundDrawableResource(17170445);
            WindowManager.LayoutParams attributes = window.getAttributes();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            attributes.width = (int) (((float) displayMetrics.widthPixels) * this.O00000oo);
            attributes.gravity = this.O00000o0;
            attributes.x = this.O0000o00;
            attributes.y = this.O0000o0;
            int[] iArr = this.O0000O0o;
            if (iArr != null) {
                attributes.width = -1;
                window.getDecorView().setPadding(O00000Oo.O000000o(iArr[0]), O00000Oo.O000000o(iArr[1]), O00000Oo.O000000o(iArr[2]), O00000Oo.O000000o(iArr[3]));
            }
            int i = this.O0000OOo;
            if (i != 0) {
                window.setWindowAnimations(i);
            }
            if (this.O0000Oo0) {
                window.addFlags(2);
            } else {
                window.clearFlags(2);
            }
            window.setAttributes(attributes);
        }
        super.onStart();
    }

    public void show(ee eeVar, String str) {
        if (!isAdded()) {
            ei O000000o2 = eeVar.O000000o();
            O000000o2.O0000Oo0 = 4097;
            O000000o2.O000000o(this, str);
            O000000o2.O00000o0();
        }
    }
}
