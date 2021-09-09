package _m_j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import java.util.Timer;
import java.util.TimerTask;

public class OO0oO extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12307O000000o;
    public View O00000Oo;
    public int[] O00000o;
    public Timer O00000o0;
    public int O00000oO;
    public O00000Oo O00000oo;

    public class O000000o extends TimerTask {

        /* renamed from: _m_j.OO0oO$O000000o$O000000o  reason: collision with other inner class name */
        public class C0092O000000o implements Runnable {

            /* renamed from: O000000o  reason: collision with root package name */
            public final /* synthetic */ int f12309O000000o;

            public C0092O000000o(int i) {
                this.f12309O000000o = i;
            }

            public final void run() {
                OO0oO.this.O00000Oo.setBackgroundColor(this.f12309O000000o);
            }
        }

        public O000000o() {
        }

        public final void run() {
            if (OO0oO.this.O00000o == null || OO0oO.this.O00000Oo == null) {
                cancel();
            } else if (OO0oO.this.O00000oO < OO0oO.this.O00000o.length) {
                int i = OO0oO.this.O00000o[OO0oO.O00000o(OO0oO.this)];
                FragmentActivity activity = OO0oO.this.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new C0092O000000o(i));
                }
            } else {
                if (OO0oO.this.O00000oo != null) {
                    OO0oO.this.O00000oo.O00000oo();
                }
                cancel();
                OO0oO.this.dismiss();
            }
        }
    }

    public interface O00000Oo {
        void O00000oo();
    }

    public static OO0oO O000000o(long j, int[] iArr) {
        OO0oO oO0oO = new OO0oO();
        Bundle bundle = new Bundle();
        bundle.putLong("blink_duration", j);
        bundle.putIntArray("blink_color_int_array", iArr);
        oO0oO.setArguments(bundle);
        oO0oO.setStyle(2, 16973934);
        return oO0oO;
    }

    public static /* synthetic */ int O00000o(OO0oO oO0oO) {
        int i = oO0oO.O00000oO;
        oO0oO.O00000oO = i + 1;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 16973838);
        if (getArguments() != null) {
            this.f12307O000000o = getArguments().getLong("blink_duration", 500);
            this.O00000o = getArguments().getIntArray("blink_color_int_array");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_blink_dialog, viewGroup, false);
    }

    public void onPause() {
        super.onPause();
        Timer timer = this.O00000o0;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void onResume() {
        super.onResume();
        Timer timer = this.O00000o0;
        if (timer != null) {
            timer.cancel();
        }
        this.O00000o0 = new Timer();
        this.O00000o0.scheduleAtFixedRate(new O000000o(), 0, this.f12307O000000o);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O00000Oo = view.findViewById(R.id.blink_view);
    }
}
