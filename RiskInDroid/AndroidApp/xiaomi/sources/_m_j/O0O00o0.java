package _m_j;

import a.a.a.b;
import a.a.a.e.c.d;
import a.a.a.e.c.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;
import in.cashify.otex.widget.DiagnoseCameraHeaderView;

public final class O0O00o0 extends ooooooo implements CircleRoadProgress.O00000Oo {
    public d O00000Oo;
    public b O00000o;
    public boolean O00000o0;
    public DiagnoseCameraHeaderView O00000oO;
    public Button O00000oo;
    public boolean O0000O0o;

    public interface O00000o0 {
        void O000000o(b bVar);
    }

    public static O0O00o0 O000000o(d dVar) {
        O0O00o0 o0O00o0 = new O0O00o0();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_camera_diagnose", dVar);
        o0O00o0.setArguments(bundle);
        return o0O00o0;
    }

    private boolean O000000o(Context context) {
        PackageManager packageManager;
        String str;
        if (O0000O0o() == 1) {
            packageManager = context.getPackageManager();
            str = "android.hardware.camera.front";
        } else {
            packageManager = context.getPackageManager();
            str = "android.hardware.camera";
        }
        return packageManager.hasSystemFeature(str);
    }

    private void O00000oo() {
        requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (d) getArguments().getParcelable("arg_camera_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_camera_diagnose, viewGroup, false);
    }

    public class O00000Oo implements O00000o0 {
        public O00000Oo() {
        }

        public final void O000000o(b bVar) {
            FragmentActivity activity = O0O00o0.this.getActivity();
            if (O0O00o0.this.isAdded() && activity != null) {
                activity.runOnUiThread(new O000000o(bVar));
            }
        }

        public class O000000o implements Runnable {

            /* renamed from: O000000o  reason: collision with root package name */
            public final /* synthetic */ b f6661O000000o;

            public O000000o(b bVar) {
                this.f6661O000000o = bVar;
            }

            public final void run() {
                b unused = O0O00o0.this.O00000o = this.f6661O000000o;
                ((ExchangeManager) O0O00o0.this.getParentFragment()).O000000o(O0O00o0.this.O00000o0(), Boolean.FALSE);
            }
        }
    }

    public class O000000o implements Runnable {
        public O000000o() {
        }

        public final void run() {
            View view = ((ExchangeManager) O0O00o0.this.getParentFragment()).O0000O0o.O00000Oo;
            if (view instanceof DiagnoseCameraHeaderView) {
                O0O00o0.this.O000000o((DiagnoseCameraHeaderView) view);
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (textView != null) {
            textView.setText(this.O00000Oo.O0000Oo);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.diagnoseMessage);
        if (textView2 != null) {
            textView2.setText(this.O00000Oo.O0000OoO);
        }
        this.O00000oo = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O00000oo;
        if (button != null) {
            button.setVisibility(this.O00000Oo.O00000Oo() ? 0 : 8);
            this.O00000oo.setText(this.O00000Oo.O0000o0);
            this.O00000oo.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        View view = ((ExchangeManager) getParentFragment()).O0000O0o.O00000Oo;
        if (!(view instanceof DiagnoseCameraHeaderView)) {
            ((ExchangeManager) getParentFragment()).O00000Oo();
            new Handler(Looper.getMainLooper()).postDelayed(new O000000o(), 500);
            return;
        }
        O000000o((DiagnoseCameraHeaderView) view);
    }

    public final void onPause() {
        DiagnoseCameraHeaderView diagnoseCameraHeaderView = this.O00000oO;
        if (diagnoseCameraHeaderView != null) {
            try {
                diagnoseCameraHeaderView.O00000o0.acquire();
                diagnoseCameraHeaderView.f12278O000000o.O000000o();
                diagnoseCameraHeaderView.O0000OOo.release();
                diagnoseCameraHeaderView.O0000OOo = null;
            } catch (Throwable unused) {
            }
            diagnoseCameraHeaderView.O00000o0.release();
        }
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.nextButton) {
            Button button = this.O00000oo;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O00000o = new b(this.O00000oO.getRequestKey(), 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }

    public final void O00000oO() {
        if (this.O00000o != null || this.O0000O0o) {
            O000000o(this.O00000o);
            return;
        }
        this.O0000O0o = true;
        this.O00000o = new b(this.O00000oO.getRequestKey(), 4005, false);
        ((ExchangeManager) getParentFragment()).O000000o(-1, this);
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(true ^ this.O00000o.O00000o0));
        DiagnoseCameraHeaderView diagnoseCameraHeaderView = this.O00000oO;
        if (diagnoseCameraHeaderView != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                HandlerThread handlerThread = diagnoseCameraHeaderView.O00000o;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                }
            } else {
                diagnoseCameraHeaderView.O00000o.quit();
            }
            try {
                diagnoseCameraHeaderView.O00000o.join();
                diagnoseCameraHeaderView.O00000o = null;
                diagnoseCameraHeaderView.O00000Oo = null;
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(DiagnoseCameraHeaderView diagnoseCameraHeaderView) {
        this.O00000oO = diagnoseCameraHeaderView;
        this.O00000oO.setmCameraContext(this.O00000Oo);
        this.O00000oO.setPictureTakenCallBack(new O00000Oo());
        this.O00000oO.O00000o0();
        if (!O000000o("android.permission.CAMERA")) {
            if (this.O00000o0) {
                ((ExchangeManager) getParentFragment()).O000000o(-1, this);
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
                this.O00000o = new b(this.O00000oO.getRequestKey(), 4002, false);
                return;
            }
            O00000oo();
            this.O00000o0 = true;
        } else if (getActivity() != null && !ooooooo.O000000o(getActivity(), 26) && !this.O00000o0) {
            O000000o();
            this.O00000o0 = true;
        } else if (!O000000o(getActivity())) {
            ((ExchangeManager) getParentFragment()).O000000o(-1, this);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            this.O00000o = new b(this.O00000oO.getRequestKey(), 4003, false);
        } else if (this.O00000oO.f12278O000000o == null) {
            ((ExchangeManager) getParentFragment()).O000000o(-1, this);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            this.O00000o = new b(this.O00000oO.getRequestKey(), 4004, false);
        } else {
            ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
            if (this.O00000oO.f12278O000000o.O00000oO) {
                this.O00000oO.O00000Oo();
                return;
            }
            DiagnoseCameraHeaderView diagnoseCameraHeaderView2 = this.O00000oO;
            diagnoseCameraHeaderView2.f12278O000000o.setPreviewStartListener(diagnoseCameraHeaderView2);
        }
    }

    private int O0000O0o() {
        return this.O00000Oo.O0000Oo0.equals(ExchangeManager.h.FRONT_CAMERA.a()) ? 1 : 0;
    }
}
