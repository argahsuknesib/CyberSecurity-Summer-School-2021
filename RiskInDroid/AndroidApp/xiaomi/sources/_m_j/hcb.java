package _m_j;

import _m_j.chu;
import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.fastvideo.VideoView;
import com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyEnterActivity;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import com.xiaomi.smarthome.newui.widget.PieProgressBar;

public final class hcb<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hcf<C, E, T> {
    private View O0000o;
    private PieProgressBar O0000o0o;
    private ImageView O0000oO;
    private ProgressBar O0000oO0;
    private FrameLayout O0000oOO;
    private VideoView O0000oOo;
    private Device O0000oo;
    private TextView O0000oo0;
    private ImageView O0000ooO;
    private View O0000ooo;
    private boolean O00oOooO;
    private boolean O00oOooo;

    public final void onUpdateViewScale(View view, int i, float f) {
    }

    public hcb(E e, T[] tArr) {
        super(e, tArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gth.O000000o(int, java.io.OutputStream):void
      _m_j.gth.O000000o(android.content.Context, com.xiaomi.smarthome.device.Device):void
      _m_j.gth.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.fastvideo.VideoView):void
      _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0 */
    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        Device O00000oO = O00000oO();
        if (gth.O000000o().O00000Oo(O00000oO.did) == null) {
            gth.O000000o().O000000o(O00000oO.did, false);
        }
        FrameLayout frameLayout = (FrameLayout) O000000o(viewGroup, (int) R.layout.card_item_camera);
        this.O0000o = frameLayout.findViewById(R.id.play_button);
        this.O0000oO = (ImageView) frameLayout.findViewById(R.id.video_view_cover);
        this.O0000oO0 = (ProgressBar) frameLayout.findViewById(R.id.camera_loading);
        this.O0000o0o = (PieProgressBar) frameLayout.findViewById(R.id.download_progress);
        this.O0000oOO = (FrameLayout) frameLayout.findViewById(R.id.video_view_container);
        this.O0000oo0 = (TextView) frameLayout.findViewById(R.id.progress_text);
        this.O0000ooO = (ImageView) frameLayout.findViewById(R.id.play_image);
        this.O0000ooo = frameLayout.findViewById(R.id.play_text);
        PieProgressBar pieProgressBar = this.O0000o0o;
        View view = this.O0000o;
        ProgressBar progressBar = this.O0000oO0;
        ImageView imageView = this.O0000oO;
        TextView textView = this.O0000oo0;
        this.O0000oo = O00000oO;
        pieProgressBar.setPercentView(textView);
        view.setOnClickListener(new View.OnClickListener(O00000oO) {
            /* class _m_j.$$Lambda$hcb$B3x1Zgf5uIW6YfeCeBOcuZUWl6c */
            private final /* synthetic */ Device f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                hcb.this.O000000o(this.f$1, view);
            }
        });
        gth.O000000o().O000000o(O00000oO, imageView, progressBar);
        O000000o(hfa.O000000o((Object[]) this.f18773O000000o), this.O0000Ooo.O00000Oo(O00000oO, hfa.O000000o((Object[]) this.f18773O000000o)));
    }

    private void O000000o(int i) {
        PieProgressBar pieProgressBar = this.O0000o0o;
        if (pieProgressBar != null && this.O0000oo0 != null) {
            pieProgressBar.setVisibility(8);
            this.O0000oo0.setVisibility(8);
        }
    }

    private void O000000o(boolean z, boolean z2) {
        if (z) {
            this.O0000o.setVisibility(8);
            return;
        }
        this.O0000o.setVisibility(0);
        this.O0000oO0.setVisibility(8);
        this.O0000oO.setVisibility(0);
        if (z2) {
            this.O0000ooO.setImageResource(R.drawable.camera_play_large);
            this.O0000ooo.setVisibility(8);
            return;
        }
        this.O0000ooO.setImageResource(R.drawable.card_camera_sleep);
        this.O0000ooo.setVisibility(0);
    }

    private void O0000O0o() {
        this.O0000oOo = new VideoView(CommonApplication.getAppContext());
        VideoView videoView = this.O0000oOo;
        FrameLayout frameLayout = this.O0000oOO;
        videoView.O000000o(gpc.O000000o(274.55f), gpc.O000000o(155.85f), false);
        videoView.setVideoViewListener(new VideoView.O000000o() {
            /* class _m_j.$$Lambda$hcb$xzujskKzlrZNLaqXzIEk27jBWI */

            public final void onVideoViewClick() {
                hcb.this.O0000Oo0();
            }
        });
        frameLayout.addView(videoView);
    }

    private void O0000OOo() {
        FrameLayout frameLayout = this.O0000oOO;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.O0000oOo = null;
    }

    public final boolean O000000o(Device device, hdb hdb) {
        if (!device.isOnline || this.O0000o0O == BaseCardRender.DataInitState.NOT || this.O0000o0O == BaseCardRender.DataInitState.DOING) {
            return false;
        }
        if (this.O00000o0 == null || this.O00000o0.size() == 0 || this.O0000Ooo.O000000o(device, hdb)) {
            return true;
        }
        return false;
    }

    public final void O000000o() {
        super.O000000o();
        if (this.O00oOooO) {
            O000000o(hfa.O000000o((Object[]) this.f18773O000000o), this.O0000Ooo.O00000Oo(this.O0000oo, hfa.O000000o((Object[]) this.f18773O000000o)));
        }
    }

    public final void O00000Oo() {
        super.O00000Oo();
        this.O00oOooO = gth.O000000o().O00000Oo(this.O0000oo);
        O00000Oo(O000000o(this.O0000oo, (hdb) null));
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000O0o = null;
        this.O0000o0o = null;
        this.O0000o = null;
        this.O0000oO0 = null;
        this.O0000oO = null;
        this.O0000oOO = null;
        this.O0000oOo = null;
        this.O0000oo0 = null;
    }

    public final void O000000o(T t, Object obj) {
        if (!this.O0000Oo0 && this.O0000o != null && this.O0000oO0 != null && this.O0000o0o != null && this.O0000oo0 != null && this.O0000oO != null) {
            if (!this.O0000oo.isOnline) {
                this.O0000o.setVisibility(8);
                this.O0000oO0.setVisibility(8);
                O000000o(8);
                return;
            }
            boolean O000000o2 = O000000o(this.O0000oo, (hdb) null);
            O000000o(8);
            if (O000000o2) {
                if (gth.O000000o().O00000Oo(this.O0000oo)) {
                    this.O0000oO.setVisibility(8);
                }
                O000000o(O000000o2);
                return;
            }
            O00000Oo(O000000o2);
            this.O0000oO0.setVisibility(8);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hcb.O000000o(boolean, boolean):void
     arg types: [int, boolean]
     candidates:
      _m_j.hcb.O000000o(com.xiaomi.smarthome.device.Device, android.view.View):void
      _m_j.hcb.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcb.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcf.O000000o(android.view.ViewGroup, int):android.view.View
      _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcy.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcb.O000000o(boolean, boolean):void */
    public final void O000000o(boolean z) {
        if (!this.O0000Oo0) {
            O000000o(true, z);
            if (!z || this.O00oOooo) {
                gsy.O000000o(4, "mijia-card", "startPlay fail enable:" + z + " mStartPlay:" + this.O00oOooo);
            } else if (!this.O0000O0o.O00000oo()) {
                O00000Oo(z);
            } else {
                if (this.O0000oOo == null) {
                    O0000O0o();
                }
                VideoView videoView = this.O0000oOo;
                ProgressBar progressBar = this.O0000oO0;
                progressBar.setVisibility(0);
                gth.O000000o().O000000o(this.O0000oo, videoView);
                gth.O000000o().O00000oO(this.O0000oo);
                gth.O000000o().O000000o(CommonApplication.getAppContext(), this.O0000oo, progressBar);
                this.O00oOooo = true;
                gsy.O000000o(4, "mijia-card", "startPlay");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hcb.O000000o(boolean, boolean):void
     arg types: [int, boolean]
     candidates:
      _m_j.hcb.O000000o(com.xiaomi.smarthome.device.Device, android.view.View):void
      _m_j.hcb.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcb.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcf.O000000o(android.view.ViewGroup, int):android.view.View
      _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcy.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcb.O000000o(boolean, boolean):void */
    public final void O00000Oo(boolean z) {
        if (!this.O0000Oo0) {
            VideoView videoView = this.O0000oOo;
            if (videoView != null) {
                gth.O000000o().O00000Oo(this.O0000oo, videoView);
            }
            gth.O000000o().O000000o(CommonApplication.getAppContext(), this.O0000oo);
            gsy.O000000o(4, "mijia-card", "stopPlay");
            this.O00oOooo = false;
            O0000OOo();
            O000000o(false, z);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Oo0() {
        if (!this.O0000Oo0) {
            O00000Oo(O000000o(this.O0000oo, (hdb) null));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hcb.O000000o(boolean, boolean):void
     arg types: [int, boolean]
     candidates:
      _m_j.hcb.O000000o(com.xiaomi.smarthome.device.Device, android.view.View):void
      _m_j.hcb.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcb.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcf.O000000o(android.view.ViewGroup, int):android.view.View
      _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcy.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcb.O000000o(boolean, boolean):void */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final Device device, View view) {
        if (!this.O0000Oo0 && O000000o(device, (hdb) null)) {
            boolean O000000o2 = O000000o(device, (hdb) null);
            if (!this.O0000O0o.O00000oo()) {
                this.O0000O0o.O000000o(DevicePinVerifyEnterActivity.class);
                return;
            }
            String str = device.model;
            chu chu = chu.O000000o.f13841O000000o;
            if (chu.O000000o(str) || fbn.O000000o(device.model)) {
                O000000o(O000000o2);
            } else if (!this.O0000Oo0) {
                ProgressBar progressBar = this.O0000oO0;
                O000000o(true, O000000o2);
                progressBar.setVisibility(0);
                if (this.O00000oo != null) {
                    this.O00000oo.setCallback(new hhi() {
                        /* class _m_j.hcb.AnonymousClass1 */

                        public final void O000000o() {
                            if (!hcb.this.O0000Oo0) {
                                hcb hcb = hcb.this;
                                hcb.O000000o(hcb.O000000o(device, (hdb) null));
                            }
                        }

                        public final void O00000Oo() {
                            if (!hcb.this.O0000Oo0) {
                                hcb hcb = hcb.this;
                                hcb.O00000Oo(hcb.O000000o(device, (hdb) null));
                            }
                        }

                        public final void O00000o0() {
                            if (!hcb.this.O0000Oo0) {
                                hcb hcb = hcb.this;
                                hcb.O00000Oo(hcb.O000000o(device, (hdb) null));
                            }
                        }
                    });
                    this.O00000oo.O000000o(device);
                }
            }
        }
    }
}
