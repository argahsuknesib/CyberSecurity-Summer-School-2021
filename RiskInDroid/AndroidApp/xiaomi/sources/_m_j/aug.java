package _m_j;

import android.content.Context;
import android.net.Uri;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

public final class aug implements auf {

    /* renamed from: O000000o  reason: collision with root package name */
    private Uri f12619O000000o;

    public aug(Uri uri) {
        this.f12619O000000o = uri;
    }

    public final dbj O000000o(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.O000000o(context.getContentResolver().openFileDescriptor(this.f12619O000000o, "r"), str);
    }
}
