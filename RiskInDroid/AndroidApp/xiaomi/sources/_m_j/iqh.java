package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.IOException;
import java.net.URL;

public class iqh extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f1554O000000o;
    private final Context O00000Oo;
    private final iqg O00000o;
    private final iqi O00000o0 = new iqi();

    /* access modifiers changed from: protected */
    public /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (!isCancelled()) {
            this.O00000o.O000000o(bitmap);
        }
    }

    public iqh(String str, Context context, iqg iqg) {
        this.f1554O000000o = str;
        this.O00000Oo = context;
        this.O00000o = iqg;
    }

    /* access modifiers changed from: protected */
    /* renamed from: O000000o */
    public Bitmap doInBackground(String... strArr) {
        int i;
        if (this.f1554O000000o.startsWith("http")) {
            return O000000o(this.f1554O000000o);
        }
        String str = this.f1554O000000o;
        Resources resources = this.O00000Oo.getResources();
        iqi iqi = this.O00000o0;
        Context context = this.O00000Oo;
        if (str == null || str.isEmpty()) {
            i = 0;
        } else {
            String replace = str.toLowerCase().replace("-", "_");
            if (iqi.f1555O000000o.containsKey(replace)) {
                i = iqi.f1555O000000o.get(replace).intValue();
            } else {
                int identifier = context.getResources().getIdentifier(replace, "drawable", context.getPackageName());
                iqi.f1555O000000o.put(replace, Integer.valueOf(identifier));
                i = identifier;
            }
        }
        return BitmapFactory.decodeResource(resources, i);
    }

    private static Bitmap O000000o(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
