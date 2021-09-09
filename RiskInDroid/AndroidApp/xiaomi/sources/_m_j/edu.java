package _m_j;

import android.util.Log;
import java.io.File;

public final class edu extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f15187O000000o;

    public edu(String str) {
        this.f15187O000000o = str;
    }

    public final void run() {
        int i;
        String str;
        super.run();
        if (!ecd.O000000o(this.f15187O000000o)) {
            een een = null;
            try {
                if (this.f15187O000000o.endsWith("client.json")) {
                    i = 9;
                    str = this.f15187O000000o;
                } else if (this.f15187O000000o.endsWith("page.json")) {
                    i = 5;
                    str = this.f15187O000000o;
                } else if (this.f15187O000000o.endsWith("event.json")) {
                    i = 7;
                    str = this.f15187O000000o;
                } else if (this.f15187O000000o.endsWith("error.json")) {
                    i = 11;
                    str = this.f15187O000000o;
                } else if (this.f15187O000000o.endsWith("crash.json")) {
                    i = 13;
                    str = this.f15187O000000o;
                } else {
                    if (this.f15187O000000o.endsWith("view.json")) {
                        i = 17;
                        str = this.f15187O000000o;
                    }
                    Log.d("test", this.f15187O000000o + " ReadFromFileThead");
                    if (een != null && een.f15191O000000o) {
                        Log.d("test", this.f15187O000000o + " ReadFromFileThead　OK");
                        File file = new File(this.f15187O000000o);
                        if (file.exists()) {
                            file.delete();
                            ecj.O000000o();
                            ecj.O000000o(file.getName());
                            return;
                        }
                        return;
                    }
                }
                een = ecb.O000000o(i, str);
                Log.d("test", this.f15187O000000o + " ReadFromFileThead");
                if (een != null) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
