package com.mijia.generalplayer.videoview;

import _m_j.chr;
import _m_j.cjm;
import _m_j.ckq;
import _m_j.cks;
import _m_j.gpc;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.xiaomi.smarthome.R;

public final class GeneralVideoView extends BasicVideoView {
    protected TextView O0000oO;
    protected CheckBox O0000oOO;
    private View O0000oOo;
    private TextView O0000oo;
    private SeekBar O0000oo0;
    private TextView O0000ooO;

    public GeneralVideoView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void O0000OOo() {
        super.O0000OOo();
        SeekBar seekBar = this.O0000oo0;
        if (seekBar != null && seekBar.getProgress() < 1000) {
            this.O0000oo0.setProgress(1000);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(long j) {
        setProgressTime(j);
        setVideoStartTime(j);
    }

    /* access modifiers changed from: protected */
    public final void O0000Oo() {
        if (this.f5221O000000o != null) {
            this.O0000ooO.setText(String.valueOf(cks.O000000o(this.f5221O000000o.O00000o() / 1000)));
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
        this.O00000Oo.addView(((LayoutInflater) this.O0000Oo0.getSystemService("layout_inflater")).inflate((int) R.layout.gp_view_general_video_view_bottom_ctrl, this.O00000Oo, false));
        this.O0000oOo = findViewById(R.id.bottom_ctrl_ll);
        this.O00000oo = (ImageView) findViewById(R.id.ivFullScreen);
        this.O0000O0o = (CheckBox) findViewById(R.id.cbTogglePlay);
        this.O00000o = (ImageView) findViewById(R.id.ivImage);
        this.O00000oO = (CardView) findViewById(R.id.card_ivImage);
        this.O0000oOO = (CheckBox) findViewById(R.id.cbIsMute);
        this.O0000oOO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.mijia.generalplayer.videoview.$$Lambda$GeneralVideoView$cQhb07TQ5gQCR4TpmfpcNRDu3g8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GeneralVideoView.this.O000000o(compoundButton, z);
            }
        });
        this.O0000oOO.setChecked(true);
        if (this.O0000OOo != 1) {
            this.O0000oOO.setEnabled(false);
        } else {
            this.O0000oOO.setEnabled(true);
        }
        this.O0000oO = (TextView) findViewById(R.id.tvsMultiSpeed);
        TextView textView = this.O0000oO;
        textView.setText(this.O0000OOo + "X");
        this.O0000oO.setOnClickListener(this);
        this.O0000oo0 = (SeekBar) findViewById(R.id.sbProgress);
        this.O0000oo0.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.mijia.generalplayer.videoview.GeneralVideoView.AnonymousClass1 */

            public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    GeneralVideoView.this.setVideoStartTime((long) ((int) ((((long) i) * GeneralVideoView.this.f5221O000000o.O00000o()) / 1000)));
                }
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
                GeneralVideoView.this.O0000Oo.removeCallbacks(GeneralVideoView.this.O0000oO0);
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
                GeneralVideoView.this.O000000o(seekBar.getProgress());
                GeneralVideoView.this.O0000Oo.postDelayed(GeneralVideoView.this.O0000oO0, 500);
            }
        });
        this.O0000oo = (TextView) findViewById(R.id.tvVideoStart);
        this.O0000ooO = (TextView) findViewById(R.id.tvVideoEnd);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
        chr.O000000o(chr.O00O0OOo);
        if (z) {
            this.f5221O000000o.O000000o(0.0f);
            return;
        }
        this.f5221O000000o.O000000o(1.0f);
        cjm.O000000o(this.O0000OoO, "plg.4gw.qte.g2w");
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ivFullScreen) {
            O0000O0o();
        } else if (id == R.id.tvsMultiSpeed && this.f5221O000000o != null) {
            if (this.O0000OOo == 1) {
                this.O0000OOo = 2;
                this.O0000oOO.setChecked(true);
                this.O0000oOO.setEnabled(false);
            } else {
                this.O0000oOO.setEnabled(true);
                this.O0000OOo = 1;
            }
            this.f5221O000000o.O000000o(this.O0000OOo);
            TextView textView = this.O0000oO;
            textView.setText(this.O0000OOo + "X");
        }
    }

    public final void O000000o(Configuration configuration) {
        super.O000000o(configuration);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O00000oO.getLayoutParams();
        if (!this.O0000o0O) {
            this.O0000oOo.setPadding(0, 0, 0, 0);
            layoutParams.topMargin = gpc.O000000o(30.0f);
        } else {
            int O000000o2 = ckq.O000000o(this.O0000Oo0);
            this.O0000oOo.setPadding(O000000o2, 0, O000000o2, 0);
            layoutParams.topMargin = gpc.O000000o(65.0f);
        }
        this.O00000oO.setLayoutParams(layoutParams);
    }

    private void setProgressTime(long j) {
        long O00000o = this.f5221O000000o.O00000o();
        if (j >= 0 && O00000o > 0) {
            int ceil = (int) Math.ceil((double) ((j * 1000) / O00000o));
            if (ceil >= 1000 || j / 1000 >= O00000o / 1000) {
                this.O0000oo0.setProgress(1000);
            } else {
                this.O0000oo0.setProgress(ceil);
            }
        }
    }

    public final void O0000Ooo() {
        this.O0000oo.setText((int) R.string.gp_time_0);
        this.O0000ooO.setText((int) R.string.gp_time_0);
        if (this.f5221O000000o != null) {
            this.f5221O000000o.O00000oo();
        }
    }

    public final void setVideoStartTime(long j) {
        TextView textView = this.O0000oo;
        textView.setText(cks.O000000o(j / 1000));
    }

    /* access modifiers changed from: protected */
    public final void O0000OoO() {
        if (this.O0000oOo.getTranslationY() <= 0.0f) {
            View view = this.O0000oOo;
            view.setTranslationY((float) view.getHeight());
        } else {
            this.O0000oOo.setTranslationY(0.0f);
        }
        if (this.O00000o0.getTranslationY() >= 0.0f) {
            this.O00000o0.setTranslationY((float) (-this.O00000o0.getHeight()));
        } else {
            this.O00000o0.setTranslationY(0.0f);
        }
    }
}
