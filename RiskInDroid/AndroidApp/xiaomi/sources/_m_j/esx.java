package _m_j;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public abstract class esx implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f15781O000000o;
    private File O00000Oo;
    private Runnable O00000o0;

    private esx(Context context, File file) {
        this.f15781O000000o = context;
        this.O00000Oo = file;
    }

    /* synthetic */ esx(Context context, File file, byte b) {
        this(context, file);
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    public final void run() {
        esw esw = null;
        try {
            if (this.O00000Oo == null) {
                this.O00000Oo = new File(this.f15781O000000o.getFilesDir(), "default_locker");
            }
            esw O000000o2 = esw.O000000o(this.f15781O000000o, this.O00000Oo);
            if (this.O00000o0 != null) {
                this.O00000o0.run();
            }
            O000000o();
            O000000o2.O000000o();
        } catch (IOException e) {
            e.printStackTrace();
            if (esw != null) {
                esw.O000000o();
            }
        } catch (Throwable th) {
            if (esw != null) {
                esw.O000000o();
            }
            throw th;
        }
    }
}
