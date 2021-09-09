package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C;
import com.xiaomi.onetrack.b.l;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.q;

public class k extends Handler {
    private final int e = 1000;
    private final int f = C.MSG_CUSTOM_BASE;
    private final int g = 1200000;
    private int h = C.MSG_CUSTOM_BASE;
    private BroadcastReceiver i = new l(this);

    public k(Looper looper) {
        super(looper);
        a(a.a());
    }

    public void a(int i2, boolean z) {
        long j;
        if (hasMessages(1000)) {
            q.a("UploadTimer", "in retry mode, return, prio=".concat(String.valueOf(i2)));
            return;
        }
        if (z) {
            removeMessages(i2);
        }
        if (!hasMessages(i2)) {
            if (z) {
                j = 0;
            } else {
                j = (long) l.a(i2);
            }
            q.a("UploadTimer", "will check prio=" + i2 + ", delay=" + j);
            a(i2, j);
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!l.a() || !l.c() || l.b()) {
            q.a("UploadTimer", "不用处理消息, available=" + l.a() + ", 是否有网=" + l.c() + ", 数据库是否为空=" + l.b());
        } else if (message.what == 1000) {
            a();
        } else {
            int i2 = message.what;
            boolean a2 = m.a().a(i2);
            q.a("UploadTimer", "handleCheckUpload ret=" + a2 + ", prio=" + i2);
            if (!a2) {
                q.a("UploadTimer", "handleCheckUpload failed, will check if need to send retry msg");
                if (!hasMessages(1000)) {
                    sendEmptyMessageDelayed(1000, (long) this.h);
                    q.a("UploadTimer", "fire retry timer after " + this.h);
                }
            }
        }
    }

    private void a() {
        if (!m.a().a(2)) {
            removeMessages(1000);
            this.h *= 2;
            if (this.h > 1200000) {
                this.h = 1200000;
            }
            q.a("UploadTimer", "will restart retry msg after " + this.h);
            sendEmptyMessageDelayed(1000, (long) this.h);
            return;
        }
        this.h = C.MSG_CUSTOM_BASE;
        q.a("UploadTimer", "retry success");
    }

    private void a(Context context) {
        if (context != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.i, intentFilter);
            } catch (Exception e2) {
                q.a("UploadTimer", "registerNetReceiver: ".concat(String.valueOf(e2)));
            }
        }
    }

    private void a(int i2, long j) {
        removeMessages(i2);
        q.a("UploadTimer", "will post msg, prio=" + i2 + ", delay=" + j);
        sendEmptyMessageDelayed(i2, j);
    }
}
