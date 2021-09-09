package _m_j;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public abstract class fzx extends AsyncTask<Void, Integer, String> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final fzu f17450O000000o;
    protected final fzq<Bitmap> O00000Oo;
    protected final String O00000o;
    protected final int O00000o0;

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void onPostExecute(Object obj) {
        if (((String) obj) != null) {
            this.f17450O000000o.O000000o();
        } else {
            this.f17450O000000o.O00000Oo();
        }
        this.f17450O000000o.O00000o0();
    }

    protected fzx(fzq<Bitmap> fzq, int i, fzu<String> fzu, String str) {
        this.f17450O000000o = fzu;
        this.O00000Oo = fzq;
        this.O00000o0 = i;
        this.O00000o = str;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i) {
        publishProgress(Integer.valueOf(i));
    }
}
