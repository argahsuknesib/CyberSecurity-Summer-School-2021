package _m_j;

import _m_j.auh;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import java.util.Iterator;
import java.util.List;

public class atp extends Handler {
    private static final String O00000o0 = "_m_j.atp";

    /* renamed from: O000000o  reason: collision with root package name */
    public PDFView f12606O000000o;
    public boolean O00000Oo = false;
    private RectF O00000o = new RectF();
    private Rect O00000oO = new Rect();
    private Matrix O00000oo = new Matrix();

    atp(Looper looper, PDFView pDFView) {
        super(looper);
        this.f12606O000000o = pDFView;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, float f, float f2, RectF rectF, boolean z, int i2, boolean z2, boolean z3) {
        sendMessage(obtainMessage(1, new O000000o(f, f2, rectF, i, z, i2, z2, z3)));
    }

    public void handleMessage(Message message) {
        try {
            final aud O000000o2 = O000000o((O000000o) message.obj);
            if (O000000o2 == null) {
                return;
            }
            if (this.O00000Oo) {
                this.f12606O000000o.post(new Runnable() {
                    /* class _m_j.atp.AnonymousClass1 */

                    public final void run() {
                        PDFView pDFView = atp.this.f12606O000000o;
                        aud aud = O000000o2;
                        if (pDFView.O0000Ooo == PDFView.State.LOADED) {
                            pDFView.O0000Ooo = PDFView.State.SHOWN;
                        }
                        if (aud.O00000o) {
                            atk atk = pDFView.O00000o0;
                            synchronized (atk.O00000o0) {
                                while (atk.O00000o0.size() >= auh.O000000o.O00000Oo) {
                                    atk.O00000o0.remove(0).O00000Oo.recycle();
                                }
                                List<aud> list = atk.O00000o0;
                                Iterator<aud> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().equals(aud)) {
                                            aud.O00000Oo.recycle();
                                            break;
                                        }
                                    } else {
                                        list.add(aud);
                                        break;
                                    }
                                }
                            }
                        } else {
                            atk atk2 = pDFView.O00000o0;
                            synchronized (atk2.O00000o) {
                                synchronized (atk2.O00000o) {
                                    while (atk2.O00000Oo.size() + atk2.f12598O000000o.size() >= auh.O000000o.f12621O000000o && !atk2.f12598O000000o.isEmpty()) {
                                        atk2.f12598O000000o.poll().O00000Oo.recycle();
                                    }
                                    while (atk2.O00000Oo.size() + atk2.f12598O000000o.size() >= auh.O000000o.f12621O000000o && !atk2.O00000Oo.isEmpty()) {
                                        atk2.O00000Oo.poll().O00000Oo.recycle();
                                    }
                                }
                                atk2.O00000Oo.offer(aud);
                            }
                        }
                        pDFView.invalidate();
                    }
                });
            } else {
                O000000o2.O00000Oo.recycle();
            }
        } catch (PageRenderingException e) {
            this.f12606O000000o.post(new Runnable() {
                /* class _m_j.atp.AnonymousClass2 */

                public final void run() {
                    PDFView pDFView = atp.this.f12606O000000o;
                    PageRenderingException pageRenderingException = e;
                    ats ats = pDFView.O0000o0O;
                    pageRenderingException.getPage();
                    pageRenderingException.getCause();
                    if (!(ats.O00000o0 != null)) {
                        String str = PDFView.f3602O000000o;
                        Log.e(str, "Cannot open page " + pageRenderingException.getPage(), pageRenderingException.getCause());
                    }
                }
            });
        }
    }

    private aud O000000o(O000000o o000000o) throws PageRenderingException {
        ato ato = this.f12606O000000o.O00000oo;
        ato.O00000Oo(o000000o.O00000o);
        int round = Math.round(o000000o.f12609O000000o);
        int round2 = Math.round(o000000o.O00000Oo);
        if (!(round == 0 || round2 == 0)) {
            if (!(!ato.O00000o.get(ato.O00000o(o000000o.O00000o), false))) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(round, round2, o000000o.O0000O0o ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                    RectF rectF = o000000o.O00000o0;
                    this.O00000oo.reset();
                    float f = (float) round;
                    float f2 = (float) round2;
                    this.O00000oo.postTranslate((-rectF.left) * f, (-rectF.top) * f2);
                    this.O00000oo.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
                    this.O00000o.set(0.0f, 0.0f, f, f2);
                    this.O00000oo.mapRect(this.O00000o);
                    this.O00000o.round(this.O00000oO);
                    int i = o000000o.O00000o;
                    Rect rect = this.O00000oO;
                    Bitmap bitmap = createBitmap;
                    ato.O00000Oo.O000000o(ato.f12605O000000o, bitmap, ato.O00000o(i), rect.left, rect.top, rect.width(), rect.height(), o000000o.O0000OOo);
                    return new aud(o000000o.O00000o, bitmap, o000000o.O00000o0, o000000o.O00000oO, o000000o.O00000oo);
                } catch (IllegalArgumentException e) {
                    Log.e(O00000o0, "Cannot create bitmap", e);
                }
            }
        }
        return null;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        float f12609O000000o;
        float O00000Oo;
        int O00000o;
        RectF O00000o0;
        boolean O00000oO;
        int O00000oo;
        boolean O0000O0o;
        boolean O0000OOo;

        O000000o(float f, float f2, RectF rectF, int i, boolean z, int i2, boolean z2, boolean z3) {
            this.O00000o = i;
            this.f12609O000000o = f;
            this.O00000Oo = f2;
            this.O00000o0 = rectF;
            this.O00000oO = z;
            this.O00000oo = i2;
            this.O0000O0o = z2;
            this.O0000OOo = z3;
        }
    }
}
