package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;

public class atq implements atr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f12610O000000o = "atq";
    private PDFView O00000Oo;

    public atq(PDFView pDFView) {
        this.O00000Oo = pDFView;
    }

    public final void O000000o(auc auc) {
        String str = auc.f12617O000000o.O00000o0;
        Integer num = auc.f12617O000000o.O00000Oo;
        if (str != null && !str.isEmpty()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            Context context = this.O00000Oo.getContext();
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            } else {
                Log.w(f12610O000000o, "No activity found for URI: ".concat(String.valueOf(str)));
            }
        } else if (num != null) {
            this.O00000Oo.O000000o(num.intValue());
        }
    }
}
