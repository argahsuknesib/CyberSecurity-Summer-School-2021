package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;

final class ebq extends Handler {
    ebq(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 4096) {
            ebs.O000000o("MobileStats", "MSG_TIMER");
            eck.O00000Oo();
            if (eeq.O000000o()) {
                Handler handler = ebp.O00000Oo;
                try {
                    File[] O00000Oo = eeq.O00000Oo();
                    if (O00000Oo != null && O00000Oo.length > 0) {
                        for (File file : O00000Oo) {
                            if (file != null && file.exists()) {
                                edu edu = new edu(file.getPath());
                                if (handler != null) {
                                    handler.post(edu);
                                } else {
                                    new Handler().post(edu);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ebt.O000000o().O00000Oo();
            }
        }
    }
}
