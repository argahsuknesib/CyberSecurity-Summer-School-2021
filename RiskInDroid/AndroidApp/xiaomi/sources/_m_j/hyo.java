package _m_j;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class hyo {
    private static volatile hyo O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f994O000000o;
    public Map<String, WeakReference<View>> O00000Oo = new HashMap();
    public Handler O00000o0 = new Handler(Looper.getMainLooper()) {
        /* class _m_j.hyo.AnonymousClass1 */

        public final void handleMessage(Message message) {
            View view;
            ViewParent parent;
            int i = message.what;
            if (i == 1) {
                hyo hyo = hyo.this;
                gsy.O00000Oo("GlobalNavButtonManager", "doClear");
                hyo.f994O000000o = null;
                for (WeakReference next : hyo.O00000Oo.values()) {
                    if (!(next == null || (view = (View) next.get()) == null || (parent = view.getParent()) == null)) {
                        ((ViewGroup) parent).removeView(view);
                    }
                }
                hyo.O00000Oo.clear();
            } else if (i == 2) {
                String str = (String) message.obj;
                hyo hyo2 = hyo.this;
                gsy.O00000Oo("GlobalNavButtonManager", "doUpdateFloatNavButton");
                if (!TextUtils.isEmpty(hyo2.f994O000000o) && !TextUtils.equals(str, hyo2.f994O000000o)) {
                    hyo2.O00000Oo();
                }
                hyo2.f994O000000o = str;
            }
        }
    };

    private hyo() {
    }

    public static hyo O000000o() {
        if (O00000o == null) {
            synchronized (hyo.class) {
                if (O00000o == null) {
                    O00000o = new hyo();
                }
            }
        }
        return O00000o;
    }

    public static boolean O000000o(String str) {
        if (TextUtils.equals("identity_xiaoai", str)) {
        }
        return true;
    }

    public final void O00000Oo() {
        gsy.O00000Oo("GlobalNavButtonManager", "clear");
        this.O00000o0.sendEmptyMessage(1);
    }

    public static View O000000o(Activity activity) {
        gsy.O00000Oo("GlobalNavButtonManager", "createXiaoAiNavBtn");
        View inflate = LayoutInflater.from(activity).inflate((int) R.layout.global_nav_btn_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.icon)).setImageResource(R.drawable.cloud_device_xiaoai_icon);
        return inflate;
    }

    public static void O000000o(Activity activity, View view) {
        Window window;
        View decorView;
        View findViewById;
        gsy.O00000Oo("GlobalNavButtonManager", "addNavButtonToActivity");
        if (!activity.isFinishing()) {
            if ((Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null && (findViewById = decorView.findViewById(16908290)) != null && (findViewById instanceof FrameLayout)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = (int) (((float) activity.getResources().getDisplayMetrics().heightPixels) * 0.43f);
                layoutParams.height = gpc.O000000o(36.0f);
                ((FrameLayout) findViewById).addView(view, layoutParams);
                view.setClickable(true);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.hyo.AnonymousClass3 */

                    public final void onClick(View view) {
                        oOOO00o0.O000000o((Activity) view.getContext());
                        hyo.O000000o().O00000Oo();
                    }
                });
            }
        }
    }
}
