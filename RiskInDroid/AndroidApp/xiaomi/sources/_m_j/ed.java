package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.PrintWriter;

public abstract class ed<E> extends ea {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f15177O000000o;
    public final Activity O00000Oo;
    public final Handler O00000o;
    public final Context O00000o0;
    public final ef O00000oO;

    public View O000000o(int i) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void O000000o(Fragment fragment) {
    }

    public void O000000o(Fragment fragment, String[] strArr, int i) {
    }

    public void O000000o(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean O000000o() {
        return true;
    }

    public boolean O000000o(String str) {
        return false;
    }

    public boolean O00000Oo() {
        return true;
    }

    public void O00000o() {
    }

    public boolean O00000oO() {
        return true;
    }

    public abstract E O0000O0o();

    protected ed(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler());
    }

    private ed(Activity activity, Context context, Handler handler) {
        this.O00000oO = new ef();
        this.O00000Oo = activity;
        this.O00000o0 = (Context) bf.O000000o(context, "context == null");
        this.O00000o = (Handler) bf.O000000o(handler, "handler == null");
        this.f15177O000000o = 0;
    }

    public LayoutInflater O00000o0() {
        return LayoutInflater.from(this.O00000o0);
    }

    public void O000000o(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.O00000o0.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void O000000o(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            oOOO00o0.O000000o(this.O00000Oo, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public int O00000oo() {
        return this.f15177O000000o;
    }
}
