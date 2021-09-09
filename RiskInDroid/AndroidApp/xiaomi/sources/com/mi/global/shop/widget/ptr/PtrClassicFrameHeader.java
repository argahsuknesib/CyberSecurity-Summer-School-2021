package com.mi.global.shop.widget.ptr;

import _m_j.ccf;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.Date;

public class PtrClassicFrameHeader extends FrameLayout implements ccf {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5029O000000o;
    protected ImageView O00000Oo;
    private boolean O00000o;
    protected ProgressBar O00000o0;
    private long O00000oO = -1;
    private boolean O00000oo;
    private String O0000O0o;
    private FrameLayout O0000OOo;
    private CustomTextView O0000Oo;
    private CustomTextView O0000Oo0;
    private ImageView O0000OoO;
    private O000000o O0000Ooo = new O000000o(this, (byte) 0);

    public PtrClassicFrameHeader(Context context) {
        super(context);
        LayoutInflater.from(context).inflate((int) R.layout.shop_pull_to_refresh_header_vertical, this);
        this.O0000OOo = (FrameLayout) findViewById(R.id.fl_inner);
        this.O0000Oo0 = (CustomTextView) this.O0000OOo.findViewById(R.id.pull_to_refresh_text);
        this.O00000o0 = (ProgressBar) this.O0000OOo.findViewById(R.id.pull_to_refresh_progress);
        this.O0000Oo = (CustomTextView) this.O0000OOo.findViewById(R.id.pull_to_refresh_sub_text);
        this.O00000Oo = (ImageView) this.O0000OOo.findViewById(R.id.pull_to_refresh_image);
        this.O0000OoO = (ImageView) this.O0000OOo.findViewById(R.id.pull_to_refresh_dancing_ellipsis);
        setLoadingDrawable(context.getResources().getDrawable(R.drawable.shop_mi_rabbit));
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo.setVisibility(0);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.O0000OoO.getBackground();
        animationDrawable.stop();
        animationDrawable.selectDrawable(0);
        if (this.O00000o) {
            ((AnimationDrawable) this.O00000Oo.getDrawable()).stop();
        }
        CustomTextView customTextView = this.O0000Oo;
        if (customTextView == null) {
            return;
        }
        if (TextUtils.isEmpty(customTextView.getText())) {
            this.O0000Oo.setVisibility(8);
        } else {
            this.O0000Oo.setVisibility(0);
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.O00000Oo.setImageDrawable(drawable);
        this.O00000o = drawable instanceof AnimationDrawable;
    }

    public void setLastUpdateTimeKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f5029O000000o = str;
        }
    }

    public void setLastRefreshTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O0000O0o = str;
        }
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        setLastUpdateTimeKey(obj.getClass().getName());
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout) {
        O000000o();
        this.O00000oo = true;
    }

    public final void O00000Oo(PtrFrameLayout ptrFrameLayout) {
        this.O00000oo = true;
        O000000o o000000o = this.O0000Ooo;
        if (!TextUtils.isEmpty(PtrClassicFrameHeader.this.f5029O000000o)) {
            o000000o.f5030O000000o = true;
            o000000o.run();
        }
        this.O00000Oo.setVisibility(0);
        this.O0000Oo0.setVisibility(0);
        if (ptrFrameLayout.O00000oO) {
            this.O0000Oo0.setText(getResources().getString(R.string.cube_ptr_pull_down_to_refresh));
        } else {
            this.O0000Oo0.setText(getResources().getString(R.string.cube_ptr_pull_down));
        }
    }

    public final void O00000o0(PtrFrameLayout ptrFrameLayout) {
        this.O00000oo = false;
        ((AnimationDrawable) this.O0000OoO.getBackground()).start();
        if (this.O00000o) {
            ((AnimationDrawable) this.O00000Oo.getDrawable()).start();
        }
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo0.setText((int) R.string.cube_ptr_refreshing);
        O000000o o000000o = this.O0000Ooo;
        o000000o.f5030O000000o = false;
        PtrClassicFrameHeader.this.removeCallbacks(o000000o);
    }

    public final void O00000o(PtrFrameLayout ptrFrameLayout) {
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo0.setText(getResources().getString(R.string.cube_ptr_refresh_complete));
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("cube_ptr_classic_last_update", 0);
        if (!TextUtils.isEmpty(this.f5029O000000o)) {
            this.O00000oO = new Date().getTime();
            sharedPreferences.edit().putLong(this.f5029O000000o, this.O00000oO).commit();
        }
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout, boolean z, byte b, int i, int i2, float f, float f2) {
        int offsetToRefresh = ptrFrameLayout.getOffsetToRefresh();
        if (i2 >= offsetToRefresh || i < offsetToRefresh) {
            if (i2 > offsetToRefresh && i <= offsetToRefresh && z && b == 2 && !ptrFrameLayout.O00000oO) {
                this.O0000Oo0.setVisibility(0);
                this.O0000Oo0.setText((int) R.string.cube_ptr_release_to_refresh);
            }
        } else if (z && b == 2) {
            this.O0000Oo0.setVisibility(0);
            if (ptrFrameLayout.O00000oO) {
                this.O0000Oo0.setText(getResources().getString(R.string.cube_ptr_pull_down_to_refresh));
            } else {
                this.O0000Oo0.setText(getResources().getString(R.string.cube_ptr_pull_down));
            }
        }
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f5030O000000o;

        private O000000o() {
            this.f5030O000000o = false;
        }

        /* synthetic */ O000000o(PtrClassicFrameHeader ptrClassicFrameHeader, byte b) {
            this();
        }

        public final void run() {
            if (this.f5030O000000o) {
                PtrClassicFrameHeader.this.postDelayed(this, 1000);
            }
        }
    }
}
