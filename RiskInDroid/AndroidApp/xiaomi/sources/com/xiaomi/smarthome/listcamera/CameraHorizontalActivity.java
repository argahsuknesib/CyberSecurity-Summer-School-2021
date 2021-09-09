package com.xiaomi.smarthome.listcamera;

import _m_j.ext;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fwq;
import _m_j.ggb;
import _m_j.gsy;
import _m_j.gth;
import _m_j.gti;
import _m_j.ha;
import _m_j.hte;
import _m_j.hxi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.fastvideo.VideoView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.listcamera.adapter.CameraLargeAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CameraHorizontalActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    RecyclerView f9389O000000o;
    int O00000Oo;
    private String O00000o;
    List<O00000o0> O00000o0 = new ArrayList();
    private HashSet<String> O00000oO = new HashSet<>();
    private O00000o0 O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo = false;
    private int O0000Oo0 = 0;
    public boolean isAutoPlay;
    public boolean isRequestingPermission = false;
    public final List<Device> mCameraDevices = new ArrayList();
    public Handler mControlViewHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            RecyclerView.O000000o adapter = CameraHorizontalActivity.this.f9389O000000o.getAdapter();
            if (adapter != null && (message.obj instanceof O0000O0o)) {
                adapter.notifyItemRangeChanged(0, adapter.getItemCount(), new O00000Oo((O0000O0o) message.obj));
            }
        }
    };
    public ha pagerSnapHelper;
    public int scrolledDx;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final List<String> f9395O000000o = Arrays.asList("mijia.camera.v3", "mijia.camera.v1", "chuangmi.camera.ipc009", "chuangmi.camera.ipc019", "isa.camera.hlc6", "chuangmi.camera.ipc021", "chuangmi.camera.ipc022", "chuangmi.camera.ip026c", "chuangmi.camera.ip029a", "chuangmi.camera.026c02", "chuangmi.camera.029a02", "chuangmi.camera.021a04");

        public static boolean O000000o(String str) {
            return f9395O000000o.contains(str);
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        O0000O0o f9396O000000o;

        public O00000Oo(O0000O0o o0000O0o) {
            this.f9396O000000o = o0000O0o;
        }
    }

    public void doAutoPlay() {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.AnonymousClass2 */

            public final void run() {
                if (CameraHorizontalActivity.this.isAutoPlay && CameraHorizontalActivity.this.f9389O000000o != null) {
                    CameraHorizontalActivity cameraHorizontalActivity = CameraHorizontalActivity.this;
                    cameraHorizontalActivity.isAutoPlay = false;
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) cameraHorizontalActivity.f9389O000000o.getLayoutManager()).findFirstVisibleItemPosition();
                    if (findFirstVisibleItemPosition >= 0) {
                        Device device = CameraHorizontalActivity.this.mCameraDevices.get(findFirstVisibleItemPosition);
                        O00000o0 o00000o0 = (O00000o0) CameraHorizontalActivity.this.f9389O000000o.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                        if (device != null && o00000o0 != null && !gth.O000000o().O000000o(device)) {
                            CameraHorizontalActivity.this.togglePlay(o00000o0, device);
                        }
                    }
                }
            }
        }, 100);
    }

    public void onPause() {
        gsy.O000000o(3, "CameraHorizontalActivit", "onPause: ");
        O000000o(this.isRequestingPermission);
        this.isRequestingPermission = false;
        super.onPause();
    }

    private void O000000o(boolean z) {
        int findFirstVisibleItemPosition;
        if (this.O00000oo != null) {
            RecyclerView.LayoutManager layoutManager = this.f9389O000000o.getLayoutManager();
            if ((layoutManager instanceof LinearLayoutManager) && (findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) >= 0) {
                gsy.O000000o(3, "CameraHorizontalActivit", "doClear: realStop: ".concat(String.valueOf(z)));
                if (z) {
                    O00000Oo(this.O00000oo, this.mCameraDevices.get(findFirstVisibleItemPosition));
                }
                this.O00000oo.O00000Oo();
                this.O00000oo.O00000oo();
                this.O00000oo.O00000o();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mControlViewHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().clearFlags(2048);
        getWindow().clearFlags(1024);
        this.O00000oO.clear();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public void togglePlay(O00000o0 o00000o0, Device device) {
        this.O00000oo = o00000o0;
        if (gth.O000000o().O000000o(device)) {
            O00000Oo(o00000o0, device);
        } else if (!gth.O000000o().O00000Oo()) {
            if (device == null || device.isSetPinCode == 0 || this.O00000oO.contains(device.did)) {
                O000000o(o00000o0, device);
            } else {
                fbt fbt = new fbt(this, "DevicePinVerifyEnterActivity");
                fbt.O000000o("extra_device_did", device.did);
                fbt.O000000o("verfy_pincode_first", true);
                fbt.O000000o("style_dialog", true);
                fbt.O000000o(100);
                fbs.O000000o(fbt);
                return;
            }
        } else {
            return;
        }
        if (gth.O000000o().O000000o(device)) {
            o00000o0.O0000OoO.setImageResource(R.drawable.all_camera_item_puase_land);
        } else {
            o00000o0.O0000OoO.setImageResource(R.drawable.all_camera_item_play_land);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(O00000o0 o00000o0, Device device) {
        if (o00000o0.O0000O0o == null) {
            o00000o0.O00000o0();
        }
        gth.O000000o().O000000o(device, o00000o0.O0000O0o);
        gth.O00000o0 O00000Oo2 = gth.O000000o().O00000Oo(device.did);
        if (!this.O0000OOo && device.did.equals(this.O00000o)) {
            O00000Oo2.O0000OOo = this.O0000O0o;
            this.O0000OOo = true;
        }
        if (O00000Oo2 == null || !gth.O000000o().O000000o(device)) {
            gth.O000000o().O000000o(getContext(), device, o00000o0.O0000Oo0);
        }
        o00000o0.O000000o();
        this.O00000oo = o00000o0;
        o00000o0.O00000oO();
        hxi.O00000oo.O000000o(4);
    }

    private void O000000o(O00000o0 o00000o0) {
        o00000o0.O00000oo.removeAllViews();
        o00000o0.O0000O0o = null;
        this.O00000oo = o00000o0;
        o00000o0.O00000oo();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(O00000o0 o00000o0, Device device) {
        gth.O000000o().O00000Oo(device, o00000o0.O0000O0o);
        gth.O000000o().O000000o(getContext(), device);
        O000000o(o00000o0);
        this.mControlViewHandler.removeCallbacksAndMessages(null);
    }

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final int[] f9397O000000o;

        public O00000o(int... iArr) {
            this.f9397O000000o = iArr;
        }

        public final void O000000o(View view, int i) {
            for (int findViewById : this.f9397O000000o) {
                View findViewById2 = view.findViewById(findViewById);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(i);
                }
            }
        }

        public final int O000000o(View view) {
            int[] iArr = this.f9397O000000o;
            if (iArr.length == 0) {
                return 8;
            }
            for (int findViewById : iArr) {
                View findViewById2 = view.findViewById(findViewById);
                if (findViewById2 != null) {
                    return findViewById2.getVisibility();
                }
            }
            return 8;
        }
    }

    class O00000o0 extends CameraLargeAdapter.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f9398O000000o;
        public ImageView O00000Oo;
        public TextView O00000o;
        public TextView O00000o0;
        public ImageView O00000oO;
        public FrameLayout O00000oo;
        public VideoView O0000O0o;
        public ImageView O0000OOo;
        public ImageView O0000Oo;
        public ProgressBar O0000Oo0;
        public ImageView O0000OoO;
        public ImageView O0000Ooo;
        public O00000o O0000o0 = new O00000o(R.id.device_name, R.id.room_name, R.id.back_button, R.id.enter_plugin, R.id.play_button, R.id.mute_button);
        public ImageView O0000o00;
        public boolean O0000o0O = false;
        public String O0000o0o;

        public O00000o0(View view) {
            super(view);
            if (view instanceof ViewGroup) {
                this.f9398O000000o = (TextView) view.findViewById(R.id.camera_state_desc);
                this.O00000Oo = (ImageView) view.findViewById(R.id.camera_state_iv);
                this.O00000o0 = (TextView) view.findViewById(R.id.device_name);
                this.O00000o = (TextView) view.findViewById(R.id.room_name);
                this.O00000oo = (FrameLayout) view.findViewById(R.id.video_view_container);
                this.O00000oO = (ImageView) view.findViewById(R.id.video_view_cover);
                this.O0000OOo = (ImageView) view.findViewById(R.id.mute_button);
                this.O0000o00 = (ImageView) view.findViewById(R.id.call_button);
                this.O0000Oo0 = (ProgressBar) view.findViewById(R.id.loading_progress);
                this.O0000Oo = (ImageView) view.findViewById(R.id.back_button);
                this.O0000OoO = (ImageView) view.findViewById(R.id.play_button);
                this.O0000Ooo = (ImageView) view.findViewById(R.id.enter_plugin);
            }
        }

        public final void O000000o() {
            O0000O0o O0000O0o2 = O0000O0o();
            CameraHorizontalActivity.this.mControlViewHandler.removeMessages(O0000O0o2.O00000Oo.hashCode());
            Message obtain = Message.obtain();
            obtain.what = O0000O0o2.O00000Oo.hashCode();
            obtain.obj = O0000O0o2;
            CameraHorizontalActivity.this.mControlViewHandler.sendMessageDelayed(obtain, 3000);
        }

        private O0000O0o O0000O0o() {
            return new O0000O0o(hashCode(), this.O0000o0o);
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            gth.O00000o0 O00000Oo2 = gth.O000000o().O00000Oo(this.O0000o0o);
            if (O00000Oo2 == null || !O00000Oo2.O0000Oo) {
                this.O0000OoO.setImageResource(R.drawable.all_camera_item_play_land);
            } else {
                this.O0000OoO.setImageResource(R.drawable.all_camera_item_puase_land);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0() {
            this.O0000O0o = new VideoView(CameraHorizontalActivity.this.getContext());
            int measuredWidth = CameraHorizontalActivity.this.f9389O000000o.getMeasuredWidth();
            this.O0000O0o.O000000o(measuredWidth, (measuredWidth * 9) / 16, true);
            this.O0000O0o.setVideoViewListener(new VideoView.O000000o() {
                /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.O00000o0.AnonymousClass6 */

                public final void onVideoViewClick() {
                    O00000o0.this.O00000Oo();
                    Device O000000o2 = fno.O000000o().O000000o(O00000o0.this.O0000o0o);
                    gsy.O000000o(3, "AAAA", "onVideoViewClick: " + O000000o2.name);
                    boolean O000000o3 = O000000o.O000000o(O000000o2.model);
                    if (O00000o0.this.O0000o0.O000000o(O00000o0.this.itemView) == 0) {
                        O00000o0.this.O0000o0.O000000o(O00000o0.this.itemView, 8);
                    } else {
                        O00000o0.this.O0000o0.O000000o(O00000o0.this.itemView, 0);
                        O00000o0.this.O000000o();
                        if (O000000o3) {
                            O00000o0.this.O0000o00.setVisibility(0);
                            return;
                        }
                    }
                    O00000o0.this.O0000o00.setVisibility(8);
                }
            });
            this.O00000oo.addView(this.O0000O0o, new FrameLayout.LayoutParams(-1, -1));
        }

        public final void O00000o() {
            O0000O0o O0000O0o2 = O0000O0o();
            CameraHorizontalActivity.this.mControlViewHandler.removeMessages(O0000O0o2.O00000Oo.hashCode());
            this.O0000OoO.setImageResource(R.drawable.all_camera_item_play_land);
            this.O0000o0.O000000o(this.itemView, 0);
            if (O000000o.O000000o(fno.O000000o().O000000o(O0000O0o2.O00000Oo).model)) {
                this.O0000o00.setVisibility(0);
            } else {
                this.O0000o00.setVisibility(8);
            }
        }

        public final void O00000oO() {
            if (gth.O000000o().O00000o0(fno.O000000o().O000000o(this.O0000o0o))) {
                this.O0000OOo.setImageResource(R.drawable.all_camera_item_mute_on_land);
            } else {
                this.O0000OOo.setImageResource(R.drawable.all_camera_item_mute_off_land);
            }
            this.O0000OOo.setEnabled(true);
            this.O0000o00.setEnabled(true);
        }

        public final void O00000oo() {
            this.O0000OOo.setEnabled(false);
            this.O0000o00.setEnabled(false);
            this.O0000o00.setSelected(false);
            Device O000000o2 = fno.O000000o().O000000o(this.O0000o0o);
            gsy.O000000o(3, "CameraHorizontalActivit", "onStopPlay: " + O000000o2.name);
            if (gth.O000000o().O0000O0o(O000000o2)) {
                gsy.O000000o(3, "CameraHorizontalActivit", "onStopPlay: stop call.");
                gth.O000000o().O00000oo(O000000o2);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        O00000o0 o00000o0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 100 && (o00000o0 = this.O00000oo) != null) {
            Device device = (Device) o00000o0.O0000oo0.getTag();
            if (device != null) {
                this.O00000oo.O0000OoO.setImageResource(R.drawable.all_camera_item_puase_land);
                this.O00000oO.add(device.did);
                O000000o(this.O00000oo, device);
            } else {
                return;
            }
        }
        this.f9389O000000o.post(new Runnable() {
            /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.AnonymousClass5 */

            public final void run() {
                RecyclerView.LayoutManager layoutManager;
                View O000000o2;
                if (CameraHorizontalActivity.this.f9389O000000o != null && (layoutManager = CameraHorizontalActivity.this.f9389O000000o.getLayoutManager()) != null && (O000000o2 = CameraHorizontalActivity.this.pagerSnapHelper.O000000o(layoutManager)) != null) {
                    int[] O000000o3 = CameraHorizontalActivity.this.pagerSnapHelper.O000000o(layoutManager, O000000o2);
                    if (O000000o3[0] != 0 || O000000o3[1] != 0) {
                        CameraHorizontalActivity.this.f9389O000000o.smoothScrollBy(O000000o3[0], O000000o3[1]);
                    }
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        O00000o0 o00000o0 = this.O00000oo;
        if (o00000o0 != null) {
            o00000o0.itemView.requestLayout();
        }
    }

    public void finish() {
        Device device;
        StringBuilder sb = new StringBuilder("finish: mViewHolder != null ");
        boolean z = true;
        sb.append(this.O00000oo != null);
        gsy.O000000o(3, "CameraHorizontalActivit", sb.toString());
        int findFirstVisibleItemPosition = ((LinearLayoutManager) this.f9389O000000o.getLayoutManager()).findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || (device = this.mCameraDevices.get(findFirstVisibleItemPosition)) == null) {
            setResult(0);
        } else {
            String str = device.did;
            gth.O00000o0 O00000Oo2 = gth.O000000o().O00000Oo(str);
            StringBuilder sb2 = new StringBuilder("finish did: ");
            sb2.append(str);
            sb2.append(" ; context == null: ");
            if (O00000Oo2 != null) {
                z = false;
            }
            sb2.append(z);
            sb2.append(" ,isPlaying: ");
            sb2.append(O00000Oo2 != null ? Boolean.valueOf(O00000Oo2.O0000Oo) : "null");
            gsy.O000000o(3, "CameraHorizontalActivit", sb2.toString());
            if (str == null || O00000Oo2 == null || !O00000Oo2.O0000Oo) {
                setResult(0);
            } else {
                Intent intent = new Intent();
                intent.putExtra("play_did", str);
                setResult(-1, intent);
            }
        }
        O000000o(false);
        super.finish();
    }

    static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f9405O000000o;
        public String O00000Oo;

        public O0000O0o(int i, String str) {
            this.f9405O000000o = i;
            this.O00000Oo = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                O0000O0o o0000O0o = (O0000O0o) obj;
                if (this.f9405O000000o != o0000O0o.f9405O000000o) {
                    return false;
                }
                String str = this.O00000Oo;
                if (str != null) {
                    return str.equals(o0000O0o.O00000Oo);
                }
                if (o0000O0o.O00000Oo == null) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i = this.f9405O000000o * 31;
            String str = this.O00000Oo;
            return i + (str != null ? str.hashCode() : 0);
        }
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(0);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i == 20 || i == 80 || i == 40) {
            O000000o(true);
        }
    }

    public void onCreate(Bundle bundle) {
        int i = Build.VERSION.SDK_INT >= 19 ? 7943 : 1799;
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(i);
        }
        getWindow().clearFlags(2048);
        getWindow().clearFlags(1024);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(1024);
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView((int) R.layout.all_camera_layout);
        this.O00000o = getIntent().getStringExtra("did");
        CharSequence[] charSequenceArrayExtra = getIntent().getCharSequenceArrayExtra("play_list");
        if (charSequenceArrayExtra == null || charSequenceArrayExtra.length == 0) {
            ArrayList<gti.O000000o> arrayList = gti.O000000o().O00000o0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                gti.O000000o o000000o = arrayList.get(i2);
                if (o000000o.f18248O000000o.equals(this.O00000o)) {
                    this.O0000Oo0 = i2;
                }
                Device O000000o2 = fno.O000000o().O000000o(o000000o.f18248O000000o);
                if (O000000o2 != null) {
                    this.mCameraDevices.add(O000000o2);
                }
            }
        } else {
            for (int i3 = 0; i3 < charSequenceArrayExtra.length; i3++) {
                String charSequence = charSequenceArrayExtra[i3].toString();
                Device O000000o3 = fno.O000000o().O000000o(charSequence.toString());
                if (O000000o3 != null) {
                    if (charSequence.equals(this.O00000o)) {
                        this.O0000Oo0 = i3;
                    }
                    this.mCameraDevices.add(O000000o3);
                }
            }
        }
        this.isAutoPlay = getIntent().getBooleanExtra("isAutoPlay", false);
        this.O0000O0o = getIntent().getBooleanExtra("isMute", true);
        if (getIntent().getBooleanExtra("isQuickPass", false)) {
            this.O00000oO.add(this.O00000o);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.f9389O000000o = (RecyclerView) findViewById(R.id.device_grid_view);
        this.f9389O000000o.setLayoutManager(linearLayoutManager);
        this.f9389O000000o.addOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.AnonymousClass3 */

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int i2;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int i3 = -1;
                    if (CameraHorizontalActivity.this.scrolledDx <= 0) {
                        i3 = linearLayoutManager.findFirstVisibleItemPosition();
                        i2 = linearLayoutManager.findLastVisibleItemPosition();
                    } else if (CameraHorizontalActivity.this.scrolledDx > 0) {
                        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                        i3 = linearLayoutManager.findLastVisibleItemPosition();
                        i2 = findFirstVisibleItemPosition;
                    } else {
                        i2 = 0;
                    }
                    if (i3 >= 0 && i2 >= 0) {
                        Device device = CameraHorizontalActivity.this.mCameraDevices.get(i3);
                        Device device2 = CameraHorizontalActivity.this.mCameraDevices.get(i2);
                        O00000o0 o00000o0 = (O00000o0) recyclerView.findViewHolderForAdapterPosition(i3);
                        O00000o0 o00000o02 = (O00000o0) recyclerView.findViewHolderForAdapterPosition(i2);
                        hxi.O00000o0.f957O000000o.O000000o("camera_slideshow_fullscreen", new Object[0]);
                        if (!(o00000o0 == null || device == null || gth.O000000o().O000000o(device))) {
                            CameraHorizontalActivity.this.togglePlay(o00000o0, device);
                        }
                        if (device2 != null && o00000o02 != null && gth.O000000o().O000000o(device2) && i2 != i3) {
                            CameraHorizontalActivity.this.togglePlay(o00000o02, device2);
                        }
                    }
                }
            }

            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                CameraHorizontalActivity.this.scrolledDx = i;
            }
        });
        this.f9389O000000o.setAdapter(new RecyclerView.O000000o() {
            /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new O00000o0(LayoutInflater.from(CameraHorizontalActivity.this.getContext()).inflate((int) R.layout.all_camera_item, viewGroup, false));
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List list) {
                if (list.isEmpty() || !(list.get(0) instanceof O00000Oo)) {
                    super.onBindViewHolder(o000OOo0, i, list);
                    return;
                }
                O00000o0 o00000o0 = (O00000o0) o000OOo0;
                O0000O0o o0000O0o = ((O00000Oo) list.get(0)).f9396O000000o;
                if (o0000O0o.O00000Oo.equals(o00000o0.O0000o0o) && o0000O0o.f9405O000000o == o00000o0.hashCode()) {
                    o00000o0.O0000o0.O000000o(o000OOo0.itemView, 8);
                    if (O000000o.O000000o(fno.O000000o().O000000o(o0000O0o.O00000Oo).model)) {
                        o00000o0.O0000o00.setVisibility(8);
                    }
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gth.O000000o(int, java.io.OutputStream):void
              _m_j.gth.O000000o(android.content.Context, com.xiaomi.smarthome.device.Device):void
              _m_j.gth.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.fastvideo.VideoView):void
              _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0 */
            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                O00000o0 o00000o0 = (O00000o0) o000OOo0;
                Device device = CameraHorizontalActivity.this.mCameraDevices.get(i);
                if (device != null) {
                    o00000o0.O0000o0o = device.did;
                    o00000o0.O00000o.setText(ggb.O00000Oo().O0000o0O(device.did));
                    o00000o0.O00000o0.setText(device.name);
                    if (gth.O000000o().O00000Oo(device.did) == null) {
                        gth.O000000o().O000000o(device.did, false);
                    }
                    o00000o0.O0000oo0.setTag(device);
                    o00000o0.O0000o00.setVisibility(O000000o.O000000o(device.model) ? 0 : 8);
                    o00000o0.O0000o00.setOnClickListener(new View.OnClickListener(device) {
                        /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.O00000o0.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Device f9399O000000o;

                        {
                            this.f9399O000000o = r2;
                        }

                        public final void onClick(View view) {
                            gth.O00000o0 O00000Oo2;
                            if (!this.f9399O000000o.isOwner() && this.f9399O000000o.isSharedReadOnly()) {
                                hte.O000000o(CameraHorizontalActivity.this.getContext(), (int) R.string.device_control_no_permit);
                            } else if (gth.O000000o().O00000Oo(this.f9399O000000o)) {
                                if (!fwq.O000000o("android.permission.RECORD_AUDIO")) {
                                    CameraHorizontalActivity.this.isRequestingPermission = true;
                                    CameraHorizontalActivity cameraHorizontalActivity = CameraHorizontalActivity.this;
                                    if (!fwq.O000000o("android.permission.RECORD_AUDIO")) {
                                        cameraHorizontalActivity.getApplication().getResources().getString(R.string.permission_successfully);
                                        fwq.O000000o(cameraHorizontalActivity, cameraHorizontalActivity.getApplication().getResources().getString(R.string.permission_failure), cameraHorizontalActivity.getApplication().getResources().getString(R.string.tips), cameraHorizontalActivity.getApplication().getResources().getString(R.string.permission_tips_denied_msg), null, "android.permission.RECORD_AUDIO");
                                        return;
                                    }
                                    return;
                                }
                                if (gth.O000000o().O0000O0o(this.f9399O000000o)) {
                                    if (!gth.O000000o().O00000o0(this.f9399O000000o)) {
                                        O00000o0.this.O0000OOo.performClick();
                                    }
                                    gth.O000000o().O00000oo(this.f9399O000000o);
                                } else {
                                    if (gth.O000000o().O00000o0(this.f9399O000000o)) {
                                        O00000o0.this.O0000OOo.performClick();
                                    }
                                    gth O000000o2 = gth.O000000o();
                                    Device device = this.f9399O000000o;
                                    if (!(device == null || (O00000Oo2 = O000000o2.O00000Oo(device.did)) == null || CoreApi.O000000o().O0000Oo(device.model) == null)) {
                                        Intent intent = new Intent();
                                        intent.putExtra("run_on_main", O00000Oo2.O0000Oo0);
                                        O00000Oo2.f18240O000000o = true;
                                        O000000o2.O000000o(CommonApplication.getAppContext(), device, 23, intent);
                                    }
                                }
                                O00000o0.this.O0000o00.setSelected(gth.O000000o().O0000O0o(this.f9399O000000o));
                                hxi.O00000o.f952O000000o.O000000o("camera_call_click_fullscreen", "type", Integer.valueOf(O00000o0.this.O0000o00.isSelected() ? 1 : 2));
                            }
                        }
                    });
                    if (device.isOnline) {
                        o00000o0.O0000OoO.setVisibility(0);
                        o00000o0.O0000OOo.setVisibility(0);
                    } else {
                        o00000o0.O0000OoO.setVisibility(8);
                        o00000o0.O0000OOo.setVisibility(8);
                    }
                    gth.O00000o0 O00000Oo = gth.O000000o().O00000Oo(device.did);
                    if (O00000Oo == null || !O00000Oo.O0000Oo) {
                        o00000o0.O0000OoO.setImageResource(R.drawable.all_camera_item_play_land);
                    } else {
                        o00000o0.O0000OoO.setImageResource(R.drawable.all_camera_item_puase_land);
                    }
                    if (O00000Oo == null || !O00000Oo.O0000OOo) {
                        o00000o0.O0000OOo.setImageResource(R.drawable.all_camera_item_mute_off_land);
                    } else {
                        o00000o0.O0000OOo.setImageResource(R.drawable.all_camera_item_mute_on_land);
                    }
                    o00000o0.O0000Ooo.setOnClickListener(new View.OnClickListener(device) {
                        /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.O00000o0.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Device f9400O000000o;

                        {
                            this.f9400O000000o = r2;
                        }

                        public final void onClick(View view) {
                            CameraHorizontalActivity.this.O00000Oo(O00000o0.this, this.f9400O000000o);
                            ext.O000000o(this.f9400O000000o).onItemClick(view, ((BaseActivity) view.getContext()).mHandler, this.f9400O000000o, view.getContext(), (BaseActivity) view.getContext());
                            hxi.O00000o.f952O000000o.O000000o("camera_gotoplugin_click_fullscreen", new Object[0]);
                        }
                    });
                    o00000o0.O0000Oo0.setVisibility(8);
                    if (o00000o0.O0000o0O) {
                        gth.O000000o().O000000o(device, o00000o0.O00000oO, o00000o0.O0000Oo0);
                        if (gth.O000000o().O00000Oo(device)) {
                            if (o00000o0.O0000O0o == null) {
                                o00000o0.O00000o0();
                            }
                            gth.O000000o().O000000o(device, o00000o0.O0000O0o);
                            o00000o0.O00000oO.setVisibility(8);
                        }
                    }
                    o00000o0.O0000OOo.setOnClickListener(new View.OnClickListener(device) {
                        /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.O00000o0.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Device f9401O000000o;

                        {
                            this.f9401O000000o = r2;
                        }

                        public final void onClick(View view) {
                            O00000o0.this.O000000o();
                            gth.O000000o().O00000o(this.f9401O000000o);
                            if (gth.O000000o().O000000o(this.f9401O000000o)) {
                                gth.O000000o().O000000o(CameraHorizontalActivity.this.getContext(), this.f9401O000000o, O00000o0.this.O0000Oo0);
                            }
                            if (gth.O000000o().O00000o0(this.f9401O000000o)) {
                                O00000o0.this.O0000OOo.setImageResource(R.drawable.all_camera_item_mute_on_land);
                            } else {
                                O00000o0.this.O0000OOo.setImageResource(R.drawable.all_camera_item_mute_off_land);
                            }
                            hxi.O00000o.f952O000000o.O000000o("camera_mute_click_fullscreen", "type", Integer.valueOf(gth.O000000o().O00000o0(this.f9401O000000o) ? 1 : 2));
                        }
                    });
                    o00000o0.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.O00000o0.AnonymousClass4 */

                        public final void onClick(View view) {
                            CameraHorizontalActivity.this.onBackPressed();
                        }
                    });
                    o00000o0.O0000OoO.setOnClickListener(new View.OnClickListener(device) {
                        /* class com.xiaomi.smarthome.listcamera.CameraHorizontalActivity.O00000o0.AnonymousClass5 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Device f9403O000000o;

                        {
                            this.f9403O000000o = r2;
                        }

                        public final void onClick(View view) {
                            O00000o0.this.O000000o();
                            CameraHorizontalActivity.this.togglePlay(O00000o0.this, this.f9403O000000o);
                            hxi.O00000o.f952O000000o.O000000o("camera_playon_click_fullscreen", "type", Integer.valueOf(gth.O000000o().O000000o(this.f9403O000000o) ? 2 : 1));
                        }
                    });
                }
            }

            public final int getItemCount() {
                return CameraHorizontalActivity.this.mCameraDevices.size();
            }

            public final void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
                if (o000OOo0 instanceof O00000o0) {
                    O00000o0 o00000o0 = (O00000o0) o000OOo0;
                    Device device = (Device) o00000o0.O0000oo0.getTag();
                    boolean z = true;
                    o00000o0.O0000o0O = true;
                    if (device != null) {
                        gth.O000000o().O000000o(device, o00000o0.O00000oO, o00000o0.O0000Oo0);
                        if (CameraHorizontalActivity.this.O00000Oo == 0) {
                            if (gth.O000000o().O00000Oo(device)) {
                                CameraHorizontalActivity.this.O000000o(o00000o0, device);
                                o00000o0.O00000oO.setVisibility(8);
                            } else if (gth.O000000o().O000000o(device)) {
                                CameraHorizontalActivity.this.O000000o(o00000o0, device);
                                o00000o0.O0000Oo0.setVisibility(0);
                            } else {
                                o00000o0.O0000Oo0.setVisibility(8);
                            }
                        } else if (gth.O000000o().O00000Oo(device)) {
                            Iterator<O00000o0> it = CameraHorizontalActivity.this.O00000o0.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().equals(o00000o0)) {
                                        break;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                            if (!z) {
                                CameraHorizontalActivity.this.O00000o0.add(o00000o0);
                            }
                        } else {
                            o00000o0.O0000Oo0.setVisibility(8);
                        }
                    }
                }
                CameraHorizontalActivity.this.doAutoPlay();
            }

            public final void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
                if (o000OOo0 instanceof O00000o0) {
                    O00000o0 o00000o0 = (O00000o0) o000OOo0;
                    Device device = (Device) o00000o0.O0000oo0.getTag();
                    o00000o0.O0000o0O = false;
                    if (device != null && o00000o0 != null) {
                        CameraHorizontalActivity.this.O00000Oo(o00000o0, device);
                    }
                }
            }
        });
        this.pagerSnapHelper = new ha();
        this.pagerSnapHelper.O000000o(this.f9389O000000o);
        RecyclerView recyclerView = this.f9389O000000o;
        int i4 = this.O0000Oo0;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i4 <= findFirstVisibleItemPosition || i4 > findLastVisibleItemPosition) {
            recyclerView.scrollToPosition(i4);
        } else {
            recyclerView.scrollBy(0, recyclerView.getChildAt(i4 - findFirstVisibleItemPosition).getTop());
        }
    }
}
