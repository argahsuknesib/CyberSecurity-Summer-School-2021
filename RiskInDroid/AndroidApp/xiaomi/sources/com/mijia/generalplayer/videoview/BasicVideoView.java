package com.mijia.generalplayer.videoview;

import _m_j.cib;
import _m_j.ciw;
import _m_j.cjl;
import _m_j.cjm;
import _m_j.cjo;
import _m_j.ckb;
import _m_j.ckc;
import _m_j.cki;
import _m_j.ckk;
import _m_j.ckq;
import _m_j.ckt;
import _m_j.cku;
import _m_j.ckv;
import _m_j.ckw;
import _m_j.fvo;
import _m_j.goq;
import _m_j.gqc;
import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.xiaomi.smarthome.R;
import java.util.Map;

public abstract class BasicVideoView extends FrameLayout implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ckc f5221O000000o;
    protected ViewGroup O00000Oo;
    protected ImageView O00000o;
    protected View O00000o0;
    protected CardView O00000oO;
    protected ImageView O00000oo;
    protected CheckBox O0000O0o;
    protected int O0000OOo = 1;
    protected Handler O0000Oo = new Handler(Looper.getMainLooper());
    protected Activity O0000Oo0;
    protected String O0000OoO;
    public int O0000Ooo;
    public long O0000o;
    public ckb.O00000Oo O0000o0;
    public int O0000o00 = 50;
    protected boolean O0000o0O;
    public int O0000o0o;
    private int O0000oO = 0;
    protected Runnable O0000oO0 = new Runnable() {
        /* class com.mijia.generalplayer.videoview.BasicVideoView.AnonymousClass1 */

        public final void run() {
            if (BasicVideoView.this.f5221O000000o != null) {
                long max = Math.max(BasicVideoView.this.O0000o, Math.min(BasicVideoView.this.f5221O000000o.O0000O0o(), BasicVideoView.this.f5221O000000o.O00000o()));
                BasicVideoView.this.O0000Oo.postDelayed(BasicVideoView.this.O0000oO0, (long) BasicVideoView.this.O0000o00);
                BasicVideoView.this.O00000Oo(max);
                if (BasicVideoView.this.O0000o0 != null) {
                    BasicVideoView.this.O0000o0.onPlaySchedule(max);
                }
            }
        }
    };
    private ImageView O0000oOO;
    private ImageView O0000oOo;
    private long O0000oo;
    private long O0000oo0;
    private String O0000ooO;
    private O000000o O0000ooo;
    private boolean O000O00o = false;
    private int O000O0OO = 0;
    private boolean O000O0Oo;
    private boolean O000O0o0;
    private ckk O00oOoOo = new ckk();
    private ckv O00oOooO;
    private ckt O00oOooo = new ckt();

    public interface O000000o {
        void onChangeOrientation(boolean z);
    }

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(long j);

    /* access modifiers changed from: protected */
    public abstract void O0000Oo();

    /* access modifiers changed from: protected */
    public abstract void O0000Oo0();

    /* access modifiers changed from: protected */
    public abstract void O0000OoO();

    public BasicVideoView(Context context) {
        super(context);
        O000000o(context);
    }

    public BasicVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public BasicVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.O0000Oo0 = (Activity) context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate((int) R.layout.gp_view_general_video_view, this);
        O0000Ooo();
        O0000o00();
    }

    public final void O000000o(String str, String str2) {
        this.O0000OoO = str;
        this.O0000ooO = str2;
    }

    public int getScreenWidth() {
        return hyy.O00000Oo(getContext() instanceof Activity ? ((Activity) getContext()).getIntent() : null).widthPixels;
    }

    private void O0000Ooo() {
        boolean z;
        this.O00000Oo = (ViewGroup) findViewById(R.id.videoViewLayout);
        fvo.O000000o();
        if (fvo.O0000oo0()) {
            fvo.O000000o();
            z = fvo.O00oOooO();
        } else {
            z = cjo.O000000o().O00000o0();
        }
        this.f5221O000000o = cku.O000000o(this.O0000Oo0, z);
        this.O0000Ooo = (int) (((float) getScreenWidth()) * 0.5625f);
        ViewGroup.LayoutParams layoutParams = this.O00000Oo.getLayoutParams();
        layoutParams.height = this.O0000Ooo;
        this.O00000Oo.setLayoutParams(layoutParams);
        this.O00000Oo.addView(this.f5221O000000o.O00000Oo(), 1);
        this.O0000oOo = (ImageView) findViewById(R.id.ivImagePreview);
        this.f5221O000000o.O000000o(new ckb.O00000Oo() {
            /* class com.mijia.generalplayer.videoview.BasicVideoView.AnonymousClass2 */

            public final void onPrepared() {
                cki.O00000o("BasicVideoView", "onPrepared");
                BasicVideoView.this.O0000Oo();
                if (BasicVideoView.this.O0000o0 != null) {
                    BasicVideoView.this.O0000o0.onPrepared();
                }
            }

            public final void onLoadingChanged(boolean z) {
                if (z) {
                    BasicVideoView.this.O000000o(false);
                } else {
                    BasicVideoView.this.O0000o0();
                }
                if (BasicVideoView.this.O0000o0 != null) {
                    BasicVideoView.this.O0000o0.onLoadingChanged(z);
                }
                cki.O00000o("BasicVideoView", "onLoadingChanged:".concat(String.valueOf(z)));
            }

            /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
            public final void onPlayerStateChanged(int i) {
                BasicVideoView basicVideoView;
                if (i != 1) {
                    if (i == 2) {
                        BasicVideoView.this.O000000o(false);
                    } else if (i != 3) {
                        if (i == 4) {
                            BasicVideoView.this.O0000o0();
                            BasicVideoView.this.O0000OOo();
                        }
                    }
                    basicVideoView = BasicVideoView.this;
                    basicVideoView.O0000o0o = i;
                    if (basicVideoView.O0000o0 != null) {
                        BasicVideoView.this.O0000o0.onPlayerStateChanged(i);
                    }
                    cki.O00000o("BasicVideoView", "playbackState:".concat(String.valueOf(i)));
                }
                BasicVideoView.this.O0000o0();
                basicVideoView = BasicVideoView.this;
                basicVideoView.O0000o0o = i;
                if (basicVideoView.O0000o0 != null) {
                }
                cki.O00000o("BasicVideoView", "playbackState:".concat(String.valueOf(i)));
            }

            public final void onPlayerError(String str) {
                BasicVideoView.this.O0000o0();
                if (str != null) {
                    cki.O00000oO("BasicVideoView", "onPlayerError:".concat(String.valueOf(str)));
                }
                if (BasicVideoView.this.O0000o0 != null) {
                    BasicVideoView.this.O0000o0.onPlayerError(str);
                }
                cki.O0000OOo("2000.5.3", BasicVideoView.this.getContext().getClass().getSimpleName() + "onPlayerError");
            }

            public final void isPlayingChanged(boolean z) {
                cki.O00000o("BasicVideoView", "isPlayingChanged:".concat(String.valueOf(z)));
                if (z) {
                    BasicVideoView.this.O0000Oo.post(BasicVideoView.this.O0000oO0);
                } else {
                    BasicVideoView.this.O0000Oo.removeCallbacks(BasicVideoView.this.O0000oO0);
                }
                if (BasicVideoView.this.O0000o0 != null) {
                    BasicVideoView.this.O0000o0.isPlayingChanged(z);
                }
            }
        });
        this.f5221O000000o.O000000o(new ckb.O000000o() {
            /* class com.mijia.generalplayer.videoview.BasicVideoView.AnonymousClass3 */

            public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
                cki.O00000o("BasicVideoView", "onVideoSizeChanged:" + i + " height:" + i2);
                if (BasicVideoView.this.O0000Oo0.getRequestedOrientation() == 1) {
                    int screenWidth = BasicVideoView.this.getScreenWidth();
                    ViewGroup.LayoutParams layoutParams = BasicVideoView.this.O00000Oo.getLayoutParams();
                    BasicVideoView basicVideoView = BasicVideoView.this;
                    basicVideoView.O0000Ooo = (i2 * screenWidth) / i;
                    layoutParams.height = basicVideoView.O0000Ooo;
                    layoutParams.width = screenWidth;
                    BasicVideoView.this.O00000Oo.setLayoutParams(layoutParams);
                    BasicVideoView.this.O00000Oo.requestLayout();
                }
            }

            public final void onRenderViewClicked(View view) {
                BasicVideoView.this.O0000OoO();
            }
        });
        this.f5221O000000o.O000000o((float) this.O000O0OO);
        this.O00000Oo.setOnClickListener(this);
        this.O0000oOO = (ImageView) findViewById(R.id.ivVideoLoading);
        this.O00000o0 = findViewById(R.id.videoViewTopCtrl);
    }

    private void O0000o00() {
        O0000Oo0();
        this.O00000oo.setOnClickListener(this);
        this.O0000O0o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.mijia.generalplayer.videoview.$$Lambda$BasicVideoView$k3LyqjAQFn779jI7oCBcyyQDB8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BasicVideoView.this.O000000o(compoundButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            if (z) {
                O00000oO();
            } else {
                O00000o();
            }
        }
    }

    public ImageView getIvBack2() {
        ckv ckv = this.O00oOooO;
        if (ckv == null) {
            return null;
        }
        return ckv.O00000oO;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mijia.generalplayer.videoview.BasicVideoView.O000000o(int[], _m_j.ckv$O000000o, boolean):void
     arg types: [int[], _m_j.ckv$O000000o, int]
     candidates:
      com.mijia.generalplayer.videoview.BasicVideoView.O000000o(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, long):void
      com.mijia.generalplayer.videoview.BasicVideoView.O000000o(int[], _m_j.ckv$O000000o, boolean):void */
    public final void O000000o(int[] iArr, ckv.O000000o o000000o) {
        O000000o(iArr, o000000o, true);
    }

    public final void O000000o(int[] iArr, ckv.O000000o o000000o, boolean z) {
        this.O00oOooO = new ckv(this.O00000Oo, o000000o, z, iArr);
        this.O00oOooO.O00000oo = new ckv.O00000Oo() {
            /* class com.mijia.generalplayer.videoview.$$Lambda$BasicVideoView$pJH9oxKyLeS7EfQaf0E1vpfi0v0 */

            public final void onBack() {
                BasicVideoView.this.O0000o0O();
            }
        };
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o0O() {
        setOrientation(1);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        cki.O00000o("BasicVideoView", "onWindowFocusChanged:".concat(String.valueOf(z)));
        if (z) {
            O00000Oo();
        } else {
            O00000o0();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (ciw.O000000o(this.O0000Oo0.getRequestedOrientation())) {
            setOrientation(1);
        }
        Runnable runnable = this.O0000oO0;
        if (runnable != null) {
            this.O0000Oo.removeCallbacks(runnable);
        }
        cki.O00000o("BasicVideoView", "onDetached release iVideoPlayer");
        ckc ckc = this.f5221O000000o;
        if (ckc != null) {
            ckc.O00000oo();
            this.f5221O000000o.O0000Oo();
        }
    }

    public void O000000o(Configuration configuration) {
        cki.O00000o("BasicVideoView", "orientation:" + configuration.orientation);
        boolean z = configuration.orientation == 1;
        this.O0000o0O = !z;
        if ((getContext() instanceof cib) && hyy.O000000o()) {
            this.O0000o0O = ((cib) getContext()).getFullScreenThroughPad(this.O0000o0O);
        }
        if (getContext() != null && (getContext() instanceof Activity)) {
            hyy.O000000o((Activity) getContext(), this.O0000o0O);
        }
        if (!this.O0000o0O) {
            this.O0000Oo0.getWindow().clearFlags(1024);
            this.O00000oo.setVisibility(0);
            ViewGroup viewGroup = this.O00000Oo;
            if (viewGroup != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                layoutParams.height = this.O0000Ooo;
                this.O00000o0.setPadding(0, 0, 0, 0);
                this.O00000Oo.setLayoutParams(layoutParams);
                this.O00000Oo.requestLayout();
            }
        } else {
            this.O0000Oo0.getWindow().setFlags(1024, 1024);
            this.O00000oo.setVisibility(8);
            ViewGroup viewGroup2 = this.O00000Oo;
            if (viewGroup2 != null) {
                ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                int O000000o2 = ckq.O000000o(this.O0000Oo0);
                this.O00000o0.setPadding(O000000o2, 0, O000000o2, 0);
                this.O00000Oo.setLayoutParams(layoutParams2);
                this.O00000Oo.requestLayout();
            }
        }
        ckv ckv = this.O00oOooO;
        if (ckv != null) {
            ckv.O000000o(!this.O0000o0O);
        }
        O000000o o000000o = this.O0000ooo;
        if (o000000o != null) {
            o000000o.onChangeOrientation(true ^ this.O0000o0O);
        }
        if (!this.O0000o0O) {
            setScaleEnable(this.O000O00o);
        } else {
            this.f5221O000000o.O00000o0().setOnTouchListener(new ckw());
        }
        gqc.O000000o(z, this.O0000Oo0.getWindow().getDecorView());
    }

    public final void O000000o(boolean z) {
        cki.O00000o0("BasicVideoView", "showVideoLoading %b", Boolean.valueOf(z));
        ImageView imageView = this.O0000oOO;
        if (imageView != null && !this.O000O0o0) {
            imageView.setVisibility(0);
            Drawable drawable = this.O0000oOO.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
            }
            if (z) {
                this.O0000Oo.postDelayed(new Runnable() {
                    /* class com.mijia.generalplayer.videoview.$$Lambda$BasicVideoView$ke8E6dexiKiP8Fg9yxo55YJ04 */

                    public final void run() {
                        BasicVideoView.this.O0000o0();
                    }
                }, 5000);
            }
        }
    }

    /* renamed from: O000000o */
    public void O0000o0() {
        cki.O00000o("BasicVideoView", "hideVideoLoading");
        this.O00oOoOo.O00000Oo("BasicVideoView", "start_play", "hideVideoLoading");
        this.O00oOoOo.O00000Oo("BasicVideoView", "start_seek", "hideVideoLoading");
        ImageView imageView = this.O0000oOO;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).stop();
            }
            this.O0000oOO.setVisibility(8);
        }
    }

    public final void O00000Oo() {
        if (this.O000O0Oo) {
            cki.O00000o("BasicVideoView", "onResume is hidden");
            return;
        }
        this.O0000oo0 = System.currentTimeMillis();
        this.O0000oo = this.O0000oo0;
        this.O0000Oo0.getWindow().setFlags(NotificationCompat.FLAG_HIGH_PRIORITY, NotificationCompat.FLAG_HIGH_PRIORITY);
        if (this.O0000oO == 2) {
            this.f5221O000000o.O0000Oo0();
        }
    }

    public final void O00000o0() {
        this.O0000oo = System.currentTimeMillis();
        long j = this.O0000oo - this.O0000oo0;
        if (j > 0) {
            cjm.O000000o(this.O0000OoO, "plg.4gw.4fn.53o", j);
        }
        this.O0000Oo0.getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        this.O0000oO = this.O0000O0o.isChecked() ? 1 : 2;
        ckc ckc = this.f5221O000000o;
        if (ckc != null) {
            ckc.O0000OOo();
        }
    }

    /* access modifiers changed from: protected */
    public void setOrientation(int i) {
        this.O0000Oo0.setRequestedOrientation(i);
    }

    private void O00000o0(String str, Map<String, String> map) {
        this.f5221O000000o.O000000o(str, map);
        this.O000O0o0 = str.startsWith("/");
    }

    public final void O000000o(int i) {
        ckc ckc;
        if (i >= 0 && (ckc = this.f5221O000000o) != null && ckc.O00000o() > 0) {
            long O00000o2 = (long) ((int) ((((long) i) * this.f5221O000000o.O00000o()) / 1000));
            this.O0000o = O00000o2;
            this.f5221O000000o.O000000o(O00000o2);
            O000000o(false);
            this.O00oOoOo.O000000o("BasicVideoView", "start_seek", "");
        }
    }

    public final void O000000o(String str, Map<String, String> map) {
        cki.O00000o("BasicVideoView", "startPlay:".concat(String.valueOf(str)));
        this.O00oOoOo.O000000o("BasicVideoView", "start_play", "");
        O00000o0(str, map);
        this.f5221O000000o.O0000Oo0();
        this.O0000O0o.setChecked(false);
        this.O0000o = 0;
    }

    public final void O00000Oo(String str, Map<String, String> map) {
        cki.O00000o("BasicVideoView", "preparePlay:".concat(String.valueOf(str)));
        O00000o0(str, map);
        this.O0000O0o.setChecked(true);
    }

    public final void O00000o() {
        if (this.O0000o0o == 4) {
            this.f5221O000000o.O000000o(0L);
        }
        this.f5221O000000o.O0000Oo0();
        this.O0000O0o.setChecked(false);
        this.O0000o = 0;
    }

    public final void O00000oO() {
        this.f5221O000000o.O0000OOo();
        this.O0000O0o.setChecked(true);
    }

    public final void O000000o(Intent intent) {
        cjl.O000000o(this.O0000Oo0, this.O0000OoO, this.O0000ooO, this.f5221O000000o, this.O00000o, intent);
    }

    public void setOnConfigurationChangedListener(O000000o o000000o) {
        this.O0000ooo = o000000o;
    }

    public ckc getPlayer() {
        return this.f5221O000000o;
    }

    public final void O000000o(long j) {
        this.O0000o = j;
        this.f5221O000000o.O000000o(j);
        this.f5221O000000o.O0000Oo0();
        this.O0000O0o.setChecked(false);
        O000000o(false);
        this.O00oOoOo.O000000o("BasicVideoView", "start_play", "");
    }

    public final void O000000o(String str, Map<String, String> map, long j) {
        this.f5221O000000o.O00000Oo(j);
        O00000Oo(str, map);
        O000000o(j);
    }

    public void setScaleEnable(boolean z) {
        this.O000O00o = z;
        this.f5221O000000o.O00000o0().setOnTouchListener(z ? this.O00oOooo : null);
    }

    public final void O00000oo() {
        setOrientation(1);
    }

    public final void O0000O0o() {
        if (!this.O0000o0O) {
            cjm.O000000o(this.O0000OoO, "plg.4gw.ohr.iqo");
            if (getContext() instanceof cib) {
                ((cib) getContext()).enterPadFullScreen();
            }
            setOrientation(0);
            return;
        }
        setOrientation(1);
    }

    public final void O000000o(String str) {
        goq.O000000o(new Runnable(str) {
            /* class com.mijia.generalplayer.videoview.$$Lambda$BasicVideoView$WoZVU2r_L6wf_lxnbJHsNADuv88 */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                BasicVideoView.this.O00000Oo(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Bitmap bitmap) {
        this.O0000oOo.setImageBitmap(bitmap);
        this.O0000oOo.setVisibility(0);
    }

    public void setPlayerListener(ckb.O00000Oo o00000Oo) {
        this.O0000o0 = o00000Oo;
    }

    public void setHidden(boolean z) {
        this.O000O0Oo = z;
    }

    /* access modifiers changed from: protected */
    public void O0000OOo() {
        this.O0000O0o.setChecked(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        mediaMetadataRetriever.release();
        this.O0000oOo.post(new Runnable(frameAtTime) {
            /* class com.mijia.generalplayer.videoview.$$Lambda$BasicVideoView$JM48_qnzsiQsFHr_Ub1ZX9PMtxQ */
            private final /* synthetic */ Bitmap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                BasicVideoView.this.O000000o(this.f$1);
            }
        });
    }
}
