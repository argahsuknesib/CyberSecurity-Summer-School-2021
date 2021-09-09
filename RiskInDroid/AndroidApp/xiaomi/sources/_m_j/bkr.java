package _m_j;

import _m_j.bku;
import _m_j.bkv;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inuker.bluetooth.library.search.SearchTask;

public final class bkr implements Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f13022O000000o;
    private int O00000Oo;
    private Handler O00000o = new Handler(Looper.myLooper(), this);
    private bks O00000o0;

    public bkr(SearchTask searchTask) {
        this.f13022O000000o = searchTask.f4496O000000o;
        this.O00000Oo = searchTask.O00000Oo;
    }

    public final boolean O000000o() {
        return this.f13022O000000o == 2;
    }

    public final boolean O00000Oo() {
        return this.f13022O000000o == 1;
    }

    private bks O00000o() {
        bks bks;
        if (this.O00000o0 == null) {
            int i = this.f13022O000000o;
            if (i == 1) {
                bks = bku.O000000o.f13024O000000o;
            } else if (i == 2) {
                bks = bkv.O000000o.f13027O000000o;
            } else {
                throw new IllegalStateException(String.format("unknown search type %d", Integer.valueOf(i)));
            }
            this.O00000o0 = bks;
        }
        return this.O00000o0;
    }

    public final void O000000o(bkw bkw) {
        O00000o().O000000o(bkw);
        this.O00000o.sendEmptyMessageDelayed(34, (long) this.O00000Oo);
    }

    public final void O00000o0() {
        this.O00000o.removeCallbacksAndMessages(null);
        O00000o().O00000Oo();
    }

    public final String toString() {
        String str;
        if (O000000o()) {
            str = "Ble";
        } else {
            str = O00000Oo() ? "classic" : "unknown";
        }
        int i = this.O00000Oo;
        if (i >= 1000) {
            return String.format("%s search (%ds)", str, Integer.valueOf(i / 1000));
        }
        double d = (double) i;
        Double.isNaN(d);
        return String.format("%s search (%.1fs)", str, Double.valueOf((d * 1.0d) / 1000.0d));
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 34) {
            return true;
        }
        O00000o().O000000o();
        return true;
    }
}
