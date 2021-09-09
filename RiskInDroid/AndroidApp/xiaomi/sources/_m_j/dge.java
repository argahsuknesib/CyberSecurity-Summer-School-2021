package _m_j;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

final class dge extends dgg {
    dge(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            dgd.O000000o(Environment.getExternalStorageDirectory() + "/" + dgi.O00000o0("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), dgi.O00000o0("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(dgi.O00000o0("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Exception e) {
                Log.w("MID", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        return dgi.O000000o(this.f14601O000000o, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        String str;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                Iterator<String> it = dgd.O000000o(new File(Environment.getExternalStorageDirectory(), dgi.O00000o0("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String[] split = it.next().split(",");
                    if (split.length == 2 && split[0].equals(dgi.O00000o0("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        Log.i("MID", "read mid from InternalStorage:" + split[1]);
                        str = split[1];
                        break;
                    }
                }
            } catch (IOException e) {
                Log.w("MID", e);
            }
            str = null;
        }
        return str;
    }
}
