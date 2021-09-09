package _m_j;

import android.os.AsyncTask;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;

public final class atl extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f12600O000000o = false;
    private PDFView O00000Oo;
    private String O00000o;
    private PdfiumCore O00000o0;
    private auf O00000oO;
    private int[] O00000oo;
    private ato O0000O0o;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Throwable th = (Throwable) obj;
        if (th != null) {
            PDFView pDFView = this.O00000Oo;
            pDFView.O0000Ooo = PDFView.State.ERROR;
            atu atu = pDFView.O0000o0O.O00000Oo;
            pDFView.i_();
            pDFView.invalidate();
            if (atu != null) {
                atu.O000000o(th);
            } else {
                Log.e(PDFView.f3602O000000o, "load pdf error", th);
            }
        } else if (!this.f12600O000000o) {
            PDFView pDFView2 = this.O00000Oo;
            ato ato = this.O0000O0o;
            pDFView2.O0000Ooo = PDFView.State.LOADED;
            pDFView2.O00000oo = ato;
            if (!pDFView2.O0000o00.isAlive()) {
                pDFView2.O0000o00.start();
            }
            pDFView2.O0000o0 = new atp(pDFView2.O0000o00.getLooper(), pDFView2);
            pDFView2.O0000o0.O00000Oo = true;
            if (pDFView2.O0000oOO != null) {
                pDFView2.O0000oOO.setupLayout(pDFView2);
                pDFView2.O0000oOo = true;
            }
            pDFView2.O00000oO.f12601O000000o = true;
            ats ats = pDFView2.O0000o0O;
            int i = ato.O00000o0;
            if (ats.f12611O000000o != null) {
                ats.f12611O000000o.a_(i);
            }
            pDFView2.O000000o(pDFView2.O0000o0o);
        }
    }

    public atl(auf auf, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.O00000oO = auf;
        this.O00000oo = iArr;
        this.O00000Oo = pDFView;
        this.O00000o = str;
        this.O00000o0 = pdfiumCore;
    }

    private Throwable O000000o() {
        try {
            this.O0000O0o = new ato(this.O00000o0, this.O00000oO.O000000o(this.O00000Oo.getContext(), this.O00000o0, this.O00000o), this.O00000Oo.getPageFitPolicy(), new Size(this.O00000Oo.getWidth(), this.O00000Oo.getHeight()), this.O00000oo, this.O00000Oo.O0000o, this.O00000Oo.getSpacingPx(), this.O00000Oo.O00oOooO);
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* access modifiers changed from: protected */
    public final void onCancelled() {
        this.f12600O000000o = true;
    }
}
