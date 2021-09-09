package com.mijia.generalplayer.videoview;

import _m_j.chr;
import _m_j.cib;
import _m_j.cin;
import _m_j.cjm;
import _m_j.cki;
import _m_j.ckq;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class GeneralVideoViewTimeLine extends BasicVideoView {
    public static final String O0000oO = "GeneralVideoViewTimeLine";
    boolean O0000oOO = false;
    Animation O0000oOo;
    Runnable O0000oo = new Runnable() {
        /* class com.mijia.generalplayer.videoview.$$Lambda$GeneralVideoViewTimeLine$hLUoOkiQt30lMBq5PQbYj9qkOU8 */

        public final void run() {
            GeneralVideoViewTimeLine.this.O0000o0();
        }
    };
    Animation O0000oo0;
    private LinearLayout O0000ooO;
    private CheckBox O0000ooo;
    private ImageView O000O00o;
    private ImageView O000O0OO;
    private ImageView O000O0Oo;
    private FrameLayout O000O0o;
    private FrameLayout O000O0o0;
    private LinearLayout O000O0oO;
    private FrameLayout O000O0oo;
    private boolean O000OO00 = false;
    private volatile boolean O000OO0o = false;
    private View O00oOoOo;
    private CheckBox O00oOooO;
    private ImageView O00oOooo;

    /* access modifiers changed from: protected */
    public final void O00000Oo(long j) {
    }

    public GeneralVideoViewTimeLine(Context context) {
        super(context);
    }

    public GeneralVideoViewTimeLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GeneralVideoViewTimeLine(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void O000000o(View view) {
        FrameLayout frameLayout = this.O000O0oo;
        if (frameLayout != null) {
            try {
                this.O0000oOO = true;
                frameLayout.addView(view);
                O00000Oo(false);
            } catch (Exception e) {
                String str = O0000oO;
                cki.O00000oO(str, "addErrorView:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O00000Oo(View view) {
        FrameLayout frameLayout = this.O000O0oo;
        if (frameLayout != null) {
            try {
                this.O0000oOO = false;
                frameLayout.removeView(view);
                O00000Oo(true);
            } catch (Exception e) {
                String str = O0000oO;
                cki.O00000oO(str, "removedErrorView:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O00000Oo(boolean z) {
        if (z) {
            if (this.O0000o0O) {
                if (this.O000O0o0.getTranslationY() <= 0.0f) {
                    removeCallbacks(this.O0000oo);
                    postDelayed(this.O0000oo, 5000);
                }
            } else if (this.O0000ooO.getVisibility() == 0) {
                removeCallbacks(this.O0000oo);
                postDelayed(this.O0000oo, 5000);
            }
        }
        if (this.O0000OOo != 1) {
            this.O0000ooo.setChecked(false);
            this.O00oOooO.setChecked(false);
            this.O0000ooo.setEnabled(false);
            this.O00oOooO.setEnabled(false);
        } else {
            this.O0000ooo.setEnabled(z);
            this.O00oOooO.setEnabled(z);
        }
        this.O00oOooo.setEnabled(z);
        this.O000O0OO.setEnabled(z);
        this.O00000oo.setEnabled(z);
        if (z && this.O0000O0o.getVisibility() == 0) {
            this.O0000O0o.setVisibility(0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final void O0000Oo0() {
        this.O00000Oo.addView(((LayoutInflater) this.O0000Oo0.getSystemService("layout_inflater")).inflate((int) R.layout.gp_view_general_video_view_time_line, this.O00000Oo, false));
        this.O00000oo = (ImageView) findViewById(R.id.ivFullScreen);
        this.O0000O0o = (CheckBox) findViewById(R.id.pause_view);
        this.O00000o = (ImageView) findViewById(R.id.ivImage);
        this.O0000ooO = (LinearLayout) this.O00000Oo.findViewById(R.id.bottom_ctrl_ll);
        this.O000O0oo = (FrameLayout) findViewById(R.id.error_layout);
        this.O0000oOo = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_in);
        this.O0000oo0 = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_out);
        if (!this.O000OO00) {
            this.f5221O000000o.O000000o(0.0f);
        }
        findViewById(R.id.iv_back_landscape).setOnClickListener(this);
        this.O000O0o = (FrameLayout) findViewById(R.id.flTopCtrlLandscape);
        this.O000O0oO = (LinearLayout) findViewById(R.id.llRightCtrlLandscape);
        this.O00oOoOo = findViewById(R.id.land_layout);
        this.O000O0o0 = (FrameLayout) findViewById(R.id.time_line_land);
        this.O000O0OO = (ImageView) findViewById(R.id.tvsMultiSpeed);
        this.O000O0OO.setOnClickListener(this);
        this.O000O0Oo = (ImageView) findViewById(R.id.tvsMultiSpeed_land);
        setMultiSpeed(this.O0000OOo);
        this.O000O0Oo.setOnClickListener(this);
        this.O00oOooo = (ImageView) findViewById(R.id.ivCameraShot);
        this.O000O00o = (ImageView) findViewById(R.id.ivCameraShot_land);
        this.O0000ooo = (CheckBox) findViewById(R.id.cdcToggleAudio);
        this.O00oOooO = (CheckBox) findViewById(R.id.cdcToggleAudio_land);
        $$Lambda$GeneralVideoViewTimeLine$MfnX5lT1sWqiODnCkw6PQMM1w r0 = new CompoundButton.OnCheckedChangeListener() {
            /* class com.mijia.generalplayer.videoview.$$Lambda$GeneralVideoViewTimeLine$MfnX5lT1sWqiODnCkw6PQMM1w */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GeneralVideoViewTimeLine.this.O000000o(compoundButton, z);
            }
        };
        this.O0000ooo.setOnCheckedChangeListener(r0);
        this.O00oOooO.setOnCheckedChangeListener(r0);
        this.O0000ooo.setChecked(false);
        this.O00oOooO.setChecked(false);
        if (this.O0000OOo != 1) {
            this.O0000ooo.setEnabled(false);
            this.O00oOooO.setEnabled(false);
            return;
        }
        this.O0000ooo.setEnabled(true);
        this.O00oOooO.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
        if (this.O000OO00 != z) {
            this.O000OO00 = z;
            this.O0000ooo.setChecked(this.O000OO00);
            this.O00oOooO.setChecked(this.O000OO00);
            chr.O000000o(chr.O00O0OOo);
            if (!z) {
                this.f5221O000000o.O000000o(0.0f);
                return;
            }
            this.f5221O000000o.O000000o(1.0f);
            cjm.O000000o(this.O0000OoO, "plg.4gw.qte.g2w");
        }
    }

    /* access modifiers changed from: protected */
    public final void O0000Oo() {
        this.O000OO0o = true;
        O00000Oo(true);
    }

    /* access modifiers changed from: protected */
    public final void O0000OoO() {
        O0000o00();
    }

    private void setMultiSpeed(int i) {
        if (i == 1) {
            this.O000O0OO.setImageResource(R.drawable.playback_icon_1x);
            this.O000O0Oo.setImageResource(R.drawable.playback_icon_1x);
        } else if (i == 2) {
            this.O000O0OO.setImageResource(R.drawable.playback_icon_2x);
            this.O000O0Oo.setImageResource(R.drawable.playback_icon_2x);
        } else if (i == 4) {
            this.O000O0OO.setImageResource(R.drawable.playback_icon_4x);
            this.O000O0Oo.setImageResource(R.drawable.playback_icon_4x);
        } else if (i == 16) {
            this.O000O0OO.setImageResource(R.drawable.playback_icon_16x);
            this.O000O0Oo.setImageResource(R.drawable.playback_icon_16x);
        }
    }

    public void setOnImageShortListener(View.OnClickListener onClickListener) {
        this.O00oOooo.setOnClickListener(onClickListener);
        this.O000O00o.setOnClickListener(onClickListener);
    }

    public FrameLayout getTime_line_land() {
        return this.O000O0o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    public final void O000000o(Configuration configuration) {
        String str = O0000oO;
        cki.O00000o(str, "orientation:" + configuration.orientation);
        super.O000000o(configuration);
        if (!this.O0000o0O) {
            this.O0000ooO.setVisibility(0);
            this.O0000O0o.setVisibility(0);
            this.O00oOoOo.setVisibility(8);
            this.O000O0o.setVisibility(8);
            this.O000O0oO.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((FrameLayout) this.O00000o.getParent()).getLayoutParams();
            layoutParams.topMargin = cin.O000000o(getContext(), 20.0f);
            ((FrameLayout) this.O00000o.getParent()).setLayoutParams(layoutParams);
            return;
        }
        this.O0000ooO.setVisibility(8);
        this.O0000O0o.setVisibility(0);
        this.O00oOoOo.setVisibility(0);
        int O000000o2 = ckq.O000000o(this.O0000Oo0);
        this.O00oOoOo.setPadding(O000000o2, 0, O000000o2, 0);
        this.O000O0o.setPadding(O000000o2, 0, O000000o2, 0);
        this.O000O0oO.setPadding(O000000o2, 0, O000000o2, 0);
        this.O000O0o.setVisibility(0);
        this.O000O0oO.setVisibility(0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) ((FrameLayout) this.O00000o.getParent()).getLayoutParams();
        layoutParams2.topMargin = cin.O000000o(getContext(), 90.0f);
        ((FrameLayout) this.O00000o.getParent()).setLayoutParams(layoutParams2);
    }

    public final void O000000o() {
        super.O0000o0();
        if (this.O0000ooO.getVisibility() == 0) {
            this.O0000O0o.setVisibility(0);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back_landscape) {
            if (getContext() instanceof cib) {
                ((cib) getContext()).exitFullScreen(null);
            } else {
                setOrientation(1);
            }
        } else if (id == R.id.ivFullScreen) {
            O0000O0o();
        } else if ((id == R.id.tvsMultiSpeed || id == R.id.tvsMultiSpeed_land) && this.f5221O000000o != null) {
            if (this.O0000OOo == 1) {
                this.O0000OOo = 2;
                this.O0000ooo.setChecked(false);
                this.O00oOooO.setChecked(false);
                this.O0000ooo.setEnabled(false);
                this.O00oOooO.setEnabled(false);
            } else {
                this.O0000ooo.setEnabled(true);
                this.O00oOooO.setEnabled(true);
                this.O0000OOo = 1;
            }
            this.f5221O000000o.O000000o(this.O0000OOo);
            setMultiSpeed(this.O0000OOo);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o0() {
        if (this.O000OO0o) {
            O00000o0(false);
        }
    }

    public final void O00000o0(boolean z) {
        if (this.O0000o0O) {
            if (z) {
                FrameLayout frameLayout = this.O000O0o0;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "translationY", (float) frameLayout.getHeight(), 0.0f);
                ofFloat.setDuration(200L);
                ofFloat.start();
                this.O000O0o.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_in2));
                this.O000O0o.setVisibility(0);
                this.O000O0oO.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_ctrl_view_x_trans_in));
                this.O000O0oO.setVisibility(0);
                if (this.O0000O0o.getVisibility() != 0) {
                    this.O0000oOo.setDuration(200);
                    this.O0000O0o.startAnimation(this.O0000oOo);
                    this.O0000O0o.setVisibility(0);
                }
                removeCallbacks(this.O0000oo);
                postDelayed(this.O0000oo, 5000);
                return;
            }
            removeCallbacks(this.O0000oo);
            FrameLayout frameLayout2 = this.O000O0o0;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(frameLayout2, "translationY", 0.0f, (float) frameLayout2.getHeight());
            ofFloat2.setDuration(200L);
            ofFloat2.start();
            this.O000O0o.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_out2));
            this.O000O0o.setVisibility(4);
            this.O000O0oO.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_ctrl_view_x_trans_out));
            this.O000O0oO.setVisibility(8);
            if (this.O0000O0o.getVisibility() == 0) {
                this.O0000oo0.setDuration(200);
                this.O0000O0o.startAnimation(this.O0000oo0);
                this.O0000O0o.setVisibility(4);
            }
        } else if (z) {
            this.O0000ooO.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_in));
            this.O0000ooO.setVisibility(0);
            if (this.O0000O0o.getVisibility() != 0) {
                this.O0000oOo.setDuration(200);
                this.O0000O0o.startAnimation(this.O0000oOo);
                this.O0000O0o.setVisibility(0);
            }
            removeCallbacks(this.O0000oo);
            postDelayed(this.O0000oo, 5000);
        } else if (!this.O0000oOO) {
            removeCallbacks(this.O0000oo);
            this.O0000ooO.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_out));
            this.O0000ooO.setVisibility(4);
            if (this.O0000O0o.getVisibility() == 0) {
                this.O0000oo0.setDuration(200);
                this.O0000O0o.startAnimation(this.O0000oo0);
                this.O0000O0o.setVisibility(4);
            }
        }
    }

    private void O0000o00() {
        boolean z = true;
        if (this.O0000o0O) {
            if (this.O000O0o0.getTranslationY() <= 0.0f) {
                z = false;
            }
            O00000o0(z);
            return;
        }
        if (this.O0000ooO.getVisibility() == 0) {
            z = false;
        }
        O00000o0(z);
    }

    public final void O0000Ooo() {
        if (this.O0000O0o.getVisibility() == 0) {
            return;
        }
        if (this.O0000o0O) {
            if (this.O000O0o0.getTranslationY() > 0.0f) {
                O0000o00();
            } else {
                this.O0000O0o.setVisibility(0);
            }
        } else if (this.O0000ooO.getVisibility() != 0) {
            O0000o00();
        } else if (!this.O0000oOO) {
            this.O0000O0o.setVisibility(0);
        }
    }
}
