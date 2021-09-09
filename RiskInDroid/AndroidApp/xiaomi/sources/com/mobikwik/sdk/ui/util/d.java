package com.mobikwik.sdk.ui.util;

import _m_j.ft;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.xiaomi.smarthome.R;
import java.util.Timer;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f5340a = 60;

    public interface a {
        void a();

        void a(String str);

        void b();

        void c();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f5341a;
        Activity b;
        private boolean c;
        /* access modifiers changed from: private */
        public AlertDialog d;
        private Timer e;
        /* access modifiers changed from: private */
        public a f;
        private BroadcastReceiver g = new e(this);
        /* access modifiers changed from: private */
        public long h;
        private c i = new c();
        private boolean j;

        public b(String str, Activity activity, boolean z, a aVar) {
            this.f5341a = str;
            this.b = activity;
            this.c = z;
            this.f = aVar;
        }

        /* access modifiers changed from: private */
        public String a(int i2) {
            String str = this.f5341a;
            if (!str.endsWith(".")) {
                str = str + ".";
            }
            return str + "<br>You should receive SMS within <b>" + i2 + " seconds</b>.";
        }

        /* access modifiers changed from: private */
        public void b() {
            if (this.j) {
                ft.O000000o(this.b).O000000o(this.g);
                this.b.unregisterReceiver(this.i);
                this.j = false;
            }
        }

        /* access modifiers changed from: private */
        public void c() {
            IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            this.b.registerReceiver(this.i, intentFilter);
            this.h = System.currentTimeMillis();
            ft.O000000o(this.b).O000000o(this.g, new IntentFilter("AUTO_OTP_FILTER"));
            this.j = true;
            d();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, ?[OBJECT, ARRAY], int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        private void d() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setTitle("Waiting for OTP");
            builder.setNeutralButton("Cancel", new f(this));
            this.d = builder.create();
            View inflate = LayoutInflater.from(this.b).inflate((int) R.layout.mk_layout_otp_waiting, (ViewGroup) null, false);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.waitingOtpProgressBar);
            this.d.setCancelable(false);
            progressBar.setMax(d.f5340a);
            progressBar.setProgress(0);
            this.d.setView(inflate);
            this.d.setMessage(Html.fromHtml(a(progressBar.getMax())));
            this.d.show();
            this.e = new Timer(true);
            this.e.schedule(new g(this, progressBar), 1000, 1000);
        }

        /* access modifiers changed from: private */
        public void e() {
            String str;
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setTitle("OTP Not Received");
            if (this.c) {
                str = "Make sure that you are using your registered primary number on this Mobile.";
            } else {
                builder.setNeutralButton("Enter OTP", new i(this));
                str = "If you have got OTP please enter, or resend OTP.";
            }
            builder.setMessage(Html.fromHtml(str));
            builder.setPositiveButton("Resend", new j(this));
            builder.setNegativeButton("Cancel", new k(this));
            builder.setCancelable(false);
            builder.show();
        }

        /* access modifiers changed from: private */
        public void f() {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
            }
            AlertDialog alertDialog = this.d;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.d.dismiss();
            }
        }

        public void a() {
            if (this.b.isFinishing()) {
                f();
                b();
            }
        }
    }

    public static b a(String str, Activity activity, boolean z, a aVar) {
        b bVar = new b(str, activity, z, aVar);
        bVar.c();
        return bVar;
    }
}
