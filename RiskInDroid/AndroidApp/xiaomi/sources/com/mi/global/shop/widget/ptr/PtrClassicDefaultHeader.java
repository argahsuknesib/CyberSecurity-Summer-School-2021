package com.mi.global.shop.widget.ptr;

import _m_j.ccf;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PtrClassicDefaultHeader extends FrameLayout implements ccf {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5027O000000o;
    private int O00000Oo = 150;
    private RotateAnimation O00000o;
    private RotateAnimation O00000o0;
    private CustomTextView O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private long O0000OOo = -1;
    private String O0000Oo;
    private CustomTextView O0000Oo0;
    private boolean O0000OoO;
    private O000000o O0000Ooo = new O000000o(this, (byte) 0);

    public PtrClassicDefaultHeader(Context context) {
        super(context);
        O000000o((AttributeSet) null);
    }

    public PtrClassicDefaultHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public PtrClassicDefaultHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.ptr_rotate_ani_time}, 0, 0);
        if (obtainStyledAttributes != null) {
            this.O00000Oo = obtainStyledAttributes.getInt(0, this.O00000Oo);
        }
        O00000Oo();
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.shop_cube_ptr_classic_default_header, this);
        this.O00000oo = inflate.findViewById(R.id.ptr_classic_header_rotate_view);
        this.O00000oO = (CustomTextView) inflate.findViewById(R.id.ptr_classic_header_rotate_view_header_title);
        this.O0000Oo0 = (CustomTextView) inflate.findViewById(R.id.ptr_classic_header_rotate_view_header_last_update);
        this.O0000O0o = inflate.findViewById(R.id.ptr_classic_header_rotate_view_progressbar);
        O00000o0();
    }

    public void setRotateAniTime(int i) {
        if (i != this.O00000Oo && i != 0) {
            this.O00000Oo = i;
            O00000Oo();
        }
    }

    public void setLastUpdateTimeKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f5027O000000o = str;
        }
    }

    public void setLastRefreshTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O0000Oo = str;
        }
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        setLastUpdateTimeKey(obj.getClass().getName());
    }

    private void O00000Oo() {
        this.O00000o0 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.O00000o0.setInterpolator(new LinearInterpolator());
        this.O00000o0.setDuration((long) this.O00000Oo);
        this.O00000o0.setFillAfter(true);
        this.O00000o = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.O00000o.setInterpolator(new LinearInterpolator());
        this.O00000o.setDuration((long) this.O00000Oo);
        this.O00000o.setFillAfter(true);
    }

    private void O00000o0() {
        O00000o();
        this.O0000O0o.setVisibility(4);
    }

    private void O00000o() {
        this.O00000oo.clearAnimation();
        this.O00000oo.setVisibility(4);
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout) {
        O00000o0();
        this.O0000OoO = true;
        O000000o();
    }

    public final void O00000Oo(PtrFrameLayout ptrFrameLayout) {
        this.O0000OoO = true;
        O000000o();
        O000000o o000000o = this.O0000Ooo;
        if (!TextUtils.isEmpty(PtrClassicDefaultHeader.this.f5027O000000o)) {
            o000000o.f5028O000000o = true;
            o000000o.run();
        }
        this.O0000O0o.setVisibility(4);
        this.O00000oo.setVisibility(0);
        this.O00000oO.setVisibility(0);
        if (ptrFrameLayout.O00000oO) {
            this.O00000oO.setText(getResources().getString(R.string.cube_ptr_pull_down_to_refresh));
        } else {
            this.O00000oO.setText(getResources().getString(R.string.cube_ptr_pull_down));
        }
    }

    public final void O00000o0(PtrFrameLayout ptrFrameLayout) {
        this.O0000OoO = false;
        O00000o();
        this.O0000O0o.setVisibility(0);
        this.O00000oO.setVisibility(0);
        this.O00000oO.setText((int) R.string.cube_ptr_refreshing);
        O000000o();
        O000000o o000000o = this.O0000Ooo;
        o000000o.f5028O000000o = false;
        PtrClassicDefaultHeader.this.removeCallbacks(o000000o);
    }

    public final void O00000o(PtrFrameLayout ptrFrameLayout) {
        O00000o();
        this.O0000O0o.setVisibility(4);
        this.O00000oO.setVisibility(0);
        this.O00000oO.setText(getResources().getString(R.string.cube_ptr_refresh_complete));
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("cube_ptr_classic_last_update", 0);
        if (!TextUtils.isEmpty(this.f5027O000000o)) {
            this.O0000OOo = new Date().getTime();
            sharedPreferences.edit().putLong(this.f5027O000000o, this.O0000OOo).commit();
        }
    }

    public final void O000000o() {
        if (TextUtils.isEmpty(this.f5027O000000o) || !this.O0000OoO) {
            this.O0000Oo0.setVisibility(8);
            return;
        }
        String lastUpdateTime = getLastUpdateTime();
        if (TextUtils.isEmpty(lastUpdateTime)) {
            this.O0000Oo0.setVisibility(8);
            return;
        }
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo0.setText(lastUpdateTime);
    }

    private String getLastUpdateTime() {
        if (this.O0000OOo == -1 && !TextUtils.isEmpty(this.f5027O000000o)) {
            this.O0000OOo = getContext().getSharedPreferences("cube_ptr_classic_last_update", 0).getLong(this.f5027O000000o, -1);
        }
        if (this.O0000OOo == -1) {
            return null;
        }
        long time = new Date().getTime() - this.O0000OOo;
        int i = (int) (time / 1000);
        if (time < 0 || i <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getString(R.string.cube_ptr_last_update));
        if (i < 60) {
            sb.append(i + getContext().getString(R.string.cube_ptr_seconds_ago));
        } else {
            int i2 = i / 60;
            if (i2 > 60) {
                int i3 = i2 / 60;
                if (i3 > 24) {
                    sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.O0000OOo)));
                } else {
                    sb.append(i3 + getContext().getString(R.string.cube_ptr_hours_ago));
                }
            } else {
                sb.append(i2 + getContext().getString(R.string.cube_ptr_minutes_ago));
            }
        }
        return sb.toString();
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout, boolean z, byte b, int i, int i2, float f, float f2) {
        int offsetToRefresh = ptrFrameLayout.getOffsetToRefresh();
        if (i2 >= offsetToRefresh || i < offsetToRefresh) {
            if (i2 > offsetToRefresh && i <= offsetToRefresh && z && b == 2) {
                if (!ptrFrameLayout.O00000oO) {
                    this.O00000oO.setVisibility(0);
                    this.O00000oO.setText((int) R.string.cube_ptr_release_to_refresh);
                }
                View view = this.O00000oo;
                if (view != null) {
                    view.clearAnimation();
                    this.O00000oo.startAnimation(this.O00000o0);
                }
            }
        } else if (z && b == 2) {
            this.O00000oO.setVisibility(0);
            if (ptrFrameLayout.O00000oO) {
                this.O00000oO.setText(getResources().getString(R.string.cube_ptr_pull_down_to_refresh));
            } else {
                this.O00000oO.setText(getResources().getString(R.string.cube_ptr_pull_down));
            }
            View view2 = this.O00000oo;
            if (view2 != null) {
                view2.clearAnimation();
                this.O00000oo.startAnimation(this.O00000o);
            }
        }
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f5028O000000o;

        private O000000o() {
            this.f5028O000000o = false;
        }

        /* synthetic */ O000000o(PtrClassicDefaultHeader ptrClassicDefaultHeader, byte b) {
            this();
        }

        public final void run() {
            PtrClassicDefaultHeader.this.O000000o();
            if (this.f5028O000000o) {
                PtrClassicDefaultHeader.this.postDelayed(this, 1000);
            }
        }
    }
}
